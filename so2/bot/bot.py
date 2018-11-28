#!/usr/bin/env python3
# -*- coding: utf-8 -*-

import os, socket, psutil, logging, telegram, configparser, getpass, redis
from telegram import InlineKeyboardButton, InlineKeyboardMarkup, ForceReply
from telegram.ext import Updater, CommandHandler, CallbackQueryHandler, MessageHandler, Filters
from zeeto import ManageUser

# Configuring bot
config = configparser.ConfigParser()
config.read_file(open('config.ini'))

# Connecting to Redis db
db = redis.StrictRedis(host=config['DB']['host'],
                       port=config['DB']['port'],
                       db=config['DB']['db'],
                       password=config['DB']['password'])

logging.basicConfig(format='%(asctime)s - %(name)s - %(levelname)s - %(message)s', level=logging.INFO)
logger = logging.getLogger(__name__)


def hello(bot, update):
    info = """
Olá {name}, eu sou o Ross, seu assistente de gerenciamento de servidores.

Você pode solicitar tarefas a partir dos seguintes comandos:

/hello - Exibe esta tela
/users - Gerenciar usuários
/proc - Gerenciar processos
/status - Resumo do status do servidor
    """.format(name=update.message.from_user.first_name)

    main_menu_keyboard = [[telegram.KeyboardButton('/users'), telegram.KeyboardButton('/proc')],
                          [telegram.KeyboardButton('/status')]]

    reply_kb_markup = telegram.ReplyKeyboardMarkup(main_menu_keyboard,
                                                   resize_keyboard=True,
                                                   one_time_keyboard=True)

    bot.send_message(chat_id=update.message.chat_id,
                     text=info,
                     reply_markup=reply_kb_markup)


def users(bot, update):
    query = update.callback_query
    info = """
Certo, você quer gerenciar seus usuários.
Informe a ação que você deseja realizar:    
    """

    keyboard = [
        [InlineKeyboardButton("Listar", callback_data='user_list'),
         InlineKeyboardButton("Criar", callback_data='user_create')],

        [InlineKeyboardButton("Mudar senha", callback_data='user_passwd'),
         InlineKeyboardButton("Excluir", callback_data='user_delete')]
    ]

    reply_markup = InlineKeyboardMarkup(keyboard)

    update.message.reply_text('O que você quer fazer?:', reply_markup=reply_markup)


def status(bot, update):
    info = """
Status atual do servidor:
    """.format(name=update.message.from_user.first_name).strip()

    info += "\nHostname: " + str(socket.gethostname())
    info += "\nKernel: " + os.uname()[2]
    info += "\nPlataforma: " + os.uname()[4]
    info += "\n\n+Memória"
    info += "\n+--total: " + '{0:.2f}'.format(psutil.virtual_memory().total / 1024 / 1024) + ' MB'
    info += "\n+--usada: " + '{0:.2f}'.format(psutil.virtual_memory().used / 1024 / 1024) + ' MB'
    info += "\n+--disponível: " + '{0:.2f}'.format(psutil.virtual_memory().available / 1024 / 1024) + ' MB'
    info += "\n+--livre: " + '{0:.2f}'.format(psutil.virtual_memory().free / 1024 / 1024)
    info += "\n\n+Uso do disco: "
    info += "\n+--Total: " + '{0:.2f}'.format(psutil.disk_usage('/').total / 1024 / 1024 / 1024) + ' GB'
    info += "\n+--Usado: " + '{0:.2f}'.format(psutil.disk_usage('/').used / 1024 / 1024 / 1024) + ' GB'
    info += "\n+--Livre: " + '{0:.2f}'.format(psutil.disk_usage('/').free / 1024 / 1024 / 1024) + ' GB'

    info += "\n\nUsuários logados"
    for user in psutil.users():
        info += "\n" + user.terminal + " - " + user.name + " - PID: " + str(user.pid)

    pids = [(p.pid, p.info['name'], p.info['username']) for p in psutil.process_iter(attrs=['name', 'username']) if
            p.info['username'] == getpass.getuser()]

    info += "\n\nProcessos em execução: "
    for pid in pids:
        info += '\n' + str(pid[0]) + '\t' + pid[1]

    update.message.reply_text(info)


def user_button(bot, update):
    query = update.callback_query

    if query.data == 'user_list':
        info = "Usuários do sistema (UID > 1000):\n\n"

        user = ManageUser()
        for user in user.list():
            info = info + user + '\n'

        bot.edit_message_text(text=info,
                              chat_id=query.message.chat_id,
                              message_id=query.message.message_id)
    elif query.data == 'user_create':
        last_message = bot.send_message(text='Nome do novo usuário :',
                                        chat_id=query.message.chat_id,
                                        reply_markup=ForceReply())
        db.set('last_message_id', last_message.message_id)
        db.set('last_message_action', 'user_new')
    elif query.data == 'user_passwd':
        keyboard = []

        user = ManageUser()
        for user in user.list():
            keyboard.append([InlineKeyboardButton(user.strip(), callback_data="passwd|" + user)])

        reply_markup = InlineKeyboardMarkup(keyboard)

        bot.edit_message_text(message_id=query.message.message_id,
                              text='Mudar a senha de qual usuário?',
                              chat_id=query.message.chat_id,
                              reply_markup=reply_markup)
    elif query.data == 'user_delete':
        keyboard = []

        user = ManageUser()
        for user in user.list():
            keyboard.append([InlineKeyboardButton(user.strip(), callback_data="delete|" + user)])

        reply_markup = InlineKeyboardMarkup(keyboard)

        last_message = bot.edit_message_text(message_id=query.message.message_id,
                                             text='Qual usuário deseja excluir?',
                                             chat_id=query.message.chat_id,
                                             reply_markup=reply_markup)
        db.set('last_message_id', last_message.message_id)
        db.set('last_message_action', 'user_del')

    else:
        print('vsf')

def proc_button(bot, update):
    query = update.callback_query
    info = ""

    pids = [(p.pid, p.info['name'], p.info['username']) for p in psutil.process_iter(attrs=['name', 'username']) if
            p.info['username'] == getpass.getuser()]


    for pid in pids:
        info += '\n' + str(pid[0]) + '\t' + pid[1]

def passwd(bot, update):
    query = update.callback_query
    data = query.data.split('|')
    if data[0] == 'passwd':
        last_message = bot.send_message(text='Senha nova para ' + data[1] + ':',
                                        chat_id=query.message.chat_id,
                                        reply_markup=ForceReply())
        db.set('last_message_id', last_message.message_id)
        db.set('last_message_action', 'chpasswd|' + data[1])


def userDelete(bot, update):
    query = update.callback_query
    data = query.data.split('|')
    if data[0] == 'passwd':
        last_message = bot.send_message(text='Digite "sim" para confirmar a exclusão de ' + data[1] + ':',
                                        chat_id=query.message.chat_id,
                                        reply_markup=ForceReply())
        db.set('last_message_id', last_message.message_id)
        db.set('last_message_action', 'user_del|' + data[1])


def processMessages(bot, update):
    last_message_id = int(db.get('last_message_id'))
    last_message_action = db.get('last_message_action')
    last_message_action = last_message_action.decode()
    print(last_message_action)
    if update.message.reply_to_message.message_id == last_message_id and last_message_action.split('|')[
        0] == 'chpasswd':
        user = ManageUser()
        user.update_password(user=last_message_action.split('|')[1], password=str(update.message.text))
        bot.send_message(text="Senha atualizada com sucesso!", chat_id=update.message.chat_id)
    elif update.message.reply_to_message.message_id == last_message_id and last_message_action == 'user_new':
        user = ManageUser()
        user.create(user=str(update.message.text))
        bot.send_message(text="Usuário criado com sucesso!", chat_id=update.message.chat_id)
    elif update.message.reply_to_message.message_id == last_message_id and last_message_action == 'user_del':
        user = ManageUser()
        user.delete(user=str(update.message.text))
        bot.send_message(text="Usuário removido com sucesso!", chat_id=update.message.chat_id)


def main():
    updater = Updater(token=config['DEFAULT']['token'])
    dp = updater.dispatcher
    dp.add_handler(CommandHandler('hello', hello))
    dp.add_handler(CommandHandler('start', hello))
    dp.add_handler(CommandHandler('users', users))
    dp.add_handler(CommandHandler('status', status))

    dp.add_handler(MessageHandler(Filters.text, processMessages))

    dp.add_handler(CallbackQueryHandler(user_button, pattern="user_.+"))
    dp.add_handler(CallbackQueryHandler(passwd, pattern="passwd.+"))
    dp.add_handler(CallbackQueryHandler(userDelete, pattern="delete.+"))

    updater.start_polling()
    updater.idle()


if __name__ == '__main__':
    main()

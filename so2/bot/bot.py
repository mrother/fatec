#!/usr/bin/env python3
# -*- coding: utf-8 -*-

import os, socket, psutil, logging, telegram, configparser
from telegram import InlineKeyboardButton, InlineKeyboardMarkup
from telegram.ext import Updater, CommandHandler, CallbackQueryHandler, ChosenInlineResultHandler
from zeeto import users as userlib

# Configuring bot
config = configparser.ConfigParser()
config.read_file(open('config.ini'))

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

    # for proc in psutil.process_iter(attrs=['pid', 'name']):
    #     info += '\n' + proc.info['name']

    update.message.reply_text(info)


def user_button(bot, update):
    query = update.callback_query

    if query.data == 'user_list':
        info = "Usuários do sistema (UID > 1000):\n\n"

        user = userlib.ManageUser()
        for user in user.list():
            info = info + user + '\n'

        bot.edit_message_text(text=info,
                              chat_id=query.message.chat_id,
                              message_id=query.message.message_id)
    elif query.data == 'user_create':
        print('weeee')
    elif query.data == 'user_passwd':
        keyboard = []

        user = userlib.ManageUser()
        for user in user.list():
            keyboard.append([InlineKeyboardButton(user.strip(), callback_data="user_passwd_pass")])

        keyboard.append([InlineKeyboardButton("<< Voltar", callback_data="users")])
        reply_markup = InlineKeyboardMarkup(keyboard)

        bot.edit_message_text(message_id=query.message.message_id,
                              text='Mudar a senha de qual usuário?',
                              chat_id=query.message.chat_id,
                              reply_markup=reply_markup)
    elif query.data == 'user_passwd_'
    elif query.data == 'user_delete':
        keyboard = []

        user = userlib.ManageUser()
        for user in user.list():
            keyboard.append([InlineKeyboardButton(user.strip(), callback_data=user.strip())])

        keyboard.append([InlineKeyboardButton("<< Voltar", callback_data="users")])
        reply_markup = InlineKeyboardMarkup(keyboard)

        bot.edit_message_text(message_id=query.message.message_id,
                              text='Qual usuário deseja excluir?',
                              chat_id=query.message.chat_id,
                              reply_markup=reply_markup)

    else:
        print('vsf')


def main():
    updater = Updater(token=config['DEFAULT']['token'])
    dp = updater.dispatcher
    dp.add_handler(CommandHandler('hello', hello))
    dp.add_handler(CommandHandler('start', hello))
    dp.add_handler(CommandHandler('users', users))
    dp.add_handler(CommandHandler('status', status))
    dp.add_handler(CallbackQueryHandler(user_button, pattern="user_.+"))
    dp.add_handler(CallbackQueryHandler(users, pattern="users"))

    updater.start_polling()
    updater.idle()


if __name__ == '__main__':
    main()

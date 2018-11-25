#!/usr/bin/env python3
# -*- coding: utf-8 -*-

import subprocess, os, string, logging, telegram
from telegram import InlineKeyboardButton, InlineKeyboardMarkup
from telegram.ext import Updater, CommandHandler, CallbackQueryHandler

logging.basicConfig(format='%(asctime)s - %(name)s - %(levelname)s - %(message)s', level=logging.INFO)
logger = logging.getLogger(__name__)


def hello(bot, update):
    info = """
Olá {name}, eu sou o Ross, seu assistente de gerenciamento de servidores.

Você pode solicitar tarefas a partir dos seguintes comandos:

/help - Exibe esta tela
/users - Gerenciar usuários
/proccess - Gerenciar processos
/status - Resumo do status do servidor
    """.format(name=update.message.from_user.first_name)

    main_menu_keyboard = [[telegram.KeyboardButton('/users'), telegram.KeyboardButton('/proccess')],
                          [telegram.KeyboardButton('/status')]]

    reply_kb_markup = telegram.ReplyKeyboardMarkup(main_menu_keyboard,
                                                   resize_keyboard=True,
                                                   one_time_keyboard=True)

    # Send the message with menu
    bot.send_message(chat_id=update.message.chat_id,
                     text=info,
                     reply_markup=reply_kb_markup)


def users(bot, update):
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

    update.message.reply_text('Escolha:', reply_markup=reply_markup)


def status(bot, update):
    info = """
Certo, você quer gerenciar seus usuários.
Informe a ação que você deseja realizar:    
    """.format(name=update.message.from_user.first_name)

    result = os.cpu_count()

    update.message.reply_text(result)


def button(bot, update):
    query = update.callback_query

    bot.edit_message_text(text="Você clicou: {}".format(query.data),
                          chat_id=query.message.chat_id,
                          message_id=query.message.message_id)


def main():
    updater = Updater('****')
    dp = updater.dispatcher
    dp.add_handler(CommandHandler('hello', hello))
    dp.add_handler(CommandHandler('users', users))
    dp.add_handler(CommandHandler('status', status))
    dp.add_handler(CallbackQueryHandler(button, pattern="user_list"))

    updater.start_polling()
    updater.idle()


if __name__ == '__main__':
    main()

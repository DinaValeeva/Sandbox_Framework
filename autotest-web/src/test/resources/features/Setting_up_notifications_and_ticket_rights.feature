#language:ru
@sandbox
Функционал: Настройка уведомлений и выдача прав на просмотр и изменение тикета

  Сценарий: Настройка уведомлений и выдача прав на просмотр и изменение тикета

    * открыть url "https://ft-sandbox.workbench.lanit.ru/"
    * инициализация страницы "Sandbox"

    * кликнуть на элемент "Войти"

    * ввести в поле "Username" значение "admin"
    * ввести в поле "Password" значение "adminft"

    * кликнуть на элемент "Вход"
    * переход на страницу "Sandbox"

    #1
    * подождать 2 сек
    * выбрать случайный тикет
    * переход на страницу "Sandbox Просмотр тикета"
    * кликнуть на элемент "Стрелка"
    * переход на страницу "Настройки поля 'Копия' тикета"

    * кликнуть на элемент "Add an Email or Helpdesk User"
    * переход на страницу "Добавить адрес в поле 'Копия'"
    * кликнуть на элемент "Вкладка Email"

    * ввести в поле "Email: Адрес электронной почты" значение "t@t.test"
    * проверить, что поле "Email: Адрес электронной почты" заполнено значением "t@t.test"

    * активировать чекбокс "Email: Может посмотреть тикет?"
    * проверить, что чекбокс "Email: Может посмотреть тикет?" активирован
    * активировать чекбокс "Email: Может изменить тикет?"
    * проверить, что чекбокс "Email: Может изменить тикет?" активирован

    #2
    * кликнуть на элемент "Email: Нет, не удалять"
    * переход на страницу "Настройки поля 'Копия' тикета"
    * кликнуть на элемент "Вернутся к тикету"

    * переход на страницу "Sandbox Просмотр тикета"
    * проверить, что поле "Копии для" содержит значение "t@t.test"

    #3
    * кликнуть на элемент "Стрелка"
    * переход на страницу "Настройки поля 'Копия' тикета"
    * кликнуть на элемент "Add an Email or Helpdesk User"
    * переход на страницу "Добавить адрес в поле 'Копия'"
    * кликнуть на элемент "Вкладка Email"

    * ввести в поле "Email: Адрес электронной почты" значение "t@t2.test"
    * проверить, что поле "Email: Адрес электронной почты" заполнено значением "t@t2.test"
    * кликнуть на элемент "Email: Cancel"
    * переход на страницу "Настройки поля 'Копия' тикета"
    * кликнуть на элемент "Вернутся к тикету"

    * переход на страницу "Sandbox Просмотр тикета"
    * проверить, что поле "Копии для" не содержит значение "t@t2.test"

    #4
    * кликнуть на элемент "Стрелка"
    * переход на страницу "Настройки поля 'Копия' тикета"
    * кликнуть на элемент "Add an Email or Helpdesk User"
    * переход на страницу "Добавить адрес в поле 'Копия'"
    * кликнуть на элемент "Вкладка Пользователь"

    * в выпадающем списке "Пользователь: Пользователь" выбрать "admin"
    * проверить, что в выпадающем списке "Пользователь: Пользователь" выбрано "admin"

    * проверить, что чекбокс "Пользователь: Может посмотреть тикет?" деактивирован
    * проверить, что чекбокс "Пользователь: Может изменить тикет?" деактивирован

    #5
    * кликнуть на элемент "Пользователь: Нет, не удалять"
    * переход на страницу "Настройки поля 'Копия' тикета"
    * кликнуть на элемент "Вернутся к тикету"

    * переход на страницу "Sandbox Просмотр тикета"
    * проверить, что поле "Копии для" содержит значение "admin"

    #6
    * кликнуть на элемент "Стрелка"
    * переход на страницу "Настройки поля 'Копия' тикета"
    * нажать кнопку 'Удалить' для пункта "admin" в таблице

    * переход на страницу "Удалить адрес в поле 'Копия'"
    * на странице присутствует текст "Вы уверены что хотите удалить этот адрес электронной почты ("
    * проверить, что поле "Электронная почта" содержит значение "admin@example.org"
    * на странице присутствует текст ") из поля \"Копия\" для этого тикета? Они прекратят получать обновления тикета."

    #7
    * кликнуть на элемент "Не удалять"
    * переход на страницу "Настройки поля 'Копия' тикета"
    * кликнуть на элемент "Вернутся к тикету"
    * переход на страницу "Sandbox Просмотр тикета"
    * проверить, что поле "Копии для" содержит значение "admin"

    #8
    * кликнуть на элемент "Стрелка"
    * переход на страницу "Настройки поля 'Копия' тикета"
    * нажать кнопку 'Удалить' для пункта "admin" в таблице
    * переход на страницу "Удалить адрес в поле 'Копия'"

    * на странице присутствует текст "Вы уверены что хотите удалить этот адрес электронной почты ("
    * проверить, что поле "Электронная почта" содержит значение "admin@example.org"
    * на странице присутствует текст ") из поля \"Копия\" для этого тикета? Они прекратят получать обновления тикета."

    * кликнуть на элемент "Да, Я Понимаю - Удалить"
    * переход на страницу "Настройки поля 'Копия' тикета"
    * нажать кнопку 'Удалить' для пункта "t@t.test" в таблице
    * переход на страницу "Удалить адрес в поле 'Копия'"

    * на странице присутствует текст "Вы уверены что хотите удалить этот адрес электронной почты ("
    * проверить, что поле "Электронная почта" содержит значение "t@t.test"
    * на странице присутствует текст ") из поля \"Копия\" для этого тикета? Они прекратят получать обновления тикета."

    * кликнуть на элемент "Да, Я Понимаю - Удалить"
    * переход на страницу "Настройки поля 'Копия' тикета"
    * кликнуть на элемент "Вернутся к тикету"

    * переход на страницу "Sandbox Просмотр тикета"
    * проверить, что поле "Копии для" не содержит значение "admin"
    * проверить, что поле "Копии для" не содержит значение "t@t.test"

    #9
    * кликнуть на элемент "Subscribe"
    * на странице отсутствует элемент "Subscribe"
    * проверить, что поле "Копии для" содержит значение "admin"
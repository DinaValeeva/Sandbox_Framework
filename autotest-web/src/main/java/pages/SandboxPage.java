package pages;

import com.codeborne.selenide.SelenideElement;
import ru.lanit.at.web.annotations.Name;
import ru.lanit.at.web.pagecontext.WebPage;

import static com.codeborne.selenide.Selenide.$x;

@Name(value = "Sandbox")
public class SandboxPage extends WebPage {

    @Name("Краткое описание проблемы")
    private SelenideElement shortDescriptionProblemField = $x("//label[contains(text(),'Краткое описание проблемы')]/..//input[@type='text']");

    @Name("Username")
    private SelenideElement userNameField = $x("//input[@name='username']");

    @Name("Password")
    private SelenideElement passwordField = $x("//input[@name='password']");

    @Name("Войти")
    private SelenideElement loginLink = $x("//a[contains(text(),'Войти')]");

    @Name("Вход")
    private SelenideElement enterButton = $x("//input[@value='Вход']");

    @Name("Таблица тикетов")
    private SelenideElement ticketTable = $x("//table[@id='ticketTable']");

    @Name("Создать тикет")
    private SelenideElement createTicket = $x("//*[text()='Создать тикет']");

    @Name("Новый Тикет")
    private SelenideElement newTicketSidebar = $x("//a[@href='/tickets/submit/']");

    @Name("Очередь")
    private SelenideElement queueDropdown = $x("//select[@name='queue']");

    @Name("Описание вашей проблемы")
    private SelenideElement descriptionProblemField = $x("//textarea[@id='id_body']");

    @Name("Приоритет")
    private SelenideElement priority = $x("//select[@id='id_priority']");

    @Name("Выполнить до")
    private SelenideElement doUntil = $x("//input[@name='due_date']");

    @Name("Выберите файл")
    private SelenideElement chooseFileButton = $x("//label[@for='id_attachment']/..//input[@type='file']");

    @Name("Ваш адрес электронной почты")
    private SelenideElement submitterEmail = $x("//input[@name='submitter_email']");

    @Name("Очередь:")
    private SelenideElement queueFinal = $x("//th[contains(text(),'Очередь:')]");

    @Name("Электронный адрес отправителя")
    private SelenideElement submitterEmailFinal = $x("//th[contains(text(),'Электронный адрес отправителя')]//parent::tr");

    @Name("Имя пользователя")
    private SelenideElement navItemDropdownUserName = $x("//a[@id='userDropdown']");

    @Name("Настройки пользователя")
    private SelenideElement navItemDropdownUserSettings = $x("//a[@href='/settings/']");

    @Name("Тикеты")
    private SelenideElement tickets = $x("//a[text()='Тикеты']");

    @Name("Overview")
    private SelenideElement overview = $x("//li[text()='Overview']");

    @Name("Первый тикет")
    private SelenideElement firstTicket = $x("//table[@id='ticketTable']//a[1]");

    @Name("DH-1")
    private SelenideElement dh1 = $x("//li[contains(text(),'DH-1')]");

    @Name("Удалить")
    private SelenideElement deleteButton = $x("//button[contains(text(),'Удалить')]");

    @Name("С выбранными тикетами:")
    private SelenideElement ticketActionDropdown = $x("//select[@id='id_mass_action']");

    @Name("Выполнить")
    private SelenideElement goButton = $x("//div[@class='card']//button[contains(.,'Выполнить')]");

    @Name("Все")
    private SelenideElement allTicketsButton = $x("//div[@class='card']//button[contains(.,'Все')]");

    @Name("Поиск...")
    private SelenideElement searchQuery = $x("//input[@id='search_query']");

    @Name("Выполнить поиск")
    private SelenideElement search = $x("//form[@id='searchform']//button[@type='submit']");

    @Name("Column visibility")
    private SelenideElement columnVisibility = $x("//div[@id='ticketTable_wrapper']//button[contains(.,'Column visibility')]");

    @Name("Контекстное меню Column visibility")
    private SelenideElement menuColumnVisibility = $x("//div[@id='ticketTable_wrapper']//div[@role='menu']");

    @Name("Timeline")
    private SelenideElement timeline = $x("//a[@id='timelinetabcontents-tab']");

    @Name("Стрелка к следующему тикету")
    private SelenideElement nextTicket = $x("//div[@class='tl-slidenav-next']//div[@class='tl-slidenav-icon']");

    @Name("Стрелка к предыдущему тикету")
    private SelenideElement previousTicket = $x("//div[@class='tl-slidenav-previous']//div[@class='tl-slidenav-icon']");

    @Name("View ticket первый тикет")
    private SelenideElement viewTicket = $x("(//a[@class = 'btn' and contains(text(),'View ticket')])[1]");

    @Name("Show entries")
    private SelenideElement showEntries = $x("//div[@id='ticketTable_length']//select[@name='ticketTable_length']");

    @Name("Next")
    private SelenideElement nextTicketTable = $x("//li[@id='ticketTable_next']");

    @Name("Previous")
    private SelenideElement previousTicketTable = $x("//li[@id='ticketTable_previous']");

    @Name("Блок кнопок с номерами страниц таблицы тикетов")
    private SelenideElement ticketTablePaginate = $x("//div[@id='ticketTable_paginate']");
}

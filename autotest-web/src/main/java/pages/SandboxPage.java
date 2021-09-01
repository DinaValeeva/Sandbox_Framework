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
    private SelenideElement ticketTable = $x("//table[@id='ticketTable']//tbody");

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
    private SelenideElement ticketActionDropdown = $x("//label[contains(text(),'С выбранными тикетами:')]/..//select");

    @Name("Выполнить")
    private SelenideElement goButton = $x("//div[@class='card']//button[contains(.,'Выполнить')]");

    @Name("Все")
    private SelenideElement allTicketsButton = $x("//div[@class='card']//button[contains(.,'Все')]");
}

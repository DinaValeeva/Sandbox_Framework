package pages;

import com.codeborne.selenide.SelenideElement;
import ru.lanit.at.web.annotations.Name;
import ru.lanit.at.web.pagecontext.WebPage;

import static com.codeborne.selenide.Selenide.$x;

@Name(value = "Sandbox Настройки пользователя")
public class SandboxUserSettingsPage extends WebPage {

    @Name("Имя пользователя")
    private SelenideElement navItemDropdownUserName = $x("//a[@id='userDropdown']");

    @Name("Настройки пользователя")
    private SelenideElement navItemDropdownUserSettings = $x("//a[@href='/settings/']");

    @Name("Показывать список тикетов после входа?")
    private SelenideElement checkboxLoginView = $x("//input[@id='id_login_view_ticketlist']");

    @Name("Уведомлять меня по электронной почте о изменениях тикета?")
    private SelenideElement checkboxEmailOnTicketChange = $x("//input[@id='id_email_on_ticket_change']");

    @Name("Уведомить меня по электронной почте о назначенных мне тикетах?")
    private SelenideElement checkboxEmailOnTicketAssign = $x("//input[@id='id_email_on_ticket_assign']");

    @Name("Количество тикетов на страницу")
    private SelenideElement dropdownTicketPerPage = $x("//label[@for='id_tickets_per_page']/");

    @Name("Использовать мой адрес электронной почты при отправке тикета?")
    private SelenideElement checkboxEmailOnTicketSubmitter = $x("//input[@id='id_use_email_as_submitter']");

    @Name("Подтвердить")
    private SelenideElement buttonSubmit = $x("//input[@value='Submit']");

}

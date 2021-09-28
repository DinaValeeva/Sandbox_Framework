package pages;

import com.codeborne.selenide.SelenideElement;
import ru.lanit.at.web.annotations.Name;
import ru.lanit.at.web.pagecontext.WebPage;

import static com.codeborne.selenide.Selenide.$x;

@Name(value = "Добавить адрес в поле 'Копия'")
public class AddCCPage extends WebPage {

    @Name("Вкладка Email")
    private SelenideElement tabEmail = $x("//a[@href='#EmailCC']");

    @Name("Email: Адрес электронной почты")
    private SelenideElement email = $x("//input[@id='id_email']");

    @Name("Email: Может посмотреть тикет?")
    private SelenideElement canViewEmailTab = $x("//div[@id='EmailCC']//input[@id='id_can_view']");

    @Name("Email: Может изменить тикет?")
    private SelenideElement canUpdateEmailTab = $x("//div[@id='EmailCC']//input[@id='id_can_update']");

    @Name("Email: Нет, не удалять")
    private SelenideElement dontDeleteEmailTab = $x("//div[@id='EmailCC']//button[text()='Нет, не удалять']");

    @Name("Email: Cancel")
    private SelenideElement cancelEmailTab = $x("//div[@id='EmailCC']//a[contains(text(),'Cancel')]");

    @Name("Вкладка Пользователь")
    private SelenideElement tabUser = $x("//a[@href='#UserCC']");

    @Name("Пользователь: Пользователь")
    private SelenideElement user = $x(" //select[@id='id_user']");

    @Name("Пользователь: Может посмотреть тикет?")
    private SelenideElement canViewUserTab = $x("//div[@id='UserCC']//input[@id='id_can_view']");

    @Name("Пользователь: Может изменить тикет?")
    private SelenideElement canUpdateUserTab = $x("//div[@id='UserCC']//input[@id='id_can_update']");

    @Name("Пользователь: Нет, не удалять")
    private SelenideElement dontDeleteUserTab = $x("//div[@id='UserCC']//button[text()='Нет, не удалять']");

    @Name("Пользователь: Cancel")
    private SelenideElement cancelUserTab = $x("//div[@id='UserCC']//a[contains(text(),'Cancel')]");

}

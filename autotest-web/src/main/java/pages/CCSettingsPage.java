package pages;

import com.codeborne.selenide.SelenideElement;
import ru.lanit.at.web.annotations.Name;
import ru.lanit.at.web.pagecontext.WebPage;

import static com.codeborne.selenide.Selenide.$x;

@Name(value = "Настройки поля 'Копия' тикета")
public class CCSettingsPage extends WebPage {

    @Name("Add an Email or Helpdesk User")
    private SelenideElement addAnEmailOrHelpdeskUser = $x("//div[@class = 'panel-body']//button[text() = 'Add an Email or Helpdesk User']");

    @Name("Вернутся к тикету")
    private SelenideElement backToTicket = $x("//div[@id='content-wrapper']//button[contains(text(), 'Вернутся к')]");

    @Name("Таблица для поля 'Копия'")
    private SelenideElement tableCopy = $x("//table[@class='table table-striped table-bordered table-hover']");

}

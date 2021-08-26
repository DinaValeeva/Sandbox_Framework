package pages;

import com.codeborne.selenide.SelenideElement;
import ru.lanit.at.web.annotations.Name;
import ru.lanit.at.web.pagecontext.WebPage;

import static com.codeborne.selenide.Selenide.$x;

@Name(value = "Sandbox Просмотр тикета")
public class SandboxViewTicketPage extends WebPage {

    @Name("Очередь:")
    private SelenideElement queueFinal = $x("//th[contains(text(),'Очередь:')]");

    @Name("Электронный адрес отправителя")
    private SelenideElement submitterEmailFinal = $x("//th[contains(text(),'Электронный адрес отправителя')]//parent::tr");

    @Name("Приоритет")
    private SelenideElement priorityFinal = $x("//th[contains(text(),'Приоритет')]//parent::tr");

}

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

    @Name("Тикеты")
    private SelenideElement tickets = $x("//a[text()='Тикеты']");

    @Name("Копии для")
    private SelenideElement copiesTo = $x("//th[text()='Копии для']/following-sibling::td");

    @Name("Стрелка")
    private SelenideElement arrowInFieldCopiesTo = $x("//i[@class='fa fa-share']/parent::button[@class='btn btn-warning btn-sm float-right']");

    @Name("Subscribe")
    private SelenideElement subscribe = $x("//a[@href='?subscribe']/button");

    @Name("Новый статус: Закрытый")
    private SelenideElement stClosed = $x("//input[@id='st_closed']");

    @Name("Это публичный тикет?")
    private SelenideElement isPublicTicket = $x("//dd[contains(text(),'Это публичный тикет?')]//input");

    @Name("Обновить этот тикет")
    private SelenideElement updateThisTicket = $x("//button[text()='Обновить этот тикет']");

    @Name("Название тикета")
    private SelenideElement ticketName = $x("//thead[@class='thead-light']//h3");

}

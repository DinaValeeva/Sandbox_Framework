package pages;

import com.codeborne.selenide.SelenideElement;
import ru.lanit.at.web.annotations.Name;
import ru.lanit.at.web.pagecontext.WebPage;

import static com.codeborne.selenide.Selenide.$x;

@Name(value = "Удалить тикет")
public class DeleteTicketPage extends WebPage {
    @Name("Тикеты")
    private SelenideElement tickets = $x("//a[text()='Тикеты']");

    @Name("Удалить тикет")
    private SelenideElement deleteTicket = $x("//li[contains(text(),'Удалить тикет')]");

    @Name("Нет, не удалять")
    private SelenideElement dontDeleteTicket = $x("//button[contains(text(),'Нет, не удалять')]");

    @Name("Да, Я Понимаю - Всё Равно Удалить")
    private SelenideElement yesDeleteTicket = $x("//button[contains(text(),'Да, Я Понимаю - Всё Равно Удалить')]");
}

package pages;

import com.codeborne.selenide.SelenideElement;
import ru.lanit.at.web.annotations.Name;
import ru.lanit.at.web.pagecontext.WebPage;

import static com.codeborne.selenide.Selenide.$x;

@Name(value = "Sandbox Создание тикета")
public class SandboxCreateTicketPage extends WebPage {

    @Name("Очередь")
    private SelenideElement queueDropdown = $x("//select[@name='queue']");

    @Name("Краткое описание проблемы")
    private SelenideElement shortDescriptionProblemField = $x("//label[contains(text(),'Краткое описание проблемы')]/..//input[@type='text']");

    @Name("Описание вашей проблемы")
    private SelenideElement descriptionProblemField = $x("//textarea[@id='id_body']");

    @Name("Приоритет")
    private SelenideElement priority = $x("//select[@id='id_priority']");

    @Name("Выполнить до")
    private SelenideElement doUntil = $x("//input[@name='due_date']");

    @Name("Выберите файл")
    private SelenideElement chooseFileButton = $x("//label[contains(text(),'Прикрепить файл')]/..//input[@type='file']");

    @Name("Ваш адрес электронной почты")
    private SelenideElement submitterEmail = $x("//input[@name='submitter_email']");

}

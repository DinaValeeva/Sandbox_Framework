package pages;

import com.codeborne.selenide.SelenideElement;
import ru.lanit.at.web.annotations.Name;
import ru.lanit.at.web.pagecontext.WebPage;

import static com.codeborne.selenide.Selenide.$x;

@Name(value = "Удалить адрес в поле 'Копия'")
public class DeleteCCPage extends WebPage {

    @Name("Не удалять")
    private SelenideElement dontDelete = $x("//button[@class = 'btn btn-primary btn-lg' and text()='Не удалять']");

    @Name("Да, Я Понимаю - Удалить")
    private SelenideElement delete = $x("//button[@class = 'btn btn-danger' and text()='Да, Я Понимаю - Удалить']");

    @Name("Электронная почта")
    private SelenideElement email = $x("//div[@id='content-wrapper']//em");

}

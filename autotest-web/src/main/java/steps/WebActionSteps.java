package steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.ru.Если;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.lanit.at.api.testcontext.ContextHolder;
import ru.lanit.at.web.pagecontext.PageManager;
import ru.lanit.at.utils.Sleep;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.io.File;

import static com.codeborne.selenide.Selenide.$;


public class WebActionSteps {

    private PageManager pageManager;
    private static final Logger LOGGER = LoggerFactory.getLogger(WebActionSteps.class);

    public static String firstTicketName;

    public WebActionSteps(PageManager manager) {
        this.pageManager = manager;
    }

    /**
     * нажимает на элемент по тексту
     *
     * @param text текст элемента
     */
    @Когда("кликнуть на элемент по тексту {string}")
    public void clickElementWithText(String text) {
        $(Selectors.byText(text))
                .shouldBe(Condition.visible)
                .click();
        LOGGER.info("клик на элемент по тексту '{}'", text);
    }

    @Если("кликнуть на элемент {string}")
    public void clickOnElement(String elementName) {
        SelenideElement element = pageManager
                .getCurrentPage()
                .getElement(elementName);
        element
                .shouldBe(Condition.visible)
                .click();
        LOGGER.info("клик на элемент '{}'", elementName);
    }

    @Если("сделать двойной клик на элемент {string}")
    public void doubleClickOnElement(String elementName) {
        SelenideElement element = pageManager
                .getCurrentPage()
                .getElement(elementName);
        element
                .shouldBe(Condition.visible)
                .doubleClick();
        LOGGER.info("двойной клик на элемент '{}'", elementName);
    }

    /**
     * скролл до элемента
     *
     * @param elementName наименование элемента
     */
    @Когда("проскролить страницу до элемента {string}")
    public void scrollToElement(String elementName) {
        SelenideElement element = pageManager.getCurrentPage().getElement(elementName);
        element.shouldBe(Condition.visible)
                .scrollIntoView("{block: 'center'}");
        LOGGER.info("скролл страницы до элемента '{}'", elementName);
    }

    /**
     * скролл до текста
     *
     * @param text текст
     */
    @Когда("проскролить страницу до текста {string}")
    public void scrollToText(String text) {
        SelenideElement element = $(Selectors.byText(text));
        element.shouldBe(Condition.visible)
                .scrollIntoView("{block: 'center'}");
        LOGGER.info("скролл страницы до текста '{}'", text);
    }

    @И("подождать {int} сек")
    public void waitSeconds(int timeout) {
        Sleep.pauseSec(timeout);
    }

    /**
     * Ввод значения в элемент
     *
     * @param field - наименование элемента
     * @param value - значение
     */
    @Когда("ввести в поле {string} значение {string}")
    public void fillTheField(String field, String value) {
        SelenideElement fieldElement = pageManager
                .getCurrentPage()
                .getElement(field);
        fieldElement
                .shouldBe(Condition.visible)
                .setValue(value);
        LOGGER.info("в поле '{}' введено значение '{}'", field, value);
    }

    /**
     * Очистка поля
     *
     * @param elementName наименование элемента
     */
    @Если("очистить поле {string}")
    public void clearFiled(String elementName) {
        pageManager
                .getCurrentPage()
                .getElement(elementName)
                .shouldBe(Condition.visible)
                .clear();
    }

    @Если("в выпадающем списке {string} выбрать {string}")
    public void selectValueDropdown(String list, String value) {
        SelenideElement element = pageManager
                .getCurrentPage()
                .getElement(list);
        if (value.startsWith("#")) {
            value = ContextHolder.getValue(value.substring(1));
        }
        element
                .shouldBe(Condition.visible)
                .selectOptionContainingText(value);
        LOGGER.info("в списке '{}' выбран элемент '{}'", list, value);
    }

    @Если("в выпадающем списке {string} выбрать случайное значение и сохранить по ключу {string}")
    public void selectRandomValueDropdown(String list, String key) {
        SelenideElement dropdown = pageManager
                .getCurrentPage()
                .getElement(list);
        List<WebElement> valuesList = dropdown.findElements(By.xpath(".//option[not(starts-with(text(), '--'))]"));
        String value = valuesList.get(new Random().nextInt(valuesList.size())).getText();
        dropdown
                .shouldBe(Condition.visible)
                .selectOptionContainingText(value);
        ContextHolder.put(key, value);
        LOGGER.info("в списке '{}' выбран элемент '{}' и сохранен по ключу '{}'", list, value, key);
    }

    @Если("с помощью элемента {string} загрузить файл, расположенный по адресу {string}")
    public void downloadFile(String elementName, String path) {
        SelenideElement element = pageManager
                .getCurrentPage()
                .getElement(elementName);
        element.uploadFile(new File(path));
        LOGGER.info(path, "был успешно загружен");
    }

    @Если("кликнуть на первый тикет")
    public void clickOnFirstTicket() {
        SelenideElement element = pageManager
                .getCurrentPage()
                .getElement("Первый тикет");
        element
                .shouldBe(Condition.visible)
                .click();
        LOGGER.info("клик на элемент 'Первый тикет'");
    }

    @И("запомнить первый тикет")
    public void saveFirstTicket() {
        firstTicketName = pageManager
                .getCurrentPage()
                .getElement("Первый тикет")
                .text();
    }

    @И("выбрать {int} тикетов в списке путем активации чекбокса")
    public void activateCheckboxInElement(int ticketNumber) {
        SelenideElement tableTicket = pageManager
                .getCurrentPage()
                .getElement("Таблица тикетов");
        for (int i = 1; i <= ticketNumber; i++) {
            WebElement ticket = tableTicket.findElement(By.xpath(".//tbody//tr[" + i + "]"));
            ticket.findElement(By.xpath(".//input[@type='checkbox']")).click();
        }
        LOGGER.info("выбраны {} тикетов в списке путем активации чекбокса", ticketNumber);
    }

    @И("запомнить имена выбранных тикетов")
    public void saveCheckedCheckboxesNames() {
        SelenideElement tableTicket = pageManager
                .getCurrentPage()
                .getElement("Таблица тикетов");
        Set<String> checkedTicketNames = new HashSet<>();
        List<WebElement> allTicketsList = tableTicket.findElements(By.xpath(".//tbody//tr"));
        for (WebElement webElement : allTicketsList) {
            if (webElement.findElement(By.xpath(".//input[@type='checkbox']")).isSelected()) {
                checkedTicketNames.add(webElement.findElement(By.xpath(".//div[@class='tickettitle']//a")).getText());
            }
        }
        ContextHolder.put("checkedTicketNames", checkedTicketNames);
        LOGGER.info("сохранены имена выбранных тикетов");
    }

    @Если("активировать чекбокс {string}")
    public void checkboxOn(String elementName) {
        SelenideElement element = pageManager
                .getCurrentPage()
                .getElement(elementName);
        element
                .should(Condition.type("checkbox"))
                .click();
        LOGGER.info("активирован чекбокс '{}'", elementName);
    }

    @Если("деактивировать чекбокс {string}")
    public void checkboxOff(String elementName) {
        SelenideElement element = pageManager
                .getCurrentPage()
                .getElement(elementName);
        element
                .shouldBe(Condition.checked)
                .click();
        LOGGER.info("деактивирован чекбокс '{}'", elementName);
    }

    @И("выбрать все пункты в контекстном меню")
    public void selectAllButtonsInMenu() {
        SelenideElement columnVisibility = pageManager
                .getCurrentPage()
                .getElement("Контекстное меню Column visibility");
        List<WebElement> allButtons = columnVisibility.findElements(By.xpath(".//button"));
        for (WebElement webElement : allButtons) {
            if (!webElement.getAttribute("class").contains("active")) {
                webElement.click();
            }
        }
        LOGGER.info("Выбраны все пункты контекстного меню");
    }

    @И("в таблице {string} произведен клик по столбцу {string}")
    public void clickColumn(String tableName, String columnName) {
        SelenideElement table = pageManager
                .getCurrentPage()
                .getElement(tableName);
        SelenideElement column = table.find(By.xpath(".//thead//th[contains(text(),'" + columnName + "')]"));
        column
                .shouldBe(Condition.visible)
                .click();
        LOGGER.info("в таблице '{}' произведен клик по столбцу '{}'", tableName, columnName);
    }

    @И("выбрать {int} страницу таблицы тикетов")
    public void selectPageTicketTable(Integer pageNumber) {
        SelenideElement buttonBlock = pageManager
                .getCurrentPage()
                .getElement("Блок кнопок с номерами страниц таблицы тикетов");
        SelenideElement page = buttonBlock.find(By.xpath(".//li//a[contains(text(),'" + pageNumber + "')]"));
        page
                .shouldBe(Condition.visible)
                .click();
        LOGGER.info("выбрана '{}' страница таблицы тикетов", pageNumber);
    }

    @И("выбрать случайный тикет")
    public void selectRandomTicket() {
        SelenideElement table = pageManager
                .getCurrentPage()
                .getElement("Таблица тикетов");
        ElementsCollection rows = table.findAll(By.xpath(".//tbody/tr"));
        SelenideElement ticket = rows.get(new Random().nextInt(rows.size() - 1)).find(By.xpath(".//td[2]/div/a"));
        ticket
                .shouldBe(Condition.visible)
                .click();
        LOGGER.info("выбран случайный тикет");
    }

    @И("нажать кнопку 'Удалить' для пункта {string} в таблице")
    public void removeItemFromTable(String item) {
        SelenideElement table = pageManager
                .getCurrentPage()
                .getElement("Таблица для поля 'Копия'");
        ElementsCollection rows = table.findAll(By.xpath(".//tbody/tr"));
        for (SelenideElement element : rows) {
            if (element.find(By.xpath(".//td[1]")).getText().equals(item)) {
                element.find(By.xpath(".//button[contains(text(),'Удалить')]")).click();
                break;
            }
        }
        LOGGER.info("нажата кнопка 'Удалить' для пункта '{}' в таблице", item);
    }

}

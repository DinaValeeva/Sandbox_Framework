package steps;

import actions.WebChecks;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.ParameterType;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import ru.lanit.at.utils.Sleep;
import ru.lanit.at.web.pagecontext.PageManager;

import java.util.List;
import java.util.Map;

public class WebCheckSteps {

    private PageManager pageManager;
    private static final Logger LOGGER = LoggerFactory.getLogger(WebCheckSteps.class);

    public WebCheckSteps(PageManager pageManager) {
        this.pageManager = pageManager;
    }

    /**
     * проверка присутствия текста на странице
     *
     * @param text текст
     */
    @Когда("на странице присутствует текст {string}")
    public void textAppearOnThePage(String text) {
        WebChecks.textVisibleOnPage(text, null);
        LOGGER.info("на странице '{}' имеется текст '{}'", pageManager.getCurrentPage().name(), text);
    }

    /**
     * проверка отсутствия текста на странице
     *
     * @param text текст
     */
    @Когда("на странице отсутствует текст {string}")
    public void textVisibleOnPage(String text) {
        WebChecks.textAbsentOnPage(text, null);
        LOGGER.info("на странице '{}' отсутствует текст '{}'", pageManager.getCurrentPage().name(), text);
    }

    /**
     * ожидание появления текста на странице в течении некоторого времени
     *
     * @param text           текст
     * @param timeoutSeconds количество секунд
     */
    @Когда("подождать появления текста {string} в течение {int} секунд")
    public void waitUntilTextAppearOnPage(String text, int timeoutSeconds) {
        WebChecks.textVisibleOnPage(text, timeoutSeconds);
        LOGGER.info("на странице '{}' имеется текст '{}'", pageManager.getCurrentPage().name(), text);
    }

    /**
     * ожидание исчезновения текста на странице в течении некоторого времени
     *
     * @param text           текст
     * @param timeoutSeconds количество секунд
     */
    @Когда("подождать исчезновения текста {string} в течение {int} секунд")
    public void waitUntilTextAbsentOnPage(String text, int timeoutSeconds) {
        WebChecks.textAbsentOnPage(text, timeoutSeconds);
        LOGGER.info("на странице '{}' отсутствует текст '{}'", pageManager.getCurrentPage().name(), text);
    }

    /**
     * ожидание элемента на странице в течении некоторого времени
     *
     * @param elementName    наименование элемента
     * @param timeoutSeconds количество секунд
     */
    @Когда("подождать появления элемента {string} в течение {int} секунд")
    public void waitUntilElementIsVisibleOnPage(String elementName, int timeoutSeconds) {
        SelenideElement element = pageManager
                .getCurrentPage()
                .getElement(elementName);
        WebChecks.elementVisibleOnPage(element, timeoutSeconds);
        LOGGER.info("на странице '{}' имеется элемент '{}'", pageManager.getCurrentPage().name(), elementName);
    }

    /**
     * проверка, что на странице отображен элемент
     *
     * @param elementName наименование элемента
     */
    @Когда("на странице имеется элемент {string}")
    public void elementAppearOnThePage(String elementName) {
        SelenideElement element = pageManager
                .getCurrentPage()
                .getElement(elementName);
        WebChecks.elementVisibleOnPage(element, null);
        LOGGER.info("на странице '{}' имеется элемент '{}'", pageManager.getCurrentPage().name(), elementName);
    }

    /**
     * проверка, что на странице отсутствует элемент
     *
     * @param elementName наименование элемента
     */
    @Когда("на странице отсутствует элемент {string}")
    public void elementAbsentOnPage(String elementName) {
        SelenideElement element = pageManager
                .getCurrentPage()
                .getElement(elementName);
        WebChecks.elementAbsentOnPage(element, null);
        LOGGER.info("на странице '{}' отсутствует элемент '{}'", pageManager.getCurrentPage().name(), elementName);
    }

    /**
     * проверка текущего url
     * <br/>можно начать написание url с переменной %{apiUrl}% или %{webUrl}%
     *
     * @param url часть или полный url (также может содержать переменные)
     */
    @Тогда("проверить что текущий url соответствует {string}")
    public void currentUrlEqualsExpected(String url) {
        WebChecks.urlEquals(url);
    }

    /**
     * проверка текущего url
     * <br/>можно начать написание url с переменной %{apiUrl}% или %{webUrl}%
     *
     * @param url часть url (также может содержать переменные)
     */
    @Тогда("проверить что текущий url содержит текст {string}")
    public void currentUrlContainsExpected(String url) {
        WebChecks.urlContains(url);
    }

    /**
     * проверка значения текста в поле
     *
     * @param fieldName    название поля
     * @param expectedText текст
     */
    @Когда("проверить, что поле {string} заполнено значением {string}")
    public void checkFieldEqualsText(String fieldName, String expectedText) {
        SelenideElement element = pageManager.getCurrentPage().getElement(fieldName);
        WebChecks.checkAttribute(element, "value", expectedText, 10);
        LOGGER.info("в поле '{}' содержится текст '{}'", fieldName, expectedText);
    }

    /**
     * проверка наличия текста в поле
     *
     * @param fieldName    название поля
     * @param expectedText текст
     */
    @Когда("проверить, что поле {string} содержит значение {string}")
    public void checkFieldContainsText(String fieldName, String expectedText) {
        SelenideElement element = pageManager.getCurrentPage().getElement(fieldName);
        WebChecks.checkIsContains(element, expectedText, 0);
        LOGGER.info("в поле '{}' содержится текст '{}'", fieldName, expectedText);
    }

    /**
     * проверка значений в полях
     *
     * @param map пара имя поля - ожидаемое наличие текста в поле
     */
    @Когда("проверить, что в полях содержатся значения:")
    public void checkFieldsContainsText(Map<String, String> map) {
        for (Map.Entry<String, String> pair : map.entrySet()) {
            checkFieldContainsText(pair.getKey(), pair.getValue());
        }
    }

    /**
     * проверка выбранного значения в выпадающем списке
     *
     * @param fieldName    название списка
     * @param expectedText ожидаемое значение
     */
    @Когда("проверить, что в выпадающем списке {string} выбрано {string}")
    public void checkIsSelectedInDropdown(String fieldName, String expectedText) {
        SelenideElement element = pageManager.getCurrentPage().getElement(fieldName);
        WebChecks.checkIsSelectedInDropdown(element, expectedText, 10);
        LOGGER.info("в списке '{}' содержится значение '{}'", fieldName, expectedText);
    }

    /**
     * проверка наличия значений в выпадающем списке
     *
     * @param fieldName название списка
     * @param fields    ожидаемые значения
     */
    @Когда("проверить, что в выпадающем списке {string} присутствуют поля:")
    public void checkDropdownContainsTexts(String fieldName, List<String> fields) {
        SelenideElement element = pageManager.getCurrentPage().getElement(fieldName);
        fields.forEach(field -> WebChecks.checkIsContains(element, field, 0));
        LOGGER.info("в списке '{}' содержатся значения '{}'", fieldName, fields);
    }

    /**
     * проверка является/не является ссылкой
     *
     * @param elementName название элемента
     */
    @Когда("проверить, что элемент {string} является ссылкой")
    public void checkElementLink(String elementName) {
        SelenideElement element = pageManager.getCurrentPage().getElement(elementName);
        WebChecks.isElementLink(element);
        LOGGER.info("Элемент '{}' - является ссылкой", elementName);
    }

    @Когда("проверить, что элемент {string} не является ссылкой")
    public void checkElementNotLink(String elementName) {
        SelenideElement element = pageManager.getCurrentPage().getElement(elementName);
        WebChecks.isElementNotLink(element);
        LOGGER.info("Элемент '{}' - не является ссылкой", elementName);
    }

    @Когда("проверить, что первый тикет удален")
    @Когда("проверить, что первый тикет отсутствует на странице")
    public void checkFirstTicketDeleted() {
        WebChecks.ticketWithNameAbsentOnPage(WebActionSteps.firstTicketName);
    }

    /**
     * проверка активации чекбокса
     *
     * @param fieldName название чекбокса
     */
    @Когда("проверить, что чекбокс {string} активирован")
    public void isCheckboxChecked(String fieldName) {
        SelenideElement element = pageManager.getCurrentPage().getElement(fieldName);
        WebChecks.checkAttribute(element, "type", "checkbox", 10);
        WebChecks.isAttributeExist(element, "checked", 10);
        LOGGER.info("проверка успешна, чекбокс '{}' активирован", fieldName);
    }

    /**
     * проверка деактивации чекбокса
     *
     * @param fieldName название чекбокса
     */
    @Когда("проверить, что чекбокс {string} деактивирован")
    public void isCheckboxNotChecked(String fieldName) {
        SelenideElement element = pageManager.getCurrentPage().getElement(fieldName);
        WebChecks.checkAttribute(element, "type", "checkbox", 10);
        WebChecks.isAttributeNotExist(element, "checked", 10);
        LOGGER.info("проверка успешна, чекбокс '{}' активирован", fieldName);
    }

    /**
     * проверка сортировки таблицы по столбцу по возрастанию/убыванию
     *
     * @param tableName  название таблицы
     * @param columnName название столбца
     * @param isAscSort  тип сортировки (по возрастанию)
     */

    @И("проверить, что в таблице {string} столбец {string} отсортирован по {sortingTypeAscDesc}")
    public void checkTableSortingType(String tableName, String columnName, boolean isAscSort) {
        Sleep.pauseSec(1);
        SelenideElement table = pageManager
                .getCurrentPage()
                .getElement(tableName);
        WebElement column = table.findElement(By.xpath(".//thead//th[contains(text(),'" + columnName + "')]"));
        if (isAscSort) {
            Assert.assertEquals(column.getAttribute("class"), "sorting_asc");
            LOGGER.info("проверка успешна, столбец '{}' отсортирован по возрастанию", columnName);
        } else {
            Assert.assertEquals(column.getAttribute("class"), "sorting_desc");
            LOGGER.info("проверка успешна, столбец '{}' отсортирован по убыванию", columnName);
        }
    }

    @ParameterType("(возрастанию|убыванию)")
    public boolean sortingTypeAscDesc(String type) {
        return type.equals("возрастанию");
    }

    /**
     * проверка номера активной страницы таблицы тикетов
     *
     * @param pageNumber номер страницы
     */
    @И("проверить, что открыта {int} страница таблицы тикетов")
    public void selectPageTicketTable(Integer pageNumber) {
        SelenideElement buttonBlock = pageManager
                .getCurrentPage()
                .getElement("Блок кнопок с номерами страниц таблицы тикетов");
        WebElement page = buttonBlock.findElement(By.xpath(".//li//a[contains(text(),'" + pageNumber + "')]/.."));
        Assert.assertEquals(page.getAttribute("class"), "paginate_button page-item active");
        LOGGER.info("проверка успешна, выбрана '{}' страница таблицы тикетов", pageNumber);
    }

}

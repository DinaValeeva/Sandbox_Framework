package pages;

import com.codeborne.selenide.SelenideElement;
import ru.lanit.at.web.annotations.Name;
import ru.lanit.at.web.pagecontext.WebPage;

import static com.codeborne.selenide.Selenide.$x;

@Name(value = "Отчёты и Статистика")
public class ReportsAndStatisticsPage extends WebPage {

    @Name("Отчёты и Статистика")
    private SelenideElement reportsAndStatistics = $x("//div[@id='content-wrapper']//a[@href='/reports/']");

    @Name("here")
    private SelenideElement here = $x("//a[@href='/reports/daysuntilticketclosedbymonth']");

    @Name("Выберите запрос:")
    private SelenideElement savedQuery = $x("//select[@name='saved_query']");

    @Name("Отчет фильтра")
    private SelenideElement filterReport = $x("//input[@value='Отчет фильтра']");

    @Name("Отчеты в разрезе Пользователей: по Приоритету")
    private SelenideElement userPriority = $x("//li[contains(.,'Отчеты в разрезе Пользователей')]//a[@href='userpriority/']");

    @Name("Отчеты в разрезе Пользователей: по Очереди")
    private SelenideElement userQueue = $x("//li[contains(.,'Отчеты в разрезе Пользователей')]//a[@href='userqueue/']");

    @Name("Отчеты в разрезе Пользователей: по Статусу")
    private SelenideElement userStatus = $x("//li[contains(.,'Отчеты в разрезе Пользователей')]//a[@href='userstatus/']");

    @Name("Отчеты в разрезе Пользователей: по Месяцам")
    private SelenideElement userMonth = $x("//li[contains(.,'Отчеты в разрезе Пользователей')]//a[@href='usermonth/']");

    @Name("Отчеты в разрезе Очередей: по Приоритету")
    private SelenideElement queuePriority = $x("//li[contains(.,'Отчеты в разрезе Очередей')]//a[@href='queuepriority/']");

    @Name("Отчеты в разрезе Очередей: по Статусу")
    private SelenideElement queueStatus = $x("//li[contains(.,'Отчеты в разрезе Очередей')]//a[@href='queuestatus/']");

    @Name("Отчеты в разрезе Очередей: по Месяцам")
    private SelenideElement queueMonth = $x("//li[contains(.,'Отчеты в разрезе Очередей')]//a[@href='queuemonth/']");

    @Name("Отчеты в разрезе Очередей: Days until ticket closed by Month")
    private SelenideElement daysUntilTicketClosedByMonth = $x("//li[contains(.,'Отчеты в разрезе Очередей')]//a[@href='daysuntilticketclosedbymonth/']");

    @Name("Блок Пользователи по Приоритетам")
    private SelenideElement blockUserPriority = $x("//div[@class='card mb-3' and contains(., 'Пользователи по Приоритетам')]");

    @Name("Блок Пользователи по Очередям")
    private SelenideElement blockUserQueue = $x("//div[@class='card mb-3' and contains(., 'Пользователи по Очередям')]");

    @Name("Блок Пользователи по Статусам")
    private SelenideElement blockUserStatus = $x("//div[@class='card mb-3' and contains(., 'Пользователи по Статусам')]");

    @Name("Блок Пользователи по Месяцам")
    private SelenideElement blockUserMonth = $x("//div[@class='card mb-3' and contains(., 'Пользователи по Месяцам')]");

    @Name("Блок Очереди по Приоритетам")
    private SelenideElement blockQueuePriority = $x("//div[@class='card mb-3' and contains(., 'Очереди по Приоритетам')]");

    @Name("Блок Очереди по Статусам")
    private SelenideElement blockQueueStatus = $x("//div[@class='card mb-3' and contains(., 'Очереди по Статусам')]");

    @Name("Блок Очереди по Месяцам")
    private SelenideElement blockQueueMonth = $x("//div[@class='card mb-3' and contains(., 'Очереди по Месяцам')]");

    @Name("Блок Days until ticket closed by Month")
    private SelenideElement blockDaysUntilTicketClosedByMonth = $x("//div[@class='card mb-3' and contains(., 'Days until ticket closed by Month')]");

}

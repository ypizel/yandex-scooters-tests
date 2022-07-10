package ChromeTests.ErrorsInOrderForms;

import PageObgect.ErrorsMessages;
import PageObgect.OrderFields;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import static Constants.URL.FIRST_ORDER_PAGE;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ErrorsInNameFIeld {

    private WebDriver driver;
    private Actions builder;
    private final String name;
    private final String expectedErrorMessage;

    public ErrorsInNameFIeld(String name, String expectedErrorMessage){
        this.name = name;
        this.expectedErrorMessage = expectedErrorMessage;
    }

    @Parameterized.Parameters
    public static Object[][] getNames(){
        return new Object[][]{
                {"", "Введите корректное имя"},
                {"Ю", "Введите корректное имя"},
                {"О'Донел", "Введите корректное имя"},
                {"Альбус Персиваль", "Введите корректное имя"},
                {"Мак-Кинли", "Введите корректное имя"},
                {"Ходжаджалалетдини", "Введите корректное имя"},
        };
    }
    @Before
    public void setDriver() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        builder = new Actions(driver);
    }

    @Test
    public void checkErrorsInNameField() {
        driver.get(FIRST_ORDER_PAGE);
        ErrorsMessages errorsMessages = new ErrorsMessages(driver);
        OrderFields orderFields = new OrderFields(driver);
        orderFields.setName(name);
        builder.sendKeys(Keys.TAB).build().perform();
        String actualResult = errorsMessages.getNameErrorMessage();
        assertEquals(expectedErrorMessage, actualResult);
    }
    @After
    public void teardown(){
        driver.quit();
    }
    }


package ChromeTests.ErrorsInOrderForms;

import PageObject.ErrorsMessages;
import PageObject.OrderFields;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ErrorsInNameFIeld {

    private WebDriver driver;
    private OrderFields orderFields;
    private ErrorsMessages errorsMessages;
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
        orderFields = new OrderFields(driver);
        errorsMessages = new ErrorsMessages(driver);
    }

    @Test
    public void checkErrorsInNameField() {
        driver.get(errorsMessages.FIRST_ORDER_FIELD);
        orderFields.setName(name);
        builder.sendKeys(Keys.TAB).build().perform();
        assertEquals(expectedErrorMessage, errorsMessages.getNameErrorMessage());
    }
    @After
    public void teardown(){
        driver.quit();
    }
    }


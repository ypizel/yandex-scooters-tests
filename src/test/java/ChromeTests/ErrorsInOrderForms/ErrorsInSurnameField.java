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
public class ErrorsInSurnameField {

    private WebDriver driver;
    private ErrorsMessages errorsMessages;
    private Actions builder;
    private final String surname;
    private final String expectedErrorMessage;

    public ErrorsInSurnameField(String surname, String expectedErrorMessage){
        this.surname = surname;
        this.expectedErrorMessage = expectedErrorMessage;
    }

    @Parameterized.Parameters
    public static Object[][] getNames(){
        return new Object[][]{
                {"", "Введите корректную фамилию"},
                {"Ю", "Введите корректную фамилию"},
                {"О'Донел", "Введите корректную фамилию"},
                {"Альбус Персиваль", "Введите корректную фамилию"},
                {"Мак-Кинли", "Введите корректную фамилию"}
        };
    }
    @Before
    public void setDriver() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        builder = new Actions(driver);
        errorsMessages = new ErrorsMessages(driver);
    }
    @Test
    public void checkErrorsInSurnameField() {
        driver.get(errorsMessages.FIRST_ORDER_FIELD);
        OrderFields orderFields = new OrderFields(driver);
        orderFields.setSurname(surname);
        builder.sendKeys(Keys.TAB).build().perform();
        String actualResult = errorsMessages.getSurnameErrorMassage();
        assertEquals(expectedErrorMessage, actualResult);
    }
    @After
    public void teardown(){
        driver.quit();
    }
}



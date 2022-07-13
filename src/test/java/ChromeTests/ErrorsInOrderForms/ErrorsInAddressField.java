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
public class ErrorsInAddressField {

    private WebDriver driver;
    private ErrorsMessages errorsMessages;
    private OrderFields orderFields;
    private Actions builder;
    private final String address;
    private final String expectedErrorMessage;

    public ErrorsInAddressField(String address, String expectedErrorMessage){
        this.address = address;
        this.expectedErrorMessage = expectedErrorMessage;
    }

    @Parameterized.Parameters
    public static Object[][] getNames(){
        return new Object[][]{
                {"М", "Введите корректный адрес"},
                {"Ма", "Введите корректный адрес"},
                {"Мая", "Введите корректный адрес"},
                {"Маяк", "Введите корректный адрес"},
                {"Mayakovskaya", "Введите корректный адрес"},
                {"Маяковская !", "Введите корректный адрес"},
        };
    }
    @Before
    public void setDriver() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        builder = new Actions(driver);
        errorsMessages = new ErrorsMessages(driver);
        orderFields = new OrderFields(driver);
    }

    @Test
    public void checkErrorsInPhoneField() {
        driver.get(errorsMessages.FIRST_ORDER_FIELD);
        orderFields.setAddress(address);
        builder.sendKeys(Keys.TAB).build().perform();
        String actualResult = errorsMessages.getAddressErrorMassage();
        assertEquals(expectedErrorMessage, actualResult);
    }
    @After
    public void teardown(){
        driver.quit();
    }
}




package ChromeTests.ErrorsInOrderForms;
import PageObject.ErrorsMessages;
import PageObject.HomePage;
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
public class ErrorsInPhoneField {

        private WebDriver driver;
        private ErrorsMessages errorsMessages;
        private Actions builder;
        private final String phoneNumber;
        private final String expectedErrorMessage;

        public ErrorsInPhoneField(String phoneNumber, String expectedErrorMessage){
            this.phoneNumber = phoneNumber;
            this.expectedErrorMessage = expectedErrorMessage;
        }

        @Parameterized.Parameters
        public static Object[][] getNames(){
            return new Object[][]{
                    {"", "Введите корректный номер"},
                    {"8", "Введите корректный номер"},
                    {"-79113445577", "Введите корректный номер"},
                    {"+7911344557721", "Введите корректный номер"}
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
        public void checkErrorsInPhoneField() {
            driver.get(errorsMessages.FIRST_ORDER_FIELD);
            OrderFields orderFields = new OrderFields(driver);
            orderFields.setPhoneNumber(phoneNumber);
            builder.sendKeys(Keys.TAB).build().perform();
            String actualResult = errorsMessages.getPhoneNumberErrorMassage();
            assertEquals(expectedErrorMessage, actualResult);
        }
        @After
        public void teardown(){
            driver.quit();
        }
    }




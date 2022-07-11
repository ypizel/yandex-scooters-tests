package ChromeTests;

import PageObgect.OrderFields;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static Constants.URL.YANDEX_SCOOTER;
import static org.junit.Assert.assertTrue;

public class ScooterOrder {

    private WebDriver driver;
    private OrderFields orderFields;
    @Before
    public void setDriver(){
        // Создаём драйвер для браузера Chrome
        System.setProperty("webdriver.chrome.driver" , "chromedriver.exe");
        driver = new ChromeDriver();
        orderFields = new OrderFields(driver);
    }
    @Test
     public void checkMakeOrderWithTopButton() {
        driver.get(YANDEX_SCOOTER);
        orderFields.clickTopOrderButton();
        orderFields.setAllOrderFields();
        assertTrue("Заказ не оформлен", orderFields.getOrderStatus().isDisplayed());
    }

    @Test
    public void checkMakeOrderWithBottomButton() {
        driver.get(YANDEX_SCOOTER);
        orderFields.clickBottomOrderButton();
        orderFields.setAllOrderFields();
        assertTrue("Заказ не оформлен", orderFields.getOrderStatus().isDisplayed());
    }
    @After
    public void teardown(){
        driver.quit();
    }
}
// ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", locator1);
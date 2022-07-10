package ChromeTests;

import PageObgect.OrderFields;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static Constants.URL.YANDEX_SCOOTER;
import static org.junit.Assert.assertTrue;

public class ScooterOrder {

    private WebDriver driver;

    @Before
    public void setDriver(){
        // Создаём драйвер для браузера Chrome
        System.setProperty("webdriver.chrome.driver" , "chromedriver.exe");
        driver = new ChromeDriver();
    }
    @Test
     public void checkMakeOrderWithTopButton() {
        driver.get(YANDEX_SCOOTER);
        OrderFields orderFields = new OrderFields(driver);
        orderFields.clickTopOrderButton();
        WebDriverWait pause = new WebDriverWait(driver, 3);
            pause.until(ExpectedConditions.elementToBeClickable(orderFields.getNameFieldLocator()));
        orderFields.setClientInfo();
            pause.until(ExpectedConditions.elementToBeClickable(orderFields.getDeliveryDateFieldLocator()));
        orderFields.setScooterInformation();
            pause.until(ExpectedConditions.elementToBeClickable(orderFields.getOrderConfirmationButtonLocator()));
        orderFields.clickOrderConfirmationButton();
        assertTrue("Заказ не оформлен", orderFields.getOrderStatus().isDisplayed());
    }

    @Test
    public void checkMakeOrderWithBottomButton() {
        driver.get(YANDEX_SCOOTER);
        OrderFields orderFields = new OrderFields(driver);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",orderFields.getBottomOrderButtonLocator());
        orderFields.clickBottomOrderButton();
        WebDriverWait pause = new WebDriverWait(driver, 3);
            pause.until(ExpectedConditions.elementToBeClickable(orderFields.getNameFieldLocator()));
        orderFields.setClientInfo();
            pause.until(ExpectedConditions.elementToBeClickable(orderFields.getDeliveryDateFieldLocator()));
        orderFields.setScooterInformation();
            pause.until(ExpectedConditions.elementToBeClickable(orderFields.getOrderConfirmationButtonLocator()));
        orderFields.clickOrderConfirmationButton();
        assertTrue("Заказ не оформлен", orderFields.getOrderStatus().isDisplayed());
    }
    @After
    public void teardown(){
        driver.quit();
    }
}
// ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", locator1);
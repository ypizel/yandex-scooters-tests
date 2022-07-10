package MozillaTests;

import PageObgect.OrderFields;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static Constants.URL.YANDEX_SCOOTER;
import static org.junit.Assert.assertTrue;

public class ScooterOrderMozilla {

    private WebDriver driver;

    @Before
    public void setDriver() {
        // Создаём драйвер для браузера Chrome
        System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
        driver = new FirefoxDriver();
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
    public void teardown() {
        driver.quit();
    }
}
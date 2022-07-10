package ChromeTests;

import PageObgect.HomePage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static Constants.URL.YANDEX_SCOOTER;
import static org.junit.Assert.assertEquals;

public class WrongOrderNumber {

    public WebDriver driver;
    String expectedRedult = "Такого заказа нет";

    @Before
    public void setDriver() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void putWrongOrderNumberNoOrder() {
        driver.get(YANDEX_SCOOTER);
        HomePage homePage = new HomePage(driver);
        WebDriverWait pause = new WebDriverWait(driver, 3);
            pause.until(ExpectedConditions.elementToBeClickable(homePage.getOrderStatusButtonLocator()));
        homePage.clickOrderStatusButton();
            pause.until(ExpectedConditions.visibilityOf(homePage.getOrderStatusFieldLocator()));
        homePage.setOrderStatus("123454");
        String actualResult = homePage.getNoOrderNotification();
        assertEquals(expectedRedult, actualResult);
    }
    @After
    public void teardown(){
        driver.quit();
    }
}

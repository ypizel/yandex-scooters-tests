package ChromeTests;

import PageObgect.HomePage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static Constants.URL.YANDEX_SCOOTER;
import static org.junit.Assert.assertTrue;

public class WrongOrderNumber {

    private WebDriver driver;
    private HomePage homePage;

    @Before
    public void setDriver() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
    }

    @Test
    public void putWrongOrderNumberNoOrder() {
        driver.get(YANDEX_SCOOTER);
        homePage.clickOrderStatusButton();
        homePage.setOrderStatus("123454");
        assertTrue(homePage.getNoOrderNotification().isDisplayed());
    }
    @After
    public void teardown(){
        driver.quit();
    }
}

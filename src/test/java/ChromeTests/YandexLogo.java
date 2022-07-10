package ChromeTests;

import PageObgect.HomePage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

import static Constants.URL.YANDEX_SCOOTER;
import static org.junit.Assert.assertTrue;

public class YandexLogo {

    private WebDriver driver;

    @Before
    public void setDriver() {
        // Создаём драйвер для браузера Chrome
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void yandexLogoOpenNewTabWithYandexMainPage(){
        driver.get(YANDEX_SCOOTER);
        HomePage homePage = new HomePage(driver);
            WebDriverWait pause = new WebDriverWait(driver, 3);
            pause.until(ExpectedConditions.elementToBeClickable(homePage.getYandexLogoLocator()));
            homePage.clickYandexLogo();
            List<String> browserTabs = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(browserTabs .get(1));
            assertTrue(homePage.getMainPageYandexLogoLocator().isDisplayed());
        }

    @After
    public void teardown() {
        driver.quit();
    }

}

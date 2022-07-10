package ChromeTests;

import PageObgect.HomePage;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static Constants.URL.FIRST_ORDER_PAGE;

import static org.junit.Assert.assertTrue;

public class ScooterLogo {
    private WebDriver driver;

    @Before
    public void setDriver(){
        // Создаём драйвер для браузера Chrome
        System.setProperty("webdriver.chrome.driver" ,  "chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void checkClickYandexLogoLeadsToYandexMainPAge() {
    driver.get(FIRST_ORDER_PAGE);
    HomePage homePage = new HomePage(driver);
    WebDriverWait pause = new WebDriverWait(driver, 3);
        pause.until(ExpectedConditions.elementToBeClickable(homePage.getScooterLogoLocator()));
    homePage.clickScooterLogo();
        pause.until(ExpectedConditions.elementToBeClickable(homePage.getOrderButton()));
    assertTrue(homePage.getOrderButton().isDisplayed());
    }

    @After
    public void teardown() {
        driver.quit();
    }
}

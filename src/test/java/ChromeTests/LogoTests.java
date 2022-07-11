package ChromeTests;

import PageObgect.HomePage;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static Constants.URL.FIRST_ORDER_PAGE;
import static Constants.URL.YANDEX_SCOOTER;
import static org.junit.Assert.assertTrue;

public class LogoTests {
    private WebDriver driver;
    private HomePage homePage;

    @Before
    public void setDriver(){
        // Создаём драйвер для браузера Chrome
        System.setProperty("webdriver.chrome.driver" ,  "chromedriver.exe");
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
    }

    @Test
    public void checkClickScooterLogoLeadsToScooterMainPage() {
    driver.get(FIRST_ORDER_PAGE);

    homePage.clickScooterLogo();
    String expectedResult = "Самокат\n" + "на пару дней\n" + "Привезём его прямо к вашей двери,\n" + "а когда накатаетесь — заберём\n";
    assertTrue("Лого самокат не ведет на главную", expectedResult.contains(homePage.getMainPageHeaderText()));
    }

    @Test
    public void yandexLogoOpenNewTabWithYandexMainPage(){
        driver.get(YANDEX_SCOOTER);
        homePage.clickYandexLogo();
        assertTrue(homePage.getMainPageYandexLogoLocator().isDisplayed());
    }

    @After
    public void teardown() {
        driver.quit();
    }
}

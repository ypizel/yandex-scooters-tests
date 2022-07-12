package ChromeTests;

import PageObject.HomePage;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class LogoTests extends BaseChromeUITest {

    @Test
    public void checkClickScooterLogoLeadsToScooterMainPage() {
        String mainPageHeaderText = new HomePage(driver)
                .open()
                .clickScooterLogo()
                .getMainPageHeaderText();
        String expectedResult = "Самокат\n" + "на пару дней\n" + "Привезём его прямо к вашей двери,\n" + "а когда накатаетесь — заберём\n";
        assertTrue("Лого самокат не ведет на главную", expectedResult.contains(mainPageHeaderText));
    }

    @Test
    public void yandexLogoOpenNewTabWithYandexMainPage() {
        boolean isYandexLogoDisplayed = new HomePage(driver)
                .open()
                .clickYandexLogo()
                .getYandexLogoIsDisplayed();
        assertTrue(isYandexLogoDisplayed);
    }
}
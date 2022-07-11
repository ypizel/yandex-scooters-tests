package ChromeTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import PageObgect.FAQPanel;
import static Constants.Information.*;
import static Constants.URL.YANDEX_SCOOTER;
import static org.junit.Assert.assertEquals;

public class ImportantQuestions {

    private WebDriver driver;
    private FAQPanel faqPanel;
    @Before
    public void setDriver(){
        // Создаём драйвер для браузера Chrome
        System.setProperty("webdriver.chrome.driver" ,  "chromedriver.exe");
        driver = new ChromeDriver();
        faqPanel = new FAQPanel(driver);
    }

    @Test
    public void checkPaymentInfoRight(){
        driver.get(YANDEX_SCOOTER);
        assertEquals("Information not found or incorrect", PAYMENT_INFO, faqPanel.getPaymentInfo());
    }

    @Test
    public void checkAmountOfInfoRight(){
        driver.get(YANDEX_SCOOTER);
        assertEquals("Information not found or incorrect", AMOUNT_OF_SCOOTERS_INFO, faqPanel.getAmountOfScootersInfo() );
    }

    @Test
    public void checkRentTimeInfoRight(){
        driver.get(YANDEX_SCOOTER);
        assertEquals("Information not found or incorrect", RENT_TIME_INFO, faqPanel.getRentTimeInfo());
    }

    @Test
    public void checkScooterTodayInfoRight(){
        driver.get(YANDEX_SCOOTER);
        assertEquals("Information not found or incorrect", SCOOTER_TODAY_INFO,faqPanel.getScooterTodayInfo());
    }

    @Test
    public void checkExtendReturnInfoRight(){
        driver.get(YANDEX_SCOOTER);
        assertEquals("Information not found or incorrect", EXTEND_RETURN_INFO, faqPanel.getExtendReturnInfo());
    }

    @Test
    public void checkChargerCableInfoRight(){
        driver.get(YANDEX_SCOOTER);
        assertEquals("Information not found or incorrect", CHARGER_CABLE_INFO, faqPanel.getChargerCableInfo());
    }

    @Test
    public void checkOrderCancellationInfoRight(){
        driver.get(YANDEX_SCOOTER);
        assertEquals("Information not found or incorrect", ORDER_CANCELLATION_INFO, faqPanel.getOrderCancellationInfo());
    }

    @Test
    public void checkCoverageZoneInfoRight(){
        driver.get(YANDEX_SCOOTER);
        assertEquals("Information not found or incorrect", COVERAGE_ZONE_INFO, faqPanel.getCoverageZoneInfo());
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
package MozillaTests;

import PageObgect.InformationPanel;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static Constants.Information.*;
import static Constants.URL.YANDEX_SCOOTER;
import static org.junit.Assert.assertEquals;

public class ImportantQuestionsMozilla {

    private WebDriver driver;

    @Before
    public void setDriver(){
        // Создаём драйвер для браузера Chrome
        System.setProperty("webdriver.gecko.driver" ,  "geckodriver.exe");
        driver = new FirefoxDriver();
    }

    @Test
    public void checkPaymentInfoRight(){
        driver.get(YANDEX_SCOOTER);
        InformationPanel informationPanel = new InformationPanel(driver);
        WebElement locator1 = informationPanel.getPaymentButtonLocator();
        WebDriverWait pause = new WebDriverWait(driver, 3);
            pause.until(ExpectedConditions.elementToBeClickable(locator1));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", locator1);
        String actualResult = informationPanel.getPaymentInfo();
        assertEquals("Information not found or incorrect", PAYMENT_INFO, actualResult);
}

    @Test
    public void checkAmountOfInfoRight(){
        driver.get(YANDEX_SCOOTER);
        InformationPanel informationPanel = new InformationPanel(driver);
        WebDriverWait pause = new WebDriverWait(driver, 3);
        WebElement locator2 = informationPanel.getAmountOfScootersButtonLocator();
            pause.until(ExpectedConditions.elementToBeClickable(locator2));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", locator2);
        String actualResult = informationPanel.getAmountOfScootersInfo();
        assertEquals("Information not found or incorrect", AMOUNT_OF_SCOOTERS_INFO, actualResult);
    }

    @Test
    public void checkRentTimeInfoRight(){
        driver.get(YANDEX_SCOOTER);
        InformationPanel informationPanel = new InformationPanel(driver);
        WebDriverWait pause = new WebDriverWait(driver, 3);
        WebElement locator3 = informationPanel.getRentTimeButtonLocator();
            pause.until(ExpectedConditions.elementToBeClickable(locator3));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", locator3);
        String actualResult = informationPanel.getRentTimeInfo();
        assertEquals("Information not found or incorrect", RENT_TIME_INFO, actualResult);
    }

    @Test
    public void checkScooterTodayInfoRight(){
        driver.get(YANDEX_SCOOTER);
        InformationPanel informationPanel = new InformationPanel(driver);
        WebElement locator4 = informationPanel.getScooterTodayButtonLocator();
        WebDriverWait pause = new WebDriverWait(driver, 3);
            pause.until(ExpectedConditions.elementToBeClickable(locator4));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", locator4);
        String actualResult = informationPanel.getScooterTodayInfo();
        assertEquals("Information not found or incorrect", SCOOTER_TODAY_INFO, actualResult);
    }

    @Test
    public void checkExtendReturnInfoRight(){
        driver.get(YANDEX_SCOOTER);
        InformationPanel informationPanel = new InformationPanel(driver);
        WebElement locator5 = informationPanel.getExtendReturnButtonLocator();
        WebDriverWait pause = new WebDriverWait(driver, 3);
            pause.until(ExpectedConditions.elementToBeClickable(locator5));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", locator5);
        String actualResult = informationPanel.getExtendReturnInfo();
        assertEquals("Information not found or incorrect", EXTEND_RETURN_INFO, actualResult);
    }

    @Test
    public void checkChargerCableInfoRight(){
        driver.get(YANDEX_SCOOTER);
        InformationPanel informationPanel = new InformationPanel(driver);
        WebElement locator6 = informationPanel.getChargerCableButtonLocator();
        WebDriverWait pause = new WebDriverWait(driver, 3);
            pause.until(ExpectedConditions.elementToBeClickable(locator6));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", locator6);
        String actualResult = informationPanel.getChargerCableInfo();
        assertEquals("Information not found or incorrect", CHARGER_CABLE_INFO, actualResult);
    }

    @Test
    public void checkOrderCancellationInfoRight(){
        driver.get(YANDEX_SCOOTER);
        InformationPanel informationPanel = new InformationPanel(driver);
        WebElement locator7 = informationPanel.getOrderCancellationButtonLocator();
        WebDriverWait pause = new WebDriverWait(driver, 3);
            pause.until(ExpectedConditions.elementToBeClickable(locator7));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", locator7);
        String actualResult = informationPanel.getOrderCancellationInfo();
        assertEquals("Information not found or incorrect", ORDER_CANCELLATION_INFO, actualResult);
    }

    @Test
    public void checkCoverageZoneInfoRight(){
        driver.get(YANDEX_SCOOTER);
        InformationPanel informationPanel = new InformationPanel(driver);
        WebElement locator8 = informationPanel.getCoverageZoneButtonLocator();
        WebDriverWait pause = new WebDriverWait(driver, 3);
            pause.until(ExpectedConditions.elementToBeClickable(locator8));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", locator8);
        String actualResult = informationPanel.getCoverageZoneInfo();
        assertEquals("Information not found or incorrect", COVERAGE_ZONE_INFO, actualResult);
    }

    @After
    public void teardown() {
        driver.quit();
    }
}

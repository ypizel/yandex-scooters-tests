package PageObgect;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InformationPanel {

    private final WebDriver driver;


    // Разделы с информацией
    private final By paymentInfoButton = By.id("accordion__heading-0");
    private final By paymentInfo = By.id("accordion__panel-0");

    private final By amountOfScootersInfoButton = By.id("accordion__heading-1");
    private final By amountOfScootersInfo = By.id("accordion__panel-1");

    private final By rentTimeInfoButton = By.id("accordion__heading-2");
    private final By rentTimeInfo = By.id("accordion__panel-2");

    private final By scooterTodayInfoButton = By.id("accordion__heading-3");
    private final By scooterTodayInfo = By.id("accordion__panel-3");

    private final By extendReturnInfoButton = By.id("accordion__heading-4");
    private final By extendReturnInfo = By.id("accordion__panel-4");

    private final By chargerCableInfoButton = By.id("accordion__heading-5");
    private final By chargerCableInfo = By.id("accordion__panel-5");

    private final By orderCancellationInfoButton = By.id("accordion__heading-6");
    private final By orderCancellationInfo = By.id("accordion__panel-6");

    private final By coverageZoneInfoButton = By.id("accordion__heading-7");
    private final By coverageZoneInfo = By.id("accordion__panel-7");

    public InformationPanel(WebDriver driver) {
        this.driver = driver;
    }

    // Локаторы
    public WebElement getPaymentButtonLocator() {
        return driver.findElement(paymentInfoButton);
    }

    public WebElement getAmountOfScootersButtonLocator() {
        return driver.findElement(amountOfScootersInfoButton);
    }

    public WebElement getRentTimeButtonLocator() {
        return driver.findElement(rentTimeInfoButton);
    }

    public WebElement getScooterTodayButtonLocator() {
        return driver.findElement(scooterTodayInfoButton);
    }

    public WebElement getExtendReturnButtonLocator() {
        return driver.findElement(extendReturnInfoButton);
    }

    public WebElement getChargerCableButtonLocator() {
        return driver.findElement(chargerCableInfoButton);
    }

    public WebElement getOrderCancellationButtonLocator() {
        return driver.findElement(orderCancellationInfoButton);
    }

    public WebElement getCoverageZoneButtonLocator() {
        return driver.findElement(coverageZoneInfoButton);
    }



    // Кнопки с информацией
    public String getPaymentInfo(){
        driver.findElement(paymentInfoButton).click();
        return driver.findElement(paymentInfo).getText();
    }

    public String getAmountOfScootersInfo(){
        driver.findElement(amountOfScootersInfoButton).click();
        return driver.findElement(amountOfScootersInfo).getText();
    }

    public String getRentTimeInfo(){
        driver.findElement(rentTimeInfoButton).click();
        return driver.findElement(rentTimeInfo).getText();
    }

    public String getScooterTodayInfo(){
        driver.findElement(scooterTodayInfoButton).click();
        return driver.findElement(scooterTodayInfo).getText();
    }

    public String getExtendReturnInfo(){
        driver.findElement(extendReturnInfoButton).click();
        return driver.findElement(extendReturnInfo).getText();
    }

    public String getChargerCableInfo(){
        driver.findElement(chargerCableInfoButton).click();
        return driver.findElement(chargerCableInfo).getText();
    }

    public String getOrderCancellationInfo(){
        driver.findElement(orderCancellationInfoButton).click();
        return driver.findElement(orderCancellationInfo).getText();
    }

    public String getCoverageZoneInfo(){
       driver.findElement(coverageZoneInfoButton).click();
       return driver.findElement(coverageZoneInfo).getText();
    }
}

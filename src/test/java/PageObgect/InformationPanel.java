package PageObgect;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

    public WebElement getPaymentInfoLocator() {
        return driver.findElement(paymentInfo);
    }
    public WebElement getAmountOfScootersButtonLocator() {
        return driver.findElement(amountOfScootersInfoButton);
    }
    public WebElement getAmountOfScootersInfoLocator(){
        return driver.findElement(amountOfScootersInfo);
    }

    public WebElement getRentTimeButtonLocator() {
        return driver.findElement(rentTimeInfoButton);
    }

    public WebElement getRentTimeInfoLocator(){
        return driver.findElement(rentTimeInfo);
    }
    public WebElement getScooterTodayButtonLocator() {
        return driver.findElement(scooterTodayInfoButton);
    }
    public WebElement getScootersInfoLocator(){
        return driver.findElement(scooterTodayInfo);
    }
    public WebElement getExtendReturnButtonLocator() {
        return driver.findElement(extendReturnInfoButton);
    }
    public WebElement getExtendReturnInfoLocator(){
        return driver.findElement(extendReturnInfo);
    }

    public WebElement getChargerCableButtonLocator() {
        return driver.findElement(chargerCableInfoButton);
    }
    public WebElement getChargerCableInfoLocator(){
        return driver.findElement(chargerCableInfo);
    }
    public WebElement getOrderCancellationButtonLocator() {
        return driver.findElement(orderCancellationInfoButton);
    }
    public WebElement getOrderCancellationInfoLocator(){
        return driver.findElement(orderCancellationInfo);
    }
    public WebElement getCoverageZoneButtonLocator() {
        return driver.findElement(coverageZoneInfoButton);
    }
    public WebElement getCoverageZoneInfoLocator() {
        return driver.findElement(coverageZoneInfo);
    }


    // Кнопки с информацией
    public String getPaymentInfo(){
        driver.findElement(paymentInfoButton).click();
        WebDriverWait pouse = new WebDriverWait(driver, 3);
        pouse.until(ExpectedConditions.visibilityOf((getPaymentInfoLocator())));
        return driver.findElement(paymentInfo).getText();
    }

    public String getAmountOfScootersInfo(){
        driver.findElement(amountOfScootersInfoButton).click();
        WebDriverWait pouse = new WebDriverWait(driver, 3);
        pouse.until(ExpectedConditions.visibilityOf(getAmountOfScootersInfoLocator()));
        return driver.findElement(amountOfScootersInfo).getText();
    }

    public String getRentTimeInfo(){
        driver.findElement(rentTimeInfoButton).click();
        WebDriverWait pouse = new WebDriverWait(driver, 3);
        pouse.until(ExpectedConditions.visibilityOf(getRentTimeInfoLocator()));
        return driver.findElement(rentTimeInfo).getText();
    }

    public String getScooterTodayInfo(){
        driver.findElement(scooterTodayInfoButton).click();
        WebDriverWait pouse = new WebDriverWait(driver, 3);
        pouse.until(ExpectedConditions.visibilityOf(getScootersInfoLocator()));
        return driver.findElement(scooterTodayInfo).getText();
    }

    public String getExtendReturnInfo(){
        driver.findElement(extendReturnInfoButton).click();
        WebDriverWait pouse = new WebDriverWait(driver, 3);
        pouse.until(ExpectedConditions.visibilityOf(getExtendReturnInfoLocator()));
        return driver.findElement(extendReturnInfo).getText();
    }

    public String getChargerCableInfo(){
        driver.findElement(chargerCableInfoButton).click();
        WebDriverWait pouse = new WebDriverWait(driver, 3);
        pouse.until(ExpectedConditions.visibilityOf(getChargerCableInfoLocator()));
        return driver.findElement(chargerCableInfo).getText();
    }

    public String getOrderCancellationInfo(){
        driver.findElement(orderCancellationInfoButton).click();
        WebDriverWait pouse = new WebDriverWait(driver, 3);
        pouse.until(ExpectedConditions.visibilityOf(getOrderCancellationInfoLocator()));
        return driver.findElement(orderCancellationInfo).getText();
    }

    public String getCoverageZoneInfo(){
       driver.findElement(coverageZoneInfoButton).click();
        WebDriverWait pouse = new WebDriverWait(driver, 3);
        pouse.until(ExpectedConditions.visibilityOf(getCoverageZoneInfoLocator()));
       return driver.findElement(coverageZoneInfo).getText();
    }
}

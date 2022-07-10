package PageObgect;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    private final WebDriver driver;
    // Лого скутер и кнопка заказать
    private final By scooterLogo = By.className("Header_LogoScooter__3lsAR");
    private final By orderButton = By.className("Button_Button__ra12g");

    // Лого яндекс на сайте скутер и лого яндекса на главной страницы лого
    private final By yandexLogo = By.className("Header_LogoYandex__3TSOI");
    private final By mainPageYandexLogoLocator = By.className("home-logo__default");

    // Кнопка статуса заказа
    private final By orderStatusButton = By.className("Header_Link__1TAG7");
    // Поле ввода номера заказа
    private final By orderStatusField = By.xpath(".//input[contains(@class,'Input_Input__1iN_Z Header_Input__xIoUq')]");
    private final By sendOrderNumberButton = By.xpath(".//button[contains(@class, 'Button_Button__ra12g Header_Button__28dPO')]");
    // Уведомление "такого заказа нет"
    private final By noOrder = By.xpath(".//*[contains(text(),'Такого заказа нет')]");

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    // Лого скутер ведет не главную страницу "Самоката"
    public WebElement getScooterLogoLocator() {
        return driver.findElement(scooterLogo);
    }
    public WebElement getOrderButton() {
        return driver.findElement(orderButton);
    }
    public void clickScooterLogo() {
        driver.findElement(scooterLogo).click();
    }

    // Лого яндекс ведет не главную страницу "Яндекса"
    public WebElement getYandexLogoLocator() {
        return driver.findElement(yandexLogo);
    }
    public WebElement getMainPageYandexLogoLocator() {
        return driver.findElement(mainPageYandexLogoLocator);
    }

    public void clickYandexLogo() {
        driver.findElement(yandexLogo).click();
    }


    public WebElement getOrderStatusButtonLocator(){
        return driver.findElement(orderStatusButton);
    }
    public WebElement getOrderStatusFieldLocator(){
        return driver.findElement(orderStatusField);
    }
    public void clickOrderStatusButton(){
        driver.findElement(orderStatusButton).click();
    }
    public void setOrderNumberStatus(String orderNumber){
        driver.findElement(orderStatusField).sendKeys(orderNumber);
    }
    public void clickSendOrderNumberStatus(){
        driver.findElement(sendOrderNumberButton).click();
    }
    public void setOrderStatus(String orderNumber) {
        setOrderNumberStatus(orderNumber);
        clickSendOrderNumberStatus();
    }
    public String getNoOrderNotification(){
        return driver.findElement(noOrder).getText();
    }
}

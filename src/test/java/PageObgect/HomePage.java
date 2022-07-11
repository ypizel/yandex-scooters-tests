package PageObgect;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.ArrayList;
import java.util.List;
public class HomePage {

    private final WebDriver driver;
    // Лого скутер и хедер главной страницы
    private final By scooterLogo = By.className("Header_LogoScooter__3lsAR");
    private final By mainPageHeader = By.className("Home_Header__iJKdX");


    // Лого яндекс на сайте скутер и лого яндекса на главной страницы лого
    private final By yandexLogo = By.className("Header_LogoYandex__3TSOI");
    private final By mainPageYandexLogoLocator = By.className("home-logo__default");

    // Кнопка статуса заказа
    private final By orderStatusButton = By.className("Header_Link__1TAG7");
    // Поле ввода номера заказа
    private final By orderStatusField = By.xpath(".//input[contains(@class,'Input_Input__1iN_Z Header_Input__xIoUq')]");
    private final By sendOrderNumberButton = By.xpath(".//button[contains(@class, 'Button_Button__ra12g Header_Button__28dPO')]");
    // Уведомление "такого заказа нет"
    private final By noOrder = By.xpath(".//img[@alt='Not found']");

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    // Лого Самокат это ссылка на главную
    public void clickScooterLogo() {
        WebElement element = driver.findElement(scooterLogo);
        waitElementToBeClickable(element);
        element.click();
    }
    public String getMainPageHeaderText(){
        WebDriverWait pause = new WebDriverWait(driver, 3);
            WebElement element = driver.findElement(mainPageHeader);
            pause.until(ExpectedConditions.visibilityOf(element));
        return element.getText();
    }

    // Лого яндекс ведет не главную страницу "Яндекса"
    public void clickYandexLogo() {
        WebElement element = driver.findElement(yandexLogo);
        waitElementToBeClickable(element);
        element.click();
    }
    public WebElement getMainPageYandexLogoLocator() {
        List<String> browserTabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(browserTabs .get(1));
        WebElement element = driver.findElement(mainPageYandexLogoLocator);
        return element;
    }

    // Неправильный номер - заказа нет
    public void waitElementToBeClickable(WebElement element){
        WebDriverWait pause = new WebDriverWait(driver, 3);
            pause.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void clickOrderStatusButton(){
        WebElement element = driver.findElement(orderStatusButton);
        waitElementToBeClickable(element);
        element.click();

    }
    public void inputOrderNumber(String orderNumber){
        WebElement element = driver.findElement(orderStatusField);
        waitElementToBeClickable(element);
        element.sendKeys(orderNumber);
    }
    public void clickSendOrderNumberStatus(){
        driver.findElement(sendOrderNumberButton).click();
    }
    public void setOrderStatus(String orderNumber) {
        clickOrderStatusButton();
        inputOrderNumber(orderNumber);
        clickSendOrderNumberStatus();
    }
    public WebElement getNoOrderNotification(){
        WebElement element = driver.findElement(noOrder);
        WebDriverWait pause = new WebDriverWait(driver, 3);
            pause.until(ExpectedConditions.visibilityOf(element));
        return element;
    }
}

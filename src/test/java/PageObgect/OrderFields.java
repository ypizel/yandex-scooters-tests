package PageObgect;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderFields {

    private final WebDriver driver;


    // Кнопки заказать
    private final By topRightOrderButton = (By.className("Button_Button__ra12g"));
    private final By bottomOrderButton = (By.xpath("(//button [text()='Заказать'])[2]"));

    // Поля с инофрмацией о клиенте
    private final By nameField = (By.xpath(".//input[@placeholder='* Имя']"));
    private final By surnameField = (By.xpath(".//input[@placeholder='* Фамилия']"));
    private final By addressField = (By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']"));
    private final By metroStationField = (By.className("select-search__input"));
    // Найденая станция
    private final By foundMetroStation = (By.xpath(".//div[contains(@class, 'Order_Text__2broi') and contains(text(), 'Аэропорт')]"));
    private final By phoneNumberField = (By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']"));

    // Кнопка далее
    private final By nextButton = (By.className("Button_Middle__1CSJM"));

    // Поля с информацией о самокате
    // Поле даты доставки
    private final By deliveryDateField = (By.xpath(".//input[@placeholder='* Когда привезти самокат']"));

    // Поле срока аренды
    private final By rentPeriod = (By.className("Dropdown-arrow"));
    // Конкретный период, например двое суток
    private final By twoDays = (By.xpath(".//div[contains(text(), 'двое суток')]"));

    // Чекбокс выбора цвета
    private final By blackColorCheckBox = (By.id("black"));
    private final By lastOrderButton = (By.xpath( ".//button[contains(@class, 'Button_Button__ra12g Button_Middle__1CSJM') and contains(text(), 'Заказать')]"));
    private final By orderConfirmationButton = (By.xpath(".//button[contains(@class, 'Button_Button__ra12g Button_Middle__1CSJM') and contains(text(), 'Да')]"));

    // Заказ оформлен
    private final By orderStatus = (By.xpath(".//button[contains(@class, 'Button_Button__ra12g Button_Middle__1CSJM') and contains(text(), 'Посмотреть статус')]"));
    // Конструктор
    public OrderFields(WebDriver driver) {
        this.driver = driver;
    }

    // Домашняя страница и страница ввода информации о клиенте
    // Локаторы кнопок заказать на главной странице
    public void clickTopOrderButton(){
        driver.findElement(topRightOrderButton).click();
    }
    public void clickBottomOrderButton(){
        WebElement element = driver.findElement(bottomOrderButton);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
    }
    public WebElement getBottomOrderButtonLocator() {
        return driver.findElement(bottomOrderButton);
    }
    // Локатор страницы информации о пользователе
    public WebElement getNameFieldLocator(){
        return driver.findElement(nameField);
    }
    // Локаторы страницы информации о самокате
    public WebElement getDeliveryDateFieldLocator() {
        return driver.findElement(deliveryDateField);
    }
    // Локатор кнопки подтверждения заказа
    public WebElement getOrderConfirmationButtonLocator() {
        return driver.findElement((orderConfirmationButton));
    }

    // Локатор кнопки статуса заказа
    public WebElement getOrderStatus(){
        return driver.findElement(orderStatus);
    }

    // Заполнение полей о пользователе
    public void setName(String name) {
        driver.findElement(nameField).sendKeys(name);
    }

    public void setSurname(String surname) {
        driver.findElement(surnameField).sendKeys(surname);
    }

    public void setAddress(String address) {
        driver.findElement(addressField).sendKeys(address);
    }

    public void setMetroStation(String station) {
        driver.findElement(metroStationField).sendKeys(station);
        driver.findElement(foundMetroStation).click();
    }

    public void setPhoneNumber(String phoneNumber) {
        driver.findElement(phoneNumberField).sendKeys(phoneNumber);
    }

    // Заполнение полей о самокате
    public void setDeliveryDate(String date){
        driver.findElement(deliveryDateField).sendKeys(date);
    }

    public void setRentPeriod() {
        driver.findElement(rentPeriod).click();
        driver.findElement(twoDays).click();
    }

    public void setBlackColorCheckBox() {
        driver.findElement(blackColorCheckBox).click();
    }

    // Клик на кнопку далее
    public void clickNextButton() {
        driver.findElement(nextButton).click();
    }
    // Клик на финальную кнопку заказать
    public void clickLastOrderButton() {
        driver.findElement(lastOrderButton).click();
    }

    // Клик на кнопку подтверждения "да"
    public void clickOrderConfirmationButton() {
        driver.findElement(orderConfirmationButton).click();
    }

    // Ввести всю информацию о клиенте
    public void setClientInfo() {
        setName("Иван");
        setSurname("Иванов");
        setAddress("Маяковская 19");
        setMetroStation("Аэро");
        setPhoneNumber("89114543454");
        clickNextButton();
    }

    // Ввести всю инофрмацию о клиенте
    public void setScooterInformation() {
        setDeliveryDate("15.07.2022");
        setRentPeriod();
        setBlackColorCheckBox();
        clickLastOrderButton();
    }

}

package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ErrorsMessages {

    private WebDriver driver;
    public ErrorsMessages(WebDriver driver) {
        this.driver = driver;
    }
    public static String URL = "https://qa-scooter.praktikum-services.ru/order";
    public static String FIRST_ORDER_FIELD = "https://qa-scooter.praktikum-services.ru/order";
    private final By nameErrorMessage =
        (By.xpath(".//div[contains(@class, 'Input_ErrorMessage__3HvIb Input_Visible___syz6') and contains(text(),'Введите корректное имя')]"));
    private final By surnameErrorMessage =
        (By.xpath(".//div[contains(@class, 'Input_ErrorMessage__3HvIb Input_Visible___syz6') and contains(text(),'Введите корректную фамилию')]"));
    private final By addressErrorMessage =
        (By.xpath( ".//div[contains(@class, 'Input_ErrorMessage__3HvIb Input_Visible___syz6') and contains(text(),'Введите корректный адрес')]"));
    private final By phoneNumberErrorMessage =
        (By.xpath(".//div[contains(@class, 'Input_ErrorMessage__3HvIb Input_Visible___syz6') and contains(text(),'Введите корректный номер')]"));

    public String getNameErrorMessage(){
        return driver.findElement(nameErrorMessage).getText();
    }
    public String getSurnameErrorMassage(){
        return driver.findElement(surnameErrorMessage).getText();
    }
    public String getPhoneNumberErrorMassage(){
        return driver.findElement(phoneNumberErrorMessage).getText();
    }
    public String getAddressErrorMassage() {
        return driver.findElement(addressErrorMessage).getText();
    }

}

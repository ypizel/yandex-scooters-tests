package PageObject;

import org.openqa.selenium.WebDriver;

public abstract class BaseObjectPage {

    protected WebDriver driver;
    public BaseObjectPage(WebDriver driver) {
        this.driver = driver;
    }

    public abstract Object open();
}

package MozillaTests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseMozillaUITest {
    protected WebDriver driver;

    @Before
    public void setDriver() {
        System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
        driver = new FirefoxDriver();
    }

    @After
    public void teardown() {
        driver.quit();
    }
}

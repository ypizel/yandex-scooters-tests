package ChromeTests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseChromeUITest {

    protected WebDriver driver;

    @Before
    public void setDriver(){
        System.setProperty("webdriver.chrome.driver" ,  "chromedriver.exe");
        driver = new ChromeDriver();
    }

    @After
    public void teardown() {
        driver.quit();
    }
}


package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait wait;

    @BeforeEach
    public void driverSet() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
       // WebDriverManager.firefoxdriver().setup();
       // driver = new FirefoxDriver();

        wait = new WebDriverWait(driver,10);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(7, TimeUnit.SECONDS);
        driver.navigate().to("http://34.94.151.29/");
        driver.manage().window().maximize();
    }

    @AfterEach
    public void driverQuit() {
        driver.quit();
    }
}

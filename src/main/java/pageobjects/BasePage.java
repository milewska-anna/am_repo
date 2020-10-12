package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    protected BasePage(WebDriver driver){
        this.driver=driver;
        wait = new WebDriverWait(driver, 7);
        PageFactory.initElements(driver,this);
    }

}

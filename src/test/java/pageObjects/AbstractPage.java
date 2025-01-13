package pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Abstract Page common across all Pages > Application > Wiring and to be inherited by Wiring classes
 */
public abstract class AbstractPage {

    protected final WebDriver driver;
    protected final WebDriverWait wait;

    public AbstractPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver,this);
    }

    /**
     * Abstract method to be implemented by respective agent classes
     * @return Boolean
     */
    public abstract boolean isAtPage();

}

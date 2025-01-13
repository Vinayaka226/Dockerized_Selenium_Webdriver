package tests;

import driverFactory.WebDriverFactory;
import listener.TestListener;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.annotations.*;
import util.Configuration;
import util.Constants;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Abstract Parent Class for All Tests.
 * Initializes Properties, sets up Local/Remote driver, sets the driver before start of each test and closes it once completed
 */
@Listeners(TestListener.class)
public abstract class AbstractTest {

    protected WebDriver driver;
    protected static final String delimeter = " ***************** ";
    public static final Logger log = LoggerFactory.getLogger(AbstractTest.class);

    /**
     * Initializes the properties by calling initialize() from Configuration Before Suite
     */
//    @BeforeSuite
//    public void setupConfiguration(){
//        Configuration.initialize();
//    }


    private WebDriver getRemoteDriver() throws MalformedURLException {
        Capabilities capabilities;
        if(System.getProperty("browser").equalsIgnoreCase("chrome"))
            capabilities = new ChromeOptions();
        else capabilities = new FirefoxOptions();

        String urlFormat = Configuration.getProperty(Constants.GRID_URL_FORMAT);
        String hubHost = Configuration.getProperty(Constants.GRID_HUB_HOST);
        String url = String.format(urlFormat,hubHost);

        log.info("The Grid URL being Used: {}", url);
        return new RemoteWebDriver(new URL(url), capabilities);
    }

    private WebDriver getLocalDriver(){
        return WebDriverFactory.getDriver(Configuration.getProperty(Constants.BROWSER));
    }

    //@BeforeTest
    @BeforeMethod
    public void setDriver(ITestContext ctx) throws MalformedURLException {
        Configuration.initialize();
        this.driver = Boolean.parseBoolean(Configuration.getProperty(Constants.GRID_ENABLED)) ? getRemoteDriver() : getLocalDriver();
        ctx.setAttribute(Constants.DRIVER,this.driver);
    }

    //@AfterTest
    //@AfterSuite
    @AfterMethod
    public void quitDriver(){
        this.driver.quit();
    }
}

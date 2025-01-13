package driverFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Map;
import java.util.function.Supplier;

public class WebDriverFactory {
    private static final Supplier<WebDriver> chromeSupplier = ChromeDriver::new;
    private static final Supplier<WebDriver> firefoxSupplier = FirefoxDriver::new;
    private static final Supplier<WebDriver> edgeSupplier = EdgeDriver::new;

    private static Map<String,Supplier<WebDriver>> DRIVER_SUPPLIER = Map.of(
        "chrome",chromeSupplier,
            "firefox",firefoxSupplier,
            "edge",edgeSupplier
    );

    /**
     * Method to get the needed driver from DRIVER_SUPPLIER
     * @param browserName
     * @return
     */
    public static WebDriver getDriver(String browserName){
        return DRIVER_SUPPLIER.get(browserName).get();
    }
}

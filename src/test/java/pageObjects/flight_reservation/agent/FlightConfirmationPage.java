package pageObjects.flight_reservation.agent;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import pageObjects.flight_reservation.wiring.FlightConfirmationPageWiring;
import util.Commons;

public class FlightConfirmationPage extends FlightConfirmationPageWiring {

    private static final Logger log = LoggerFactory.getLogger(FlightConfirmationPage.class);

    public FlightConfirmationPage(WebDriver driver){
        super(driver);
        isAtPage();
    }

    /**
     * Asserting if the displayed Total Price matches expected price
     * @param price
     * @return
     */
    public FlightConfirmationPage assertTotalPrice(String price){
        Commons.logsReporter("Asserting if the displayed Total Price matches: '"+price+"'", log);
        String actualTotalPrice = this.totalPrice.getText();
        Assert.assertTrue(actualTotalPrice.contains(price),
                "Expected Total price to be: '"+price+"' but found: "+actualTotalPrice);
        return this;
    }
}

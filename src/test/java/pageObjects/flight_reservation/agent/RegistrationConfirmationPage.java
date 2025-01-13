package pageObjects.flight_reservation.agent;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import pageObjects.flight_reservation.wiring.RegistrationConfirmationPageWiring;
import util.Commons;

public class RegistrationConfirmationPage extends RegistrationConfirmationPageWiring {

    private static final Logger log = LoggerFactory.getLogger(RegistrationConfirmationPage.class);

    public RegistrationConfirmationPage(WebDriver driver){
        super(driver);
    }

    /**
     * Assert displayed first name
     * @param firstName
     * @return RegistrationConfirmationPage
     */
    public RegistrationConfirmationPage assertDisplayedFirstName(String firstName){
        Commons.logsReporter("Asserting firstName matches '"+firstName+"'", log);
        Assert.assertTrue(this.firstName.getFirst()
                .getText()
                .contains(firstName),"Expected First Name: "+firstName+" to be present, but not found" );
        return this;
    }

    /**
     * Clicking on 'Go To Flight Search' button > Navigate to Flight Search Page
     * @return FlightSearchPage
     */
    public FlightSearchPage clickGoToFlightSearch(){
        Commons.logsReporter("Clicking on 'Go To Flight Search' button > Navigate to Flight Search Page", log);
        this.flightSearchButton.click();
        return new FlightSearchPage(driver);
    }

}

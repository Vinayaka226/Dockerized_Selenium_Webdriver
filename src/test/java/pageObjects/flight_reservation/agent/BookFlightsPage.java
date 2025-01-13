package pageObjects.flight_reservation.agent;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pageObjects.flight_reservation.wiring.BookFlightsPageWiring;
import util.Commons;

public class BookFlightsPage extends BookFlightsPageWiring {

    private static final Logger log = LoggerFactory.getLogger(BookFlightsPage.class);
    public BookFlightsPage(WebDriver driver){
        super(driver);
        isAtPage();
    }

    /**
     * Clicking on Emirates Departure Flight > First Class
     * @return BookFlightsPage
     */
    public BookFlightsPage clickDepartureEmiratesFirst(){
        Commons.logsReporter("Clicking on Emirates Departure Flight > First Class", log);
        this.depEmiratesFirst.click();
        return this;
    }

    /**
     * Clicking on Emirates Departure Flight > Business Class
     * @return BookFlightsPage
     */
    public BookFlightsPage clickDepartureEmiratesBusiness(){
        Commons.logsReporter("Clicking on Emirates Departure Flight > Business Class", log);
        this.depEmiratesBusiness.click();
        return this;
    }

    /**
     * Clicking on Emirates Arrival Flight > Business Class
     * @return BookFlightsPage
     */
    public BookFlightsPage clickArrivalEmiratesBusiness(){
        Commons.logsReporter("Clicking on Emirates Arrival Flight > Business Class", log);
        this.arrEmiratesBusiness.click();
        return this;
    }

    /**
     * Clicking on Emirates Arrival Flight > First Class
     * @return BookFlightsPage
     */
    public BookFlightsPage clickArrivalEmiratesFirst(){
        Commons.logsReporter("Clicking on Emirates Arrival Flight > First Class", log);
        this.arrEmiratesFirst.click();
        return this;
    }

    public FlightConfirmationPage clickConfirmFlight(){
        Commons.logsReporter("Clicking Confirm Flight > Navigate to Flight Confirmation page", log);
        this.confirmFlightsButton.click();
        return new FlightConfirmationPage(driver);
    }
}

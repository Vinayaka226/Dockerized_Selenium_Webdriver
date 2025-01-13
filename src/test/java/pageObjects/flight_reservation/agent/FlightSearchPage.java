package pageObjects.flight_reservation.agent;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pageObjects.flight_reservation.wiring.FlightSearchPageWiring;
import util.Commons;

public class FlightSearchPage extends FlightSearchPageWiring {

    private static final Logger log = LoggerFactory.getLogger(FlightSearchPage.class);
    public FlightSearchPage(WebDriver driver){
        super(driver);
        isAtPage();
    }

    /**
     * Selecting One-Way trip
     * @return FlightSearchPage
     */
    public FlightSearchPage selectOnewayTrip(){
        Commons.logsReporter("Selecting One-Way trip", log);
        this.onewayTrip.click();
        return this;
    }

    /**
     * Selecting Round trip
     * @return FlightSearchPage
     */
    public FlightSearchPage selectRoundTrip(){
        Commons.logsReporter("Selecting Two-Way trip", log);
        this.roundTrip.click();
        return this;
    }

    /**
     * Select Number of Passengers
     * @param passengers
     * @return FlightSearchPage
     */
    public FlightSearchPage selectPassengers(String passengers){
        Commons.logsReporter("Selecting Passengers: '"+passengers+"' from Dropdown", log);
        Commons.dropdownSelectVisibleText(this.passengers, passengers);
        return this;
    }

    /**
     * Select Service Class
     * @param serviceClass
     * @return FlightSearchPage
     */
    public FlightSearchPage selectServiceClass(String serviceClass){
        Commons.logsReporter("Selecting Service Class: '"+serviceClass+"'", log);
        if(serviceClass.equalsIgnoreCase("Economy"))
            this.economy.click();
        else if(serviceClass.equalsIgnoreCase("First"))
            this.firstClass.click();
        else
            this.business.click();
        return this;
    }

    /**
     * Click on 'Flight Search' button
     * @return BookFlightsPage
     */
    public BookFlightsPage clickFlightSearchButton(){
        Commons.logsReporter("Clicking on 'Flight Search' button", log);
        this.searchFlightBtn.click();
        return new BookFlightsPage(driver);
    }
}

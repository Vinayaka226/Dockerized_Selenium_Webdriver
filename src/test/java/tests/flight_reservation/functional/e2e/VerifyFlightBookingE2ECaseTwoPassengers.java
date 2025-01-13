package tests.flight_reservation.functional.e2e;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.flight_reservation.agent.CustomerRegistrationPage;
import tests.AbstractTest;
import tests.flight_reservation.e2eScenarios.FlightBookingCase;
import util.Commons;

import java.util.function.Consumer;

public class VerifyFlightBookingE2ECaseTwoPassengers extends AbstractTest {

    private CustomerRegistrationPage regPage;

    @BeforeMethod
    public void setUpPage() {
        regPage = new CustomerRegistrationPage(driver);
    }

    @Test(dataProvider = "consumerData")
    public void VerifyFlightBookingE2ECaseTwoPassengersTest(Consumer<CustomerRegistrationPage> consumer){
        Commons.logsReporter(delimeter+"Starting Test 'VerifyFlightBookingE2ECaseTwoPassengersTest' For Single Passenger"+delimeter, log);
        regPage.goToPage();
        consumer.accept(regPage);
        Commons.logsReporter(delimeter+"Successfully Completed 'VerifyFlightBookingE2ECaseTwoPassengersTest' For Single Passenger"+delimeter, log);
    }

    @DataProvider(name = "consumerData")
    public Object[] testData(){
        return new Object[] {
                FlightBookingCase.custRegTwoPassengers
        };
    }
}

package tests.flight_reservation.functional.registrationConfirmation;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.flight_reservation.agent.CustomerRegistrationPage;
import pageObjects.flight_reservation.records.FlightReservationTestRecord;
import tests.AbstractTest;
import util.Commons;
import util.JSONUtil;

public class VerifyFirstNameOnRegistrationConfirmationPage extends AbstractTest {

    private CustomerRegistrationPage regPage;
    private FlightReservationTestRecord testData;
    private String testDataFileName = "singlePassenger.json";

    @BeforeMethod
    @Parameters("testDataPath")
    public void setUpPage(String testDataPath){
        regPage = new CustomerRegistrationPage(driver);
        regPage.goToPage();
        this.testData = JSONUtil.getData(testDataPath+testDataFileName, FlightReservationTestRecord.class);
    }

    @Test(groups = {"functional"})
    public void registerButtonEnabled() {
        //log.info(delimeter+"Starting Test 'registerButtonEnabled'"+delimeter);
        Commons.logsReporter(delimeter+"Starting Test 'registerButtonEnabled'"+delimeter, log);
        regPage.enterFirstName(testData.firstName())
                .enterLastName(testData.lastName())
                .enterEmail(testData.email())
                .enterStreet(testData.street())
                .enterCity(testData.city())
                .selectState(testData.state())
                .enterZip(testData.zip())
                .clickRegisterButton()
                .assertDisplayedFirstName(testData.firstName());
        //log.info(delimeter+"Successfully Completed Test 'registerButtonEnabled' "+delimeter);
        Commons.logsReporter(delimeter+"Successfully Completed Test 'registerButtonEnabled' "+delimeter, log);
    }

}

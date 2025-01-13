package tests.flight_reservation.functional.registration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.flight_reservation.agent.CustomerRegistrationPage;
import tests.AbstractTest;
import util.Commons;

public class VerifyRegisterBtnIsDisabledIfInformationNotFilled extends AbstractTest {

    private CustomerRegistrationPage regPage;

    @BeforeMethod
    public void setUpPage(){
        regPage = new CustomerRegistrationPage(driver);
        regPage.goToPage();
    }

    @Test(groups = {"functional"})
    public void registerButtonDisabled(){
        //log.info(delimeter+"Starting Test 'registerButtonDisabled'"+delimeter);
        Commons.logsReporter(delimeter+"Starting Test 'registerButtonDisabled'"+delimeter, log);
        regPage.assertRegisterBtnNotDisplayed();
        //log.info(delimeter+"Successfully Completed 'registerButtonDisabled'"+delimeter);
        Commons.logsReporter(delimeter+"Successfully Completed 'registerButtonDisabled'"+delimeter, log);
    }

}

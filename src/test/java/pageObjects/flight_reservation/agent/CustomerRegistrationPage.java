package pageObjects.flight_reservation.agent;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pageObjects.flight_reservation.wiring.CustomerRegistrationPageWiring;
import util.Commons;
import util.Configuration;
import util.Constants;
import org.testng.Assert;

public class CustomerRegistrationPage extends CustomerRegistrationPageWiring {

    private static String flightRegistartion = Configuration.getProperty(Constants.APPLICATION_URL);
    private static final Logger log = LoggerFactory.getLogger(CustomerRegistrationPage.class);

    /**
     * Constructor for CustomerRegistrationPage
     * @param driver
     */
    public CustomerRegistrationPage(WebDriver driver){
        super(driver);

    }

    public CustomerRegistrationPage goToPage(){
        //log.info("Navigating to Page: "+flightRegistartion);
        Commons.logsReporter("Navigating to Page: "+flightRegistartion, log);
        this.driver.get(flightRegistartion);
        this.isAtPage();
        return this;
    }

    /**
     * Method to enter first name
     * @param firstName
     * @return CustomerRegistrationPage
     */
    public CustomerRegistrationPage enterFirstName(String firstName){
        //log.debug("Entering firstName: "+firstName);
        Commons.logsReporter("Entering firstName: "+firstName, log);
        this.firstName.sendKeys(firstName);
        return this;
    }

    /**
     * Method to enter last name
     * @param lastName
     * @return CustomerRegistrationPage
     */
    public CustomerRegistrationPage enterLastName(String lastName){
        //log.debug("Entering lastName: "+lastName);
        Commons.logsReporter("Entering lastName: "+lastName, log);
        this.lastName.sendKeys(lastName);
        return this;
    }

    /**
     * Method to enter email
     * @param email
     * @return CustomerRegistrationPage
     */
    public CustomerRegistrationPage enterEmail(String email){
        //log.debug("Entering Email: "+email);
        Commons.logsReporter("Entering Email: "+email, log);
        this.email.sendKeys(email);
        return this;
    }

    /**
     * Method to enter password
     * @param password
     * @return CustomerRegistrationPage
     */
    public CustomerRegistrationPage enterPassword(String password){
        //log.debug("Entering password: "+password);
        Commons.logsReporter("Entering password: "+password, log);
        this.password.sendKeys(password);
        return this;
    }

    /**
     * Method to enter street
     * @param street
     * @return CustomerRegistrationPage
     */
    public CustomerRegistrationPage enterStreet(String street){
        //log.debug("Entering Street: "+street);
        Commons.logsReporter("Entering Street: "+street, log);
        this.street.sendKeys(street);
        return this;
    }

    /**
     * Method to enter city
     * @param city
     * @return CustomerRegistrationPage
     */
    public CustomerRegistrationPage enterCity(String city){
        //log.debug("Entering City: "+city);
        Commons.logsReporter("Entering City: "+city, log);
        this.city.sendKeys(city);
        return this;
    }

    /**
     * Method to select state
     * @param state
     * @return CustomerRegistrationPage
     */
    public CustomerRegistrationPage selectState(String state){
        //log.debug("Selecting State: "+state);
        Commons.logsReporter("Selecting State: "+state, log);
        Commons.dropdownSelectVisibleText(this.state,state);
        return this;
    }

    /**
     * Method to enter zip
     * @param zip
     * @return CustomerRegistrationPage
     */
    public CustomerRegistrationPage enterZip(String zip){
        //log.debug("Entering zip: "+zip);
        Commons.logsReporter("Entering zip: "+zip, log);
        this.zip.sendKeys(zip);
        return this;
    }

    /**
     * Assert if Register Button is displayed
     * @return CustomerRegistrationPage
     */
    public CustomerRegistrationPage assertRegisterBtnDisplayed(){
        log.debug("Assert if Register Button is displayed");
        Commons.logsReporter("Assert if Register Button is displayed", log);
        Assert.assertTrue(this.register_btn.isDisplayed());
        return this;
    }

    /**
     * Assert if Register Button is Not displayed
     * @return CustomerRegistrationPage
     */
    public CustomerRegistrationPage assertRegisterBtnNotDisplayed(){
        //log.debug("Assert if Register Button is not displayed");
        Commons.logsReporter("Assert if Register Button is not displayed", log);
        Assert.assertFalse(this.register_btn.isDisplayed(), "Expected Button not to be displayed, but was displayed");
        return this;
    }

    /**
     * Clicking on Register Button > Navigating to Register Confirmation page
     * @return RegistrationConfirmationPage
     */
    public RegistrationConfirmationPage clickRegisterButton(){
        //log.debug("Clicking on Register Button > Navigating to Register Confirmation page");
        Commons.logsReporter("Clicking on Register Button > Navigating to Register Confirmation page", log);
        this.register_btn.click();
        RegistrationConfirmationPage reg_confirmation = new RegistrationConfirmationPage(driver);
        reg_confirmation.isAtPage();
        return reg_confirmation;
    }
}

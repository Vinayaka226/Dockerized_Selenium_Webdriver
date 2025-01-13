package pageObjects.flight_reservation.wiring;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageObjects.AbstractPage;

public class CustomerRegistrationPageWiring extends AbstractPage {

    public CustomerRegistrationPageWiring(WebDriver driver){
        super(driver);
    }

    //Registration Page Elements below
    @FindBy(id = "firstName")
    protected WebElement firstName;

    @FindBy(id = "lastName")
    protected WebElement lastName;

    @FindBy(id = "email")
    protected WebElement email;

    @FindBy(id = "password")
    protected WebElement password;

    @FindBy(css = "input[name='street']")
    protected WebElement street;

    @FindBy(css = "input[name='city']")
    protected WebElement city;

    @FindBy(id = "inputState")
    protected WebElement state;

    @FindBy(css = "input[name='zip']")
    protected WebElement zip;

    @FindBy(id = "register-btn")
    protected WebElement register_btn;

    /**
     * Waits till couple of elements on the is page is displayed
     * @return Boolean
     */
    public boolean isAtPage(){
        this.wait.until(ExpectedConditions.visibilityOf(this.register_btn));
        this.wait.until(ExpectedConditions.visibilityOf(this.firstName));

        return this.register_btn.isDisplayed();
    }
}

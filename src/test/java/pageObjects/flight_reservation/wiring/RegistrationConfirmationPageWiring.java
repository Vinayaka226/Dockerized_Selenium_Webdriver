package pageObjects.flight_reservation.wiring;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageObjects.AbstractPage;

import java.util.List;

public class RegistrationConfirmationPageWiring extends AbstractPage {

    public RegistrationConfirmationPageWiring(WebDriver driver){
        super(driver);
    }

    @FindBy(css = "div[class*='justify-content-center']>div>p>b")
    protected List<WebElement> firstName;

    @FindBy(id="go-to-flights-search")
    protected WebElement flightSearchButton;

    @Override
    public boolean isAtPage() {
        this.wait.until(ExpectedConditions.visibilityOf(flightSearchButton));
        return flightSearchButton.isDisplayed();
    }
}

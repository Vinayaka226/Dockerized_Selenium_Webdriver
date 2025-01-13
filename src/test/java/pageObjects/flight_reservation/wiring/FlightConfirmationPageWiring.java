package pageObjects.flight_reservation.wiring;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageObjects.AbstractPage;

public class FlightConfirmationPageWiring extends AbstractPage {

    public FlightConfirmationPageWiring(WebDriver driver){
        super(driver);
    }

    @FindBy(css = "div[class='card-body'] div:nth-child(3) div p")
    protected WebElement totalPrice;

    @Override
    public boolean isAtPage() {
        this.wait.until(ExpectedConditions.visibilityOf(this.totalPrice));
        return this.totalPrice.isDisplayed();
    }
}

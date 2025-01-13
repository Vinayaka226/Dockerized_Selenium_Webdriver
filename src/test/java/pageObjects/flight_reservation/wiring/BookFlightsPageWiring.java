package pageObjects.flight_reservation.wiring;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageObjects.AbstractPage;

public class BookFlightsPageWiring extends AbstractPage {

    public BookFlightsPageWiring(WebDriver driver){
        super(driver);
    }

    @FindBy(id = "dep-emirates-first")
    protected WebElement depEmiratesFirst;

    @FindBy(id = "dep-emirates-business")
    protected WebElement depEmiratesBusiness;

    @FindBy(id = "arr-emirates-first")
    protected WebElement arrEmiratesFirst;

    @FindBy(id = "arr-emirates-business")
    protected WebElement arrEmiratesBusiness;

    @FindBy(id = "confirm-flights")
    protected WebElement confirmFlightsButton;

    @Override
    public boolean isAtPage() {
        this.wait.until(ExpectedConditions.visibilityOf(this.confirmFlightsButton));
        return this.confirmFlightsButton.isDisplayed();
    }
}

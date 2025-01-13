package pageObjects.flight_reservation.wiring;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageObjects.AbstractPage;

public class FlightSearchPageWiring extends AbstractPage {

    public FlightSearchPageWiring(WebDriver driver){
        super(driver);
    }

    @FindBy(id = "oneway")
    protected WebElement onewayTrip;

    @FindBy(id = "twoway")
    protected WebElement roundTrip;

    @FindBy(id = "passengers")
    protected WebElement passengers;

    @FindBy(id = "service-class1")
    protected WebElement economy;

    @FindBy(id = "service-class2")
    protected WebElement firstClass;

    @FindBy(id = "service-class3")
    protected WebElement business;

    @FindBy(id = "search-flights")
    protected WebElement searchFlightBtn;

    @Override
    public boolean isAtPage() {
        this.wait.until(ExpectedConditions.visibilityOf(searchFlightBtn));
        return this.searchFlightBtn.isDisplayed();
    }
}

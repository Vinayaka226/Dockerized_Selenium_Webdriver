package listener;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import util.Constants;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        Object obj =  result.getTestContext().getAttribute(Constants.DRIVER);
        TakesScreenshot screenShot = (TakesScreenshot) obj;
        String base64Image = screenShot.getScreenshotAs(OutputType.BASE64);
        String htmlImageFormat = "<img width=500px src='data:image/png;base64,%s' />";
        String htmlImage = String.format(htmlImageFormat, base64Image);
        Reporter.log(htmlImage);
    }
}

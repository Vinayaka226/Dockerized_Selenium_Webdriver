package listener;

import org.slf4j.MDC;
import org.testng.ITestContext;
import org.testng.TestListenerAdapter;


public class TestCaseLogger extends TestListenerAdapter {
    @Override
    public void onStart(ITestContext testContext) {
        MDC.put("tests",testContext.getName());
    }
}

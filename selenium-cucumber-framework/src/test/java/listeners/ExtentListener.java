package listeners;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.ExtentManager;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class ExtentListener {

    private static ExtentTest test;

    @Before
public void beforeScenario(Scenario scenario) {
    test = ExtentManager.getExtentReports().createTest("Scenario: " + scenario.getName());
    test.log(Status.INFO, "Starting Scenario: " + scenario.getName());
}

@After
public void afterScenario(Scenario scenario) {
    if (scenario.isFailed()) {
        test.fail("Scenario failed: " + scenario.getName());
    } else {
        test.pass("Scenario passed successfully: " + scenario.getName());
    }
    test.log(Status.INFO, "Ending Scenario: " + scenario.getName());
}

    @After
    public void tearDown() {
        // Flush the report
        ExtentManager.flush();
    }
}

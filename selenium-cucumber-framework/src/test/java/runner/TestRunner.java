package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import utils.ExtentManager;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features",
    glue = {"stepDefinitions","listeners"},
    plugin = {"pretty", "html:target/cucumber-reports.html"}
)
public class TestRunner {
    public static void beforeAll() {
        // Initialize the ExtentReport before any tests run
        ExtentManager.getExtentReports();
    }

    public static void afterAll() {
        // Flush the reports after all tests
        ExtentManager.flush();
    }
}

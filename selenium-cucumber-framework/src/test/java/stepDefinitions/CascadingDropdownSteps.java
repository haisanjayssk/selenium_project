package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pageObjects.DropdownPage;
import utils.WebDriverManagerUtil;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CascadingDropdownSteps {

    private WebDriver driver;
    private DropdownPage dropdownPage;

    @Given("I navigate to the cascading dropdown test page")
    public void navigateToTestPage() {
        driver = WebDriverManagerUtil.getDriver();
        driver.get("http://localhost:5501/index.html"); // Adjust based on your server
        dropdownPage = new DropdownPage(driver);
    }

    @When("I select {string} from the parent dropdown")
    public void selectParentOption(String parentOption) {
        dropdownPage.selectParentDropdown(parentOption);
    }

    @Then("I should see {string} in the child dropdown")
    public void validateChildDropdown(String childOption) {
        assertTrue(
            dropdownPage.isChildDropdownAvailable(childOption),
            "The expected option was not found in the child dropdown."
        );
    }
}

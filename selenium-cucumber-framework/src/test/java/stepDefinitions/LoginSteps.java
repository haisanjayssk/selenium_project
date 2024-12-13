package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pageObjects.LoginPage;
import utils.WebDriverManagerUtil;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginSteps {

    private WebDriver driver;
    private LoginPage loginPage;

    @Given("I navigate to the login page")
    public void navigateToLoginPage() {
        driver = WebDriverManagerUtil.getDriver();
        driver.get("https://the-internet.herokuapp.com/login");
        loginPage = new LoginPage(driver);
    }

    @When("I enter username {string} and password {string}")
    public void enterCredentials(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @When("I click on the login button")
    public void clickLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("I should see {string}")
    public void validateOutcome(String expectedOutcome) {
        if (expectedOutcome.equals("Dashboard page is displayed")) {
            assertTrue(loginPage.isDashboardDisplayed(), "Dashboard was not displayed after successful login.");
        } else {
            String actualError = loginPage.getErrorMessage();
            assertTrue(actualError.contains(expectedOutcome), "Expected error message not found: " + actualError);
        }
    }
}

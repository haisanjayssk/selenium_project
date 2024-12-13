package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.WebDriverManagerUtil;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AlternateTableSteps {

    private WebDriver driver;

    @Given("I navigate to the W3Schools table page")
    public void navigateToTablePage() {
        driver = WebDriverManagerUtil.getDriver();
        driver.get("https://www.w3schools.com/html/html_tables.asp");
    }

    @When("I extract data from the {string}")
    public void extractDataFromTable(String tableName) {
        // Locate the table based on its structure
        WebElement table = driver.findElement(By.xpath("//table[@id='customers']"));

        // Extract all rows
        List<WebElement> rows = table.findElements(By.xpath(".//tr"));
        System.out.println("Total Rows Found: " + rows.size());

        // Extract specific column values (e.g., Contact column)
        for (int i = 2; i <= rows.size(); i++) { // Start at 2 to skip the header
            String contact = driver.findElement(By.xpath("//table[@id='customers']/tbody/tr[" + i + "]/td[2]")).getText();
            System.out.println("Contact: " + contact);
        }

        this.rowCount = rows.size(); // Store row count
    }

    private int rowCount;

    @Then("the {string} column should contain {string}")
    public void verifyColumnContains(String columnName, String expectedValue) {
        WebElement table = driver.findElement(By.xpath("//table[@id='customers']"));
        List<WebElement> rows = table.findElements(By.xpath(".//tr"));

        boolean found = false;

        // Check the "Contact" column (column index 2)
        for (int i = 2; i <= rows.size(); i++) { // Start at 2 to skip header
            String contact = driver.findElement(By.xpath("//table[@id='customers']/tbody/tr[" + i + "]/td[2]")).getText();
            if (contact.equalsIgnoreCase(expectedValue)) {
                found = true;
                break;
            }
        }

        assertTrue(found, columnName + " column does not contain: " + expectedValue);
    }

    @Then("the total number of rows should be {int}")
    public void verifyTotalNumberOfRows(int expectedRowCount) {
        assertEquals(expectedRowCount, rowCount, "Row count mismatch.");
    }
}

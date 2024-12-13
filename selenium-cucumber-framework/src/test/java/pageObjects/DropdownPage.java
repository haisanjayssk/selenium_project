package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownPage {

    WebDriver driver;

    // Locators
    private By parentDropdown = By.id("parentDropdown");
    private By childDropdown = By.id("childDropdown");

    public DropdownPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectParentDropdown(String option) {
        Select select = new Select(driver.findElement(parentDropdown));
        select.selectByVisibleText(option);
    }

    public String getChildDropdownValue() {
        Select select = new Select(driver.findElement(childDropdown));
        return select.getFirstSelectedOption().getText();
    }

    public boolean isChildDropdownAvailable(String value) {
        Select select = new Select(driver.findElement(childDropdown));
        return select.getOptions().stream().anyMatch(o -> o.getText().equals(value));
    }
}

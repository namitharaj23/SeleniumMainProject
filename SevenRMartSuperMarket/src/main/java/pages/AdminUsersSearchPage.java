package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.WaitUtility;

public class AdminUsersSearchPage {
	public WebDriver driver;

	public AdminUsersSearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@onclick=\"click_button(2)\"]")
	WebElement adminUserSearchButton;
	@FindBy(xpath = "//input[@name='un']")
	WebElement usernameField;
	@FindBy(xpath = "//select[@name='ut']")
	WebElement userTypeDropDown;
	@FindBy(xpath = "//button[@name='Search']")
	WebElement searchButton;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']")
	WebElement userTable;

	public void clickAdminUserSearchButton() {
		adminUserSearchButton.click();
	}

	public void enterUserName(String username) {
		usernameField.sendKeys(username);
	}

	public void selectUserType(int useValue) {
		Select select = new Select(userTypeDropDown);
		select.selectByIndex(useValue);
	}

	public void clickSerachButton() {
		WaitUtility wait=new WaitUtility();
		wait.waitForClickingElement(driver, adminUserSearchButton);
		searchButton.click();
	}
	// Method to check if a specific value is present in the table
    public boolean isValuePresentInTable(String value) {
    	// Locate all first-column cells in the table
        List<WebElement> rows = userTable.findElements(By.xpath("//table[@class='table table-bordered table-hover table-sm']/tbody/tr/td[1]"));
        
        // Iterate through each row
        for (WebElement row : rows) {
            // Check if the first column contains the value
            if (row.getText().contains(value)) {
                return true; // Value found
            }
        }
        return false; // Value not found
}}
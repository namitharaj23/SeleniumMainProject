package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageUsersSearchPage {
	public WebDriver driver;

	public ManageUsersSearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@onclick='click_button(2)']")
	WebElement searchButton1;
	@FindBy(xpath = "//input[@placeholder='Title']")
	WebElement titleField;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement searchButton2;

	// @FindBy(xpath = "//table[@class='table table-bordered table-hover
	// table-sm']/tbody/tr/td[1]")
	// WebElement newsTable;
	public void clickSearchButton() {
		searchButton1.click();
	}

	public void enterNewsTitle(String newsTitle) {
		titleField.sendKeys(newsTitle);
	}

	public void clickSearchButton2() {
		searchButton2.click();
	}

	public boolean searchForNewsTitle(String newsTitle) {
		// Get the rows of the table
		List<WebElement> rows = driver
				.findElements(By.xpath("//table[@class='table table-bordered table-hover table-sm']/tbody/tr"));

		for (WebElement row : rows) {
			// Get the text of the first column (the news title)
			String rowTitle = row.findElement(By.xpath("td[1]")).getText();

			// If the title matches, return true
			if (rowTitle.equals(newsTitle)) {
				return true;
			}
		}

		// Return false if the title is not found in any row
		return false;
	}

}
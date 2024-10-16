package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@data-toggle='dropdown']")
	WebElement adminLogo;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/logout']")
	WebElement logoutButton;
	@FindBy(xpath = "//p[text()='Sub Category']")
	WebElement subCategory;
	@FindBy(xpath = "//a[@onclick='click_button(2)']")
	WebElement subCategorySearchButton;

	public void clickAdminLogo() {
		adminLogo.click();
	}

	public void clickLogoutButton() {
		logoutButton.click();
	}

	public SubCategoryDeletePage clickSubCategoryForDelete() {
		subCategory.click();
		return new SubCategoryDeletePage(driver);
	}
	public SubCategorySearchItemPage clickSubCategorySearchButton() {
		subCategorySearchButton.click();
		return new SubCategorySearchItemPage(driver);
	}
	public SubCategoriesAddNewPage clickSubCategory() {
		subCategory.click();
		return new SubCategoriesAddNewPage(driver);
	}

}
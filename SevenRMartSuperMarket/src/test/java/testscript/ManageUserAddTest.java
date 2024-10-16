package testscript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import constants.Constants;
import pages.LoginPage;
import pages.ManageNewsAddPage;
import utilities.ExcelUtilities;

public class ManageUserAddTest extends Base {
	@Test
	@Parameters({"username","password","NewsTitle"})
	public void verifyAddingNews(String username,String password,String NewsTitle) throws IOException {
		// Log in
		LoginPage loginPage = new LoginPage(driver);
		//loginPage.enterUserNameField(ExcelUtilities.readStringData(0, 1, "LoginPage1"));
		//loginPage.enterPasswordField(ExcelUtilities.readStringData(1, 1, "LoginPage1")); 
		loginPage.enterUserNameField(username);
		loginPage.enterPasswordField(password);
		
		loginPage.clickSignInButton();
		// Manage news
		ManageNewsAddPage managepage=new ManageNewsAddPage(driver);
		managepage.clickManageNews();
		managepage.clikNewButton();
		managepage.enterNewsField(NewsTitle);
		managepage.clickSaveButton();
		boolean isAlertdisplayed=managepage.isAlertDisplayed();
		assertTrue(isAlertdisplayed,Constants.UNABLETOADDERRORMSG);
	}
}
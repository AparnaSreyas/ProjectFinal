package testcases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.Base;
import elementRepository.HomePage;
import elementRepository.LoginPage;

public class HomeTest extends Base {
	
	@DataProvider(name = "data-provider")
	public Object[][] dpMethod() {
		return new Object[][] { { "carol", "1q2w3e4r" } };
	}
	
	@Test(dataProvider = "data-provider", retryAnalyzer = listener.Retry.class, groups = "smoke")
	public void verifyHomePage(String username, String password) {
		LoginPage login = new LoginPage(driver);
		login.inputUserName(username);
		login.inputPassword(password);
		login.clickLoginButton();
		HomePage homepage = new HomePage(driver);
		String actualText = homepage.getTextOfHomePageWelcomeMessage();
		String expectedText = "Welcome to Payroll Application";
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(actualText, expectedText,"Text is not verified");
		homepage.clickWorkers();
		sa.assertAll();
	}
}

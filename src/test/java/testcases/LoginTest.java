package testcases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.Base;
import elementRepository.HomePage;
import elementRepository.LoginPage;
import utilities.ExcelReadUtility;

public class LoginTest extends Base {
	ExcelReadUtility er;

	@DataProvider(name = "data-provider")
	public Object[][] dpMethod() {
		return new Object[][] { { "carol", "1q2w3e4r" } };
	}

	@Test(dataProvider = "data-provider", retryAnalyzer = listener.Retry.class, groups = "smoke")
	public void verifyLogin(String username, String password) throws IOException {
		LoginPage login = new LoginPage(driver);
		login.inputUserName(username);
		login.inputPassword(password);
		login.clickLoginButton();

		HomePage homepage = new HomePage(driver);
		String actualText = homepage.getTextOfHomePageWelcomeMessage();
		System.out.println(actualText);
		String expectedText = "Welcome to Payroll Application";
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(actualText, expectedText, "Text is not verified");
		er = new ExcelReadUtility();
		er.ExcelReadUtilities();
		sa.assertAll();
	}
}

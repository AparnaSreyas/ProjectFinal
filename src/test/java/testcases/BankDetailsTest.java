package testcases;

import java.awt.AWTException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.Base;
import elementRepository.BankDetailsPage;
import elementRepository.HomePage;
import elementRepository.LoginPage;
import elementRepository.WorkersPage;

public class BankDetailsTest extends Base {

	@DataProvider(name = "data-provider")
	public Object[][] dpMethod() {
		return new Object[][] { { "carol", "1q2w3e4r" } };
	}

	@Test(dataProvider = "data-provider")
	public void verifyBankDetails(String username, String password) throws AWTException {
		LoginPage login = new LoginPage(driver);
		  login.inputUserName(username);
		  login.inputPassword(password);
		  login.clickLoginButton();
		  
		  HomePage homepage = new HomePage(driver);
		  homepage.clickWorkers();
		  
		  WorkersPage worker = new WorkersPage(driver);
		  worker.inputFirstName("Dennis");
		  worker.clickSearch();
		  try {
				worker.clickUpdate();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  
		  worker.clickNext();
		  BankDetailsPage bankdetails = new BankDetailsPage(driver);
		  bankdetails.inputAccountName();
		  bankdetails.inputAccountNumber();
		  bankdetails.inputSortCode();
		  bankdetails.clickSave();
		  bankdetails.clickHome();
		
	}
}

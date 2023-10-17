package testcases;

import java.awt.AWTException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.Base;
import constants.Constant;
import elementRepository.HomePage;
import elementRepository.LoginPage;
import elementRepository.WorkersPage;

public class WorkersTest extends Base {
	Constant co;
	
	@DataProvider(name = "data-provider")
	public Object[][] dpMethod() {
		return new Object[][] { { "carol", "1q2w3e4r" } };
	}
  @Test(dataProvider = "data-provider")
  public void verifyWorkersPage(String username, String password) {
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
	
	  String actualHeader = worker.getHeaderOfWorkerUpdate();
	  String expectedHeader = "UPDATE WORKER: DENNIS BENNY";
	  Assert.assertEquals(actualHeader, expectedHeader, co.ERRORMESSAGEWRONGTEXT); 
	  worker.clickNext();
	  
  }
}

package elementRepository;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtility;
import utilities.WaitUtility;

public class WorkersPage {
	WebDriver driver;
	WaitUtility wu ;
	JavascriptExecutor js ; 
	GeneralUtility gu ;
	
	public WorkersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@id='workersearch-first_name']")
	WebElement firstName;
	
	@FindBy(xpath = "//div//button[@type='submit']")
	WebElement searchButton;
	
	@FindBy(xpath = "//table[@class='table table-striped table-bordered']//tbody//tr[3]//td[8]//a[2]")
	WebElement update;
	
	@FindBy(xpath = "//h1[contains(text(),'Update Worker')]")
	WebElement updateWorkerHeader;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement nextButton;
	
	public void inputFirstName(String fname) {
		  firstName.sendKeys(fname);
	}
	
	public void clickSearch() {
		searchButton.click();
	}
	
	public void clickUpdate() throws InterruptedException {
		Thread.sleep(5000);
		update.click();
//		wu = new WaitUtility(driver);
//		wu.waitUntilVisibilityOfElement(getHeaderOfWorkerUpdate(), 10);
	}
	
	public String getHeaderOfWorkerUpdate() {
		gu = new GeneralUtility();
		return gu.getTextOfElement(updateWorkerHeader);
	}
	
	public void clickNext() {
		wu = new WaitUtility(driver);
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", nextButton);
		wu.waitForElementToBeClickable(nextButton, 10L);
		nextButton.click();
	
	}
	
//	public void workersPageFunctionalities() throws InterruptedException {
//		inputFirstName(fname);
//		clickSearch();
//		clickUpdate();
//		
//	}

}

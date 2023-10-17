package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtility;

public class HomePage {
	WebDriver driver;
	GeneralUtility gu = new GeneralUtility();

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//p[text()='Welcome to Payroll Application']")
	WebElement welcomePageText;

	@FindBy(xpath = "//a[text()='Workers']")
	WebElement workers;

	public String getTextOfHomePageWelcomeMessage() {
		return gu.getTextOfElement(welcomePageText);
	}

	public void clickWorkers() {
		workers.click();
	}

}

package elementRepository;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtility;

public class BankDetailsPage {
	WebDriver driver;
	Actions ac;
	Robot ro;
	WaitUtility waitUtility;
	JavascriptExecutor js; 

	public BankDetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//input[@id='worker-ac_name']")
	WebElement accountName;

	@FindBy(xpath = "//input[@id='worker-ac_no']")
	WebElement accountNumber;

	@FindBy(xpath = "//input[@id='worker-sort_code']")
	WebElement sortCode;

	@FindBy(xpath = "//button[text()='Save']")
	WebElement saveButton;

	@FindBy(xpath = "//div[@class='col-sm-6 breadcrumb-navigation']//ul//a[1]")
	WebElement home;

	public void inputAccountName() throws AWTException {
		ac = new Actions(driver);
		waitUtility = new WaitUtility(driver);
		waitUtility.waitForElementToBeVisible(By.xpath("//input[@id='worker-ac_name']"), 10L);
		ac.moveToElement(accountName).click().perform();
		ro = new Robot();
		ro.keyPress(KeyEvent.VK_CONTROL);
		ro.keyPress(KeyEvent.VK_A);
		ro.keyPress(KeyEvent.VK_BACK_SPACE);
		ro.keyRelease(KeyEvent.VK_CONTROL);
		ro.keyRelease(KeyEvent.VK_A);
		ro.keyRelease(KeyEvent.VK_BACK_SPACE);
		ro.delay(750);
		accountName.sendKeys("xxxx");

	}

	public void inputAccountNumber() throws AWTException {
		
		ac = new Actions(driver);
		ac.moveToElement(accountNumber).click().perform();
		waitUtility = new WaitUtility(driver);
		waitUtility.waitForElementToBeVisible("//input[@id='worker-ac_no']", 10L);
		ro = new Robot();
		accountNumber.sendKeys(Keys.chord(Keys.CONTROL,"A"));
		accountNumber.sendKeys(Keys.BACK_SPACE);
		ro.delay(750);
		accountNumber.sendKeys("2628");
	}

	public void inputSortCode() throws AWTException {
		ac = new Actions(driver);
		ac.moveToElement(sortCode).click().perform();
		ro = new Robot();
		sortCode.sendKeys(Keys.chord(Keys.CONTROL,"A"));
		sortCode.sendKeys(Keys.BACK_SPACE);
		ro.delay(750);
		sortCode.sendKeys("111");
	}

	public void clickSave() {
		waitUtility = new WaitUtility(driver);
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", saveButton);
		waitUtility.waitForElementToBeClickable(saveButton, 10L);
		saveButton.click();
	}

	public void clickHome() {
		waitUtility = new WaitUtility(driver);
		waitUtility.waitForElementToBeClickable(home, 10L);
		home.click();
	}
}

package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='loginform-username']")
	WebElement userName;

	@FindBy(xpath = "//input[@id='loginform-password']")
	WebElement password;

	@FindBy(xpath = "//button[text()='Login']")
	WebElement loginButton;

	public void inputUserName(String username) {
		userName.sendKeys(username);
	}

	public void inputPassword(String pswrd) {
		password.sendKeys(pswrd);
	}

	public void clickLoginButton() {
		loginButton.click();
	}

}

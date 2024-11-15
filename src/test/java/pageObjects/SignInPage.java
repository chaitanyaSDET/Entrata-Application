package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignInPage {

	public WebDriver driver;

	// constructor
	public SignInPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	// capturing elements

	@FindBy(xpath = "//a[contains(@class,'button hover_black')]")
	WebElement drpPropertyManagerLogin;

	@FindBy(xpath = "//h2[@class='fsm-header']")
	WebElement msgHeading;

	@FindBy(id = "entrata-username")
	WebElement txtUserName;

	@FindBy(id = "entrata-password")
	WebElement txtPassword;

	@FindBy(css = "button[type='submit']")
	WebElement btnSignIn;

	@FindBy(xpath = "//p[@id='statusMessage']")
	WebElement statusMsg;

// Action Methods to Perform Actions on Element
	public void clickPropertyManagerLogin() {
		WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
		mywait.until(ExpectedConditions.elementToBeClickable(drpPropertyManagerLogin)).click();
	}

	public boolean isSignInPageExist() {
		try {
			return (msgHeading.isDisplayed());
		} catch (Exception e) {
			return false;
		}
	}

	public void setUserName(String email) {
		txtUserName.sendKeys(email);

	}

	public void setPassword(String pwd) {
		txtPassword.sendKeys(pwd);

	}

	public void clickSignIn() {
		btnSignIn.click();
	}
	// here we do not have actual account to login so we took statusMsg(Assuming we
	// Logedin) for validation for invalid credentials

	public boolean errorValidation() {
		try {
			return (statusMsg.isDisplayed());
		} catch (Exception e) {
			return false;
		}
	}
}

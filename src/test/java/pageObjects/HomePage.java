package pageObjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	public WebDriver driver;

	// constructor
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// capturing elements

	@FindBy(xpath = "//div[contains(text(),'Products')]")
	WebElement drpProduct;

	@FindBy(xpath = "//div[@class='footer-column']//a[contains(@class,'footer')][text()='ResidentPay']")
	WebElement drpResidentPay;

	@FindBy(xpath = "//div[contains(text(),'Solutions')]")
	WebElement drpSolutions;

	@FindBy(xpath = "//a[starts-with(@class,'sub-menu')][text()='Multifamily']")
	WebElement drpMultiFamily;

	@FindBy(xpath = "//div[contains(text(),'Resources')]")
	WebElement drpResources;

	@FindBy(xpath = "//a[text()='Webinars']")
	WebElement drpWebinars;

	@FindBy(xpath = "//a[contains(text(),'Accept')]")
	WebElement btnCookieAccept;

	@FindBy(xpath = "//button[starts-with(@class,'')]")
	WebElement btnPopUP;

	@FindBy(xpath = "//a[text()='Careers']")
	WebElement lnkCarrier;

	@FindBy(xpath = "//a[contains(text(),'Sign In')]")
	WebElement btnSignIn;

	@FindBy(xpath = "//a[contains(@class,'button hover_black')]")
	WebElement drpPropertyManagerLogin;

	@FindBy(xpath = "(//h3[@class='mega-heading'][text()='Utilities'])[4]")
	WebElement drputilities;

	// action methods of elements

	public void clickPropertyManagerLogin() {
		drpPropertyManagerLogin.click();
	}

	public void clickCookieAccept() {
		WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
		mywait.until(ExpectedConditions.elementToBeClickable(btnCookieAccept)).click();
		// mywait.until(ExpectedConditions.visibilityOf(btnCookieAccept)).click();
	}

	public void clickPopUP() {
		WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
		mywait.until(ExpectedConditions.elementToBeClickable(btnPopUP)).click();
	}

	public void clickProduct() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", drpProduct);
	}

	public void clickResidentPay() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", drpResidentPay);
	}

	public void clickSolutions() {
		drpSolutions.click();
	}

	public void clickMultifamily() {
		drpMultiFamily.click();
	}

	public void clickResources() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", drpResources);

	}

	public void clickWebinar() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", drpWebinars);

	}

	public void clickCarrier() {
		lnkCarrier.click();
	}

	public void clickSignIn() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", btnSignIn);
	}

	public void clickUtilities() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", drputilities);
	}

}

package pageObjects;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CarrierPage {

	public WebDriver driver;
	// constructor

	public CarrierPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	// capturing elements

	@FindBy(xpath = "//a[contains(@class,'white-button w')]")
	WebElement lnkSearchJob;

	@FindBy(xpath = "//div[text()='Location']")
	WebElement drpLocation;

	@FindBy(xpath = "//div[@aria-label='Filter by Location: All']/div[2]//li")
	List<WebElement> drpLocationAllOptions;

	@FindBy(xpath = "//div[normalize-space()='Team']")
	WebElement drpTeam;

	@FindBy(xpath = "//a[normalize-space()='Test Engineering']")
	WebElement drpTestEngineering;

	@FindBy(xpath = "//h5[text()='Senior Performance Testing Engineer']")
	WebElement lnkSeniorSoftwareTestEngineer;

	@FindBy(xpath = "//div[starts-with(@class,'p')]//a[contains(@class,'po')][contains(text(),'App')]")
	WebElement btnApplyforThisJob;

	@FindBy(xpath = "//input[@id='resume-upload-input']")
	WebElement inputFileUpload;

	@FindBy(name = "name")
	WebElement txtFullName;

	@FindBy(xpath = "//input[@value='He/him']")
	WebElement chkHeHim;

	@FindBy(name = "email")
	WebElement txtEmail;

	@FindBy(name = "phone")
	WebElement txtPhone;

	@FindBy(xpath = "//input[@id='location-input']")
	WebElement txtCurrentLocation;

	@FindBy(xpath = "//input[@name='org']")
	WebElement txtCurrentCompany;

	@FindBy(css = "input[name='urls[LinkedIn]']")
	WebElement txtLinkedInURL;

	@FindBy(css = "input[name='urls[GitHub]']")
	WebElement txtGitHubUrl;

	@FindBy(css = "input[name='urls[Portfolio]']")
	WebElement txtPortfolioUrl;

	@FindBy(css = "#additional-information")
	WebElement txtAreaAdditionalInformation;

	@FindBy(xpath = "//button[@id='btn-submit']")
	WebElement btnsubmit;

	// action methods of elements

	public void clickSearchJob() {
		lnkSearchJob.click();
	}

	public void switchToWindow() {
		// Loop through all window handles
		Set<String> windowIDs = driver.getWindowHandles(); // Returns IDs of Multiple windows of Browser

		List<String> windowId = new ArrayList<>(windowIDs);
		String ChildWindowID = windowId.get(1);
		driver.switchTo().window(ChildWindowID);
	}

	public void clickLocationDrp() {
		drpLocation.click();
		for (WebElement option : drpLocationAllOptions) {
			if (option.getText().equals("Pune,India")) {
				option.click();
				break;
			}
		}
	}

	public void clickTeam() {

		WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(5));
		mywait.until(ExpectedConditions.elementToBeClickable(drpTeam)).click();
		mywait.until(ExpectedConditions.elementToBeClickable(drpTestEngineering)).click();
	}

	public void clickApply() {

		WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
		mywait.until(ExpectedConditions.elementToBeClickable(lnkSeniorSoftwareTestEngineer)).click();
	}

	public void clickApplyforThisJob() {
		WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
		mywait.until(ExpectedConditions.elementToBeClickable(btnApplyforThisJob)).click();

	}

	/*
	 * public void uploadResume() {
	 *
	 * JavascriptExecutor js=(JavascriptExecutor)driver; js.
	 * executeScript("arguments[0].setAttribute('value','C:\\\\Users\\\\CHAITANYA AUTADE\\\\Pictures\\\\Screenshots\\\\Screenshot (2).png')"
	 * , inputFileUpload);
	 *
	 *
	 *
	 *
	 * // validation of Screenshot
	 *
	 * /*if (inputFileUpload.getText().equals("Screenshot (280).png")) {
	 * System.out.println("file uploaded successfully"); } else {
	 * System.out.println("unable to upload file"); }
	 */

	public void setFullName(String fname) {
		txtFullName.sendKeys(fname);
	}

	public void clkPronoun() {
		chkHeHim.click();

	}

	public void setemail(String email) {
		txtEmail.sendKeys(email);
	}

	public void setPhone(String phone) {
		txtPhone.sendKeys(phone);
	}

	public void setLocation(String location) {
		txtCurrentLocation.sendKeys(location);
	}

	public void setCompany(String company) {
		txtCurrentCompany.sendKeys(company);
	}

	public void setLinkedInURL(String lurl) {
		txtLinkedInURL.sendKeys(lurl);
	}

	public void setgitHubURL(String ghurl) {
		txtGitHubUrl.sendKeys(ghurl);
	}

	public void setPortfolioURL(String purl) {
		txtPortfolioUrl.sendKeys(purl);
	}

	public void setAdditionalAreaIngormation(String additionalinfo) {
		txtAreaAdditionalInformation.sendKeys(additionalinfo);

	}

	public String getTextofSubmitBtn() {
		String txt = btnsubmit.getText();
		return txt;

	}

}

package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;



public class UtilitiesPage {

	// class Driver declaration
	public WebDriver driver;

	// constructor
	public UtilitiesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	// capturing elements

	@FindBy(xpath = "//img[contains(@class,'slide-image image-contain')]")
	List<WebElement> images;

	@FindBy(xpath = "//div[@class='slider-icon w-icon-slider-right']")
	WebElement nextButton;

	@FindBy(xpath = "//div[@class='slider-icon w-icon-slider-left']")
	WebElement prevButton;

	@FindBy(xpath = "//h2[contains(text(),'Complete')]")
	WebElement sliderHeading;

	// action methods of elements
	// scrooling to slider element
	public void ImageCarousel() throws InterruptedException {

	JavascriptExecutor js=(JavascriptExecutor)driver;
 	js.executeScript("arguments[0].scrollIntoView();",sliderHeading);

		for (WebElement image : images) {

			WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(15));
			mywait.until(ExpectedConditions.visibilityOf(image));
			Assert.assertTrue(image.isDisplayed());

            nextButton.click();

		}
	}
}

package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.UtilitiesPage;
import testBase.BaseClass;

public class TC0004_ImageCarousel extends BaseClass {

	@Test
	public void verify_ImageCarousel() {
		logger.info("***** Starting TC005_ImageCarousel ****");
		try {
			HomePage hp = new HomePage(driver);
			hp.clickCookieAccept();         //  Accept Cookies
			hp.clickPopUP();                // Close PopUp Bar
			hp.clickProduct();              // Click on Product Dropdown
			hp.clickUtilities();            // Click on Utilities

			logger.info("Clicked on utilities.. ");
			String title = driver.getTitle();
			System.out.println(title);
			
			softAssert.assertEquals("Recapture utility expenses for your property | Entrata Utilities", title);

			UtilitiesPage ut = new UtilitiesPage(driver);   // Create Object for Utilities Page and Pass Driver as Parameter

			logger.info("verify ImageCarousel.. ");
			ut.ImageCarousel();

			logger.info("Test passed");
			
			softAssert.assertAll();

		} catch (Exception e) {
			logger.error("Test failed: " + e.getMessage());
			Assert.fail("Test failed: " + e.getMessage());

		} finally {
			logger.info("***** Finished TC0005_Image Caousel*****");
		}
	}

}

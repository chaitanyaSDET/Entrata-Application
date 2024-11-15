package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import testBase.BaseClass;

@Test
public class TC0001_HomePageNavigation extends BaseClass {

	public void verify_Navigation() {
		logger.info("***** Starting TC001_Navigation ****");
		try {
			HomePage hp = new HomePage(driver);
			hp.clickCookieAccept();
			hp.clickPopUP();

			hp.clickProduct();
			logger.info("Clicked on Products.. ");
			hp.clickResidentPay();
			softAssert.assertEquals("ResidentPay | Entrata", driver.getTitle());

			hp.clickSolutions();
			logger.info("Clicked on Solutions.. ");
			hp.clickMultifamily();
			softAssert.assertEquals("Multifamily Property Management Software | Entrata", driver.getTitle());

			hp.clickResources();
			logger.info("Clicked on Resources.. ");
			hp.clickWebinar();

			logger.info("Validating expected Title..");
			softAssert.assertEquals("Helpful Resources for the Multifamily Industry", driver.getTitle());

			softAssert.assertAll();

			logger.info("Test passed");
		} catch (Exception e) {
			logger.error("Test failed: " + e.getMessage());
			Assert.fail("Test failed: " + e.getMessage());
		} finally {
			logger.info("***** Finished TC001_Navigation *****");
		}

	}
}

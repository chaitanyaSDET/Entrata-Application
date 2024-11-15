package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CarrierPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC0002_EndToEndTest extends BaseClass {

	@Test
	public void verify_Carrier() {
		logger.info("***** Starting TC001_Navigation ****");
		try {
			HomePage hp = new HomePage(driver);
			hp.clickCookieAccept();
			hp.clickPopUP();
			hp.clickCarrier();
			logger.info("Clicked on Carrier.. ");

			CarrierPage cp = new CarrierPage(driver);
			cp.clickSearchJob();

			cp.switchToWindow();
			softAssert.assertEquals("Entrata", driver.getTitle());

			cp.clickLocationDrp();

			cp.clickTeam();

			cp.clickApply();

			logger.info("Clicked on Apply.. ");

			System.out.println(driver.getTitle());
			softAssert.assertEquals("Entrata - Senior Performance Testing Engineer", driver.getTitle());

			cp.clickApplyforThisJob();
			logger.info("Clicked on Aply for this Job.. ");
			System.out.println(driver.getTitle());

			softAssert.assertEquals("Entrata - Senior Performance Testing Engineer", driver.getTitle());

			// cp.uploadResume();
			// logger.info("Resume Uploaded .. ");

			cp.setFullName(randomeString());
			logger.info("set FullName... ");

			cp.clkPronoun();
			logger.info("click on pronoun .. ");

			cp.setemail(randomeString()+"@gmail.com");// randomly generated the email
			logger.info("set Email.. ");

			cp.setPhone(randomeNumber());
			logger.info("set PhoneNumber.. ");

			cp.setLocation(randomeAlphaNumberic());
			logger.info("set CurrentLocation.. ");

			cp.setCompany(randomeString().toUpperCase());
			logger.info("set Current Company.. ");

			cp.setLinkedInURL(randomeString().toLowerCase());
			logger.info("set LinkedIn URL.. ");

			cp.setgitHubURL(randomeString().toLowerCase());
			logger.info("set GitHub URL");

			cp.setPortfolioURL(randomeString().toLowerCase());
			logger.info("set PortfolioURL.. ");

			cp.setAdditionalAreaIngormation(randomeAlphaNumberic());
			logger.info("set Additional Area Information.. ");

			String txt = cp.getTextofSubmitBtn();
			softAssert.assertEquals("SUBMIT APPLICATION", txt);

			softAssert.assertAll();
			logger.info("Test passed");

		} catch (Exception e) {
			logger.error("Test failed: " + e.getMessage());
			Assert.fail("Test failed: " + e.getMessage());

		} finally {
			logger.info("***** Finished TC0002_End to End Test *****");
		}

	}

}

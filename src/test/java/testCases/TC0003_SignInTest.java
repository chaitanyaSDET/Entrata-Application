package testCases;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.SignInPage;
import testBase.BaseClass;

public class TC0003_SignInTest extends BaseClass {

	@Test()
	public void verify_loginDDT() throws InterruptedException {
		logger.info("***** Starting TC0003_SignIn Test****");

		try {
			// HomePage
			HomePage hp = new HomePage(driver);
			hp.clickCookieAccept();
			hp.clickPopUP();
			hp.clickSignIn();
			logger.info("Clicked on SignIn button....");


             // SignIn Page
			SignInPage sp = new SignInPage(driver);
			sp.clickPropertyManagerLogin();
			logger.info("clicked on Property Manager Login");

			boolean messageHeading = sp.isSignInPageExist();
			Assert.assertEquals(messageHeading, true,"Login Failed");

			sp.setUserName(p.getProperty("username"));
			logger.info("Enter UserName....");

			sp.setPassword(p.getProperty("password"));
			logger.info("Enter Password....");

			sp.clickSignIn();
			logger.info("clicked on Property Manager Login");

		// we donot have valid data so we are validating Error Message Validation on Wrong Credentials

		  boolean errorMessage   = sp.errorValidation();
			logger.info("Invalid Credentials, Login Failed, status message displayed and TestPassed");
			Assert.assertEquals(errorMessage, true);

        	} catch (Exception e) {
			Assert.fail("An exception occurred: " + e.getMessage());
		}
		logger.info("***** Finished TC00003_SignIn Test  ****");

	}
}

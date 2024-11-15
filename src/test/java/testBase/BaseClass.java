package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager; //Log4j
import org.apache.logging.log4j.Logger; //Log4j
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

public class BaseClass {

	public static WebDriver driver; // for capture screenshot make it static other wise remove static
	public Logger logger; // Log4j
	public Properties p;
	public SoftAssert softAssert;
	public ChromeOptions option;

	@BeforeClass()
	@Parameters({ "browser" })
	public void setup(String br) throws IOException {
		// Loading config.properties file
		FileReader file = new FileReader("./src//test//resources//config.properties");
		p = new Properties();
		p.load(file);
		logger = LogManager.getLogger(this.getClass()); // geting classname dynamically and generate logs
		softAssert = new SoftAssert();
		option = new ChromeOptions();
		option.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});

		switch (br.toLowerCase()) {
		case "chrome":driver = new ChromeDriver(option);break;
		case "edge":driver = new EdgeDriver();break;
		case "firefox":driver = new FirefoxDriver();break;
		default:System.out.println("Invalid Browser");
			return; // if browser is invalid the script will exit the test
		}

		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get(p.getProperty("appURL")); // reading url from properties file.
		driver.manage().window().maximize();

	}

	@AfterClass()
	public void tearDown() {
		driver.quit();
	}

	public String randomeString() {
		String generatedstring = RandomStringUtils.randomAlphabetic(20);
		return generatedstring;
	}

	public String randomeNumber() {
		String generatednumber = RandomStringUtils.randomNumeric(10);
		return generatednumber;
	}

	public String randomeAlphaNumberic() {
		String generatedstring = RandomStringUtils.randomAlphabetic(20);
		String generatednumber = RandomStringUtils.randomNumeric(10);
		return (generatedstring + "@" + generatednumber);
	}

	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

		String targetFilePath = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile = new File(targetFilePath);

		sourceFile.renameTo(targetFile);

		return targetFilePath;

	}

}

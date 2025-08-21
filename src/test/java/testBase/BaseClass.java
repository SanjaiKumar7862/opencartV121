package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	
public static WebDriver driver;
public Logger logger;       //Log4j
	
public Properties pt;       //Properties

	@BeforeClass(groups= {"Sanity", "Regression", "Master", "Datadriven"})
	
	@Parameters({"os","browser"})      //master.xml & crossbrowserParallel.xml
	
	public void setup(String os, String br) throws InterruptedException, IOException
	{
		
		//Access properties file
		FileReader file=new FileReader("./src//test//resources//config.properties");
		pt = new Properties();
		pt.load(file);
		
		
		logger = LogManager.getLogger(this.getClass());
		
		switch(br.toLowerCase())
		{
		case "chrome" : driver = new ChromeDriver(); break;
		case "edge" : driver = new EdgeDriver(); break;
		case "firefox" : driver = new FirefoxDriver(); break;
		default : System.out.println("Invalid browser..End"); return;
		}
		
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//driver.get("https://demo.opencart.com/en-gb?route=common/home");
		//driver.get("https://tutorialsninja.com/demo/");
		
		driver.get(pt.getProperty("appURL1"));     //reading value from properties file
		driver.manage().window().maximize();
		
		Thread.sleep(10000);
	}
	
	
	@AfterClass(groups= {"Sanity", "Regression", "Master", "Datadriven"})
	public void tearDown()
	{
		driver.quit();
	}
	

//Important part - to generate random data
	
	public String randomString()   //Java methods to create random string (returning string)
	{
		String generatedString = RandomStringUtils.randomAlphabetic(6);
		return generatedString;
	}
	
	public String randomNum()   //Java methods to create random number (returning number in string format)
	{
		String generatedNum = RandomStringUtils.randomNumeric(10);
		return generatedNum;
	}
	
	public String randomAlphaNumeric()   //Java methods to create random AlphaNumeric
	{
		String generatedString = RandomStringUtils.randomAlphabetic(6);
		String generatedNum = RandomStringUtils.randomNumeric(10);
		return (generatedString+generatedNum);
	}
	
	
	//Screenshot method
	public String captureScreen(String tname) throws IOException {
	    // Generate timestamp for unique file name
	    String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());

	    // Take screenshot
	    TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
	    File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

	    // Define target file path
	    String targetFilePath = System.getProperty("user.dir") 
	            + "\\screenshots\\" + tname + "_" + timeStamp + ".png";

	    File targetFile = new File(targetFilePath);

	    // Copy source file to target location
	    sourceFile.renameTo(targetFile);

	    return targetFilePath;  // return path so ExtentReport can use it
	}

}


/*
 * The main thing is for creating BaseClass is code reusability and to avoid duplication when using in multiple test cases
 */




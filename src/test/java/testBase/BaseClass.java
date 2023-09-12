package testBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.Logger; // logging package
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.beust.jcommander.ResourceBundle;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;
	public Logger logger; // for logging the log
	
	public java.util.ResourceBundle rb;
	
	@BeforeClass(groups = {"Master","Sanity","Regression"})
	@Parameters("browser")
    public void launchBrowser(String br) throws Throwable {
        
		rb = java.util.ResourceBundle.getBundle("config"); // load config.properties file.
		
		logger = org.apache.logging.log4j.LogManager.getLogger(this.getClass());

	//	ChromeOptions options = new ChromeOptions();
	//	options.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
		
	//	System.setProperty("webdriver.chrome.driver", "D:\\new\\chromedriver.exe");
	//	WebDriverManager.chromedriver().setup();
		WebDriverManager.firefoxdriver().setup();
		
		if(br.equals("firefox"))
		{
			driver = new FirefoxDriver();
		//	driver = new ChromeDriver();
		//	WebDriverManager.firefoxdriver().setup();
		//	WebDriverManager.chromedriver().setup();
		}
		else if(br.equals("chrome"))
		{
			driver = new FirefoxDriver();
			//WebDriverManager.firefoxdriver().setup();
		}
		else 
		{
			driver = new EdgeDriver();
		}
			
		driver.manage().deleteAllCookies();
		
        driver.manage().window().maximize();
       // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      
        driver.get(rb.getString("AITLURL"));

	}
    @AfterClass(groups = {"Master","Sanity","Regression"})
    public void closeBrowser() {
        driver.close();
    }
    
    public String randomeString()
    {
    	String generateString = RandomStringUtils.randomAlphabetic(5);
		return (generateString);   	
    }
    
    public String randomeNumber()
    {
    	String generateString2 = RandomStringUtils.randomNumeric(5);
		return (generateString2);    	
    }
    
    public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";

		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (Exception e) {
			e.getMessage();
		}
		return destination;

	}
}


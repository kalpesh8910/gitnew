package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

	WebDriver driver;
	
	public BasePage(WebDriver driver)
	{
		System.out.println("Came in the base page...");
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}

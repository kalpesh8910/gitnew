package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	// Elements
	
	@FindBy(xpath = "//input[@name='email']")
	WebElement username;
	public void enterUsername(String email)
	{
		username.sendKeys(email);
	}
	
	@FindBy(xpath = "//input[@type='password']")
	WebElement password;
	public void enterPassword(String pwd)
	{
		password.sendKeys(pwd);
	}
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement loginBtn;
	public void clickLoginBtn()
	{
		loginBtn.click();
	}
	
	@FindBy(xpath = "//button[@class='mat-focus-indicator mat-mini-fab mat-button-base mat-primary']")
	WebElement icon;
	public void profileIcon()
	{
		icon.click();
	}
	
	@FindBy(xpath="//*[contains(text(), \"Welcome to All In The Loop\")]")
	WebElement welcomemesg;
	public boolean welcomeMSG()
	{
		try {		 
			return welcomemesg.isDisplayed();		
		} catch(Exception e)		
		{
			return(false);
		}		
	}
	
	@FindBy(xpath="//button[@class='mat-focus-indicator mat-mini-fab mat-button-base mat-primary']")
	WebElement profile;
	public void clickProfile()
	{
		profile.click();	
	}
	
	@FindBy(xpath="//button[@class='mat-focus-indicator mat-mini-fab mat-button-base mat-primary']")
	WebElement signOutText;
	public void clickSignout()
	{
		signOutText.click();	
	}
}

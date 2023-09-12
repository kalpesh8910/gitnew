package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage{

	public RegisterPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//span[contains(text(),\"Register now!\")]")
	WebElement registerNowButton;
	public void clickRegisterNow()
	{
		registerNowButton.click();
	}
	
	@FindBy(id = "login-email")
	WebElement newEmail;
	public void enterEmail(String email)
	{
		newEmail.sendKeys(email);
	}
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement getStartedBtn;
	public void clickGetStarted()
	{
		getStartedBtn.click();
	}
	
	@FindBy(xpath = "//button[@class='btn btn-primary1 next btn btn-primary']")
	WebElement continueButton;
	public void clickContinueButton()
	{
		//continueButton.click();
		
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", continueButton);
	}
	
	@FindBy(name = "name")
	WebElement nameField;
	public void enterName(String name)
	{
		nameField.sendKeys(name);
	}
	
	@FindBy(name = "companyName")
	WebElement companyField;
	public void enterCompanyname(String companyname)
	{
		companyField.sendKeys(companyname);
	}
	
	@FindBy(name = "password")
	WebElement passwordField;
	public void enterpassword(String password)
	{
		passwordField.sendKeys(password);
	}
	
	@FindBy(id = "val-confirm-password")
	WebElement confirmPasswordField;
	public void enterConfirmPassword(String confpassword)
	{
		confirmPasswordField.sendKeys(confpassword);
	}
	
	@FindBy(xpath = "//*[contains(text(),\"Create Account\")]")
	WebElement createAccountButton;
	public void clickCreateActButton()
	{
		createAccountButton.click();
	}
	
	@FindBy(xpath = "//*[contains(text(),\"Click here to Login\")]")
	WebElement clickheretologin;
	public void clickHereToLogin()
	{
		clickheretologin.click();
	}
	
	
	
	
	
	
	
}

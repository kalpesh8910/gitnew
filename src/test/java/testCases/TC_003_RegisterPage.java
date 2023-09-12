package testCases;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import pageObjects.RegisterPage;
import testBase.BaseClass;

public class TC_003_RegisterPage extends BaseClass{

	@Test(groups = {"Sanity"})
	void test_account_register () throws InterruptedException
	{
		
		logger.info("*** Starting TC_003_RegisterPage ***");
		
		RegisterPage rp = new RegisterPage(driver);
		
		Thread.sleep(2000);
		
		rp.clickRegisterNow();
		Thread.sleep(3000);
		
		rp.enterEmail(rb.getString("newRegisterEmail"));
		Thread.sleep(3000);
		
		rp.clickGetStarted();
		Thread.sleep(3000);
		
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("window.scrollBy(0,250)", "");
			
		rp.clickContinueButton();
		Thread.sleep(5000);
		
		rp.enterName(rb.getString("name"));
		Thread.sleep(3000);
		
		rp.enterCompanyname(rb.getString("companyName"));
		Thread.sleep(3000);
		
		rp.enterpassword(rb.getString("password"));
		Thread.sleep(3000);
		
		rp.enterConfirmPassword(rb.getString("confirmPassword"));
		Thread.sleep(5000);
		
		rp.clickContinueButton();
		Thread.sleep(3000);
		
		rp.clickCreateActButton();
		Thread.sleep(3000);
		
		rp.clickHereToLogin();
		Thread.sleep(3000);
	}
}

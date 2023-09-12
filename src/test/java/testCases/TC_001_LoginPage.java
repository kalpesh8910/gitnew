package testCases;

import org.testng.annotations.Test;

import pageObjects.CallforPaper;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC_001_LoginPage extends BaseClass{
	
	@Test(groups = {"Regression"})
	void test_account_login() throws InterruptedException
	{
		logger.info("*** Starting TC_001_LoginPage ***");
	
		try {
		
		System.out.println("Came in the main test case");
		
		LoginPage lp = new LoginPage(driver);
		CallforPaper cp = new CallforPaper(driver);
		
		// Enter email address
		lp.enterUsername(rb.getString("AITLEmail"));
		logger.info("*** Enter the user email address***");
		Thread.sleep(2000);
		
		// Enter password
		lp.enterPassword(rb.getString("AITLPassword"));
		logger.info("*** Enter the password ***");
		Thread.sleep(2000);
		
		// Click on login button
		lp.clickLoginBtn();
		logger.info("*** Clicking on login button ***");		
		Thread.sleep(4000);
		
		// Click on +New call for paper
		cp.clickNewCallPaper();
		Thread.sleep(7000);
		
		String value = rb.getString("PaperName");
		
		// Enter new call for paper
		cp.EnterNewPaperName(value);		
		Thread.sleep(3000);
		
		// Click on Add button
		cp.clickAddButton();
		Thread.sleep(6000);
		
		cp.clickEditCallForPaper(value);
		
		Thread.sleep(8000);
		} catch(Exception e)
		
		{
			System.out.println(e);
			System.out.println("It's a catch block...");
		}
		
		logger.info("*** finished the TC_001_LoginPage ***");
		
	}	
	
}

package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_002_LoginDDT extends BaseClass {

	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class)
	public void test_loginDDT(String emailadd, String pwd, String exp) throws InterruptedException
	{
		logger.info(" *** Starting TC_002_LoginDDT ***");
		
	try {	
		LoginPage lp = new LoginPage(driver);
		System.out.println(rb.getString(emailadd));
		
		lp.enterUsername(rb.getString(emailadd));
		logger.info("*** Enter the email address ***");
		Thread.sleep(2000);
		
		lp.enterPassword(rb.getString(pwd));
		logger.info("*** Enter the password ***");
		Thread.sleep(2000);
		
		lp.clickLoginBtn();
		logger.info("*** Clicking on login button ***");
		
		Thread.sleep(4000);
		
		boolean targateText = lp.welcomeMSG();
		
		if(exp.equals("Valid"))
		{
			if(targateText==true)
			{
				lp.clickProfile();
				Thread.sleep(1000);
				lp.clickSignout();
				Assert.assertTrue(true);
			} else {
				Assert.assertTrue(false);
			}
		}
		
		if(exp.equals("Invalid"))
		{
			if(targateText==true)
			{
				lp.clickProfile();
				Thread.sleep(1000);
				lp.clickSignout();
				Assert.assertTrue(false);
			} else {
				Assert.assertTrue(true);
			}
		}
		
		}catch(Exception e)
			{
				Assert.fail();
			}
		logger.info("*** Finished TC_002_LoginDDT ***");
	}
	
}

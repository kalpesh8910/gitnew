package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CallforPaper extends BasePage{
	private WebDriver d;                
	public CallforPaper(WebDriver driver) {
		super(driver);
		d = driver;
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//*[contains(text(),'+ New Call for Papers')]")
	WebElement callForPaper;
	public void clickNewCallPaper()
	{
		callForPaper.click();
	}
	
	@FindBy(xpath = "//input[@name='name']")
	WebElement enterNewPaperName;
	public void EnterNewPaperName(String newpapername)
	{
		enterNewPaperName.sendKeys(newpapername);
	}
	
	@FindBy(xpath = "//span[contains(text(),\"Add\")]")
	WebElement addButton;
	public void clickAddButton()
	{
		addButton.click();
	}
		
//	@FindBy(xpath = "//mat-card-title[text()='new kp']/../../following-sibling::mat-card-content//button[1]")
	WebElement editCallForPaper;
	public void clickEditCallForPaper(String name)
	{
		String s = "//mat-card-title[text()='"+name+"']/../../following-sibling::mat-card-content//button[1]";
		//String.format(s, name);
		System.out.println(s);
		WebElement e = d.findElement(By.xpath(s));	
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", e);
	}
	
	@FindBy(xpath = "//input[@name='eventname']")
	WebElement maindetaileventname;
	public void enterMainDetaileventName(String eventname)
	{
		maindetaileventname.sendKeys(eventname);
	}
		
	@FindBy(xpath = "//input[@name='eventname']")
	WebElement inputName;
	public void enterName(String name)
	{
		inputName.sendKeys(name);
	}
	
	
}

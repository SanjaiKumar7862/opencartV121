package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccount extends BasePage {

//1.Constructor
	
	public MyAccount(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
//2.Locators
	@FindBy(xpath="//h2[normalize-space()='My Account']")
	WebElement msgHeading;
	
	@FindBy(xpath="//div[@class='list-group']//a[text()='Logout']")
	WebElement lnkLogout;
	
	
//3.Action methods
	public boolean isMyAccountPageExist()
	{
		try
		{
		return (msgHeading.isDisplayed());
		}
		catch (Exception e)
		{
			return false;
		}
	}
	
	
	public void clickLogout()
	{
		lnkLogout.click();
	}

}

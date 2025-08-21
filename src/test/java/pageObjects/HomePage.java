package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	
//--> Whenever creating the page object class we need to focus on 3 things:
	// 1) Constructor
	// 2) Locators
	// 3) Action methods

//Note --> In page object class, we should not do any validations
	
	
// 1) Constructor to initialize driver from BasePage
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	
// 2) Locators
	@FindBy(xpath="//span[normalize-space()='My Account']")
	WebElement lnkMyaccount;
	
	@FindBy(xpath="//a[normalize-space()='Register']")
	WebElement lnkRegister;
	
	
	@FindBy(xpath="//a[normalize-space()='Login']")
	WebElement lnkLogin;
	

// 3) Action methods
	public void ClickMyAccount()
	{
		lnkMyaccount.click();
	}
	
	public void ClickRegister()
	{
		lnkRegister.click();
	}
	
	public void ClickLogin()
	{
		lnkLogin.click();
	}
	
}

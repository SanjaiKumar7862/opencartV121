package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class AccountRegister extends BasePage{
	
//--> Whenever creating the page object class we need to focus on 3 things:
	// 1) Constructor
	// 2) Locators
	// 3) Action methods

//Note --> In page object class, we should not do any validations	


//1) Contructor
	public AccountRegister(WebDriver driver) 
	{
		super(driver);
	}
	

//2) Locators
	@FindBy(xpath="//input[@id=\"input-firstname\"]")
	WebElement txtFirstName;

	@FindBy(xpath="//input[@id=\"input-lastname\"]")
	WebElement txtLastName;
	
	@FindBy(xpath="//input[@id=\"input-email\"]")
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@id=\"input-telephone\"]")
	WebElement txtPhone;
	
	@FindBy(xpath="//input[@id=\"input-password\"]")
	WebElement txtPassword;
	
	@FindBy(xpath="//input[@id=\"input-confirm\"]")
	WebElement txtPasswordCnfrm;
	
	
	@FindBy(xpath="//label[contains(.,'Yes')]")
	WebElement chkNewsletter;
	
	@FindBy(xpath="//input[@name=\"agree\"]")
	WebElement chkPrivacy;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement btnContinue;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;
	

//3) Action methods
	public void FirstName(String fname)
	{
		txtFirstName.sendKeys(fname);
	}
	
	public void LastName(String lname)
	{
		txtLastName.sendKeys(lname);
	}
	
	public void Email(String email)
	{
		txtEmail.sendKeys(email);
	}
	
	public void Telephone(String phn)
	{
		txtPhone.sendKeys(phn);
	}
	
	public void Password(String pwd)
	{
		txtPassword.sendKeys(pwd);
	}
	
	public void PasswordCnfrm(String pwd)
	{
		txtPasswordCnfrm.sendKeys(pwd);
	}
	
	public void NewsLetter()
	{
		chkNewsletter.click();
	}
	
	public void Privacy()
	{
		chkPrivacy.click();
	}
	
	public void Continue()
	{
		// btnContinue.click();    // Sol 1
		
		
		// btnContinue.submit();   //Sol 2
		
		// Actions ac = new Actions(driver);   //Sol 3
		// ac.moveToElement(btnContinue).click().perform();
		
		// JavascriptExecutor js = (JavascriptExecutor)driver;   //Sol 4
		// js.executeScript("arguments[0].click();", btnContinue);
		
		 btnContinue.sendKeys(Keys.ENTER);   //Sol 5
		
		// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));    //Sol 6
		// wait.until(ExpectedConditions.elementToBeClickable(btnContinue)).click();
		
	}
	
	public String getmsgConfirmation()     //this method get the msg and returning the string
	{
		try
		{
			return (msgConfirmation.getText());
		}
		catch(Exception e) 
		{
			return (e.getMessage());
		}
	}
	
	
}


package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


//BaseClass is a parent class of all page objects classes. Here we are creating only Constructor to initialize driver

//this. -> refers to the driver variable at class level

public class BasePage {

	WebDriver driver;
	
	public BasePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
}

/*
 * --> PageFactory.initElements(driver, this);
 * This initializes all @FindBy annotated WebElements in the current class.
 * driver: tells Selenium where to look for elements.
 * this: refers to the current page object instance. 
 * 
 */

/*
 * The main thing is for creating BaseClass is code reusability and to avoid duplication when using in multiple test cases
 */


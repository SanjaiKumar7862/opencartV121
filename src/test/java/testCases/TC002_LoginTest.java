package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccount;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass{
	
	@Test(groups={"Sanity","Master"})
	public void verify_Login()
	{
		logger.info("Starting the test case TC002");
		
		try
		{		
		HomePage hp = new HomePage(driver);       //Access Homepage to access element and Pass driver from BaseClass into pageObject class
		hp.ClickMyAccount();
		hp.ClickLogin();
		
		LoginPage lp = new LoginPage(driver);     //Access Loginpage to access element and Pass driver from BaseClass into pageObject class
		lp.setemail(pt.getProperty("email"));     //Access data from properties file
		lp.setpassword(pt.getProperty("password"));
		lp.clickLogin();
		
		//MyAccount page
		MyAccount mp = new MyAccount(driver);     //Access MyAccount
		boolean targetpage = mp.isMyAccountPageExist();
		
		//Assert.assertEquals(targetpage, true, "Login Failed..");        (or)
		Assert.assertTrue(targetpage);
		}
		catch (Exception e)
		{
			Assert.fail();
		}
		
		
		logger.info("Finishing the test case TC002");	
		
	}
	
}

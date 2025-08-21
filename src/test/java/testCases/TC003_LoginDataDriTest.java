package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccount;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDataDriTest extends BaseClass{
	
	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class, groups="Datadriven")      //We need to specify additional parameter because DP is in different package
	public void verify_LoginDDT(String email, String pwd, String expected)
	{
		
		logger.info("Starting of Test case TC003");
	
		try
		{
		
		HomePage hp = new HomePage(driver);       //Access Homepage to access element and Pass driver from BaseClass into pageObject class
		hp.ClickMyAccount();
		hp.ClickLogin();
		
		LoginPage lp = new LoginPage(driver);     //Access Loginpage to access element and Pass driver from BaseClass into pageObject class
		lp.setemail(email);     //Access data from DataProvider class
		lp.setpassword(pwd);
		lp.clickLogin();
		
		//MyAccount page
		MyAccount mp = new MyAccount(driver);     //Access MyAccount
		boolean targetpage = mp.isMyAccountPageExist();
		
		
		/*   
		 * Validations
		Data is valid - login success - test pass - logout
						login fail - test fail

		Data is invalid - login success - test fail - logout
						login fail - test pass
		 */
		
		if(expected.equalsIgnoreCase("Valid"))
		{
			if(targetpage==true)
			{
				mp.clickLogout();
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
		
		if(expected.equalsIgnoreCase("Invalid"))
		{
			if(targetpage==true)
			{
				mp.clickLogout();
				Assert.assertTrue(false);
			}
			else
			{
				Assert.assertTrue(true);
			}
		}
		
		}catch(Exception e)
		{
			Assert.fail();
		}
		
		
		logger.info("Ending of Test case TC003");
	
	}
	
}

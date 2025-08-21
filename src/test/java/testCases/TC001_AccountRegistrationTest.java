package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegister;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass{

	
	@Test(groups={"Regression","Master"})
	public void verify_RegisterAccount()
	{
		try
		{
		logger.info("*** Starting of TC001 ***");
		
		HomePage hp = new HomePage(driver); //HomePage driver constructor involke on run time
		hp.ClickMyAccount();
		logger.info("Clicking on MyAccount..");
		
		hp.ClickRegister();
		logger.info("Clicking on Register..");
		
		AccountRegister accReg = new AccountRegister(driver);
		logger.info("Providing customer details..");
		accReg.FirstName("SANJAI");
		accReg.LastName("SB");
		accReg.Email(randomString()+"@gmail.com");    //Generate random email by using random method created in BaseClass
		accReg.Telephone(randomNum());
		
		String pwd = "sanjaikumar";
		accReg.Password(pwd);
		accReg.PasswordCnfrm(pwd);
		
		accReg.NewsLetter();
		accReg.Privacy();
		accReg.Continue();
		
		logger.info("Validating expected message..");
		String accRegMsg = accReg.getmsgConfirmation();
		
		if(accRegMsg.equals("Your Account Has Been Created!"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("Test Failed");
			logger.debug("Debug Logs");
			
			Assert.assertTrue(false);
		}
		
				//Assert.assertEquals(accRegMsg, "Your Account Has Been Created!");
		}
		catch (Exception e)
		{
			//System.out.println("Exception: " + e);
			
			Assert.fail();
		}
		
		logger.info("*** End of TC001 ***");
	}	
	
}

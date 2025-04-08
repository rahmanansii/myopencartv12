package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePge;
import testBase.BaseClass;


public class TC001_AccountRegistrationTest extends BaseClass {
	
	
	
	
	
	@Test(groups={"sanity","master"})
	public void verify_acc_req()
	{
		logger.debug("started");;
		
		try {
		HomePge hp= new HomePge(driver);
		hp.clickMyAccount();
		hp.clickRegister();
		logger.debug("***Clicked on login***");
		
		
		AccountRegistrationPage rp = new AccountRegistrationPage(driver);
		rp.setFirstName(randstring().toUpperCase());
		rp.setLastName(randstring().toUpperCase());
		rp.setEmail(randstring()+"@gmail.com");
		rp.setPhone(randnumber());
		
		
		String Pass=ranalphanum();
		rp.setPassword(Pass);
		rp.setConfirmPassword(Pass);
		rp.setPolicy();
		rp.clickContinue();
		
		logger.debug("***validating message***");
		String confmsg=rp.getConfirmationMsg();
		if(confmsg.equals("Your Account Has Been Created!"))
		{
			Assert.assertTrue(true);
		}
		else 
		{
			logger.error("test failed");
			logger.debug("debug logs");
			Assert.assertTrue(false);
		}
		}
		catch(Exception e)
		{
			
			Assert.fail();
		}
		logger.debug("finisheddddd");
	}
	
	
	
	
	

}

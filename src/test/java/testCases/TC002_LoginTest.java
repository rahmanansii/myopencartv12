package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePge;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {
	
	@Test(groups= {"regression","master"})
	public void verify_login()
	{
		logger.info("**started**");
		
		try {
		HomePge hp=new HomePge(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		
		LoginPage lp= new LoginPage(driver);
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin();
		
		
		MyAccountPage maccp = new MyAccountPage(driver);
		boolean target=maccp.myAccountExists();
		Assert.assertEquals(target, true,"failed");}
		
		catch(Exception e) {
			Assert.fail();
		}
		
		logger.info("**finished**");
		
	}
	
	
	
	
	

}

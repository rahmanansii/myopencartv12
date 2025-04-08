package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePge;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass{
	
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class)
	public void verify_loginDDT(String email, String pwd, String exp)
	{
		logger.info("**started**");
		
		try {
		HomePge hp=new HomePge(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		
		/*LoginPage lp= new LoginPage(driver);
		lp.setEmail(email);
		lp.setPassword(pwd);
		lp.clickLogin();*/
		
		
		MyAccountPage maccp = new MyAccountPage(driver);
		boolean target=maccp.myAccountExists();
		
		if(exp.equalsIgnoreCase("valid"))
		{
			if(target==true)
			{
				maccp.clickLogout();
				Assert.assertTrue(true);
				
			}
			else
			{
				Assert.assertTrue(false); 
			}
		}
		
		if(exp.equalsIgnoreCase("invalid"))
		{
			if(target==true)
			{
				maccp.clickLogout();
				Assert.assertTrue(false);
			}
			else
			{
				
				Assert.assertTrue(true);
			}
		}
		}
		catch(Exception e){
			Assert.fail();
		}
		
		logger.info("**finished**");
		
	}

}

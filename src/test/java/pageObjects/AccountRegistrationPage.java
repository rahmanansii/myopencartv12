package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage{
	WebDriver driver;
	
	public AccountRegistrationPage(WebDriver driver)
	{
		super(driver);
	}
	
	
	@FindBy(xpath = "//input[@id='input-firstname']")
	WebElement txtFirstname;


@FindBy(xpath="//input[@id='input-lastname']")
WebElement txtLastname;

@FindBy(xpath="//input[@id='input-email']")
WebElement txtEmail;

@FindBy(xpath="//input[@id='input-telephone']")
WebElement txtPhone;

@FindBy(xpath="//input[@id='input-password']")
WebElement txtPassword;

@FindBy(xpath="//input[@id='input-confirm']")
WebElement txtConfirmPassword;

@FindBy(xpath="//input[@name='agree']")
WebElement checkedPolicy;

@FindBy(xpath="//input[@value='Continue']")
WebElement btnContinue;

@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
WebElement verifyMessage;


public void setFirstName(String fname) {
	txtFirstname.sendKeys(fname);
}

public void setLastName(String lname) {
	txtLastname.sendKeys(lname);}

public void setEmail(String email) {
	txtEmail.sendKeys(email);}

public void setPhone(String phone) {
	txtPhone.sendKeys(phone);}

public void setPassword(String pswd) {
	txtPassword.sendKeys(pswd);}

public void setConfirmPassword(String pswd) {
	txtConfirmPassword.sendKeys(pswd);}

public void setPolicy() {
	checkedPolicy.click();}

public void clickContinue() {
	 btnContinue.click();}

public String getConfirmationMsg() {
	try {
		return(verifyMessage.getText());
	}
	catch(Exception e) {
		return (e.getMessage());
	}
	}
	
}

	


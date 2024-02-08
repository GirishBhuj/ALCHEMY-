package com.ibm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/*
 * initElements(): initElements is a static method in Page 
 * Factory class. Using the initElements method, one can initialize 
 * all the web elements located by @FindBy annotation.
 * 
 */

public class LandingPage {
	
	public WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Define all actions on all the elements
	
	//Address of  Username Edit box
	@FindBy(css= "input#login1" )
	public WebElement Uname;
	
	//Address of Password Edit box
	@FindBy(css= "input[name = 'passwd']" )
	public WebElement Pwd;

	//Address of Keep Me Signed InCheckbox
	@FindBy(name= "remember" )
	public WebElement KeepMeSignedIn;
	
	//Address of Sign Button
	@FindBy(css= "form[name ='loginform']>div:nth-child(3)>div:nth-child(2)>div:nth-child(2)>div:nth-child(2)>div:nth-child(1)>input:nth-child(3)" )
	public WebElement Signin;
	
	//Address of Create a New Account 
	@FindBy(xpath = "/html/body/div[1]/div[1]/div[1]/div[2]/form/div[2]/div/a/u")
	public WebElement CreateAccount;
	
	//Define all actions on all the elements
	//Type on Username Edit box
	public void TypeUsername(String txt) {
		Uname.clear();
		Uname.sendKeys(txt);
	}
	
	//Type on Password Edit box
	public void TypePassword(String txt) {
		Pwd.clear();
		Pwd.sendKeys(txt);
	}
	
	//Check the Keep Me Signed In Checkbox
	public void CheckKeepmesignedin() {
		KeepMeSignedIn.click();
	}
	
	//Click on Sign in button
	public void ClickSigninButton() {
		Signin.click();
	}
	
	//Click on Create a new account link
	public void ClickCreateAccount() {
		CreateAccount.click();
	}
	
	/*
	 * Validation can also be kept for each element but we have 
	 * created assertion based function in Utilities class of 
	 * com.ibm.utils package
	 */
	
	
}

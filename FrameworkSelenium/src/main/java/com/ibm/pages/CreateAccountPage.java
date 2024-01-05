package com.ibm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateAccountPage {
	public WebDriver driver;
	public Select s;
	
	public CreateAccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Address of Full Name Field
	@FindBy(xpath = "//input[contains(@name,'name')]")
	public WebElement FullName;
	
	//Address of Choose a Rediffmail id field
	@FindBy(css = "input[name*='login']")
	public WebElement RediffmailID;
	
	//Address of Password field
	@FindBy(xpath = "//input[contains(@name, 'passwd')]")
	public WebElement Passwd;
	
	//Address of Retype Password field
	@FindBy(xpath = "//input[contains(@name, 'confirm_passwd')]")
	public WebElement RePasswd;
	
	//Address of checkbox if we do not have alternate id
	@FindBy(xpath = "//input[starts-with(@name, 'chk_altemail')]")
	public WebElement CheckoxNoAltID;
		
	
	//Address of Select a Security Question dropdown
	@FindBy(xpath = "//select[contains(@name,'hint')]")
	public WebElement SelectQuestion;
	
	//Address of Enter Answer for Security question
	@FindBy(xpath = "//input[starts-with(@name, 'hinta')]")
	public WebElement EnterAnswerSecurityQuestion;
	
	//Address of Mother's Maiden Name
	@FindBy(xpath = "//input[starts-with(@name, 'mothername')]")
	public WebElement MotherName;
	
	
	//Address of Drop down - ISD COde
	
	@FindBy(xpath = "//*[@id='div_mob']/table/tbody/tr/td[3]/div[2]")
	public WebElement CountryCodeDropDown;
	//Address of the Afghanistan option
	@FindBy(xpath = "//*[@id='country_id']/ul/li[4]")
	public WebElement AfghanOptionDropDown;
	
	
	//Address of Mobile Number
	@FindBy(xpath = "//input[starts-with(@name, 'mobno')]")
	public WebElement MobileNumber;
	
	
	//Address of Day Drop Down
	@FindBy(xpath = "//select[contains(@name,'DOB_Day')]")
	public WebElement DayDropDown;
	
	//Address of Month Drop Down
	@FindBy(xpath = "//select[contains(@name,'DOB_Month')]")
	public WebElement MonthDropDown;
	
	//Address of Year Drop Down
	@FindBy(xpath = "//select[contains(@name,'DOB_Year')]")
	public WebElement YearDropDown;
	
	/*Address of Female Radio button
	// Radio button with all attributes are same only value is different
	<td colspan="3">
		<input type="radio" name="gender94e72db3" value="m" checked="checked" onclick="fieldTrack(this);">Male &nbsp;&nbsp;
		<input type="radio" name="gender94e72db3" value="f" onclick="fieldTrack(this);">Female 
	</td>
	*/
	@FindBy(xpath = "//input[@value = 'f']")
	public WebElement FemaleRadiobutton;
	
	//Type Action on Rediffmail ID  Field
	public void TypeRediffmailId(String txt) {
		RediffmailID.clear();
		RediffmailID.sendKeys(txt);
	}
	
	//Type Action on Full Name
	public void TypeFullName(String txt) {
		FullName.clear();
		FullName.sendKeys(txt);
	}
	
	//Type Action on Password Field
	public void TypePasswrd(String txt) {
		Passwd.clear();
		Passwd.sendKeys(txt);
	}
	
	//Type Action on Retype Password Field
	public void TypeRetypePasswrd(String txt) {
		RePasswd.clear();
		RePasswd.sendKeys(txt);
	}
	
	//Click  Action on checkbox if we do not have alternate id
	public void ClickCheckBoxNoAlternateID() {
		CheckoxNoAltID.click();
	
	}
	
	//Select by index - Select Security Question drop Down
	public void SelectQuestion(int index) {
		s = new Select(SelectQuestion);
		//Will select by index number
		s.selectByIndex(index);
	}
	
	//Type Action on Enter Answer for Security Question
	public void TypeEnterAnswerSecurityQuestion(String txt) {
		EnterAnswerSecurityQuestion.clear();
		EnterAnswerSecurityQuestion.sendKeys(txt);
	}
	
	//Type Action on mother's Maiden Name
	public void TypeMotherName(String txt) {
		MotherName.clear();
		MotherName.sendKeys(txt);
	}
	
	//Choose Afghanistan option from ISD Drop Down
	public void ChooseAfghanOptionDropDown() {
		CountryCodeDropDown.click();
		AfghanOptionDropDown.click();
	}
	
	//Type Action on mobile number
	public void TypeMobilNumber(String txt) {
		MobileNumber.clear();
		MobileNumber.sendKeys(txt);
	}
	
	//Select by index - Select Day drop Down
	public void SelectDay(String d) {
		s = new Select(DayDropDown);
		//Will select by visible text
		s.selectByVisibleText(d);
	}
	
	//Select by index - Select Month drop Down
	public void SelectMonth(String mon) {
		s = new Select(MonthDropDown);
		//Will select by value
		s.selectByValue(mon);
    }
	
	//Select by index - Select YEar drop Down
	public void SelectYear(String yrs) {
		s = new Select(YearDropDown);
		//Will select by value
		s.selectByValue(yrs);
	}
	
	//Click  Action on Female Radio Button
	public void ClickFemaleRadioButton() {
		FemaleRadiobutton.click();
		
	}
	
}

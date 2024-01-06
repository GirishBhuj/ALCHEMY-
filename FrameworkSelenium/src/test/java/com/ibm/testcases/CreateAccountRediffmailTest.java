package com.ibm.testcases;

import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.util.Hashtable;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.ibm.base.Base;
import com.ibm.config.DataTestCase;
import com.ibm.pages.CreateAccountPage;
import com.ibm.pages.LandingPage;
import com.ibm.utils.ExtentManager;
import com.ibm.utils.Utilities;



public class CreateAccountRediffmailTest extends Base{
	
	
	public WebDriver driver;
	public WebDriverWait wait;
	public WebElement w1;
	public List<WebElement> l1;
	public Utilities u;
	public Actions act;
	public Select s;
	public LandingPage l;
	public CreateAccountPage ca;
	
	//Create an object of ExtentSparksReporter class
	ExtentSparkReporter report = ExtentManager.getInstanceExtentSparkReporter();
    //Create an object of ExtentReports class
    ExtentReports extent = ExtentManager.getInstanceExtentReports();
	//This class acts like a log report creator
	ExtentTest logger;

	@BeforeMethod
	public void SetUp() throws MalformedURLException {
		
		driver = CreateAccountRediffmailTest.OpenBrowser("Chrome", "https://mail.rediff.com/cgi-bin/login.cgi");
	
		//Create object of Utilities class
		u = new Utilities(driver);
		
		l = new LandingPage(driver);
		
		ca = new CreateAccountPage(driver);
	}
	
	@AfterMethod
	public void TearDown(ITestResult result) {
		
		if(result.getStatus() == ITestResult.FAILURE) {
			String screenshot = u.FailScreeshot(result.getName());
			//Also put the failed screenshot in Extent report
			// Adding screenshots to log of Extent Report
			logger.fail("Assertion failed", MediaEntityBuilder.createScreenCaptureFromPath(screenshot).build());
			// Adding screenshots to test
			logger.fail("Assertion failed").addScreenCaptureFromPath(screenshot);
			//Add the test annotation method name which has failed in the log
			logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + "-- Create Account - Rediffmail Test case Failed", ExtentColor.RED));
			//Add the exception name on assertion failure to the log
			logger.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + "--  Create Account - Rediffmail Test case Failed", ExtentColor.RED));
		}
		
		//Flush out the report
		extent.flush();
				
		
		//Close the browser
		u.CloseBrowser();
	}
	

	@Test(dataProvider = "AccountCreation" , dataProviderClass = DataTestCase.class )
	//public void AccountCreateRediffmail(String fullName, String rediffId, String pwd, String rpwd, String ans, String mName, String pNum) throws InterruptedException {
	public void AccountCreateRediffmail(Hashtable<String, String> h ) throws InterruptedException {
		//Create the Test Case
		logger = extent.createTest("Create Account - Rediffmail");
		
		//Create the category for testing - using the assign category method of ExtentTest class
		logger.assignCategory("Functional Test Category");
		
		u.StepWiseScreeshot("OpenCreateAccountWebsite");
		
		logger.log(Status.INFO, MarkupHelper.createLabel("Opening of App - Create Account",ExtentColor.BLUE));
		
		
		//Implicit Wait
		u.ImpicitDynamicWait(20);
		
		//Explicit Wait
		u.ExplicitPageTitle(20, "Rediffmail");
		
		//Click on Create a new account
		l.ClickCreateAccount();
		
		logger.log(Status.INFO, MarkupHelper.createLabel("Clicked on Create a new Account",ExtentColor.BLUE));
		
		
		//Assert that the text "Create a Rediffmail account" is present
		u.AssertText("Create a Rediffmail account", "xpath", "//td[text() = 'Create a Rediffmail account']", "Create a Rediffmail account text not present");
		
		logger.log(Status.PASS, MarkupHelper.createLabel("Create a Rediffmail account text present",ExtentColor.GREEN));
		
		
		
		//Use the Assert class of TestNG to validate by text - Full Name
		u.AssertText("Full Name", "xpath", "//*[@id='tblcrtac']/tbody/tr[3]/td[1]", "Full Name text is not present");
	
		logger.log(Status.PASS, MarkupHelper.createLabel("Full Name text is not present",ExtentColor.GREEN));
		
		
		//Type on Full Name field
		ca.TypeFullName(h.get("fullName"));
		
		logger.log(Status.INFO, MarkupHelper.createLabel("Type on FullName field ",ExtentColor.BLUE));
		
		
		u.StepWiseScreeshot("TypeFullName");
		
		
		//Use the Assert class of TestNG to validate by text - Choose Rediffmail id
		u.AssertText("Choose a Rediffmail ID", "xpath", "//*[@id='tblcrtac']/tbody/tr[7]/td[1]", "Choose a Rediffmail text is not present");
		
		logger.log(Status.PASS, MarkupHelper.createLabel("Choose a Rediffmail text is present",ExtentColor.GREEN));
		
		
		//Type on Choose a Rediffmail id field
		ca.TypeRediffmailId(h.get("rediffId"));
		
		logger.log(Status.INFO, MarkupHelper.createLabel("Type on Rediffmail field",ExtentColor.BLUE));
		
		
		u.StepWiseScreeshot("TypeRediffmailId");
		
		
		//Use the Assert class of TestNG to validate by attribute value - Check Availability button
		u.AssertAttributeValue("Check availability", "value", "xpath", "//input[starts-with(@name, 'btnchk')]", "Attribute value for VALUE is not matching");
		
		logger.log(Status.PASS, MarkupHelper.createLabel("Attribute value for VALUE is matching",ExtentColor.GREEN));
		
		
		//Click on Check Avalability button
		if(u.isTextPresent("//input[starts-with(@name, 'btnchk')]")) {
			System.out.println("Element Present ");
		}else {
			System.out.println("Move Forward");
		}
		
		//Assert the text PASSWORD
		u.AssertText("Password", "xpath", "//*[@id=\"tblcrtac\"]/tbody/tr[9]/td[1]", "Password Text not present");
		
		logger.log(Status.PASS, MarkupHelper.createLabel("Password Text is present",ExtentColor.GREEN));
		
		
		//Type on Password Field
		ca.TypePasswrd(h.get("pwd"));
		
		logger.log(Status.INFO, MarkupHelper.createLabel("Typed on Passworf field",ExtentColor.BLUE));
		
		
		u.StepWiseScreeshot("TypePasswrd");
		
		//Assert the text RETYPE PASSWORD
		u.AssertText("Retype password", "xpath", "//*[@id=\"tblcrtac\"]/tbody/tr[11]/td[1]", "Retype Password Text not present");
			
		logger.log(Status.PASS, MarkupHelper.createLabel("Retype Password Text is present",ExtentColor.GREEN));
		
		//Type on Retype Password Field
		ca.TypeRetypePasswrd(h.get("rpwd"));
		
		logger.log(Status.INFO, MarkupHelper.createLabel("Types on retype password field",ExtentColor.BLUE));
		
		
		u.StepWiseScreeshot("TypeRetypePasswrd");	
		
		//Assert for checkbox by the attribute value "class"
		u.AssertAttributeValue("nomargin", "class", "xpath", "//input[starts-with(@name, 'chk_altemail')]", "Attribute value for CLASS is not matching");
		
		logger.log(Status.PASS, MarkupHelper.createLabel("Attribute value for CLASS is  matching",ExtentColor.GREEN));
		
		
		if(u.isCheckboxOrRadioButtonSelected("//input[starts-with(@name, 'chk_altemail')]") == false) {
			
			//Check the Checkbox for alternate Emil id if IF condition is false
			ca.ClickCheckBoxNoAlternateID();
			
			logger.log(Status.INFO, MarkupHelper.createLabel("Clicked on checkbox for no alterate email id",ExtentColor.BLUE));
			
			
			u.StepWiseScreeshot("ClickCheckBoxNoAlternateID");	
		}
		
		//Assert the text "Select a Security Question" is present
		u.AssertText("Select a Security Question", "xpath", "//*[@id=\"div_hintQS\"]/table/tbody/tr[2]/td[1]", "Select a Security Question Text not present");
		
		logger.log(Status.PASS, MarkupHelper.createLabel("Select a Security Question Text is present",ExtentColor.GREEN));
		
		
		//Use the Select class if a drop down is created by select tag
		ca.SelectQuestion(3);
		
		logger.log(Status.INFO, MarkupHelper.createLabel("Drop Down - What is favourite food selected",ExtentColor.BLUE));
		
		
		u.StepWiseScreeshot("SecurityQuestion");	
		
		//Assert the text "Enter an Answer" is present
		u.AssertText("Enter an Answer", "xpath", "//*[@id=\"div_hintQS\"]/table/tbody/tr[4]/td[1]", "Enter an Answer Text not present");
			
		logger.log(Status.PASS, MarkupHelper.createLabel("Enter an Answer Text is present",ExtentColor.GREEN));
		
		
		//Type on Enter an answer field
		ca.TypeEnterAnswerSecurityQuestion(h.get("ans"));
		
		logger.log(Status.INFO, MarkupHelper.createLabel("Typed on security question field",ExtentColor.BLUE));
		
		
		u.StepWiseScreeshot("EnterAnswerSecurity");	
		
		//Assert the text "Mother's Maiden Name" is present
		u.AssertText("Mother's Maiden Name", "xpath", "//*[@id=\"div_hintQS\"]/table/tbody/tr[6]/td[1]", "Mother's Maiden Name Text not present");
			
		logger.log(Status.PASS, MarkupHelper.createLabel("Mother's Maiden Name Text is present",ExtentColor.GREEN));
		
		
		//Type on Mother's Maiden Name field
		ca.TypeMotherName(h.get("mName"));
		
		logger.log(Status.INFO, MarkupHelper.createLabel("Typed on mother name field",ExtentColor.BLUE));
		
		
		u.StepWiseScreeshot("TypeMotherName");			
		
		
		//Assert the text "Mobile No." is present for drop down
		u.AssertText("Mobile No.", "xpath", "//*[@id=\"mob_txt\"]", "Mobile No. Text not present");
			
		logger.log(Status.PASS, MarkupHelper.createLabel("Mobile No. Text is present",ExtentColor.GREEN));
		
		
		Thread.sleep(3000l);
		//Choose Afghanistan from drop down' - not created by Select tag
		ca.ChooseAfghanOptionDropDown();
		
		logger.log(Status.INFO, MarkupHelper.createLabel("Choose the Afghan drop down option",ExtentColor.BLUE));
		
		
		u.StepWiseScreeshot("ChooseAfghanOptionDropDown");	
		
		
		//Type the mobile number in the field
		ca.TypeMobilNumber(h.get("pNum"));
		
		logger.log(Status.INFO, MarkupHelper.createLabel("Types on mobile number",ExtentColor.BLUE));
		
		
		u.StepWiseScreeshot("TypeMobilNumber");	
		
		//Select the day from drop down
		ca.SelectDay("06");
		
		logger.log(Status.INFO, MarkupHelper.createLabel("Select the 06 option for day drop down",ExtentColor.BLUE));
		
		
		u.StepWiseScreeshot("SelectDay");	
		
		//Select the month from drop down
		ca.SelectMonth("03");
		
		logger.log(Status.INFO, MarkupHelper.createLabel("Select the 03 option for month drop down",ExtentColor.BLUE));
		
		
		u.StepWiseScreeshot("SelectMonth");	
		
		//Select the year from drop down
		ca.SelectYear("2020");
		
		logger.log(Status.INFO, MarkupHelper.createLabel("Select the 2020 option for year drop down",ExtentColor.BLUE));
		
		
		u.StepWiseScreeshot("SelectYear");	
		
		//Assert for radio button by the attribute value "value"
		//u.AssertAttributeValue("f", "value", "xpath", "//input[@value = 'f']", "Attribute value for VALUE is not matching");
		u.AssertAttributeValue("f", "value", "xpath", "//input[@value = 'f']", "Attribute value \"f\" for VALUE is not matching");		
		
		logger.log(Status.PASS, MarkupHelper.createLabel("Attribute value \"f\" for VALUE is matching",ExtentColor.GREEN));
		
		
		
		if(u.isCheckboxOrRadioButtonSelected("//input[@value = 'f']") == false) {
			
			//Select the FEMALE radio button
			ca.ClickFemaleRadioButton();
			
			logger.log(Status.INFO, MarkupHelper.createLabel("Clicked on female radio button",ExtentColor.GREEN));
			
			
			u.StepWiseScreeshot("ClickFemaleRadioButton");	
		}
		
		
	}
	
	
	
}

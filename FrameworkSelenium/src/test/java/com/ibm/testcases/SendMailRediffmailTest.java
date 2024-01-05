package com.ibm.testcases;

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
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.ibm.base.Base;
import com.ibm.config.DataTestCase;
import com.ibm.pages.InboxPage;
import com.ibm.pages.LandingPage;
import com.ibm.utils.ExtentManager;
import com.ibm.utils.Utilities;



public class SendMailRediffmailTest extends Base{
	
	public WebDriver driver;
	public WebDriverWait wait;
	public WebElement w1;
	public List<WebElement> l1;
	public Utilities u;
	public Actions act;
	public Select s;
	public LandingPage l;
	public InboxPage i;
	
	//Create an object of ExtentSparksReporter class
	ExtentSparkReporter report = ExtentManager.getInstanceExtentSparkReporter();
	//Create an object of ExtentReports class
	ExtentReports extent = ExtentManager.getInstanceExtentReports();
	//This class acts like a log report creator
	ExtentTest logger;

	
	@BeforeMethod
	public void SetUp() throws MalformedURLException {
		driver = CreateAccountRediffmailTest.OpenBrowser("Firefox", "https://mail.rediff.com/cgi-bin/login.cgi");
	
		//Create object of Utilities class
		u = new Utilities(driver);
		
		l = new LandingPage(driver);
		
		i = new InboxPage(driver);
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
			logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + "-- Send mail - Rediffmail Test case Failed", ExtentColor.RED));
			//Add the exception name on assertion failure to the log
			logger.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + "--  Send Mail - Rediffmail Test case Failed", ExtentColor.RED));
		
		}
		
		//Flush out the report
		extent.flush();
						
				
		//Close the browser
		u.CloseBrowser();
	}
	

	@Test(dataProvider = "SendMail", dataProviderClass = DataTestCase.class)
	public void SendMailRediffmail(Hashtable<String, String> h) {
		
		//Create the Test Case
		logger = extent.createTest("Send Mail - Rediffmail");
				
		//Create the category for testing - using the assign category method of ExtentTest class
		logger.assignCategory("Functional Test Category");
				
		
		u.StepWiseScreeshot("OpenSendMailWebsite");
		
		logger.log(Status.INFO, MarkupHelper.createLabel("Opening of App - Send Mail",ExtentColor.BLUE));
		
	
        //Implicit
        u.ImpicitDynamicWait(20);
		
		//u.ExplicitTExtPresent(20, "cssSelector", "p.form-label", "Username");
		u.AssertText("Username", "cssSelector", "p.form-label", "Username text is not present");
		
		logger.log(Status.PASS, MarkupHelper.createLabel("Username text is present",ExtentColor.GREEN));
		
		
        //Type on Username
        l.TypeUsername(h.get("username"));
        
        logger.log(Status.INFO, MarkupHelper.createLabel("Typed Username",ExtentColor.BLUE));
		
        
        u.StepWiseScreeshot("TypeUsername");
        
        
        
        
        //Validate that the text "password" is present for password edit box
      	u.ExplicitTExtPresent(20, "cssSelector", "div[class = 'table'] div:nth-child(2) div:nth-child(1) p:nth-child(1)", "Password");	
      	u.AssertText("Password", "cssSelector", "div[class = 'table'] div:nth-child(2) div:nth-child(1) p:nth-child(1)", "Password text not present");
      	
      	logger.log(Status.PASS, MarkupHelper.createLabel("Password text is present",ExtentColor.GREEN));
		
      	
        //Type on Passwords
      	l.TypePassword(h.get("Pwd"));
      	
      	u.StepWiseScreeshot("TypePassword");
      	
      	logger.log(Status.INFO, MarkupHelper.createLabel("Typed Password",ExtentColor.BLUE));
		
      	
      	//Validate for a attribute value in Sign In button - customised with compound class for CssSelector 
      	u.ExplicitAttributeToBe(20, "cssSelector", "div[class='floatL leftwidth']>div:nth-child(2)>div:nth-child(2)>div:nth-child(2)>div:nth-child(1)>input:nth-child(3)", "name", "proceed");
      	u.AssertAttributeValue("proceed", "name", "cssSelector", "div[class='floatL leftwidth']>div:nth-child(2)>div:nth-child(2)>div:nth-child(2)>div:nth-child(1)>input:nth-child(3)", "Name attribute value process not present");
      	
      	logger.log(Status.PASS, MarkupHelper.createLabel("Name attribute value process is present",ExtentColor.GREEN));
		
      	
      	//Click on sign button Customised CsSelector 
      	l.ClickSigninButton();
      	
      	u.StepWiseScreeshot("ClickSigninButton");
      	
      	logger.log(Status.INFO, MarkupHelper.createLabel("Clicked in Sign-in Button",ExtentColor.BLUE));
		
      	
      	//Validate that "write mail" text is present
      	u.ExplicitTExtPresent(20, "cssSelector", "#boxscroll>li.rd_write>a>b", "Write mail");
      	u.AssertText("Write mail", "cssSelector", "#boxscroll>li.rd_write>a>b", "Write mail text not present.");
      	
      	logger.log(Status.PASS, MarkupHelper.createLabel("Write mail text is present",ExtentColor.GREEN));
		
      	
      	//Click on Write Mail link
      	i.ClickWriteMailLink();
      	
      	u.StepWiseScreeshot("ClickWriteMailLink");
      	
      	logger.log(Status.INFO, MarkupHelper.createLabel("Clicked in Write Mail link",ExtentColor.BLUE));
		
      	
    	//Validate that "To:" text is present
      	u.ExplicitTExtPresent(20, "cssSelector", "label[class = 'lbl-link rd_lbl_addr_to']", "To:");
      	u.AssertText("To:", "cssSelector", "label[class = 'lbl-link rd_lbl_addr_to']", "To text not present ");
      	
      	logger.log(Status.PASS, MarkupHelper.createLabel("To text is present",ExtentColor.GREEN));
		
      	
      	//Type on To field - USed Regular expression of CssSelector to handle dynamic attribute value
      	i.TypeToEmailField(h.get("To"));
      	
      	u.StepWiseScreeshot("TypeToEmailField");
      	
      	logger.log(Status.INFO, MarkupHelper.createLabel("Typed in To field",ExtentColor.BLUE));
		
        
      	//Validate that "Subject:" text is present
      	u.ExplicitTExtPresent(20, "cssSelector", "label[class = 'lbl']", "Subject:");
      	u.AssertText("Subject:", "cssSelector", "label[class = 'lbl']", "Subject text not present");
      	
      	logger.log(Status.PASS, MarkupHelper.createLabel("Subject text is present",ExtentColor.GREEN));
		
      	
        //Type on Subject field
      	i.TypeToSubjectField(h.get("Subject"));
      	
      	u.StepWiseScreeshot("TypeToSubjectField");
      	
      	logger.log(Status.INFO, MarkupHelper.createLabel("Typed in Subject field",ExtentColor.BLUE));
		
      	
      	//To write in Compose area , we need to switch to frame as compose area is inside framed
      	//Switch to the frame by address
      	u.SwitchFrameAddress("cssSelector", "iframe[class = 'cke_wysiwyg_frame cke_reset']");
      	
      	logger.log(Status.INFO, MarkupHelper.createLabel("Switched to frame ",ExtentColor.BLUE));
		
        
      	//Type on compose area after switching to frame
      	i.TypeComposeArea(h.get("Compose"));

      	u.StepWiseScreeshot("TypeComposeArea");
      	
      	logger.log(Status.INFO, MarkupHelper.createLabel("Typed in Compose Area ",ExtentColor.BLUE));
		
      	
      	
      	//Get the focus back to main page from frame
      	u.FocusMainPageFromFrame();
      	
      	logger.log(Status.INFO, MarkupHelper.createLabel("Switched to main page from frame ",ExtentColor.BLUE));
		
      	
        //Validate that "Send" text is present
      	u.ExplicitTExtPresent(20, "linkText", "Send", "Send");
      	u.AssertText("Send", "linkText", "Send", "Send text is not present");
      	
      	logger.log(Status.PASS, MarkupHelper.createLabel("Send text is present",ExtentColor.GREEN));
		
      	
      	//Click on Send link
      	i.ClickSendLink(); 
      	
      	u.StepWiseScreeshot("ClickSendLink");
      	
      	logger.log(Status.INFO, MarkupHelper.createLabel("Clicked on Send Link",ExtentColor.BLUE));
		
      	
        //Validate that "Logout" text is present
      	u.ExplicitTExtPresent(20, "linkText", "Logout", "Logout");
      	u.AssertText("Hi", "linkText", "Logout", "Logout text is not present");
      	
      	logger.log(Status.PASS, MarkupHelper.createLabel("Logout text is present",ExtentColor.GREEN));
		
      	
      	//Click on Logout link
      	i.ClickLogoutLink();
      	
      	u.StepWiseScreeshot("ClickLogoutLink");
      	
      	logger.log(Status.INFO, MarkupHelper.createLabel("Clicked on Logout Link",ExtentColor.BLUE));
		
      	
      	
      	
	}

}

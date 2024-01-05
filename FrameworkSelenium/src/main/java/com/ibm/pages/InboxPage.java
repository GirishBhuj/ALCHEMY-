package com.ibm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InboxPage {
	
	public WebDriver driver;
	public Actions act;
	
	public InboxPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Address of  Write Mail Link
	@FindBy(css= "#boxscroll>li.rd_write>a>b" )
	public WebElement WriteMailAdd;
		
	//Address of To field
	@FindBy(css= "input[id^= 'TO_IDcmp']" )
	public WebElement To;

	//Address of Subject field
	@FindBy(css= "input[class*='rd_inp_sub rd_subject_datacmp']" )
	public WebElement Subject;
		
	//Address of Compose Area
	@FindBy(css= "body" )
	public WebElement Composearea;
	
	//Address of Send Link
	@FindBy(linkText= "Send" )
	public WebElement SendLink;
	
	//Address of Logout Link
	@FindBy(partialLinkText= "out" )
	public WebElement LogoutLink;
		
	//Define all actions on all the elements
	//Click on the Write mail link
	public void ClickWriteMailLink() {
		WriteMailAdd.click();
	}
	
	//Type on To field
	public void TypeToEmailField(String txt) {
		To.clear();
      	To.sendKeys(txt);
      	To.sendKeys(Keys.RETURN);
	}
	
	//Type on Subject field
	public void TypeToSubjectField(String txt) {
		Subject.clear();
		Subject.sendKeys(txt);	To.sendKeys(Keys.RETURN);
	}
	
	//Type on Subject field
	public void TypeComposeArea(String txt) {
		Composearea.clear();
		Composearea.sendKeys(txt);	
	}
	
	//Click on Send Link
	public void ClickSendLink() {
		SendLink.click();
			
	}
	
	//Click on Logout Link
	public void ClickLogoutLink() {
		LogoutLink.click();
				
	}

}

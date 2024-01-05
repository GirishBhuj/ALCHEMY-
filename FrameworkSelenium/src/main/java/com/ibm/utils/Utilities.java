package com.ibm.utils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;




public class Utilities {
	
	public WebDriver driver;
	public WebDriverWait wait;
	public Date d;
	public TakesScreenshot t;
	public File f1;
	public File f2;
	public WebElement w1;
	public Actions act;
	
	
	public Utilities(WebDriver driver) {
		this.driver = driver;
	}
	
	public void AssertText(String expectedText, String locatorType, String locatorVal, String msg) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		
		if(locatorType.equals("id")) {
			String actualText = driver.findElement(By.id(locatorVal)).getText();
			wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id(locatorVal), actualText));
			Assert.assertEquals(actualText, expectedText, msg);
		}else if (locatorType.equals("name")) {
			String actualText = driver.findElement(By.name(locatorVal)).getText();
			wait.until(ExpectedConditions.textToBePresentInElementLocated(By.name(locatorVal), actualText));
			
			Assert.assertEquals(actualText, expectedText, msg);
		
		}else if (locatorType.equals("className")) {
			String actualText = driver.findElement(By.className(locatorVal)).getText();
			wait.until(ExpectedConditions.textToBePresentInElementLocated(By.className(locatorVal), actualText));
			
			Assert.assertEquals(actualText, expectedText, msg);
		
		}else if (locatorType.equals("tagName")) {
			String actualText = driver.findElement(By.tagName(locatorVal)).getText();
			wait.until(ExpectedConditions.textToBePresentInElementLocated(By.tagName(locatorVal), actualText));
			
			Assert.assertEquals(actualText, expectedText, msg);
		
		}else if (locatorType.equals("linkText")) {
			String actualText = driver.findElement(By.linkText(locatorVal)).getText();
			wait.until(ExpectedConditions.textToBePresentInElementLocated(By.linkText(locatorVal), actualText));
			
			Assert.assertEquals(actualText, expectedText, msg);
		
		}else if (locatorType.equals("partialLinkText")) {
			String actualText = driver.findElement(By.partialLinkText(locatorVal)).getText();
			wait.until(ExpectedConditions.textToBePresentInElementLocated(By.partialLinkText(locatorVal), actualText));
			
			Assert.assertEquals(actualText, expectedText, msg);
		
		}else if (locatorType.equals("xpath")) {
			String actualText = driver.findElement(By.xpath(locatorVal)).getText();
			wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(locatorVal), actualText));
			
			Assert.assertEquals(actualText, expectedText, msg);
		
		}else if (locatorType.equals("cssSelector")) {
			String actualText = driver.findElement(By.cssSelector(locatorVal)).getText();
			wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector(locatorVal), actualText));
			
			Assert.assertEquals(actualText, expectedText, msg);
		
		}
	}
	
	public void AssertAttributeValue(String expectedAttributeVal, String attributeType, String locatorType, String locatorVal, String msg) {
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		if(locatorType.equals("id") && attributeType .equals("value")) {
			String actualAttributeVal = driver.findElement(By.id(locatorVal)).getAttribute("value");
			wait.until(ExpectedConditions.attributeToBe(By.id(locatorVal), "value", actualAttributeVal));
			Assert.assertEquals(actualAttributeVal, expectedAttributeVal, msg);
		}else if(locatorType.equals("id") && attributeType .equals("id")){
			String actualAttributeVal = driver.findElement(By.id(locatorVal)).getAttribute("id");
			wait.until(ExpectedConditions.attributeToBe(By.id(locatorVal), "id", actualAttributeVal));
			
			Assert.assertEquals(actualAttributeVal, expectedAttributeVal, msg);
		
		}else if(locatorType.equals("id") && attributeType .equals("name")) {
			String actualAttributeVal = driver.findElement(By.id(locatorVal)).getAttribute("name");
			wait.until(ExpectedConditions.attributeToBe(By.id(locatorVal), "name", actualAttributeVal));
			
			Assert.assertEquals(actualAttributeVal, expectedAttributeVal, msg);
		
		}else if(locatorType.equals("id") && attributeType .equals("class")) {
			String actualAttributeVal = driver.findElement(By.id(locatorVal)).getAttribute("class");
			wait.until(ExpectedConditions.attributeToBe(By.id(locatorVal), "class", actualAttributeVal));
			
			Assert.assertEquals(actualAttributeVal, expectedAttributeVal, msg);
		
		}else if(locatorType.equals("className") && attributeType .equals("value")) {
			String actualAttributeVal = driver.findElement(By.className(locatorVal)).getAttribute("value");
			wait.until(ExpectedConditions.attributeToBe(By.className(locatorVal), "value", actualAttributeVal));
			
			Assert.assertEquals(actualAttributeVal, expectedAttributeVal, msg);
		}else if(locatorType.equals("className") && attributeType .equals("id")){
			String actualAttributeVal = driver.findElement(By.id(locatorVal)).getAttribute("id");
			wait.until(ExpectedConditions.attributeToBe(By.className(locatorVal), "id", actualAttributeVal));
			
			Assert.assertEquals(actualAttributeVal, expectedAttributeVal, msg);
		
		}else if(locatorType.equals("className") && attributeType .equals("name")) {
			String actualAttributeVal = driver.findElement(By.className(locatorVal)).getAttribute("name");
			wait.until(ExpectedConditions.attributeToBe(By.className(locatorVal), "name", actualAttributeVal));
			
			Assert.assertEquals(actualAttributeVal, expectedAttributeVal, msg);
		
		}else if(locatorType.equals("className") && attributeType .equals("class")) {
			String actualAttributeVal = driver.findElement(By.className(locatorVal)).getAttribute("class");
			wait.until(ExpectedConditions.attributeToBe(By.className(locatorVal), "class", actualAttributeVal));
			
			Assert.assertEquals(actualAttributeVal, expectedAttributeVal, msg);
		
		}else if(locatorType.equals("name") && attributeType .equals("value")) {
			String actualAttributeVal = driver.findElement(By.name(locatorVal)).getAttribute("value");
			wait.until(ExpectedConditions.attributeToBe(By.name(locatorVal), "value", actualAttributeVal));
			
			Assert.assertEquals(actualAttributeVal, expectedAttributeVal, msg);
		}else if(locatorType.equals("name") && attributeType .equals("id")){
			String actualAttributeVal = driver.findElement(By.name(locatorVal)).getAttribute("id");
			wait.until(ExpectedConditions.attributeToBe(By.name(locatorVal), "id", actualAttributeVal));
			
			Assert.assertEquals(actualAttributeVal, expectedAttributeVal, msg);
		
		}else if(locatorType.equals("name") && attributeType .equals("name")) {
			String actualAttributeVal = driver.findElement(By.name(locatorVal)).getAttribute("name");
			wait.until(ExpectedConditions.attributeToBe(By.name(locatorVal), "name", actualAttributeVal));
			
			Assert.assertEquals(actualAttributeVal, expectedAttributeVal, msg);
		
		}else if(locatorType.equals("name") && attributeType .equals("class")) {
			String actualAttributeVal = driver.findElement(By.name(locatorVal)).getAttribute("class");
			wait.until(ExpectedConditions.attributeToBe(By.name(locatorVal), "class", actualAttributeVal));
			
			Assert.assertEquals(actualAttributeVal, expectedAttributeVal, msg);
		
		}else if(locatorType.equals("tagName") && attributeType .equals("value")) {
			String actualAttributeVal = driver.findElement(By.tagName(locatorVal)).getAttribute("value");
			wait.until(ExpectedConditions.attributeToBe(By.tagName(locatorVal), "value", actualAttributeVal));
			
			Assert.assertEquals(actualAttributeVal, expectedAttributeVal, msg);
		}else if(locatorType.equals("tagName") && attributeType .equals("id")){
			String actualAttributeVal = driver.findElement(By.tagName(locatorVal)).getAttribute("id");
			
			wait.until(ExpectedConditions.attributeToBe(By.tagName(locatorVal), "id", actualAttributeVal));
			Assert.assertEquals(actualAttributeVal, expectedAttributeVal, msg);
		
		}else if(locatorType.equals("tagName") && attributeType .equals("name")) {
			String actualAttributeVal = driver.findElement(By.tagName(locatorVal)).getAttribute("name");
			wait.until(ExpectedConditions.attributeToBe(By.tagName(locatorVal), "name", actualAttributeVal));
			
			Assert.assertEquals(actualAttributeVal, expectedAttributeVal, msg);
		
		}else if(locatorType.equals("tagName") && attributeType .equals("class")) {
			String actualAttributeVal = driver.findElement(By.tagName(locatorVal)).getAttribute("class");
			wait.until(ExpectedConditions.attributeToBe(By.tagName(locatorVal), "class", actualAttributeVal));
			
			Assert.assertEquals(actualAttributeVal, expectedAttributeVal, msg);
		
		}else if(locatorType.equals("linkText") && attributeType .equals("value")) {
			String actualAttributeVal = driver.findElement(By.linkText(locatorVal)).getAttribute("value");
			wait.until(ExpectedConditions.attributeToBe(By.linkText(locatorVal), "value", actualAttributeVal));
			
			Assert.assertEquals(actualAttributeVal, expectedAttributeVal, msg);
		}else if(locatorType.equals("linkText") && attributeType .equals("id")){
			String actualAttributeVal = driver.findElement(By.linkText(locatorVal)).getAttribute("id");
			wait.until(ExpectedConditions.attributeToBe(By.linkText(locatorVal), "id", actualAttributeVal));
			
			Assert.assertEquals(actualAttributeVal, expectedAttributeVal, msg);
		
		}else if(locatorType.equals("linkText") && attributeType .equals("name")) {
			String actualAttributeVal = driver.findElement(By.linkText(locatorVal)).getAttribute("name");
			wait.until(ExpectedConditions.attributeToBe(By.linkText(locatorVal), "name", actualAttributeVal));
			
			Assert.assertEquals(actualAttributeVal, expectedAttributeVal, msg);
		
		}else if(locatorType.equals("linkText") && attributeType .equals("class")) {
			String actualAttributeVal = driver.findElement(By.linkText(locatorVal)).getAttribute("class");
			wait.until(ExpectedConditions.attributeToBe(By.linkText(locatorVal), "class", actualAttributeVal));
			
			Assert.assertEquals(actualAttributeVal, expectedAttributeVal, msg);
		
		}else if(locatorType.equals("partialLinkText") && attributeType .equals("value")) {
			String actualAttributeVal = driver.findElement(By.partialLinkText(locatorVal)).getAttribute("value");
			wait.until(ExpectedConditions.attributeToBe(By.partialLinkText(locatorVal), "value", actualAttributeVal));
			
			Assert.assertEquals(actualAttributeVal, expectedAttributeVal, msg);
		}else if(locatorType.equals("partialLinkText") && attributeType .equals("id")){
			String actualAttributeVal = driver.findElement(By.partialLinkText(locatorVal)).getAttribute("id");
			wait.until(ExpectedConditions.attributeToBe(By.partialLinkText(locatorVal), "id", actualAttributeVal));
			
			Assert.assertEquals(actualAttributeVal, expectedAttributeVal, msg);
		
		}else if(locatorType.equals("partialLinkText") && attributeType .equals("name")) {
			String actualAttributeVal = driver.findElement(By.partialLinkText(locatorVal)).getAttribute("name");
			wait.until(ExpectedConditions.attributeToBe(By.partialLinkText(locatorVal), "name", actualAttributeVal));
			
			Assert.assertEquals(actualAttributeVal, expectedAttributeVal, msg);
		
		}else if(locatorType.equals("partialLinkText") && attributeType .equals("class")) {
			String actualAttributeVal = driver.findElement(By.partialLinkText(locatorVal)).getAttribute("class");
			wait.until(ExpectedConditions.attributeToBe(By.partialLinkText(locatorVal), "class", actualAttributeVal));
			
			Assert.assertEquals(actualAttributeVal, expectedAttributeVal, msg);
		
		}else if(locatorType.equals("xpath") && attributeType .equals("value")) {
			String actualAttributeVal = driver.findElement(By.xpath(locatorVal)).getAttribute("value");
			wait.until(ExpectedConditions.attributeToBe(By.xpath(locatorVal), "value", actualAttributeVal));
			
			Assert.assertEquals(actualAttributeVal, expectedAttributeVal, msg);
		}else if(locatorType.equals("xpath") && attributeType .equals("id")){
			String actualAttributeVal = driver.findElement(By.xpath(locatorVal)).getAttribute("id");
			wait.until(ExpectedConditions.attributeToBe(By.xpath(locatorVal), "id", actualAttributeVal));
			
			Assert.assertEquals(actualAttributeVal, expectedAttributeVal, msg);
		
		}else if(locatorType.equals("xpath") && attributeType .equals("name")) {
			String actualAttributeVal = driver.findElement(By.xpath(locatorVal)).getAttribute("name");
			wait.until(ExpectedConditions.attributeToBe(By.xpath(locatorVal), "name", actualAttributeVal));
			
			Assert.assertEquals(actualAttributeVal, expectedAttributeVal, msg);
		
		}else if(locatorType.equals("xpath") && attributeType .equals("class")) {
			String actualAttributeVal = driver.findElement(By.xpath(locatorVal)).getAttribute("class");
			wait.until(ExpectedConditions.attributeToBe(By.xpath(locatorVal), "class", actualAttributeVal));
			
			Assert.assertEquals(actualAttributeVal, expectedAttributeVal, msg);
		
		}else if(locatorType.equals("cssSelector") && attributeType .equals("value")) {
			String actualAttributeVal = driver.findElement(By.cssSelector(locatorVal)).getAttribute("value");
			wait.until(ExpectedConditions.attributeToBe(By.cssSelector(locatorVal), "value", actualAttributeVal));
			
			Assert.assertEquals(actualAttributeVal, expectedAttributeVal, msg);
		}else if(locatorType.equals("cssSelector") && attributeType .equals("id")){
			String actualAttributeVal = driver.findElement(By.cssSelector(locatorVal)).getAttribute("id");
			wait.until(ExpectedConditions.attributeToBe(By.cssSelector(locatorVal), "id", actualAttributeVal));
			
			Assert.assertEquals(actualAttributeVal, expectedAttributeVal, msg);
		
		}else if(locatorType.equals("cssSelector") && attributeType .equals("name")) {
			String actualAttributeVal = driver.findElement(By.cssSelector(locatorVal)).getAttribute("name");
			wait.until(ExpectedConditions.attributeToBe(By.cssSelector(locatorVal), "name", actualAttributeVal));
			
			Assert.assertEquals(actualAttributeVal, expectedAttributeVal, msg);
		
		}else if(locatorType.equals("cssSelector") && attributeType .equals("class")) {
			String actualAttributeVal = driver.findElement(By.cssSelector(locatorVal)).getAttribute("class");
			wait.until(ExpectedConditions.attributeToBe(By.cssSelector(locatorVal), "class", actualAttributeVal));
			
			Assert.assertEquals(actualAttributeVal, expectedAttributeVal, msg);
		
		}
	}
	
	public void StepWiseScreeshot(String stepName) {
		try {
			d = new Date();
			String date = d.toString().replace(":", "_").replace(" ", "_");
			//Stepwise screenshot  - on opening the website
			t = (TakesScreenshot)driver;
			//f1 is the temp memory location where screenshot is taken
			f1 = t.getScreenshotAs(OutputType.FILE); //Can be PNG or JPEG for mat
			//Permanent location - f2 is where we will permanently keep the screenshot
			f2 = new File(System.getProperty("user.dir")+"\\StepwiseScreenshot\\"+stepName+"_"+date+".jpeg");
			//Copy the screenshot from temp location to permanent - Common IO Api's FileUtils class 
			FileUtils.copyFile(f1, f2);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	//Changes based on extent report usage
	public String FailScreeshot(String TestAnnotationName) {
		try {
			d = new Date();
			String date = d.toString().replace(":", "_").replace(" ", "_");
			//Stepwise screenshot  - on opening the website
			t = (TakesScreenshot)driver;
			//f1 is the temp memory location where screenshot is taken
			f1 = t.getScreenshotAs(OutputType.FILE); //Can be PNG or JPEG for mat
			
			String pathOfscreenshot = System.getProperty("user.dir")+"\\FailScreenshot\\"+TestAnnotationName+"_"+date+".jpeg";
			//Permanent location - f2 is where we will permanently keep the screenshot
			f2 = new File(pathOfscreenshot);
			//Copy the screenshot from temp location to permanent - Common IO Api's FileUtils class 
			FileUtils.copyFile(f1, f2);
			
			return pathOfscreenshot;
		} catch (IOException e) {
			String exceptionMsg = e.getMessage();
			return exceptionMsg;
		}
		
	}
	
	//Implicit wait
	public void ImpicitDynamicWait(long t) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(t));
		
	}
	
	//Explicit Wait based on Text present
	public void ExplicitTExtPresent(long t, String locatorType, String locatorValue, String text){
		wait  = new WebDriverWait(driver, Duration.ofSeconds(t));
		if(locatorType.equals("id")) {
			wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id(locatorValue), text));
		}else if(locatorType.equals("name")) {
			wait.until(ExpectedConditions.textToBePresentInElementLocated(By.name(locatorValue), text));	
		}else if(locatorType.equals("className")) {
			wait.until(ExpectedConditions.textToBePresentInElementLocated(By.className(locatorValue), text));
		}else if(locatorType.equals("tagName")) {
			wait.until(ExpectedConditions.textToBePresentInElementLocated(By.tagName(locatorValue), text));
		}else if(locatorType.equals("linkText")) {
			wait.until(ExpectedConditions.textToBePresentInElementLocated(By.linkText(locatorValue), text));
		}else if(locatorType.equals("partialLinkText")) {
			wait.until(ExpectedConditions.textToBePresentInElementLocated(By.partialLinkText(locatorValue), text));
		}else if(locatorType.equals("xpath")) {
			wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(locatorValue), text));
		}
		else if(locatorType.equals("cssSelector")) {
			wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector(locatorValue), text));
		}
		
	}
	
	//Explicit Wait based on Text present
	public void ExplicitAttributeToBe(long t, String locatorType, String locatorValue, String attributeType, String attributeVal){
		wait  = new WebDriverWait(driver, Duration.ofSeconds(t));
		if(locatorType.equals("id")) {
			wait.until(ExpectedConditions.attributeToBe(By.id(locatorValue), attributeType, attributeVal));
		}else if(locatorType.equals("name")) {
			wait.until(ExpectedConditions.attributeToBe(By.name(locatorValue), attributeType, attributeVal));
		}else if(locatorType.equals("className")) {
			wait.until(ExpectedConditions.attributeToBe(By.className(locatorValue), attributeType, attributeVal));			
		}else if(locatorType.equals("tagName")) {
			wait.until(ExpectedConditions.attributeToBe(By.tagName(locatorValue), attributeType, attributeVal));		
		}else if(locatorType.equals("linkText")) {
			wait.until(ExpectedConditions.attributeToBe(By.linkText(locatorValue), attributeType, attributeVal));
		}else if(locatorType.equals("partialLinkText")) {
			wait.until(ExpectedConditions.attributeToBe(By.partialLinkText(locatorValue), attributeType, attributeVal));
		}else if(locatorType.equals("xpath")) {
			wait.until(ExpectedConditions.attributeToBe(By.xpath(locatorValue), attributeType, attributeVal));
		}else if(locatorType.equals("cssSelector")) {
			wait.until(ExpectedConditions.attributeToBe(By.cssSelector(locatorValue), attributeType, attributeVal));
		}
			
	}
	
	//Explicit Wait based on page title
	public void ExplicitPageTitle(long t, String titleVal) {
			wait  = new WebDriverWait(driver, Duration.ofSeconds(t));
			wait.until(ExpectedConditions.titleIs(titleVal));
				
	}
	
	//Switch Frame By address
	public void SwitchFrameAddress(String locatorType, String locatorVal) {
		
      	if(locatorType.equals("id")) {
      		w1  = driver.findElement(By.id(locatorVal));
          	driver.switchTo().frame(w1);
        }else if(locatorType.equals("name")) {
        	w1  = driver.findElement(By.name(locatorVal));
          	driver.switchTo().frame(w1);
		}else if(locatorType.equals("className")) {
			w1  = driver.findElement(By.className(locatorVal));
	      	driver.switchTo().frame(w1);
		}else if(locatorType.equals("tagName")) {
			w1  = driver.findElement(By.tagName(locatorVal));
	      	driver.switchTo().frame(w1);
		}else if(locatorType.equals("linkText")) {
			w1  = driver.findElement(By.linkText(locatorVal));
	      	driver.switchTo().frame(w1);
		}else if(locatorType.equals("partialLinkText")) {
			w1  = driver.findElement(By.partialLinkText(locatorVal));
	      	driver.switchTo().frame(w1);
		}else if(locatorType.equals("xpath")) {
			w1  = driver.findElement(By.xpath(locatorVal));
	      	driver.switchTo().frame(w1);
		}else if(locatorType.equals("cssSelector")) {
			w1  = driver.findElement(By.cssSelector(locatorVal));
	      	driver.switchTo().frame(w1);
		}
	}
	
	//Move from frame to main page
	public void FocusMainPageFromFrame() {
		driver.switchTo().defaultContent();
	}
	
	//Close the browser
	public void CloseBrowser() {
		driver.quit();
	}
	
	public boolean isTextPresent(String xpathVal) {
		act = new Actions(driver);
		int x = driver.findElements(By.xpath(xpathVal)).size();
		if(x==1) {
			System.out.println("YIPPE text found");
			w1 = driver.findElement(By.xpath(xpathVal));
			act.moveToElement(w1).click();
			act.build().perform();
			return true;
		}else {
			System.out.println("YIPPE text not found");
			return false;
		}
	}
	
	//Check if Checkbox or radio button is selected
	public boolean isCheckboxOrRadioButtonSelected(String locatorVal) {
		boolean checkedVal = driver.findElement(By.xpath(locatorVal)).isSelected();
		return checkedVal;
	}
	
		

}

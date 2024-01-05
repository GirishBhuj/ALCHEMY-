package com.ibm.base;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Base {
	
	public static WebDriver driver;
	public static EdgeOptions optEdge;
	public static ChromeOptions optChrome;
	public static FirefoxOptions optFirefox;
	public static DesiredCapabilities cap;
	
	
	public static WebDriver OpenBrowser(String browserName, String Url ) throws MalformedURLException {
		
		if(browserName.equals("Chrome")) {
			
			//Grid code
			cap = new DesiredCapabilities();
			cap.setCapability(CapabilityType.BROWSER_NAME, "chrome");
			cap.setCapability(CapabilityType.PLATFORM_NAME, Platform.WIN11);
		
			cap.setCapability(CapabilityType.PAGE_LOAD_STRATEGY, PageLoadStrategy.NORMAL);
			
			//optChrome = new ChromeOptions();
			//optChrome.addArguments("--start-maximized"); //Maximising Windows
			//optChrome.addArguments("--disable-notifications"); //Disable notification
			
			//Set the Page Load Strategy
			//optChrome.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		
			//Open the Browser
			//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\chromedriver.exe");
			//driver = new ChromeDriver(optChrome);
			
			//Open the Browser - Grid Code
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\chromedriver.exe");
			driver = new RemoteWebDriver(new URL("http://192.168.0.157:4444"), cap);
			
			
			//Maximise the browser window - Grid Code
			driver.manage().window().maximize();
			
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			
			//Navigate To url
			driver.get(Url);
			
			return driver;
		}else if(browserName.equals("Edge")) {
			
			//Grid code
			cap = new DesiredCapabilities();
			cap.setCapability(CapabilityType.BROWSER_NAME, "edge");
			cap.setCapability(CapabilityType.PLATFORM_NAME, Platform.WIN11);
			cap.setCapability(CapabilityType.PAGE_LOAD_STRATEGY, PageLoadStrategy.NORMAL);
			
			System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+"\\msedgedriver.exe");
			
			//optEdge = new EdgeOptions();
			
			//Maximising Windows
			//optEdge.addArguments("--start-maximized");
			
			//Disable notification
			//optEdge.addArguments("--disable-notifications");
			
			//Set the Page Load Strategy
			//optEdge.setPageLoadStrategy(PageLoadStrategy.NORMAL);
			
			//optEdge.addArguments("ignore-certificate-errors");

		
			//Open the Browser
			//driver = new EdgeDriver(optEdge);
			
			//Open the Browser - Grid Code
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\chromedriver.exe");
			driver = new RemoteWebDriver(new URL("http://192.168.0.157:4444"), cap);
			
			
			//Maximise the browser window - Grid Code
			driver.manage().window().maximize();
			
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		
			//Navigate To url
			driver.get(Url);
			
			return driver;
		}else if (browserName.equals("Firefox")) {
			
			//Grid code
			cap = new DesiredCapabilities();
			cap.setCapability(CapabilityType.BROWSER_NAME, "firefox");
			cap.setCapability(CapabilityType.PLATFORM_NAME, Platform.WIN11);
			cap.setCapability(CapabilityType.PAGE_LOAD_STRATEGY, PageLoadStrategy.NORMAL);
			
			
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\geckodriver.exe");
			
			//optFirefox  = new FirefoxOptions();
			
			//Set the Page Load Strategy
			//optFirefox.setPageLoadStrategy(PageLoadStrategy.NORMAL);
			
			//Disable notifications
			//1.  Create the profile manually  - Go to about:profiles  2. Create Profile Button  3. Give name
			//ProfilesIni allProf = new ProfilesIni(); // all the profiles
			//FirefoxProfile prof = allProf.getProfile("Kaushik");
			//prof.setPreference("dom.webnotifications.enabled", false);
			
			
			//optFirefox.setProfile(prof);
			
			
			//Open the Browser
			//driver = new FirefoxDriver(optFirefox);
			
			//Open the Browser - Grid Code
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\chromedriver.exe");
			driver = new RemoteWebDriver(new URL("http://192.168.0.157:4444"), cap);
			
			
			//Maximise the browser window - Grid Code
			driver.manage().window().maximize();
			
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			
			
			//Navigate To url
			driver.get(Url);
			
			
			return driver;
			
		}
		return driver;
		
	}

}

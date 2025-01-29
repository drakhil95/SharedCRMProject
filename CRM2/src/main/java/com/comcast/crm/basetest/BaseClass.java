package com.comcast.crm.basetest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FIleUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.generic.webdriverutility.WebdriverUtility;
import com.comcast.crm.objectrepository.HomePage;
import com.comcast.crm.objectrepository.LoginPage;

public class BaseClass {
	
	public WebDriver driver;
	
	public FIleUtility fu = new FIleUtility();
	public WebdriverUtility wu = new WebdriverUtility();
	public ExcelUtility eu = new ExcelUtility();
	public JavaUtility ju = new JavaUtility();
	
	@BeforeSuite
	public void configBS() {
		System.out.println("****Connect to DB****, ****Report config****");	
		
	}
	
	@AfterSuite
	public void afterSuite() {
		System.out.println("****DB Disconnected****, ****Report file****");	
	}
	
	@Parameters("browser")
	@BeforeClass
	public void openBrowser(@Optional("chrome") String browser) throws IOException {
		System.out.println("BeforClass method is executing");
		switch (browser) {
			case "chrome": driver = new ChromeDriver(); break;
			case "edge": driver = new EdgeDriver(); break;
			case "firefox": driver = new FirefoxDriver(); break;
			default: driver = new ChromeDriver();
		}
		wu.waitForPageToLoad(driver);
		// sdriver = driver; // we need to pass the browser session into the TakeScreenshot  in listener so we use this 
		// static driver to pass the browser session into that. But it is no longer needed since we are using the utility class object to pass the same driver object
		UtilityClassObject.setDriver(driver); // sharing the static 
	}
	
	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}
	
	@BeforeMethod
	public void login() throws IOException {
		LoginPage lp = new LoginPage(driver);
		String un = fu.getDataFromPropertyFile("un");
		String pw = fu.getDataFromPropertyFile("pw");
		String url = fu.getDataFromPropertyFile("url");
		lp.login(url, un, pw);
		
	}
	
	@AfterMethod
	public void logout() {
		HomePage hp = new HomePage(driver);
		hp.logout();
	}

}

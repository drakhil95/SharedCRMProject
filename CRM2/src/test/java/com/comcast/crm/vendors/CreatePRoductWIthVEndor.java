package com.comcast.crm.vendors;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FIleUtility;
import com.comcast.crm.generic.webdriverutility.WebdriverUtility;

public class CreatePRoductWIthVEndor {

	public static void main(String[] args) throws IOException {
		FIleUtility fiu = new FIleUtility();
		ExcelUtility eu = new ExcelUtility();
		WebdriverUtility wu = new WebdriverUtility();

		//Get common date from the Common data
		// String BROWSER = fiu.getDataFromPropertyFile("browser");
		String URL = fiu.getDataFromPropertyFile("url");
		String UN = fiu.getDataFromPropertyFile("un");
		String PW = fiu.getDataFromPropertyFile("pw");

		String vendorName = eu.getDataFromExcel("Sheet1", 16, 2);
		String productName = eu.getDataFromExcel("Sheet1", 16, 3);

		WebDriver driver = new ChromeDriver();
		wu.waitForPageToLoad(driver);
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(UN);
		driver.findElement(By.name("user_password")).sendKeys(PW);
		driver.findElement(By.id("submitButton")).click();

		//navigate to organization module
		wu.mouseMoveOnElement(driver, driver.findElement(By.linkText("More")));
		driver.findElement(By.linkText("Vendors")).click();

		driver.findElement(By.xpath("//img[@title='Create Vendor...']")).click();
		driver.findElement(By.name("vendorname")).sendKeys(vendorName);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
//************************************Creating vendor********************************************************
		wu.waitForElementPresent(driver, driver.findElement(By.linkText("Products")));
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
		driver.findElement(By.name("productname")).sendKeys(productName);

		driver.findElement(By.xpath("//img[@title='Select']")).click();

		wu.switchTabOnUrl(driver, "module=Vendors&action");
		driver.findElement(By.id("search_txt")).sendKeys(vendorName + Keys.ENTER);
		driver.findElement(By.id("1")).click();
		wu.switchTabOnUrl(driver, "module=Products&action");
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		WebElement actVendor = driver.findElement(By.id("dtlview_Vendor Name"));

		if (actVendor.getText().equals(vendorName)) {
			System.out.println("Vendor verified");
		}

		driver.quit();


	}

}

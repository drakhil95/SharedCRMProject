package com.comcast.crm.leadtest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FIleUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebdriverUtility;

public class LeadWithPhone {
	public static void main(String[] args) throws Exception {
		FIleUtility fiu = new FIleUtility();
		JavaUtility ju = new JavaUtility();
		ExcelUtility eu = new ExcelUtility();
		WebdriverUtility wu = new WebdriverUtility();
		
		//Get common date from the Common data
		// String BROWSER = fiu.getDataFromPropertyFile("browser");
		String URL = fiu.getDataFromPropertyFile("url");
		String UN = fiu.getDataFromPropertyFile("un");
		String PW = fiu.getDataFromPropertyFile("pw");
		
		
	
		String lastName = eu.getDataFromExcel("Sheet1", 10, 2);
		String orgName = eu.getDataFromExcel("Sheet1", 1, 2) + ju.getRandomNumber();
		String phone = eu.getDataFromExcel("Sheet1", 7, 3);
		
		WebDriver driver = new ChromeDriver();
		wu.waitForPageToLoad(driver);
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(UN);
		driver.findElement(By.name("user_password")).sendKeys(PW);
		driver.findElement(By.id("submitButton")).click();

		//navigate to organization module
		driver.findElement(By.linkText("Leads")).click();
		
		driver.findElement(By.xpath("//img[@title='Create Lead...']")).click();
		driver.findElement(By.name("lastname")).sendKeys(lastName);
		driver.findElement(By.name("company")).sendKeys(orgName);
		driver.findElement(By.id("phone")).sendKeys(phone);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		
		WebElement actPhone = driver.findElement(By.id("dtlview_Phone"));
		
		if (actPhone.getText().equals(phone)) {
			System.out.println("Phone number verified");
		}
		
		driver.quit();

	}
}

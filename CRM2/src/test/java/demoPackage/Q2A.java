package demoPackage;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.comcast.crm.generic.fileutility.FIleUtility;
import com.comcast.crm.generic.webdriverutility.WebdriverUtility;

public class Q2A {
	
	@Test(dataProviderClass = Q2.class, dataProvider = "orgNameAndPhone")
	public void execute(String orgName, int phoneNo) throws Exception {
		FIleUtility fiu = new FIleUtility();
		WebdriverUtility wu = new WebdriverUtility();
		
		//Get common date from the Common data
		// String BROWSER = fiu.getDataFromPropertyFile("browser");
		String URL = fiu.getDataFromPropertyFile("url");
		String UN = fiu.getDataFromPropertyFile("un");
		String PW = fiu.getDataFromPropertyFile("pw");

		String orgName1 = orgName;
		String phone = phoneNo + "";
		
		//Open the browser and go to the URL and login
		WebDriver driver = new ChromeDriver();
		wu.waitForPageToLoad(driver);  // implicit wait and maximizing the window
		driver.get(URL);

		driver.findElement(By.name("user_name")).sendKeys(UN);
		driver.findElement(By.name("user_password")).sendKeys(PW);
		driver.findElement(By.id("submitButton")).click();

		//navigate to organization module
		driver.findElement(By.linkText("Organizations")).click();

		//Click on create organization button
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();

		try {
			//Enter all details and create a new Organization
			driver.findElement(By.name("accountname")).sendKeys(orgName1);
			driver.findElement(By.id("phone")).sendKeys(phone);
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

			
			//Verify the industry and type
			WebElement actPhone = driver.findElement(By.id("dtlview_Phone"));
			if (actPhone.getText().equals(phone)) // Verifying Industry
				System.out.println(phone + " verified. ===> Passed");
			else 
				System.out.println(phone + " not verified. ===> Failed");
			
		} catch (Exception e) {
			System.out.println("Organisation name already present in the database");
		}
		driver.quit();
	}
	
}

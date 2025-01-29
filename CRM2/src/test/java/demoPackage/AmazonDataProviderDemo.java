package demoPackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.comcast.crm.generic.fileutility.ExcelUtility;

public class AmazonDataProviderDemo {
	
	@Test(dataProvider = "getData")
	public void amazonTest(String key, String product) {
		WebDriver driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("http://amazon.in");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(key+ Keys.ENTER);
		
		System.out.println(key);
		System.out.println(product);
		String x = "//span[text()='"+product+"']/../../../..//span[@class='a-price-whole']";
		
		String price = driver.findElement(By.xpath(x)).getText();
		System.out.println(price);
		
		driver.quit();
	}
	
	@DataProvider
	public Object[][] getData() throws Exception {
		ExcelUtility eu = new ExcelUtility();
		int rowCount = eu.getRowCount("data");
		Object[][] objAr = new Object[rowCount][2];
		
		for (int i = 0; i < rowCount; i++) {
			objAr[i][0] = eu.getDataFromExcel("data", i+1, 0);
			objAr[i][1] = eu.getDataFromExcel("data", i+1, 1);
		}		
		return objAr;
	}
}

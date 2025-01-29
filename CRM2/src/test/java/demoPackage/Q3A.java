package demoPackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class Q3A{
	
	@Test(dataProviderClass = Q3.class, dataProvider = "getProductData")
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
}
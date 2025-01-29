package com.comcast.crm.mocks;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.comcast.crm.generic.fileutility.FIleUtility;
import com.comcast.crm.generic.webdriverutility.WebdriverUtility;


public class HotstarMock {
	
	@Test
	public void hotStarMock() throws IOException {
		WebdriverUtility wu = new WebdriverUtility();
		FIleUtility fu = new FIleUtility();
		
		String url = fu.getDataFromPropertyFile("urlHotstar");
		
		WebDriver driver = new ChromeDriver();
		wu.waitForPageToLoad(driver);
		driver.get(url);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		
		List<WebElement> allImg = driver.findElements(By.tagName("img"));
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		
		
		
		System.out.println("************These are the links********************");
		for (WebElement link : allLinks) {
			System.out.println(link.getText());
		}
		System.out.println("************These are the links********************");
		
		
		
		System.out.println("************These are the images********************");
		for (WebElement img : allImg) {
			System.out.println(img.getDomProperty("src"));
		}
		System.out.println("************These are the images********************");
		
		
		
		
		driver.findElement(By.xpath("//h2[text()='Latest Releases']/../../../../../..//div[@data-swiper-slide-index='0']")).click();
		wait.until(ExpectedConditions.urlContains("sweet-dreams"));
		
//		driver.findElement(By.xpath("//a[@aria-label='Search']")).click();
//		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("searchBar"))));
//		driver.findElement(By.id("searchBar")).sendKeys("deadpool");
//		
//		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//img[@alt='Deadpool & Wolverine']"))));
//		
//		driver.findElement(By.xpath("//img[@alt='Deadpool & Wolverine']")).click();
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("shimmerContainer"))));
		
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshots/dpScreenshot.png");
		FileUtils.copyFile(src, dest);

		driver.quit();
	}	
}

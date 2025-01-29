package com.comcast.crm.generic.webdriverutility;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebdriverUtility {
	int implicitWaitDuration = 150;
	int explicitWaitDuration = 20;
	
	
	/*Method to introduce implicit wait*/
	public void waitForPageToLoad(WebDriver driver) {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWaitDuration));
	}
	
	// Method to introduce explicit wait
	public void waitForElementPresent(WebDriver driver, WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(explicitWaitDuration));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
	/*
	 * Switching to other tab using partial URL
	 */
	public void switchTabOnUrl(WebDriver driver, String partialURL) {
		Set<String> allWid = driver.getWindowHandles();
		
		for (String wID : allWid) {
			driver.switchTo().window(wID);
			
			if (driver.getCurrentUrl().contains(partialURL))  // checking if the user is on the required tab
				break;
		}
	}
	
	/*
	 * Switching to the other tab using title
	 */
	public void switchTabOnTitle(WebDriver driver, String partialTitle) {
		Set<String> allWid = driver.getWindowHandles();
		
		for (String wID : allWid) {
			driver.switchTo().window(wID);
			
			if (driver.getTitle().contains(partialTitle))  // checking if the user is on the required tab
				break;
		}
	}
	
	
	
	public void switchToFrame(WebDriver driver, int index) { // Switching the frames using index, name or webElemenet
		driver.switchTo().frame(index);
	}
	
	public void switchToFrame(WebDriver driver, String nameID) {  // These three methods are overloaded
		driver.switchTo().frame(nameID);
	}
	
	public void switchToFrame(WebDriver driver, WebElement ele) {
		driver.switchTo().frame(ele);
	}
	
	
	
	
	public void switchAndAcceptAlert(WebDriver driver) { // For accepting and rejecting the alerts
		driver.switchTo().alert().accept();
	}
	
	public void switchAndRejectAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	
	
	
	
	public void selectDropdown(WebElement ele, int index) {  // select class using the index
		Select s = new Select(ele);
		s.selectByIndex(index);
	}
	
	public void selectDropdown(WebElement ele, String text) { // select class using the visible text
		Select s = new Select(ele);
		s.selectByVisibleText(text);
	}
	
	
	
	
	public void mouseMoveOnElement(WebDriver driver, WebElement ele) {  // mouse hover over the element
		Actions act = new Actions(driver);
		act.moveToElement(ele).perform();
	}
	
	public void doubleClick(WebDriver driver, WebElement ele) { // double clicking the element
		Actions act = new Actions(driver);
		act.doubleClick().perform();
	}
}

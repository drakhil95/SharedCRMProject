package com.comcast.crm.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VendorsInformationPage {
	WebDriver driver;
	
	@FindBy(className = "lvtHeaderText")
	private WebElement header;
	
	@FindBy(id = "dtlview_Vendor Name")
	private WebElement actVendorName;
	
	@FindBy(id = "dtlview_Phone")
	private WebElement actPhoneNo;
	
	public VendorsInformationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getHeader() {
		return header;
	}

	public WebElement getActVendorName() {
		return actVendorName;
	}

	public WebElement getActPhoneNo() {
		return actPhoneNo;
	}
	
	
}

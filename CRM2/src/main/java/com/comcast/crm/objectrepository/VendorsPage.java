package com.comcast.crm.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VendorsPage {
	
	WebDriver driver;
	
	@FindBy(xpath = "//img[@title='Create Vendor...']")
	private WebElement createVendorBtn;

	public VendorsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);;
	}

	public WebElement getCreateVendorBtn() {
		return createVendorBtn;
	}
}

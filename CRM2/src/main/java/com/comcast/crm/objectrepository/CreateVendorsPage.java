package com.comcast.crm.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateVendorsPage {
	WebDriver driver;
	
	@FindBy(name = "vendorname")
	private WebElement vendorNameTbx;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	public CreateVendorsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getVendorNameTbx() {
		return vendorNameTbx;
	}	
	
	public WebElement getSaveBtn() {
		return saveBtn;
	}
}

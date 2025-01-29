package com.comcast.crm.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateProductsPage {
	WebDriver driver;
	
	@FindBy(name = "productname")
	private WebElement productNameTbx;
	
	@FindBy(xpath = "//img[@title='Select']")
	private WebElement addVendorBtn;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
}

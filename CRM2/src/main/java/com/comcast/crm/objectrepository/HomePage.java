package com.comcast.crm.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebdriverUtility;

public class HomePage {
	
	WebDriver driver;
	
	@FindBy(linkText = "Organizations")
	private WebElement organizationsLink;
	
	@FindBy(linkText = "Leads")
	private WebElement leadsLink;
	
	@FindBy(linkText = "Contacts")
	private WebElement contactsLink;
	
	@FindBy(linkText = "Products")
	private WebElement productsLink;
	
	@FindBy(linkText = "More")
	private WebElement moreLink;
	
	@FindBy(linkText = "Vendors")
	private WebElement vendorsLink;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signOutBtn;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement userImage;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void navigateToVendor() { // Since vendors only appear after we hover the mouse over the more icon
		WebdriverUtility wu = new WebdriverUtility();
		wu.mouseMoveOnElement(driver, moreLink);
		vendorsLink.click();
	}
	
	public void logout() {
		WebdriverUtility wu = new WebdriverUtility();
		wu.mouseMoveOnElement(driver, userImage);
		signOutBtn.click();
	}

	public WebElement getOrganizationsLink() {
		return organizationsLink;
	}

	public WebElement getLeadsLink() {
		return leadsLink;
	}

	public WebElement getContactsLink() {
		return contactsLink;
	}

	public WebElement getProductsLink() {
		return productsLink;
	}

	public WebElement getMoreLink() {
		return moreLink;
	}

	public WebElement getVendorsLink() {
		return vendorsLink;
	}
	
	
}

package com.comcast.crm.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebdriverUtility;

public class CreateNewOrganizationPage {
	WebDriver driver;
	
	@FindBy(name = "accountname")
	private WebElement organizationNameTbx;
	
	@FindBy(id = "phone")
	private WebElement phoneTbx;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(name = "industry")
	private WebElement industryDropdown;
	
	@FindBy(name="accounttype")
	private WebElement typeDropdown;
	
	
	
	public CreateNewOrganizationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	public void industryDropdown(int index) {
		WebdriverUtility wu = new WebdriverUtility();
		wu.selectDropdown(industryDropdown, index);
	}
	
	public void typeDropdown(int index) {
		WebdriverUtility wu = new WebdriverUtility();
		wu.selectDropdown(typeDropdown, index);
	}
	
	public void industryDropdown(String industry) {
		WebdriverUtility wu = new WebdriverUtility();
		wu.selectDropdown(industryDropdown, industry);;
	}
	
	public void typeDropdown(String accountType) {
		WebdriverUtility wu = new WebdriverUtility();
		wu.selectDropdown(typeDropdown, accountType);;
	}
	
	public WebElement getOrganizationNameTbx() {
		return organizationNameTbx;
	}

	public WebElement getPhoneTbx() {
		return phoneTbx;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	
}

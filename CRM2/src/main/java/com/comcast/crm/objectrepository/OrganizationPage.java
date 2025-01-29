package com.comcast.crm.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebdriverUtility;

public class OrganizationPage {
	
	WebDriver driver;
	
	@FindBy(xpath = "//img[@title='Create Organization...']")
	private WebElement createOrgBtn;
	
	@FindBy(name = "search_text")
	private WebElement orgSearchFieldTbx;
	
	@FindBy(id = "bas_searchfield")
	private WebElement orgSearchDropdown;
	
	@FindBy(xpath = "//span[contains(text(),'No Organization Found !')]")
	private WebElement orgNotFoundMsg;

	public WebElement getOrgNotFoundMsg() {
		return orgNotFoundMsg;
	}

	public OrganizationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void searchDropdown(String value) {
		WebdriverUtility wu = new WebdriverUtility();
		wu.selectDropdown(orgSearchDropdown, value);
	}

	public WebElement getOrgSearchFieldTbx() {
		return orgSearchFieldTbx;
	}

	public WebElement getCreateOrgBtn() {
		return createOrgBtn;
	}
}

package com.comcast.crm.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebdriverUtility;

public class OrganizationNameLookUpPage {
	WebDriver driver;
	
	@FindBy(id = "search_txt")
	private WebElement orgSearchTbx;

	public WebElement getOrgSearchTbx() {
		return orgSearchTbx;
	}
	public WebElement getFirstSearchResult() {
		return firstSearchResult;
	}
	public WebElement getOrgSearchCriteraDropdown() {
		return orgSearchCriteraDropdown;
	}

	@FindBy(id = "1")
	private WebElement firstSearchResult;
	
	@FindBy(name = "search_field")
	private WebElement orgSearchCriteraDropdown;
	
	public OrganizationNameLookUpPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void selectOrganizationNameInDropDown() {
		WebdriverUtility wu = new WebdriverUtility();
		wu.selectDropdown(orgSearchCriteraDropdown, "Organization Name");
	}
	
	public void selectOrgSearchCriteriaDropdown(String criteria) {
		WebdriverUtility wu = new WebdriverUtility();
		wu.selectDropdown(orgSearchCriteraDropdown, criteria);
	}
}

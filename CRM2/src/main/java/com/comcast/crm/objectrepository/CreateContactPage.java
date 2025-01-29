package com.comcast.crm.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateContactPage {
WebDriver driver;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(name = "firstname")
	private WebElement firstNameTbx;
	
	@FindBy(name = "lastname")
	private WebElement lastNameTbx;
	
	@FindBy(xpath = "//img[contains(@onclick,'contact_account_address')]")
	private WebElement selectOrgBtn; // The plus button to select the organization
	
	@FindBy(name = "dvtCellInfo")
	private WebElement mobileTbx;
	
	@FindBy(name = "support_start_date")
	private WebElement supportStartDateTbx;
	
	@FindBy(name = "support_end_date")
	private WebElement supportEndDatetbx;
	
	
	public WebElement getSupportStartDateTbx() {
		return supportStartDateTbx;
	}

	public WebElement getSupportEndDatetbx() {
		return supportEndDatetbx;
	}

	public CreateContactPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getFirstNameTbx() {
		return firstNameTbx;
	}

	public WebElement getLastNameTbx() {
		return lastNameTbx;
	}

	public WebElement getSelectOrgBtn() {
		return selectOrgBtn;
	}

	public WebElement getMobileTbx() {
		return mobileTbx;
	}
}

package com.comcast.crm.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInformationPage {
	
	WebDriver driver;
	
	@FindBy(id = "dtlview_Organization Name")
	private WebElement actOrgName;
	
	@FindBy(id = "dtlview_Industry")
	private WebElement actIndustryName;
	
	@FindBy(id = "dtlview_Type")
	private WebElement actType;
	
	@FindBy(id = "dtlview_Phone")
	private WebElement actPhone;
	
	@FindBy(className = "dvHeaderText")
	private WebElement header;
	
	@FindBy(xpath = "//input[@title='Delete [Alt+D]']")
	private WebElement deleteBtn;
	
	
	public WebElement getDeleteBtn() {
		return deleteBtn;
	}

	public void setDeleteBtn(WebElement deleteBtn) {
		this.deleteBtn = deleteBtn;
	}


	public OrganizationInformationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	public WebElement getActOrgName() {
		return actOrgName;
	}

	public WebElement getActIndustryName() {
		return actIndustryName;
	}

	public WebElement getActType() {
		return actType;
	}

	public WebElement getActPhone() {
		return actPhone;
	}

	public WebElement getHeader() {
		return header;
	}
}

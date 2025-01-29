package com.comcast.crm.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ContactsInformationPage {
	public WebElement getActStartDate() {
		return actStartDate;
	}

	public WebElement getActEndDate() {
		return actEndDate;
	}

	WebDriver driver;
	
	@FindBy(id = "dtlview_First Name")
	private WebElement actFirstName;
	
	@FindBy(id = "dtlview_Last Name")
	private WebElement actLastName;
	
	@FindBy(className = "dvHeaderText")
	private WebElement header;
	
	@FindBy(id = "dtlview_Mobile")
	private WebElement actMobile;
	
	@FindBy(xpath = "//span[@id='dtlview_Support Start Date']")
	private WebElement actStartDate;
	
	@FindBy(xpath = "//span[@id='dtlview_Support End Date']")
	private WebElement actEndDate;
	
	@FindBy(id = "mouseArea_Organization Name")
	private WebElement actOrgName;
	
	
	
	public WebElement getActOrgName() {
		return actOrgName;
	}

	public ContactsInformationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	
	public WebElement getActFirstName() {
		return actFirstName;
	}

	public WebElement getActLastName() {
		return actLastName;
	}

	public WebElement getHeader() {
		return header;
	}

	public WebElement getActMobile() {
		return actMobile;
	}
	
	
}

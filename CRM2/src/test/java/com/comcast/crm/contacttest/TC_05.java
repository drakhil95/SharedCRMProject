package com.comcast.crm.contacttest;


import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.objectrepository.ContactsInformationPage;
import com.comcast.crm.objectrepository.ContactsPage;
import com.comcast.crm.objectrepository.CreateContactPage;
import com.comcast.crm.objectrepository.HomePage;


@Listeners(com.comcast.crm.listenerutility.ListenerImpClass.class)
public class TC_05 extends BaseClass{
	// Create a contact with the validation for a month...i.e put start day of today and end date after a month
	
	@Test
	public void contactWithValidationTest() throws Exception {
		//Get Test Script data from the Excel
		String lastName = eu.getDataFromExcel("sheet1", 10, 2);
		String firstName = eu.getDataFromExcel("sheet1", 10, 4);

		//navigate to Contacts module
		HomePage hp = new HomePage(driver);
		hp.getContactsLink().click();

		//Click on create contact button
		ContactsPage cp = new ContactsPage(driver);
		cp.getCreateContactBtn().click();

		//Enter all details and create a new Contact with the start and end date
		CreateContactPage ccp = new CreateContactPage(driver);
		
		String startDate = ju.getSystemDateYYYYMMDD();  // Getting the current system date	
		String endDate = ju.getRequiredDate(30);  // Getting the required end date....i.e. date after 30 days from current system date
		
		ccp.getFirstNameTbx().sendKeys(firstName);
		ccp.getLastNameTbx().sendKeys(lastName);
		
		ccp.getSupportStartDateTbx().clear();
		ccp.getSupportStartDateTbx().sendKeys(startDate);
		
		ccp.getSupportEndDatetbx().clear();
		ccp.getSupportEndDatetbx().sendKeys(endDate);
		
		ccp.getSaveBtn().click();
		
		ContactsInformationPage cip = new ContactsInformationPage(driver);
		
		//Verify the support start and end date
		WebElement actStartDate = cip.getActStartDate();
		System.out.println(actStartDate.getText());
		System.out.println(startDate);
		Assert.assertTrue(actStartDate.getText().equals(startDate), startDate + " not verified. ===> Failed");
		
		WebElement actEndDate = cip.getActEndDate();
		System.out.println(actEndDate.getText());
		System.out.println(endDate);
		Assert.assertTrue(actEndDate.getText().equals(endDate), endDate + " not verified. ===> Failed");
	}
}

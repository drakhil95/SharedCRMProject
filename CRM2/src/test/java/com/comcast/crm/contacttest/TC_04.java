package com.comcast.crm.contacttest;


import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.objectrepository.ContactsInformationPage;
import com.comcast.crm.objectrepository.ContactsPage;
import com.comcast.crm.objectrepository.CreateContactPage;
import com.comcast.crm.objectrepository.HomePage;

public class TC_04 extends BaseClass{
	// Create a contact and verify it
	
	@Test
	public void createContactTest() throws Exception {
		//Get Test Script data from the Excel
		String lastName = eu.getDataFromExcel("sheet1", 10, 2);
		String firstName = eu.getDataFromExcel("sheet1", 10, 4);
		
		//navigate to COntacts module
		HomePage hp = new HomePage(driver);
		hp.getContactsLink().click();

		//Click on create contact button
		ContactsPage cp = new ContactsPage(driver);
		cp.getCreateContactBtn().click();

		//Enter all details and create a new Contact
		CreateContactPage ccp = new CreateContactPage(driver);
		ccp.getFirstNameTbx().sendKeys(firstName);
		ccp.getLastNameTbx().sendKeys(lastName);
		ccp.getSaveBtn().click();
		

		//Verify the last and first name
		ContactsInformationPage cip = new ContactsInformationPage(driver);
		
		WebElement actLastName = cip.getActLastName();
		Assert.assertTrue(actLastName.getText().equals(lastName), lastName + " not verified. ===> Failed");
		
		WebElement actFirstName = cip.getActFirstName();
		Assert.assertTrue(actFirstName.getText().equals(firstName), firstName + " not verified. ===> Failed");
	}
}

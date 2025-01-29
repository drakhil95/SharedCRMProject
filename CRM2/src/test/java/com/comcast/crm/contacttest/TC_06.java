package com.comcast.crm.contacttest;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.objectrepository.ContactsInformationPage;
import com.comcast.crm.objectrepository.ContactsPage;
import com.comcast.crm.objectrepository.CreateContactPage;
import com.comcast.crm.objectrepository.CreateNewOrganizationPage;
import com.comcast.crm.objectrepository.HomePage;
import com.comcast.crm.objectrepository.OrganizationNameLookUpPage;
import com.comcast.crm.objectrepository.OrganizationPage;

public class TC_06 extends BaseClass{
	// create a contact with a organization...we will create a new organization first since we don't know whether any org will be present or not,
	// also the TestCase will be able to run into any Env. no matter if the data will be present in the database or not
	
	@Test
	public void ContactwithOrg() throws Exception {
		
		int randomInt = ju.getRandomNumber();// To get a random integer

		//Get Test Script data from the Excel
		String orgName = eu.getDataFromExcel("sheet1", 1, 2) + randomInt; // Concatenating the org name with random no.
		String lastName = eu.getDataFromExcel("sheet1", 10, 2);
		String firstName = eu.getDataFromExcel("sheet1", 10, 4);

		//navigate to organization module
		HomePage hp = new HomePage(driver);
		hp.getOrganizationsLink().click();

		//Click on create organization button
		OrganizationPage op = new OrganizationPage(driver);
		op.getCreateOrgBtn().click();

		//Enter all details and create a new ORganization
		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		cnop.getOrganizationNameTbx().sendKeys(orgName);
		cnop.getSaveBtn().click();
		//*****************************************************************************************************
		// CREATING THE CONTACT WITH THE ABOVE CREATED ORGANIZATION

		//navigate to Contacts module
		// wu.waitForElementPresent(driver, hp.getContactsLink());
		driver.navigate().refresh();
		hp.getContactsLink().click();

		//Click on create contact button
		ContactsPage cp = new ContactsPage(driver);
		cp.getCreateContactBtn().click();

		//Enter all details and create a new COntact
		CreateContactPage ccp = new CreateContactPage(driver);
		ccp.getFirstNameTbx().sendKeys(firstName);
		ccp.getLastNameTbx().sendKeys(lastName);
		ccp.getSelectOrgBtn().click();
		
		wu.switchTabOnUrl(driver, "module=Accounts&action"); // switching to the child window
		OrganizationNameLookUpPage onlp = new OrganizationNameLookUpPage(driver);
		onlp.selectOrganizationNameInDropDown();
		onlp.getOrgSearchTbx().sendKeys(orgName+ Keys.ENTER);
		Thread.sleep(1000);
		onlp.getFirstSearchResult().click();
		
		wu.switchTabOnUrl(driver, "module=Contacts&action");  // switching the control back to the parent window
		ccp.getSaveBtn().click();

		//Verify the Organization name in the contact
		
		ContactsInformationPage cip = new ContactsInformationPage(driver);
		
		Assert.assertTrue(cip.getActOrgName().getText().contains(orgName));
		
	}
}

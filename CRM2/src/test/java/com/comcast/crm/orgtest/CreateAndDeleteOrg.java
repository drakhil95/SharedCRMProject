package com.comcast.crm.orgtest;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.objectrepository.CreateNewOrganizationPage;
import com.comcast.crm.objectrepository.HomePage;
import com.comcast.crm.objectrepository.OrganizationInformationPage;
import com.comcast.crm.objectrepository.OrganizationPage;


@Listeners(com.comcast.crm.listenerutility.ListenerImpClass.class)
public class CreateAndDeleteOrg extends BaseClass{
	
	@Test
	public void createDeleteOrgTest() throws IOException {
		
		ExtentTest test = UtilityClassObject.getTest();

		int randomInt = ju.getRandomNumber();// To get the random integer
		//Get Test Script data from the Excel
		String cellValue = eu.getDataFromExcel("sheet1", 1, 2);
		String orgName = cellValue + randomInt; // Concatenating the Org name with random no.

		//navigate to organization module
		test.log(Status.INFO, "Navigating to organization module");
		HomePage hp = new HomePage(driver);
		hp.getOrganizationsLink().click();

		//Click on create organization button
		test.log(Status.INFO, "clicking on the 'Create Organization' button");
		OrganizationPage orgPage = new OrganizationPage(driver);
		orgPage.getCreateOrgBtn().click();
		
		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		cnop.getOrganizationNameTbx().sendKeys(orgName);
		cnop.getSaveBtn().click(); // Organization created
		test.log(Status.PASS, "Organization Created");
		
		OrganizationInformationPage oip = new OrganizationInformationPage(driver);
		oip.getDeleteBtn().click(); // Deleting the created organization
		test.log(Status.PASS, "Organization Deleted");
		wu.switchAndAcceptAlert(driver);
		
		hp.getOrganizationsLink().click();  // verifying the org name if deleted or not
		orgPage.searchDropdown("Organization Name");
		orgPage.getOrgSearchFieldTbx().sendKeys(orgName+ Keys.ENTER);
		
		
		Assert.assertTrue(orgPage.getOrgNotFoundMsg().isDisplayed());
		test.log(Status.PASS, orgName+ " is deleted=======> Passed");
	}
}

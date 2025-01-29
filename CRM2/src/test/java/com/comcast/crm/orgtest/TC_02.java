package com.comcast.crm.orgtest;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.objectrepository.CreateNewOrganizationPage;
import com.comcast.crm.objectrepository.HomePage;
import com.comcast.crm.objectrepository.OrganizationInformationPage;
import com.comcast.crm.objectrepository.OrganizationPage;

public class TC_02 extends BaseClass{
	// Create and organization and select the industry, type and verify the organization
	
	@Test
	public void OrgWithIndustryAndType() throws Exception {
		int randomInt = ju.getRandomNumber();// To get the random integer
		
		//Get Test Script data from the Excel
		String orgName = eu.getDataFromExcel("sheet1", 4, 2) + randomInt; // Concatenating the org name with random no.
		String industry = eu.getDataFromExcel("sheet1", 4, 3);
		String type = eu.getDataFromExcel("sheet1", 4, 4);	

		//navigate to organization module
		HomePage hp = new HomePage(driver);
		hp.getOrganizationsLink().click();

		//Click on create organization button
		OrganizationPage op = new OrganizationPage(driver);
		op.getCreateOrgBtn().click();
		
		try {
			//Enter all details and create a new Organization
			CreateNewOrganizationPage createOrgPage = new CreateNewOrganizationPage(driver);
			createOrgPage.getOrganizationNameTbx().sendKeys(orgName);
			createOrgPage.industryDropdown(industry); // Selecting the industry
			createOrgPage.typeDropdown(type); // Selecting the type
			createOrgPage.getSaveBtn().click();
			
			//Verify the industry and type
			OrganizationInformationPage orgInfoPage = new OrganizationInformationPage(driver);
			
			WebElement actIndustry = orgInfoPage.getActIndustryName();
			Assert.assertTrue(actIndustry.getText().equals(industry), industry + " type not set. ===> Failed");  // Verifying Industry
			
			WebElement actType = orgInfoPage.getActType();
			Assert.assertTrue(actType.getText().equals(type), type + " type set. ===> Failed");
		} catch (Exception e) {
			System.out.println("Organisation name already present in the database");
		}
	}
}
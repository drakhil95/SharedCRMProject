package com.comcast.crm.orgtest;


import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;

import com.comcast.crm.objectrepository.CreateNewOrganizationPage;
import com.comcast.crm.objectrepository.HomePage;
import com.comcast.crm.objectrepository.OrganizationInformationPage;
import com.comcast.crm.objectrepository.OrganizationPage;

public class TC_03 extends BaseClass{
	// Create and organization with phone number and verify the phone number

	@Test
	public void orgWithPhone() throws IOException {

		int randomInt = ju.getRandomNumber(); // To get the random integer

		//Get Test Script data from the Excel
		String orgName = eu.getDataFromExcel("sheet1", 7, 2) + randomInt; // Concatenating the Org name with random no.
		String phone =eu.getDataFromExcel("sheet1", 7, 3);

		//navigate to organization module
		HomePage hp = new HomePage(driver);
		hp.getOrganizationsLink().click();

		//Click on create organization button
		OrganizationPage op = new OrganizationPage(driver);
		op.getCreateOrgBtn().click();

		try {
			//Enter all details and create a new Organization
			CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
			cnop.getOrganizationNameTbx().sendKeys(orgName);
			cnop.getPhoneTbx().sendKeys(phone);
			cnop.getSaveBtn().click();

			//Verify the industry and type
			OrganizationInformationPage oip = new OrganizationInformationPage(driver);
			WebElement actPhone = oip.getActPhone();
			Assert.assertTrue(actPhone.getText().equals(phone), phone + " not verified. ===> Failed");
		} catch (Exception e) {
			System.out.println("Organisation name already present in the database");
		}
	}
}
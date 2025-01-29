package com.comcast.crm.orgtest;

import org.openqa.selenium.WebElement;
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
public class TC_01 extends BaseClass{
	
// Create an organization and verify the header message and the organization name
	@Test
	public void createOrgTest() throws Exception {
		int randomInt = ju.getRandomNumber();// To get the random integer
		//Get Test Script data from the Excel
		String cellValue = eu.getDataFromExcel("sheet1", 1, 2);
		String orgName = cellValue + randomInt; // Concatenating the Org name with random no.
		
		ExtentTest test = UtilityClassObject.getTest();
		
		
		//navigate to organization module
		test.log(Status.INFO, "Navingating to Organization Module");
		HomePage hp = new HomePage(driver);
		hp.getOrganizationsLink().click();
		
		//Click on create organization button
		test.log(Status.INFO, "Clicking on the Create organizaton button");
		OrganizationPage orgPage = new OrganizationPage(driver);
		orgPage.getCreateOrgBtn().click();
		
		try {
			//Enter all details and create a new ORganization
			test.log(Status.INFO, "ENtering all the details and clicking on Save button");
			CreateNewOrganizationPage createOrgPage = new CreateNewOrganizationPage(driver);
			createOrgPage.getOrganizationNameTbx().sendKeys(orgName);
			createOrgPage.getSaveBtn().click();
			
			//Verify the header message and expected result
			OrganizationInformationPage orgInfoPage = new OrganizationInformationPage(driver);
			String header = orgInfoPage.getHeader().getText();
			
			Assert.assertTrue(header.contains(orgName), orgName + " not created=====> FAILED"); // comparing the organization in header
			test.log(Status.PASS, "Organization name verified in header");
			
			WebElement orgNameRes = orgInfoPage.getActOrgName();
			Assert.assertTrue(orgNameRes.getText().equals(orgName), orgName + " is not verified===>Failed"); // comparing the Org name in the field
			test.log(Status.PASS, "Organization name verified");
		} catch (Exception e) {
				System.out.println("Organisation name already present in the database");
				test.log(Status.FAIL, "Organization naem already present in the DataBase");
		}
	}

}

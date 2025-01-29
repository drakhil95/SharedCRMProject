package demoPackage;

import org.testng.annotations.Test;

public class Q1A {
	@Test(dataProviderClass = Q1.class, dataProvider = "orgNameAndPhone")
	public void execute(String orgName, int phoneNo) throws Exception {
		System.out.println("Organization Name: " + orgName);
		System.out.println("Phone Number: " + phoneNo);
	}
}

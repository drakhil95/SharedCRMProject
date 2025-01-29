package demoPackage;

import org.testng.annotations.DataProvider;


public class Q2 {

	@DataProvider
	public Object[][] orgNameAndPhone() {
		Object[][] ar = {
				{"Akhil Infotech123", 9999},
				{"Akhil Infotech223", 9999},
				{"Akhil Infotech333", 9999},
				{"Akhil Infotech423", 9999},
				{"Akhil Infotech523", 9999}
		};
		return ar;
	}

	@DataProvider
	public Object[][] orgNamePhoneEmail() {
		Object[][] ar = {
				{"Akhil Infotech11", "9999999999", "akhil@infotech.com"},
				{"Akhil Infotech21", "9999999999", "akhil@infotech.com"},
				{"Akhil Infotech31", "9999999999", "akhil@infotech.com"},
				{"Akhil Infotech41", "9999999999", "akhil@infotech.com"},
				{"Akhil Infotech51", "9999999999", "akhil@infotech.com"}
		};
		return ar;
		
	}
	
	@DataProvider
	public Object[][] orgNamePhoneEmailFax() {
		Object[][] ar = {
				{"Akhil Infotech11", 9999999999l, "akhil@infotech.com", 61039109},
				{"Akhil Infotech21", 9999999999l, "akhil@infotech.com", 61039109},
				{"Akhil Infotech31", 9999999999l, "akhil@infotech.com", 61039109},
				{"Akhil Infotech41", 9999999999l, "akhil@infotech.com", 61039109},
				{"Akhil Infotech51", 9999999999l, "akhil@infotech.com", 61039109}
		};
		return ar;
		
	}
}

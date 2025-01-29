package demoPackage;

import org.testng.annotations.DataProvider;

public class Q1 {
	
	@DataProvider
	public Object[][] orgNameAndPhone() {
		Object[][] ar = {
				{"Akhil Infotech1", 9999},
				{"Akhil Infotech2", 9999},
				{"Akhil Infotech3", 9999},
				{"Akhil Infotech4", 9999},
				{"Akhil Infotech5", 9999}
		};
		return ar;
	}
}

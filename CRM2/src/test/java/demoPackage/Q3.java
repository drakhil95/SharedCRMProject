package demoPackage;


import org.testng.annotations.DataProvider;

import com.comcast.crm.generic.fileutility.ExcelUtility;

public class Q3 {
	
	@DataProvider
	public Object[][] getProductData() throws Exception {
		ExcelUtility eu = new ExcelUtility();
		int rowCount = eu.getRowCount("data");
		Object[][] ar = new Object[rowCount][2];
		
		for (int i = 0; i < rowCount; i++) {
			for (int j = 0; j < 2; j++) {
				ar[i][j] = eu.getDataFromExcel("data", i, j);
			}
		}
		
		return ar;
	}
}

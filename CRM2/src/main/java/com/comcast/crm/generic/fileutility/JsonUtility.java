package com.comcast.crm.generic.fileutility;

import java.io.FileReader;
import java.io.IOException;


public class JsonUtility {
	
	public String getDataFromJsonFile(String key) throws IOException {  // This code is not correct
		FileReader fir = new FileReader("./configAppData/GnericUtilityCommonData.properties");
		fir.close();
		return key;
	}
}

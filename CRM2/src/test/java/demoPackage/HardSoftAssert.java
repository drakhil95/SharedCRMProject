package demoPackage;

import org.testng.asserts.SoftAssert;

public class HardSoftAssert {
	public static void main(String[] args) {
		SoftAssert sas = new SoftAssert();
		sas.assertAll();
	}
}

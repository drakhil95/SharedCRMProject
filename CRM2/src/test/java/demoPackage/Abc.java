package demoPackage;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.listenerutility.ListenerImpClass;


@Listeners(com.comcast.crm.listenerutility.ListenerImpClass.class)
public class Abc extends BaseClass{
	
	
	@Test
	public void test1() {
		ListenerImpClass.test.log(Status.FAIL, "This test case will FAIL");
		Assert.assertEquals(false, true);
	}
	
	
	@Test
	public void test2() {
		ListenerImpClass.test.log(Status.PASS, "This test case will PASS");
		Assert.assertEquals(false, false);
	}
	
	@Test
	public void test3() {
		ListenerImpClass.test.log(Status.PASS, "This test case will PASS");
		Assert.assertEquals(true, true);
	}
}

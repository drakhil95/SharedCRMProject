package demoPackage;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;

@Listeners(com.comcast.crm.listenerutility.ListenerImpClass.class)
public class ListenerTest extends BaseClass {
	
	@Test(retryAnalyzer = com.comcast.crm.listenerutility.RetryListenerImp.class)
	public void tc_999() {
		System.out.println("This testcase has failed successfully :) ");
		Assert.fail();
	}
}

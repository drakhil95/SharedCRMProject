package demoPackage;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.basetest.BaseClass;

public class ExtentReportsDemo extends BaseClass{
	@Test
	public void createContactTest() {
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvancedReport/report.html");
		spark.config().setDocumentTitle("Demo report");
		spark.config().setReportName("Demo Report Name");
		spark.config().setTheme(Theme.DARK);
		
		// add env info &  create the test
		ExtentReports reports = new ExtentReports();  
		reports.attachReporter(spark);
		reports.setSystemInfo("OS", "Windows 11");
		reports.setSystemInfo("Browser", "Chrome");
		

		// adding the info to the test
		ExtentTest test = reports.createTest("createContactTEST");
		test.log(Status.INFO, "Login to the app");
		test.log(Status.INFO,"create the contact");
		test.log(Status.INFO,"save the contact as HDFC");
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		String filePath = ts.getScreenshotAs(OutputType.BASE64);
		test.addScreenCaptureFromBase64String(filePath, "DemoScreenshot"); // To attach the screenshot in the report
		
		if ("HDFC".equals("HDFC")) {
			test.log(Status.PASS,"PASSED");
		} else {
			test.log(Status.FAIL, "FAILED");
		}
		
		reports.flush();  
	}
}

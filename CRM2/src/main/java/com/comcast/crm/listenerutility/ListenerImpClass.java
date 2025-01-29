package com.comcast.crm.listenerutility;


import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;


public class ListenerImpClass implements ITestListener, ISuiteListener{

	public ExtentReports reports;
	public static ExtentTest test;
	
	
	@Override
	public void onStart(ISuite suite) {
		System.out.println("=====Report configuration=====");
		String date = new Date().toString().replace(":", "_").replace(" ", "_");
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvancedReport/report_"+date+".html");
		spark.config().setDocumentTitle("Demo report");
		spark.config().setReportName("Demo Report Name");
		spark.config().setTheme(Theme.DARK);
		
		// add env info &  create the test
		reports = new ExtentReports();
		reports.attachReporter(spark);
		reports.setSystemInfo("OS", "Windows 11");
		reports.setSystemInfo("Browser", "Chrome");
	}

	@Override
	public void onFinish(ISuite suite) {
		System.out.println("=====Report backup=====");
		reports.flush(); // backing up the report
	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println(result.getMethod().getMethodName()+ " has started to execute");
		test = reports.createTest(result.getMethod().getMethodName());
		UtilityClassObject.setTest(test);
		test.log(Status.INFO, result.getMethod().getMethodName()+ " Started");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println(result.getMethod().getMethodName()+ " executed successfully");
		test.log(Status.PASS, result.getMethod().getMethodName()+ " executed successfully");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		String date = new Date().toString().replace(":", "_").replace(" ", "_");
		
		TakesScreenshot ts = (TakesScreenshot) UtilityClassObject.getDriver();
		String src = ts.getScreenshotAs(OutputType.BASE64); // saving the path of the screenshot in a string
		
		test.addScreenCaptureFromBase64String(src, methodName+ "_" + date); // giving the method name along with the current time and date	
		test.log(Status.FAIL, result.getMethod().getMethodName()+ " Failed");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println(result.getMethod().getMethodName()+ " got skipped");
		test.log(Status.SKIP, result.getMethod().getMethodName()+ " Skipped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println(result.getMethod().getMethodName()+ "name of listener method that executed is :  onTestFailedButWithinSuccessPercentage");
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		System.out.println(result.getMethod().getMethodName()+ " got skipped");
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("onSatrt() method executed successfylly");

	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("onFinish() method executed successfylly");
	}
	
}

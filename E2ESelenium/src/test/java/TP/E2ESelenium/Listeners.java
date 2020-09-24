package TP.E2ESelenium;

import java.io.IOException;
import java.lang.reflect.Field;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import resources.ExtentReportNG;
import resources.baseclass;

public class Listeners extends baseclass implements ITestListener
{
	ExtentReports extent=ExtentReportNG.getReport();
	ExtentTest test;
	ThreadLocal <ExtentTest>extentTest=new ThreadLocal<ExtentTest>();
	@Override
	public void onTestStart(ITestResult result) 
	{

		 test=extent.createTest(result.getMethod().getMethodName());
		 extentTest.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result)
	{

		extentTest.get().log(Status.PASS,"Test Passed");
	}
	@Override
	public void onTestFailure(ITestResult result)
	{
		extentTest.get().fail(result.getThrowable());
				
	}

	@Override
	public void onTestSkipped(ITestResult result) {}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {}

	@Override
	public void onStart(ITestContext context) {}

	@Override
	public void onFinish(ITestContext context) 
	{ 
		extent.flush();
		
	}	
}
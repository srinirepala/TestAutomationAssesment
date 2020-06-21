package com.absa.qa.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;



public class ListenerCustom extends ScreenshotBase implements ITestListener {

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Success Test");
		success(result.getMethod().getMethodName());
		
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("FAILED Test");
		failed(result.getMethod().getMethodName());
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("Finish Test");
		onfinish(((ITestResult) context).getMethod().getMethodName());
		
	}
}

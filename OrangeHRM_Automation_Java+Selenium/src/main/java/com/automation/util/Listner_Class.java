package com.automation.util;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGListener;
import org.testng.ITestResult;

public class Listner_Class extends Test_Util implements ITestListener{
	

	
	  public  void onTestStart(ITestResult result) {
		  System.out.println("Test case Starting");
	  
	  }

	  
		
	  public  void onTestSuccess(ITestResult result) {
		  System.out.println("Test succesfully completed");
	
	  }

	 
		
	  public  void onTestFailure(ITestResult result) {
		  System.out.println("Test failed --> Screenshot captured");
		  try {
			takesScreenshot();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	  
	  }

		
	  public  void onTestSkipped(ITestResult result) {
	   
	  }

	
		
	  public  void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	    
	  }

		
	  public  void onTestFailedWithTimeout(ITestResult result) {
	    onTestFailure(result);
	  }

	
		
	  public  void onStart(ITestContext context) {
	   
	  }
		
	  public  void onFinish(ITestContext context) {
	    
	  }
	}




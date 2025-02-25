package org.iitwf.selenium.mmpequinox;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerUtility extends FrameworkLibrary implements ITestListener {
	
	@Override
	public void onTestSuccess(ITestResult tr) {
	  
		System.out.println("Test case passed " +tr.getName());
		System.out.println("Total time in execution of this test case name: " +tr.getName() +" " +tr.getEndMillis());
		
	  }
	
	@Override
	public void onTestFailure(ITestResult tr) {
		
		System.out.println("Test case failed " +tr.getName());
		System.out.println("Total time taken in execution of this test case name: " +tr.getName() +" " +tr.getEndMillis());
	    
	  }

}

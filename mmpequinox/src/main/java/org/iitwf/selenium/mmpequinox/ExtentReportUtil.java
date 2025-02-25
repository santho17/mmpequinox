package org.iitwf.selenium.mmpequinox;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class ExtentReportUtil {
	
	private static ExtentReports extent;
	
	public static ExtentReports createInstance(String FileName) {
		
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(FileName);
		//Setting true to append to existing report
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		return extent;
		
		
	}

	public static ExtentReports getInstance() {
		return extent;
	}
	

}

package org.iitwf.selenium.mmpequinox;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;

import org.iitwf.mmp.pages.patientmodule.HomePage;
import org.iitwf.mmp.pages.patientmodule.MMPUtility;
import org.iitwf.mmp.pages.patientmodule.ScheduleAppointmentPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

@Listeners(ListenerUtility.class)
public class ScheduleAppointmentFinal extends FrameworkLibrary {
	
	/*
	
	Formatted Date:::February/20/2025
	Same Year 
	Same Month -> Click on the date - 2
	----------------------------------------
	Formatted Date:::April/20/2025 - split("/") - [0] - April,[1]- 20,[2]-2025
	Same Year 
	Different Month - Expected Year - April -> Click on next button
	Different Month - Expected Year - December -> till i see the month as December 
	---------------------------------------------------------------------------------
	Formatted Date: April/20/2026
	Different Year - Click on next button till 2026 is displayed 
	Different Month - Click on next button till April is displayed 
	click on 20th as date 
	---------------------------------------------------------------------
	*/
	
	private ExtentTest extentTest;
	
	@Test
	public void validateBookAppointmentTest() throws IOException {
		
		extentTest = extentReports.createTest("Validate Schedule Appointment Test");
		launchBrowser(prop.getProperty("patient_url"));
		MMPUtility mmputil = new MMPUtility(driver);
		mmputil.login(prop.getProperty("patient_username"), prop.getProperty("patient_password"));
		HomePage hPage = new HomePage(driver);
		hPage.navigatetoAModule("Schedule Appointment");
		extentTest.info("Navigating to Schedule Appointment");
		
		ScreenshotUtility screenshotUtil = new ScreenshotUtility(driver);
		String screenshotPath = screenshotUtil.captureScreenshot("Schedule Appointment_Page 1");
		extentTest.addScreenCaptureFromPath(screenshotPath, "Navigation_To_Schedule_Appointment_Page");
		
		ScheduleAppointmentPage sPage = new ScheduleAppointmentPage(driver);
		HashMap<String,String> expectedHMap= sPage.bookAppointment(60,"MMMM/d/YYYY","Cardiologist","Charlie");
		extentTest.info("Expected HMap: " +expectedHMap);
		
        HashMap<String,String> actualHMap = hPage.fetchAppointmentDetails();
        extentTest.info("Actual HMap: " +actualHMap);
        
        screenshotUtil = new ScreenshotUtility(driver);
		screenshotPath = screenshotUtil.captureScreenshot("Schedule Appointment_Page 2");
		extentTest.addScreenCaptureFromPath(screenshotPath, "Schedule Appointment page completed");
		
		Assert.assertEquals(actualHMap, expectedHMap, "Booking is unsuccessful");
	}
	
	
}
	
	
	
	


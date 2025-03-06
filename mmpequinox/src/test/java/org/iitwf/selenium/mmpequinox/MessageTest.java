package org.iitwf.selenium.mmpequinox;

import org.testng.annotations.Test;
import java.io.IOException;

import org.iitwf.mmp.pages.patientmodule.MMPUtility;
import org.iitwf.selenium.mmpequinox.FrameworkLibrary;
import org.iitwf.selenium.mmpequinox.ScreenshotUtility;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import com.aventstack.extentreports.ExtentTest;

	public class MessageTest extends FrameworkLibrary {
		
		private ExtentTest extentTest;
		
@Test
		public void validateMessageTests() throws IOException, InterruptedException {
			
			extentTest = extentReports.createTest("Validate Message Tests");
			
			launchBrowser(prop.getProperty("patient_url"));
			
			MMPUtility mmpUtil = new MMPUtility(driver);
			mmpUtil.login(prop.getProperty("patient_username"), prop.getProperty("patient_password"));
			driver.findElement(By.xpath("//span[normalize-space()='Messages']")).click();
			extentTest.info("Navigating to Messages page");
			
			ScreenshotUtility screenshotUtil = new ScreenshotUtility(driver);
			String screenshotPath = screenshotUtil.captureScreenshot("Messages page_Step 1");
			extentTest.addScreenCaptureFromPath(screenshotPath, "Messages Landing page");
			
			//Entering the Contact reason
			driver.findElement(By.id("subject")).sendKeys("Sick visit");
			//Entering the Subject for the visit
			driver.findElement(By.id("message")).sendKeys("Need an appointment from the doctor for the lower abdomen pain");
			
			screenshotUtil = new ScreenshotUtility(driver);
			screenshotPath = screenshotUtil.captureScreenshot("Messages page_Step 2");
			extentTest.addScreenCaptureFromPath(screenshotPath, "Messages_filled_Step 2");
			
			//click on Send button
			driver.findElement(By.xpath("//table[@class='table']/tbody/tr[4]/td/input[@value='Send']")).click();
			Thread.sleep(2000);
			Alert alrt = driver.switchTo().alert();
			String alertActual = alrt.getText();
			System.out.println("Print the alert text: " +alertActual);
			String alertExpected = "Messages Successfully sent.";
			if(alertActual.equals(alertExpected)) {
				System.out.println("Test case passed");
			}
			alrt.accept();
		
		}
		
		}	
		




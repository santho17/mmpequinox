package org.iitwf.selenium.mmpequinox;

import java.io.IOException;

import org.iitwf.mmp.pages.patientmodule.EditProfilePage;
import org.iitwf.mmp.pages.patientmodule.HomePage;
import org.iitwf.mmp.pages.patientmodule.MMPUtility;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

public class EditProfiletest extends FrameworkLibrary{	
		
			/**
			 * 1. update the firstname by passing randomtext value.
			 * 	  expected and actual 
			 *    compare expected vs actual
			 *  
			 * 2. LAstName
			 * 3. SSN
			 * 4. Address
			 * 
			 * SoftAssert 
			 * 
			 * FluentWait
			 * Breakpoint by modifying the logic
			 * 
			 * */
	
	private ExtentTest extentTest;
	
@Test
	public void validateEditFunctionAllFields() throws IOException {
	extentTest = extentReports.createTest("Validate Edit Profile Test");
	MMPUtility mmputil = new MMPUtility(driver);
	mmputil.login(prop.getProperty("patient_username"), prop.getProperty("patient_password"));
	HomePage hPage = new HomePage(driver);
	hPage.navigatetoAModule("Profile");
	extentTest.info("Navigating to Profile page");
	ScreenshotUtility screenshotUtil = new ScreenshotUtility(driver);
	String screenshotPath = screenshotUtil.captureScreenshot("Edit Profile_Page Step 1");
	extentTest.addScreenCaptureFromPath(screenshotPath, "Edit Profile_landing Page");
	
	EditProfilePage editProObj = new EditProfilePage(driver);
	String actualFName = editProObj.editAllFields();
	String expectedFName = prop.getProperty("patient_username");
	extentTest.info("Expected FName" +expectedFName);
	extentTest.info("Actual FName" +actualFName);
	Assert.assertEquals(actualFName, expectedFName);
	
	
	

}
public void navigateToModule(String moduleName) {
	
	driver.findElement(By.xpath("//span[normalize-space()='"+moduleName+"']")).click();
}

public void editProfile() {
	
	driver.findElement(By.id("Ebtn")).click();
	
	String expectedfNameValue = RandomEx.generateRandomString("AUTFNAME");
	WebElement fNameWE = driver.findElement(By.id("fname"));
	fNameWE.clear();
	fNameWE.sendKeys(expectedfNameValue);
	
	String expectedlNameValue = RandomEx.generateRandomString("AUTLNAME");
	WebElement lNameWE = driver.findElement(By.id("lname"));
	lNameWE.clear();
	lNameWE.sendKeys(expectedlNameValue);
	
	int expectedSSNValue = RandomEx.generateRandomDigits(10000000, 99999999);
	System.out.println("Printing the SSN number: " +expectedSSNValue);
	WebElement ssnWE = driver.findElement(By.id("ssn"));
	ssnWE.clear();
	ssnWE.sendKeys(String.valueOf(expectedSSNValue));
	
	int expectedAgeValue = RandomEx.generateRandomNumber(1);
	System.out.println("Printing the Age: " +expectedAgeValue);
	WebElement ageWE = driver.findElement(By.id("age"));
	ageWE.clear();
	ageWE.sendKeys(String.valueOf(expectedAgeValue));
	
	driver.findElement(By.id("Sbtn")).click();
	handleAlerts();
	
	fNameWE = driver.findElement(By.id("fname"));
	String actualfNameValue = fNameWE.getDomProperty("value");
	
	lNameWE = driver.findElement(By.id("lname"));
	String actuallNameValue = lNameWE.getDomProperty("value");
	
	ssnWE = driver.findElement(By.id("ssn"));
	String actualSSNValue = ssnWE.getDomProperty("value");
	
	ageWE = driver.findElement(By.id("age"));
	String actualAgeValue = ageWE.getDomProperty("value");
	
	if(expectedfNameValue.equals(actualfNameValue))
	{
		System.out.println("FName value is updated");
	}
	
	if(expectedlNameValue.equals(actuallNameValue))
	{
		System.out.println("LName value is updated");
	}
	if(actualSSNValue.equals("expectedSSNValue"))
	{
		System.out.println("SSN value is updated");
	}
	if(actualAgeValue.equals("expectedAgeValue"))
	{
		System.out.println("Age value is updated");
	}
	
	
}

public String handleAlerts() {
	Alert alrt = driver.switchTo().alert();
	String alertTxt = alrt.getText();
	alrt.accept();
	return alertTxt;
}

}

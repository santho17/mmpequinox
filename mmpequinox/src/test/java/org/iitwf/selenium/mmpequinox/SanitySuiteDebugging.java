package org.iitwf.selenium.mmpequinox;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SanitySuiteDebugging extends FrameworkLibrary {

	/**
	 * 
	 * Click on the menu bar and validated the text
	 * Display the following output message:
	 * Following are the modules deployed successfully and Sanity Tests are passed!!!!!."
	 * 
	 */


	public void main(String[] args) {
		
		MMPUtility mmputil = new MMPUtility(driver);
		mmputil.login(prop.getProperty("patient_username"), prop.getProperty("patient_password"));
		
        HashMap<String,String> actualMenuTitleText = fetchMenuTitleText();
        HashMap<String,String> expectedMenuTitleText = validateMenuTitleText();
		
		System.out.println(actualMenuTitleText.equals(expectedMenuTitleText));
		

	}
	
	public HashMap<String,String> fetchMenuTitleText()
	{

		List<WebElement> actualList = driver.findElements(By.xpath("//div[@class='sidebar-holder']/ul/li/a"));
		HashMap<String,String> actualMenuTitleText = new HashMap<String,String>();
		for(int i = 0;i<actualList.size()-1;i++)
		{
			actualList = driver.findElements(By.xpath("//div[@class='sidebar-holder']/ul/li/a"));
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOfAllElements(actualList.get(i)));
			wait.until(ExpectedConditions.elementToBeClickable(actualList.get(i)));
			String menuitem = actualList.get(i).getText();
		
			actualList.get(i).click();
		
			//actualList = driver.findElements(By.xpath("//div[@class='sidebar-holder']/ul/li/a/span"));
			actualMenuTitleText.put(
					menuitem,
					driver.findElement(By.xpath("//div[@class='panel-heading']")).getText());
		}
		System.out.println("Actual Title text is: " +actualMenuTitleText);
		return actualMenuTitleText;
	}
	
	public static HashMap<String,String> validateMenuTitleText(){
		
		HashMap<String,String> expectedMenuTitleText = new HashMap<String,String>();
		expectedMenuTitleText.put("HOME", "Patient Portal");
		expectedMenuTitleText.put("Profile", "Personal Details");
		expectedMenuTitleText.put("Schedule Appointment", "Current Appointments");
		expectedMenuTitleText.put("Information", "Information");
		expectedMenuTitleText.put("Fees", "Fees");
		expectedMenuTitleText.put("Search Symptoms", "Search Symptoms");
		expectedMenuTitleText.put("Messages", "Messages");
		System.out.println(expectedMenuTitleText);
		return expectedMenuTitleText;
	}
	


}

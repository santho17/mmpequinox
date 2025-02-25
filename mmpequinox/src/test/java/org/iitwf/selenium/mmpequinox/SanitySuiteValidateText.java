package org.iitwf.selenium.mmpequinox;

import java.util.ArrayList;
import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class SanitySuiteValidateText extends FrameworkLibrary {
	
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
		//Expected Menu Items in sorted order
		ArrayList<String> expectedMenuArray = new ArrayList<String>();
		expectedMenuArray.add("Schedule Appointment");
		expectedMenuArray.add("Profile");
		expectedMenuArray.add("HOME");
		expectedMenuArray.add("Fees");
		expectedMenuArray.add("Information");
		expectedMenuArray.add("Search Symptoms");
		expectedMenuArray.add("Messages");
		expectedMenuArray.add("Logout");
	    
		ArrayList<String> expectedTitlesArray = readMenuText();
		
		System.out.println("Expected Array List: " +expectedTitlesArray);
		
		
		//Loop through the menu items
	    for(int i=0;i<expectedMenuArray.size()+2;i++) 
	    {
		try {
			WebElement menuWE =  driver.findElement(By.xpath("//div[@class='sidebar-holder']/ul/li["+i+"]/a"));
			String menuItems = menuWE.getText().trim();
			if (expectedMenuArray.contains(menuItems)) 
			{
				System.out.println("Clicking page: "+menuItems);
				menuWE.click();				
				Thread.sleep (2000);
				System.out.println("Page load successful");
				WebElement actualTitle = driver.findElement(By.xpath("//h3[@class='panel-title']"));
				String title = actualTitle.getText().trim();
				assert expectedTitlesArray.get(i)==title;
				System.out.println("Actual title matches with expected title: " +title);	
		}
				else {
					System.out.println("Actual title does not match with expected title");
				}
		}
		catch(Exception e) 
		{
			System.out.println("No Such element exception");
		}
	}		
	}
		
	public static ArrayList<String> readMenuText(){
		ArrayList<String> expectedTitlesArray = new ArrayList<String>();
		expectedTitlesArray.add("Patient Portal");
		expectedTitlesArray.add("Personal Details");
		expectedTitlesArray.add("Current Appointments");
		expectedTitlesArray.add("Information");
		expectedTitlesArray.add("Fees");
		expectedTitlesArray.add("Search Symptoms");
		expectedTitlesArray.add("Messages");
		Arrays.sort(expectedTitlesArray.toArray());
		return expectedTitlesArray;
	}
		
	
	
}

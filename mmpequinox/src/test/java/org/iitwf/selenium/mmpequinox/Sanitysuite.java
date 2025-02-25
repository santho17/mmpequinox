package org.iitwf.selenium.mmpequinox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sanitysuite extends FrameworkLibrary {
	/**
	 * 
	 * Validate all the modules are deployed successfuly
	 * Display the following output message:
	 * 
	 * 	"Following are the modules deployed successfully and Sanity Tests are passed!!!!!."
	 * 
	 */
	

public void main (String args[]) {
	
	MMPUtility mmputil = new MMPUtility(driver);
	mmputil.login(prop.getProperty("patient_username"), prop.getProperty("patient_password"));
	ArrayList<String> expectedMenuArrayList = readMenuTitles();
	ArrayList<String> actualMenuArrayList = fetchMenuTitlesFromUI();
	
	System.out.println("Expected Array List: " +expectedMenuArrayList);
	System.out.println("Actual Array List: " +actualMenuArrayList);
	
	System.out.println(actualMenuArrayList.equals(expectedMenuArrayList));
	driver.close();
}

public ArrayList<String> fetchMenuTitlesFromUI()
{
	List<WebElement> actualArrayList = driver.findElements(By.xpath("//div[@class='sidebar-holder']/ul/li/a/span"));
	ArrayList<String> actualMenuArrayList = new ArrayList<String>();
	for(int i=0;i<actualArrayList.size();i++) {
		actualMenuArrayList.add(actualArrayList.get(i).getText().trim());
	}
	Arrays.sort(actualMenuArrayList.toArray());
	return actualMenuArrayList;

}

public ArrayList<String> readMenuTitles(){
	ArrayList<String> expectedMenuArrayList = new ArrayList<String>();
	expectedMenuArrayList.add("HOME");
	expectedMenuArrayList.add("Profile");
	expectedMenuArrayList.add("Schedule Appointment");
	expectedMenuArrayList.add("Information");
	expectedMenuArrayList.add("Fees");
	expectedMenuArrayList.add("Search Symptoms");
	expectedMenuArrayList.add("Messages");
	expectedMenuArrayList.add("Logout");
	Arrays.sort(expectedMenuArrayList.toArray());
	return expectedMenuArrayList;
	
}

}

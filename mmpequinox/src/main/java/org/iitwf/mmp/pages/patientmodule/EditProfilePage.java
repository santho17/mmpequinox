package org.iitwf.mmp.pages.patientmodule;

import org.iitwf.selenium.mmpequinox.RandomEx;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditProfilePage {
	
	@FindBy(id="Ebtn")
	private WebElement editButton;

	protected WebDriver driver;
	
	
	public EditProfilePage(WebDriver driver)
	{
	    this.driver = driver;
	     if (!driver.getTitle().equals("profile")) {
	      throw new IllegalStateException("This is not Edit Profile Page," +
	            " current page is: " + driver.getCurrentUrl());
	    }
	PageFactory.initElements(driver, this);

}
	public String editAllFields()
	{
		Actions action = new Actions(driver);

		action.moveToElement(driver.findElement(By.id("Ebtn")));
		action.click();

		//Fname Logic
		WebElement fnameWE = driver.findElement(By.id("fname"));
		action.moveToElement(fnameWE);
		action.sendKeys(fnameWE,Keys.CLEAR);
		String expectedFName = RandomEx.generateRandomString("QAAUT");
		action.sendKeys(fnameWE,expectedFName);
		String actualFName = fnameWE.getDomProperty("value");
		action.perform();

		//Age Logic
		WebElement ageWE = driver.findElement(By.id("age"));
		action.moveToElement(ageWE);
		action.sendKeys(ageWE,Keys.CLEAR);
		String ageExpected = RandomEx.generateRandomDigits(100,999)+"";
		String ageActual = ageWE.getDomProperty("value");
		action.sendKeys(ageActual,ageExpected);
		action.perform();


		WebElement saveButton = driver.findElement(By.id("Sbtn"));
		action.moveToElement(saveButton);
		action.click(saveButton);
		action.perform();

		Alert alrt = driver.switchTo().alert();
		System.out.println("Alert Text " + alrt.getText());
		alrt.accept();

		return actualFName;

	}
	
	public void editProfile() {
		
		editButton.click();
		
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
		return actualAgeValue;
		
		
	}

	public String handleAlerts() {
		Alert alrt = driver.switchTo().alert();
		String alertTxt = alrt.getText();
		alrt.accept();
		return alertTxt;
	}
	

}

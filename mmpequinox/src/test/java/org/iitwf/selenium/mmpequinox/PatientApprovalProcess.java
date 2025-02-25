package org.iitwf.selenium.mmpequinox;

import java.util.Random;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PatientApprovalProcess 
{
	
	/**
	 * registerPatient() - Tuesday 
loginToPatientModule()- Thursday
logintoAdminModule() - Thursday
approvePatient() - Thursday
loginToPatientModule()-Thursday
	 
	http://85.209.95.122/MMP-Release2-Admin-Build.2.1.000/login.php
	Ben@123
	Frank@123
	
	*/
	
	static WebDriver driver = new ChromeDriver();

	public static void main(String[] args) 
	{
		
		driver.get("http://85.209.95.122/MMP-Release2-Integrated-Build.6.8.000/portal/login.php");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@value='Register']")).click();
		
/*		String expectedfirstNameValue = RandomEx.generateRandomString("QAFNAME");
		WebElement firstNameWE = driver.findElement(By.id("firstname"));
		firstNameWE.sendKeys(expectedfirstNameValue);
		
		String expectedlastNameValue = RandomEx.generateRandomString("QALNAME");
		WebElement lastNameWE = driver.findElement(By.id("lastname"));
		lastNameWE.sendKeys(expectedlastNameValue);
		
	    String expectedDateOfBirthValue = getDateOfBirth(-10000, "MM/dd/YYYY");
		WebElement dateOfBirthWE = driver.findElement(By.id("datepicker"));
		dateOfBirthWE.sendKeys(expectedDateOfBirthValue);
		*/
		
		int expectedSSN = RandomEx.generateRandomDigits(100000000, 999999999);
	    WebElement ssnWE = driver.findElement(By.id("ssn"));
	    ssnWE.sendKeys(String.valueOf(expectedSSN));
	    
	    String randomState = generateRandomState("A");
		System.out.println("Print the state: " +randomState);
		WebElement stateWE = driver.findElement(By.id("state"));
	    stateWE.sendKeys(randomState);
	    
	    String randomAddress = generateRandomAddress(4, "Drive");
	    System.out.println("Print the address: " +randomAddress);
		WebElement addressWE = driver.findElement(By.id("address"));
	    addressWE.sendKeys(randomAddress);
	    
	    int LL = 00000;
	    int UL = 99999;
	    
	    Random rand = new Random();
	    
	    int digit_5 = rand.nextInt(LL+(UL-LL+1));
	    
		digit_5 = generateRandomZip(00000, 99999);
		System.out.println("5 digit random number from function: " +digit_5);
		WebElement zipCodeWE = driver.findElement(By.id("zipcode"));
	    zipCodeWE.sendKeys(String.valueOf(digit_5));
	    
	    int lAge = 18;
		int uAge = 99;

		int age_2 = rand.nextInt(lAge+(uAge-lAge+1));
		age_2 = generateRandomAge(18,99);
		System.out.println("2 digit random number from function: " +age_2);
		WebElement ageWE = driver.findElement(By.id("age"));
		ageWE.sendKeys(String.valueOf(age_2));
		
		
		
		}
	
	
	public static String getDateOfBirth(int noofDays,String format)
	{
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, noofDays);
		Date d = cal.getTime();
		System.out.println("The Date and Time::" + d);
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		String formattedDate = sdf.format(d);
		System.out.println("Formatted Date::: " + formattedDate);
		return formattedDate;

	}

	public static String generateRandomState(String Str) {
		
		Random rand = new Random();
		int digit1 = 65+rand.nextInt((90-65+1));
		char upperCaseCh = (char) digit1;

		
		String randomState = Str+upperCaseCh;
		return randomState;	
		
}

	public static String generateRandomAddress(int n, String str) {
		
		Random rand = new Random();
		int digit1 = 65+rand.nextInt((90-65+1));
		char upperCaseCh = (char) digit1;
		
		int digit2 = 97+rand.nextInt((122-97+1));
		char lowerCaseCh = (char) digit2;
		
		String randomAddress = n+" "+upperCaseCh+lowerCaseCh+" "+str;
		return randomAddress;
		
	}
	
	public static int generateRandomZip(int LL, int UL){
	
	    Random rand = new Random();
		int digits = rand.nextInt(LL+(UL-LL+1));
		return digits;
}

public static int generateRandomAge(int lAge, int uAge){

		Random rand = new Random();
		int age = lAge+rand.nextInt((uAge-lAge+1));
		return age;		
}
}
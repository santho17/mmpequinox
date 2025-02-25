package org.iitwf.selenium.mmpequinox;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScheduleAppointment {
	
	static WebDriver driver = new ChromeDriver();

	public static void main(String[] args) throws InterruptedException {
	
		/* Formatted Date:::February/20/2025
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
		
		datepicker();
		
		//selecting the date Feb 20, 2025
//		driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr[4]/td[5]/a")).click();
//		Thread.sleep(2000);
//		//selecting the date Apr 20, 2025
//		driver.findElement(By.id("datepicker")).click();
//		driver.findElement(By.xpath("//div[@class='ui-datepicker-header ui-widget-header ui-helper-clearfix ui-corner-all']/a[2]")).click();
//		driver.findElement(By.xpath("//div[@class='ui-datepicker-header ui-widget-header ui-helper-clearfix ui-corner-all']/a[2]")).click();
//		driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr[4]/td[1]/a")).click();
		//selecting the Date Dec 18, 2026
		driver.findElement(By.id("datepicker")).click();
		//driver.findElement(By.xpath("//div[@class='ui-datepicker-header ui-widget-header ui-helper-clearfix ui-corner-all']/a[2]")).click();
		WebElement monthWE = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']"));
		WebElement yearWE = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']"));
		String month = monthWE.getText().trim();
		System.out.println("Print the month: " +month);
		String year = yearWE.getText().trim();
		System.out.println("Print the year: " +year);
		while(!(month.equals("December") && year.equals("2026"))) {		
			driver.findElement(By.xpath("//div[@class='ui-datepicker-header ui-widget-header ui-helper-clearfix ui-corner-all']/a[2]")).click();
			monthWE = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']"));
			month = monthWE.getText().trim();
			yearWE = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']"));
			year = yearWE.getText().trim();
		}
		if (month.equals("December")) {
			//System.out.println("Month is "+month);
			driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr[3]/td[6]/a")).click();
		}
		//selecting the date Feb 20, 2027
//		driver.findElement(By.id("datepicker")).click();
//		while((!year.equals("2026") && !month.equals("April"))) {
//			driver.findElement(By.xpath("//div[@class='ui-datepicker-header ui-widget-header ui-helper-clearfix ui-corner-all']/a[2]")).click();
//			driver.findElement(By.xpath("//span[@class='ui-datepicker-year']"));
//			yearWE.getText().trim();
//			driver.findElement(By.xpath("//div[@class='ui-datepicker-header ui-widget-header ui-helper-clearfix ui-corner-all']/a[2]")).click();
//			monthWE = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']"));
//			month = monthWE.getText().trim();
//		}
//		if(month.equals("April") && (year.equals("2026"))) {
//			driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr[4]/td[2]/a")).click();
//			
//		}
		
		
		
	}
	
	//public static String generateAppointment(int n, String format) {
		
		
		
		
		
	//}
	
	public static void datepicker() {
		driver.manage().window().maximize();
		driver.get("http://85.209.95.122/MMP-Release2-Integrated-Build.6.8.000/portal/login.php");
		driver.findElement(By.id("username")).sendKeys("ria1");
		driver.findElement(By.id("password")).sendKeys("Ria12345");
		driver.findElement(By.name("submit")).click();
		driver.findElement(By.xpath("//div[@class='sidebar-holder']/ul/li[4]/a")).click();
		driver.findElement(By.xpath("//input[@value='Create new appointment']")).click();
		driver.findElement(By.id("opener")).click();
		driver.switchTo().frame("myframe");
		driver.findElement(By.id("datepicker")).click();
	}

}

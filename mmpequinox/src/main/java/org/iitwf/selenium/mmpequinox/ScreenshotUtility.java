package org.iitwf.selenium.mmpequinox;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtility {
	
	WebDriver driver;
	
	public ScreenshotUtility(WebDriver driver) {
		
		this.driver = driver;
		
	}
	
	public String captureScreenshot(String FileName) throws IOException {
		
		String timeStamp = new SimpleDateFormat("yyyy-mm-dd_HH-mm-ss").format(new Date());
		
		//Take screenshot
		TakesScreenshot ts = (TakesScreenshot)driver;
		
		//Capture screenshot and store it as a file
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
		
		String filePath = System.getProperty("user.dir")+"/screenshots/"+FileName+"_"+timeStamp+".png";
		
	    //Copy the screenshot to the specified location
		FileUtils.copyFile(srcFile, new File(filePath));
		
		return filePath;
		
		
	}

}

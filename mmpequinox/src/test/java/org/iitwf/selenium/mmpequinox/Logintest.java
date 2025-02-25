package org.iitwf.selenium.mmpequinox;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Logintest extends FrameworkLibrary {
//	id="username"
//	id="password"
//	name="submit"
//	//h3[normalize-space()='Patient Portal']
//
//	String expectedText = "Patient Portal";
	
@DataProvider(name="DP")	
public String[][] feedData() throws IOException {
	
	String inputData[][] = ExcelUtils.getCellData("mmpdata.xlsx");
	return inputData;
}

	
@Test(dataProvider="DP")
public void testLogin(String username, String password)
{
	MMPUtility mmputil = new MMPUtility(driver);
	mmputil.login(username, password);
	String actualText = driver.findElement(By.xpath("//h3[normalize-space()='Patient Portal']")).getText();
	String expectedText = "Patient Portal";
	Assert.assertEquals(actualText, expectedText);
	launchBrowser(prop.getProperty("patient_url"));

}

}

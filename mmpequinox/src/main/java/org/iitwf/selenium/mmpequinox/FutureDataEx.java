package org.iitwf.selenium.mmpequinox;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class FutureDataEx {
	
	public static void main(String[] args) 
	{
		getFutureDate(0,"dd/MM/YYYY HH:MM:SS");
		getFutureDate(5,"dd/MMM/YYYY");
		getFutureDate(60,"dd/MMMM/YYYY");
		
	}
	public static String getFutureDate(int noofDays,String format)
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

}

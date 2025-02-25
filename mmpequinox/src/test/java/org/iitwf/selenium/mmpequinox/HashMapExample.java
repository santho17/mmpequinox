package org.iitwf.selenium.mmpequinox;

import java.util.HashMap;
import java.util.Set;

public class HashMapExample {

	public static void main(String[] args) {
	
		HashMap<String,Integer> marksHmap = new HashMap<String,Integer>();
		marksHmap.put("John", 82);
		marksHmap.put("Bose", 72);
		marksHmap.put("Mike", 89);
		
		System.out.println(marksHmap.size());
		
		System.out.println(marksHmap.get("John"));
		
		System.out.println(marksHmap);
		
		//Print all the values of HashMap
		Set<String> keys = marksHmap.keySet();
		
		for(String studentName: keys) {
			
			Integer marks = marksHmap.get(studentName);
			System.out.println("Student Name :" + studentName +"::"+ "Marks Value : " + marks);
			
			
		}

	}

}

package com.practice;

import com.holidaygurutravel.genericUtility.WebDriverUtility;

public class callGenericUtility {
	public static void main(String[] args) {
		
//		JavaUtility javaUtility=new JavaUtility();
//		 int i = (Integer)javaUtility.stringToAnyDataType("1234", "int");
//		 
//		 System.out.println(i);
		 
		 WebDriverUtility webdriverUtility=new WebDriverUtility();
		  String date = webdriverUtility.getDate();
		  System.out.println(date);
		
	}

}

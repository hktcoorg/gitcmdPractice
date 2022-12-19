package com.holidaygurutravel.genericUtility;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Date;
import java.util.Locale;
import java.util.Random;
/**
 * This class is used to conversion of values 
 * @author THRINESH
 *
 */
public class JavaUtility {

	//	public long stringToLong(String s)
	//		//long convertData = Long.parseLong(s); //if it is a single statement we use direct return
	//		{
	//			return Long.parseLong(s);
	//		}

	/**
	 * conversion
	 * @param s
	 * @param strategy
	 * @return
	 */
	public Object stringToAnyDataType(String s, String strategy)
	//long convertData = Long.parseLong(s); //if it is a single statement we use direct return
	{	
		Object convertData = null;

		if(strategy.equals("int"))
		{
			convertData=Integer.parseInt(s);
		}
		else if(strategy.equals("long"))
		{
			convertData=Long.parseLong(s);		//call object in another class check it
		}
		return convertData;
	}

	/**
	 * This method is used to getRamdom number
	 * in limit pass parameter integer num of digits
	 * @param limit
	 * @return
	 */
	public int gertRandomNumber(int limit)
	{
		int randomNumber=new Random().nextInt(limit);
		return randomNumber;
	}

	public String[] splitSting(String s, String strategy)
	{
		return s.split(strategy);
	}


	/**
	 * This method is convert string to int of month
	 * @param s
	 * @return
	 */
	public int getMonthInMMFormat(String s)
	{
		return DateTimeFormatter.ofPattern("MMMM")
				.withLocale(Locale.ENGLISH)
				.parse(s)
				.get(ChronoField.MONTH_OF_YEAR);
	}

	
	/**
	 * This method is used to get sys date
	 * @return
	 */
	public String getDateTime()
	{
		Date d=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("dd_MM_YYYY_HH_mm_sss");  //for mili sec--sss
		String d2=sdf.format(d);
		return d2;
	}

}

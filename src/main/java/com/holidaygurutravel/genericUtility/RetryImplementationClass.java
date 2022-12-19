package com.holidaygurutravel.genericUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryImplementationClass implements IRetryAnalyzer //it is functional interface only on interface
{
	int count=0;
	int retryLimit=3; //global declare

	@Override
	public boolean retry(ITestResult result) 
	{
		if(count<retryLimit)
		{
			count++;
			return true;
		}
		return false;
	}
	
	
}

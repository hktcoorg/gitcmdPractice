package com.testNGpractice;

import org.testng.annotations.Test;

public class Cmdprompt {
	
	@Test
	public void FetchDataFromCMDprompt() 
	{
		
		String url=System.getProperty("url");
		String userName=System.getProperty("userName");
		String userPassword=System.getProperty("userPassword");
		
		System.out.println("url is ------>"+url);
		System.out.println("userName is ------>"+userName);
		System.out.println("userPassword is ------>"+userPassword);
	}

}

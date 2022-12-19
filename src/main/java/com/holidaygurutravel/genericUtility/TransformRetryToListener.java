package com.holidaygurutravel.genericUtility;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.IConfigurationAnnotation;
import org.testng.annotations.ITestAnnotation;


/**
 * This is covert parameter of reterAnalyser to Litener to pass in xml file
 * @author THRINESH
 *
 */
public class TransformRetryToListener implements IAnnotationTransformer
{

	@Override
	public void transform(ITestAnnotation arg0, Class arg1, Constructor arg2, Method arg3) 
	{
		arg0.setRetryAnalyzer(com.holidaygurutravel.genericUtility.RetryImplementationClass.class);
	}




	}

	


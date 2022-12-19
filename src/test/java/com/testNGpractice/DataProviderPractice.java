package com.testNGpractice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class DataProviderPractice {
	
	@Test(dataProvider="getData")
	public void dataProTest(String city, int pincode) 
	{
		System.out.println("CityName-------->"+city+"-----Pincode------>"+pincode);
		
	}
	//if specify name will take or it will take getdata method name by default
	
	
	 @DataProvider  //@DataProvider(name="getdata")
	public Object[][] getData()    //row and column fetching so 2 dimensional array
	{
		Object[][] arr=new Object[4][2];

				arr[0][0]="Bangalore";   
				arr[0][1]=560058;
				
				arr[1][0]="Mandya";
				arr[1][1]=573201;
				
				arr[2][0]="Kodagu";
				arr[2][1]=571232;
				
				arr[3][0]="vizag";
				arr[3][1]=530013;
				
				return arr;
	}
	
	
	@DataProvider
	public String[][] getDataExcelDP() throws EncryptedDocumentException, IOException
	{
		
		FileInputStream fis=new FileInputStream("./src/test/resources/exceldata.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet("dataprovider");
		
		int LastRowNum = sheet.getLastRowNum(); //index
		short lastCellNum = sheet.getRow(0).getLastCellNum(); //count/ size==1
		
		String[][] arr=new String[LastRowNum][lastCellNum];
	
//initialization
		for(int i=0; i<LastRowNum; i++)
		{
			for (int j=0; j<lastCellNum; j++)
			{
				arr[i][j]=sheet.getRow(i+1).getCell(j).toString();
			}
		}	

//utilization
		
		for(int i=0; i<arr.length; i++)
		{
			for (int j=0; j<arr[i].length; j++)
			{
				System.out.println(arr[i][j]);
			}
		}
		return arr;                          //make it generic
	}
	
	
	@Test(dataProvider="getDataExcelDP")
	public void dataProTest1(String username, String password)
	{
		System.out.println("username-------->"+username+"-----password------>"+password);
		
		Reporter.log("Test pass"); //in both console and report enter, true
	}
	
	//Generic of DataProvider
	/**
	 * This method is used to fetch multiple data from excel and dataprovider
	 * @param sheetName
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String [][] getDataFromExcel(String sheetName) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream("./src/test/resources/orange.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet(sheetName);
		int lastRowNum = sheet.getLastRowNum();
		short lastCellNum = sheet.getRow(0).getLastCellNum();
		
		String[][] arr=new String[lastRowNum][lastCellNum];
		
		for(int i=0; i<lastRowNum; i++)
		{
			for(int j=0; j<lastCellNum; j++)
			{
				DataFormatter df=new DataFormatter();
				arr[i][j]=df.formatCellValue(sheet.getRow(i+1).getCell(j));
			}
		}
		return arr;
	}
	
}

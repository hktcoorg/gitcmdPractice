package com.practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchcelldataVerify {
	
	public static void main(String[] args) throws IOException {
		
		FileInputStream fis=new FileInputStream("./src/test/resources/exceldata.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet("admin_testdata");
		
		int LastRowNum = sheet.getLastRowNum(); //index
		short lastCellNum = sheet.getRow(0).getLastCellNum(); //count/ size==1
		
		System.out.println(LastRowNum); //num of rows 58
		System.out.println(lastCellNum); //all 58 rows in 1st coulmn(size())
		
		String expectedKey="Admin user name";
		String expectedTestdata ="admin";
		
		String value=null;
		for (int i=0; i<=LastRowNum; i++)
		{
			String actualKey = sheet.getRow(i).getCell(0).getStringCellValue();
			if(actualKey.equals(expectedKey))
			{
				for (int j=1; j<lastCellNum-1; j++) 
				{

					String actualTestdata=sheet.getRow(i).getCell(j).getStringCellValue();
					if (actualTestdata.equals(expectedTestdata))
					{
						value = sheet.getRow(i+1).getCell(j).getStringCellValue();
						break;
					}
				}
				break;
				
			}
		}
		System.out.println(value);
		
		
	}

}

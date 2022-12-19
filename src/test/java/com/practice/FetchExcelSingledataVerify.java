package com.practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchExcelSingledataVerify {
	
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./src/test/resources/exceldata.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet("admin_testdata");
		
		int LastRowNum = sheet.getLastRowNum(); //index
		short lastCellNum = sheet.getRow(0).getLastCellNum(); //count/ size==1
		
		System.out.println(LastRowNum); //num of rows 58
		System.out.println(lastCellNum); //all 58 rows in 1st coulmn(size())
		
		String expectedKey="Admin user name";
		
		String userName=null;
		String password=null;
		for (int i=0; i<=LastRowNum; i++)
		{
			String actualKey = sheet.getRow(i).getCell(0).getStringCellValue();
			if(actualKey.equals(expectedKey))
			{
				userName=sheet.getRow(i).getCell(2).getStringCellValue();
				password=sheet.getRow(i+1).getCell(2).getStringCellValue();
				break;
			}
		}
		System.out.println(userName);
		System.out.println(password);
	}
}

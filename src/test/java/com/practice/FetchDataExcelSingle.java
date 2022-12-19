package com.practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchDataExcelSingle {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {


		FileInputStream fis=new FileInputStream("./src/test/resources/exceldata.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		try
		{
		Sheet sheet = workbook.getSheet("admin_testdata");
		Row row = sheet.getRow(6);
		Cell cell = row.getCell(3);
		String data = cell.getStringCellValue();
		System.out.println(data);
		
		DataFormatter df=new DataFormatter();
		String value = df.formatCellValue(cell);
		System.out.println(value);
		}
		finally
		{
			fis.close();
			System.out.println("Work book closed");
		}



	}
}
package com.practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class CreateDtaExcelSingle {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {

		FileInputStream fis=new FileInputStream("./src/test/resources/exceldata.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet("admin_testdata");
		Row row = sheet.getRow(6);
		Cell cell = row.getCell(2); //it will set value for existing cell
									// if we create new cell we use create cell
												
		cell.setCellValue("Test@123");
		
		FileOutputStream fos=new FileOutputStream("./src/test/resources/exceldata.xlsx");
		book.write(fos);
		fis.close();
		System.out.println("data updated successfully");
	}
}


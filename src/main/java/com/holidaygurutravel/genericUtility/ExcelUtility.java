package com.holidaygurutravel.genericUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class is contains Excel Reusable methods
 * @author THRINESH
 *
 */
public class ExcelUtility {
	private FileInputStream fisExcel;
	private FileOutputStream fio;
	public Workbook workbook;
	private DataFormatter df;

	Sheet sheet;
	public String currentPassword;
	public String expectedCurrentPassword;
	String newPassword;
	String confirmPassword;

	/**
	 * This method initialize the workbook
	 * @param excelPath
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public void openExcel(String excelPath) throws EncryptedDocumentException, IOException
	{
		fisExcel=new FileInputStream(excelPath);
		workbook = WorkbookFactory.create(fisExcel);
		df=new DataFormatter();
	}
	
	/**
	 *  This method is used to fetch the data from excel using row and cell index
	 * @param sheetName
	 * @param rowNumber
	 * @param cellNumber
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String getDataFromExcel(String sheetName, int rowNumber, int cellNumber) throws EncryptedDocumentException, IOException
	{
		String data=df.formatCellValue(workbook.getSheet(sheetName).getRow(rowNumber).getCell(cellNumber));
		return data;
	}

	/**
	 * First openExcel method call
	 * This method use to get the sheet od Excel forLastRowNumber
	 * @param sheetNameForLastRowNum
	 * @return
	 */
	public Sheet sheetForLastRowNumber(String sheetNameForLastRowNum)
	{
		Sheet sheet = workbook.getSheet(sheetNameForLastRowNum);
		return sheet;
	}
	
	
	/**
	 * Before perform sheetLastRowNumber() method 
	 * This method is created for Avoid nullPointer exception
	 * @param excelPath
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public void setDataToExcel(String excelPath, String sheetName, int rowNumber, int cellNumber, String data) throws IOException
	{
		workbook.getSheet(sheetName).getRow(rowNumber).createCell(cellNumber).setCellValue(data);
		fio=new FileOutputStream(excelPath);
	}
	
	/**
	 * Save file or corrupt the file so save method
	 * @throws IOException
	 */
	
	public void saveDataToExcel() throws IOException 
	{
		workbook.write(fio);
	}
	
	
	
	/**
	 * This method is used to get currentPassword from the excel
	 *it will open the excel and find ith row and same row value fetch by cell number
	 * @param expectedCurrentPassword
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String ifCurrentPassword(String expectedCurrentPassword) throws EncryptedDocumentException, IOException
	{
		openExcel(IConstantPath.EXCEL_PATH);
		sheet=sheetForLastRowNumber(SheetName.USER_TESTDATA.convertToString());
			//workbook.getSheet(sheetName);
		for(int i=0; i<=sheet.getLastRowNum(); i++)
		{
			String actualCurrentPassword=getDataFromExcel(SheetName.USER_TESTDATA.convertToString(), i, 0);
										//df.formatCellValue(workbook.getSheet(sheetName).getRow(rowNumber).getCell(cellNumber));		
			if(actualCurrentPassword.equals(expectedCurrentPassword))
			{
				currentPassword=getDataFromExcel(SheetName.USER_TESTDATA.convertToString(), i, 2);
				break;
			}
		}
		return currentPassword;
	}
	
	/**
	 * This method is used to get newPassword from the excel
	 *it will open the excel and find i th row and same row value fetch by cell number
	 * @param expectedNewPassword
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	
	public String ifNewPassword(String expectedNewPassword) throws EncryptedDocumentException, IOException
	{
		
		openExcel(IConstantPath.EXCEL_PATH);
		sheet=sheetForLastRowNumber(SheetName.USER_TESTDATA.convertToString());
		for(int i=0; i<=sheet.getLastRowNum(); i++)
		{
			String actualNewPassword=getDataFromExcel(SheetName.USER_TESTDATA.convertToString(), i, 0);
			if(actualNewPassword.equals(expectedNewPassword))
			{
				newPassword=getDataFromExcel(SheetName.USER_TESTDATA.convertToString(), i, 2);
				break;
			}
		}
		return newPassword;
	}
	
	/**
	 * This method is used to get confirmPassword from the excel
	 *it will open the excel and find i th row and same row value fetch by cell number
	 * @param expectedConfirmPassword
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String ifConfirmPassword(String expectedConfirmPassword) throws EncryptedDocumentException, IOException
	{
		openExcel(IConstantPath.EXCEL_PATH);
		sheet=sheetForLastRowNumber(SheetName.USER_TESTDATA.convertToString());
		for(int i=0; i<=sheet.getLastRowNum(); i++)
		{
			String actualNewPassword=getDataFromExcel(SheetName.USER_TESTDATA.convertToString(), i, 0);
			if(actualNewPassword.equals(expectedConfirmPassword))
			{
				confirmPassword=getDataFromExcel(SheetName.USER_TESTDATA.convertToString(), i, 2);
				break;
			}
		}
		return confirmPassword;
	}
	

	/**
	 * This method is used to close the workbook and Excel
	 * @throws IOException
	 */
	public void closeExcel() throws IOException
	{
		workbook.close();
		fisExcel.close();
	}
	



}

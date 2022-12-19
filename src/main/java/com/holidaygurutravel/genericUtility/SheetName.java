package com.holidaygurutravel.genericUtility;
/**
 * This enum is used to specify the sheetName of Excel
 * @author THRINESH
 *
 */
public enum SheetName {
	/**
	 * Specify all sheet names and enter Proper sheet name in value
	 */
	USER_TESTDATA("user_testdata"), ADMIN_TESTDATA("admin_testdata");
	
	private String sheetName;
	
	/**
	 * setter constructor
	 * @param sheetName
	 */
	private SheetName(String sheetName)
	{
		this.sheetName=sheetName;
	}
	
	/**
	 * getter
	 * @return
	 */
	public String convertToString()
	{
		return sheetName.toString();
	}

}

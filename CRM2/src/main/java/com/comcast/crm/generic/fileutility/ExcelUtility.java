package com.comcast.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	
	public String getDataFromExcel(String sheetName, int rowNum, int cellNum) throws IOException {
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\GenericUtilityTestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		return wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).toString();
	}
	
	public int getRowCount(String sheetName) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\GenericUtilityTestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		return wb.getSheet(sheetName).getLastRowNum();
	}
	
	public void setDataToExcel(String sheetName, int rowNum, int cellNum, String data) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\GenericUtilityTestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);

	    // Get the sheet by its name
	   Sheet sheet = wb.getSheet(sheetName);

	    // If the row does not exist, create it
	    Row row = sheet.getRow(rowNum);
	    if (row == null) {
	        row = sheet.createRow(rowNum);
	    }

	    // If the cell does not exist, create it
	    Cell cell = row.getCell(cellNum);
	    if (cell == null) {
	        cell = row.createCell(cellNum);
	    }

	    // Set the value of the cell
	    cell.setCellValue(data);

	    // Close the FileInputStream as it is no longer needed
	    fis.close();

	    // Create a FileOutputStream to save the changes
	    FileOutputStream fos = new FileOutputStream(".\\src\\test\\resources\\GenericUtilityTestData.xlsx");

	    // Write the changes back to the file
	    wb.write(fos);

	    // Close the FileOutputStream
	    fos.close();

	    // Close the workbook
	    wb.close();
	}
}

package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelOperations {
	public static XSSFSheet excelWorkSheet;
	public static XSSFWorkbook excelWorkBook;
	public static XSSFCell excelCell;
	public static XSSFRow excelRow;
	
	//This method is to set the File path and to open the Excel file, Pass Excel Path and Sheet Name as Arguments to this method
	public static void setExcelFile() throws Exception{
		try{
			//Open Excel File
			FileInputStream excelFile = new FileInputStream(Constants.ExcelTestDataFilePath + Constants.ExcelTestDataFileName);
			
			//Access the required test data sheet
			excelWorkBook = new XSSFWorkbook(excelFile);
			
			Log.info("Excel Sheet Opened Successfully !");
		}
		catch(Exception e){
			throw(e);
		}
	}
	
	//This method is to read the test data from the Excel cell, in this we are passing parameters as Row Number and Column Number
	public static String getCellData(int iRowNum, int iColNum) throws Exception{
		try{
			excelWorkSheet = excelWorkBook.getSheet(Constants.currentActiveSheet);
			
			excelCell = excelWorkSheet.getRow(iRowNum).getCell(iColNum);
			String sCellData = excelCell.getStringCellValue();
			
			return sCellData;
		}
		catch (Exception e){
			throw(e);
		}
	}
	
	//This method is to write in the Excel cell, Row Number and Column Number are the parameters
	@SuppressWarnings("static-access")
	public static void setCellData(String sResult, int iRowNum, int iColNum) throws Exception{
		try{
			excelWorkSheet = excelWorkBook.getSheet(Constants.currentActiveSheet);
			
			excelRow = excelWorkSheet.getRow(iRowNum);
			excelCell = excelRow.getCell(iColNum, excelRow.RETURN_BLANK_AS_NULL);
			
			if(excelCell == null){
				excelCell = excelRow.createCell(iColNum);
				excelCell.setCellValue(sResult);
			}
			else{
				excelCell.setCellValue(sResult);
			}
		}
		catch (Exception e){
			throw(e);
		}
	}
	
	public static int getRowContains(String sTestCaseName, int iColNum) throws Exception{	 
		int iCounter;
		try{
			int rowCount = ExcelOperations.getRowUsed();
			for(iCounter=0 ; iCounter<=rowCount; iCounter++){
				if(ExcelOperations.getCellData(iCounter,iColNum).equalsIgnoreCase(sTestCaseName)){
					break;
				}
			}

			return iCounter;
		}
		catch (Exception e){
			throw(e);
		}
	}
	
	public static int getRowUsed() throws Exception{	 
		try{
			excelWorkSheet = excelWorkBook.getSheet(Constants.currentActiveSheet);
			
			int iRowCount = excelWorkSheet.getLastRowNum();
			Log.info("Total number of Row used return as " + iRowCount);		

			return iRowCount;
		}
		catch (Exception e){
			throw (e);
		}
	}
	
	public static int getColumnUsed(){
		try{
			excelWorkSheet = excelWorkBook.getSheet(Constants.currentActiveSheet);
			
			int iColumnCount = excelWorkSheet.getRow(0).getLastCellNum();
			
			return iColumnCount;
		}
		catch (Exception e){
			throw (e);
		}
	}
	
	public static void closeExcelFile() throws Exception{
		try{
            FileOutputStream fileOut = new FileOutputStream(Constants.ExcelTestDataFilePath + Constants.ExcelTestDataFileName);
            excelWorkBook.write(fileOut);
          	fileOut.close();
          	Log.info("Excel file closed successfully !");
		}
		catch(Exception e){
			throw (e);
		}
	}
	
	public static String fileData(String ColumnName, int iRowNo) throws Exception{
		
		int iColumns = ExcelOperations.getColumnUsed();
		
		String excelColumnName;
		int excelColumnNo = 0;
		String data = null;
		
		for(int iCounter=0; iCounter<iColumns; iCounter++){
			excelColumnName = ExcelOperations.getCellData(0, iCounter);
			if(excelColumnName.equalsIgnoreCase(ColumnName)){
				excelColumnNo = iCounter;
				Constants.iColumnNo = excelColumnNo;
				break;
			}
			else if(iCounter == iColumns-1){
				Log.error("No such column name : " + ColumnName + " found in excel sheet : " + Constants.currentActiveSheet + " !");
			}
		}
		
		data = ExcelOperations.getCellData(iRowNo, excelColumnNo);
				
		return data;
	}
}

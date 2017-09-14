package testNG;

import java.lang.reflect.Method;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import testFunctions.FunctionsLibrary;
import utilities.Constants;
import utilities.ExcelOperations;

public class MainTest {
	@BeforeClass
	public void beforeClass() throws Exception{
		FunctionsLibrary.initializeLog4J();
		ExcelOperations.setExcelFile();
	}
	
	@Test(priority=0)
	public void executeTestCases() throws Exception{
		Constants.currentActiveSheet = "ExecutionDriver";
		
		int iExecutionDriverRows = ExcelOperations.getRowUsed();
		String ExecutionFlag, eTestCaseID, tTestCaseID, TestFunction;
		
		FunctionsLibrary FL = new FunctionsLibrary();
		
		for(int iCounter=1; iCounter<=iExecutionDriverRows; iCounter++){
			Constants.currentActiveSheet = "ExecutionDriver";
			
			ExecutionFlag = ExcelOperations.fileData("ExecutionFlag", iCounter);
			
			if(ExecutionFlag.equalsIgnoreCase("Yes")){
				eTestCaseID = ExcelOperations.fileData("TestCaseID", iCounter);
				
				Constants.currentActiveSheet = "TestCases";
				int iTestCasesRows = ExcelOperations.getRowUsed();
				
				for(int jCounter=1; jCounter<=iTestCasesRows; jCounter++){
					tTestCaseID = ExcelOperations.fileData("TestCaseID", jCounter);
					
					if(eTestCaseID.equalsIgnoreCase(tTestCaseID)){
						Constants.iCurrentRowNo = jCounter;
						TestFunction = ExcelOperations.fileData("TestFunctions", jCounter);
						Method method = FunctionsLibrary.class.getDeclaredMethod(TestFunction);
						method.invoke(FL);
					}
				}
			}
		}
	}


	@AfterClass
	public void closeBrowser() throws Exception{
		//FunctionsLibrary.closeBrowser();
		ExcelOperations.closeExcelFile();
	}
}

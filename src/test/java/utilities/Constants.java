package utilities;

//All the constants/static properties are defined here
public class Constants {
	public static final String ExcelTestDataFilePath = System.getProperty("user.dir")+"\\src\\test\\java\\testData\\";
	public static final String ExcelTestDataFileName = "TestCases.xlsx";
	public static final String ExcelDriverSheetName = "ExecutionDriver";
	public static final String ExcelTestCasesSheetName = "TestCases";
	public static String currentActiveSheet;
	public static int iCurrentRowNo = 0;
	public static int iColumnNo;
	public static String appValue;
	public static final String ScreenshotPath = System.getProperty("user.dir")+"\\src\\test\\java\\testOutput\\";
	public static final String BrowserName = "Mozilla";
	public static final String URL = "https://www.transavia.com/en-NL/home/";
}

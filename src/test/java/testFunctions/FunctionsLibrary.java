package testFunctions;

import java.io.File;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import operations.UIOperations;
import utilities.Constants;

public class FunctionsLibrary {
	
	static WebDriver driver;
	static UIOperations operation = new UIOperations();
	
	static String value;
	static boolean bValue;
	
	public static void initializeLog4J() throws Exception{
		File log4jfile = new File("./src/main/resources/log4j.properties");
		PropertyConfigurator.configure(log4jfile.getAbsolutePath());
	}
	
	public static void openBrowser() throws Exception{
		driver = UIOperations.selectBrowser(Constants.BrowserName);
		value = operation.perform(driver, "GoToURL", null, null, Constants.URL, 0);
		Thread.sleep(2000);			
	}
	
	public static void validateForm() throws Exception{
		//Transavia Home Page
		value = operation.perform(driver, "ElementExists", "SearchFormTitle", "XPATH", null, 0);
		bValue = operation.checkCondition(value, "True", "Transavia Home page opened successfully !", "Issue while opening Transavia Home Page !");
		Assert.assertTrue(bValue);
		Thread.sleep(3000);
		value = operation.perform(driver, "ElementExists", "From", "XPATH", null, 0);
		value = operation.perform(driver, "ElementExists", "Departure", "XPATH", null, 0);
		value = operation.perform(driver, "ElementExists", "To", "XPATH", null, 0);
		value = operation.perform(driver, "ElementExists", "Destination", "XPATH", null, 0);
		value = operation.perform(driver, "ElementExists", "DepartOn", "XPATH", null, 0);
		
		value = operation.perform(driver, "ElementExists", "txtReturnOn", "XPATH", null, 0);
		value = operation.perform(driver, "ElementExists", "DateDepartOn", "XPATH", null, 0);
		value = operation.perform(driver, "ElementExists", "DateReturnOn", "XPATH", null, 0);
		
		value = operation.perform(driver, "ElementExists", "WhoWillBeTravelling", "XPATH", null, 0);
		value = operation.perform(driver, "ElementExists", "Travellers", "XPATH", null, 0);
		value = operation.perform(driver, "ElementExists", "txtShowBlueMiles", "XPATH", null, 0);
		}
	
	public static void validatePlanBook() throws Exception{
		//Plan and Book links
		value = operation.perform(driver, "CLick", "Plan&Book", "XPATH", null, 0);
		value = operation.perform(driver, "ElementExists", "Plan&Book", "XPATH", null, 0);
		value = operation.perform(driver, "ElementExists", "BookFlightLink", "XPATH", null, 0);
		value = operation.perform(driver, "ElementExists", "BookHotelLink", "XPATH", null, 0);
		value = operation.perform(driver, "ElementExists", "RentCarLink", "XPATH", null, 0);
		value = operation.perform(driver, "ElementExists", "ViewOffers", "XPATH", null, 0);
		value = operation.perform(driver, "ElementExists", "BookCityTrip", "XPATH", null, 0);
		value = operation.perform(driver, "ElementExists", "BookTransfer", "XPATH", null, 0);
		value = operation.perform(driver, "ElementExists", "BookParkingSlot", "XPATH", null, 0);
		value = operation.perform(driver, "ElementExists", "BookBusinessTrip", "XPATH", null, 0);
		value = operation.perform(driver, "ElementExists", "BookFlyingBlueMiles", "XPATH", null, 0);
		value = operation.perform(driver, "ElementExists", "ViewDestinations", "XPATH", null, 0);
		value = operation.perform(driver, "ElementExists", "AdvanceSerach", "XPATH", null, 0);
		}
		
		public static void validateManageBooking() throws Exception{
		value = operation.perform(driver, "CLick", "ManageBooking", "XPATH", null, 0);
		value = operation.perform(driver, "ElementExists", "ManageBooking", "XPATH", null, 0);
		value = operation.perform(driver, "ElementExists", "OnlineCheckIn", "XPATH", null, 0);
		value = operation.perform(driver, "ElementExists", "ViewyourBooking", "XPATH", null, 0);
		}
		
		
		public static void validateService() throws Exception{
		value = operation.perform(driver, "Click", "Service", "XPATH", null, 0);
		value = operation.perform(driver, "ElementExists", "Service", "XPATH", null, 0);
		value = operation.perform(driver, "ElementExists", "Service&Information", "XPATH", null, 0);
		value = operation.perform(driver, "ElementExists", "CustomerService", "XPATH", null, 0);
		value = operation.perform(driver, "ElementExists", "FAQs", "XPATH", null, 0);
		value = operation.perform(driver, "Click", "Service", "XPATH", null, 0);
		}
		
		
		public static void validateIcons() throws Exception{
		value = operation.perform(driver, "ElementExists", "Facebook", "XPATH", null, 0);
		value = operation.perform(driver, "ElementExists", "Twitter", "XPATH", null, 0);
		value = operation.perform(driver, "ElementExists", "Instagram", "XPATH", null, 0);
		value = operation.perform(driver, "ElementExists", "Whatsapp", "XPATH", null, 0);
		value = operation.perform(driver, "ElementExists", "YouTube", "XPATH", null, 0);
		value = operation.perform(driver, "ElementExists", "GooglePlus", "XPATH", null, 0);
		}
	
	public static void enterData() throws Exception{
		value = operation.perform(driver,  "SetText", "Departure" ,"XPATH" , "DestinationFROM", 1);
		value = operation.perform(driver,  "SetText", "Destination" ,"XPATH" , "DestinationTO", 1);
	
		value = operation.perform(driver,  "Clear", "DateDepartOn" ,"XPATH" , null, 0);
		value = operation.perform(driver,  "SetText", "DateDepartOn" ,"XPATH" , "DepartOn", 1);
		
		value = operation.perform(driver,  "Clear", "DateReturnOn" ,"XPATH" , null, 0);
		value = operation.perform(driver,  "SetText", "DateReturnOn" ,"XPATH" , "ReturnON", 1);	
		
		value = operation.perform(driver,  "Click", "Travellers" ,"XPATH" , null , 0);
	
		value = operation.perform(driver,  "Click", "Submit" ,"XPATH" , null , 0);
		
	}
	
	public static void closeBrowser() throws Exception{
		value = operation.perform(driver, "CloseBrowser", null, null, null, 0);
	}

}


package Core;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class keywords extends util{

	public void getURL(WebDriver driver, ExtentTest test, String data){
		
		try{
			driver.get(data);
			test.log(LogStatus.PASS, "Navigated to the URL: "+data);
		}
		catch(Exception e){
			test.log(LogStatus.PASS, "Unable to navigate to the URL: "+data);
			throw e;
		}
		
	}
	
}

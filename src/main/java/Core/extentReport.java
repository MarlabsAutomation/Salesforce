package Core;

import io.appium.java_client.AppiumDriver;

import java.io.File;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;

import com.relevantcodes.extentreports.ExtentReports;

public class extentReport {
	
	 static String reportLocation = System.getProperty("user.dir")+"\\src\\Reports\\";
	    static String imageLocation = "images/";
	    	
	public static void startReport(String driver, ITestContext context){
		
		
		String name = null;
		if(driver.toString().contains("IE")){
			name = "IE";
			ExtentReports extent = new ExtentReports(reportLocation+name+"Report.html", true);
			context.setAttribute(name, extent);
		}
		if(driver.toString().contains("Chrome")){
			name = "Chrome";
			ExtentReports extent = new ExtentReports(reportLocation+name+"Report.html", true);
			context.setAttribute(name, extent);
		}
		if(driver.toString().contains("Firefox")){
			name = "Firefox";
			ExtentReports extent = new ExtentReports(reportLocation+name+"Report.html", true);
			context.setAttribute(name, extent);
		}
		if(driver.toString().contains("Android")){
			name = "Android";
			ExtentReports extent = new ExtentReports(reportLocation+name+"Report.html", true);
			context.setAttribute(name, extent);
		}
		//extent = new ExtentReports(reportLocation+name+"Report.html", true);
			
		//context.setAttribute(name, extent);
		
		System.out.println("Report created: "+driver+" Location: "+reportLocation+name+"Report.html");
		
	}
	 	
	//Take scrennshot
	public static String createScreenshot(WebDriver driver) {
	   	 
        UUID uuid = UUID.randomUUID();
     
        // generate screenshot as a file object
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            // copy file object to designated location
            FileUtils.copyFile(scrFile, new File(reportLocation + imageLocation + uuid + ".png"));
            
        } catch (Exception e) {
            System.out.println("Error while generating screenshot:\n" + e.toString());
        }
        return reportLocation + imageLocation + uuid + ".png";
    }
}

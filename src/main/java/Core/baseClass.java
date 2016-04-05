package Core;

import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.relevantcodes.extentreports.ExtentReports;

public class baseClass extends util{
	
	
	@Parameters ({"browser"})
  @BeforeTest
  public void initialise(String browser, ITestContext context) {
	
	String driver = browser;
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
	
	
	 System.out.println("This is from the Before suite");
  }
  	
  @AfterTest
  public void cleanUP(ITestContext context) {
	 ExtentReports extent;
	 String bname = getDriver().toString();
	 	
	 extent = getExtent(bname, context);
	 
	 extent.flush();
	 System.out.println("This is from the After suite - cleanup");
	  
  }
}

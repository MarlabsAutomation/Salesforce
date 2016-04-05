package Core;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.relevantcodes.extentreports.ExtentReports;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;

public class util extends extentReport{
  
	protected ThreadLocal<RemoteWebDriver> threadDriver = null;
		
	@SuppressWarnings("rawtypes")
	AppiumDriver drv = null;
	
	@SuppressWarnings("rawtypes")
	@Parameters ({"browser"})
	@BeforeMethod 
	public void setUP(String browser) throws MalformedURLException {
	
	System.out.println("Browser name: "+browser);
	threadDriver = new ThreadLocal<RemoteWebDriver>();
			
	DesiredCapabilities cap = new DesiredCapabilities();
	cap.setPlatform(org.openqa.selenium.Platform.WINDOWS);
	
	//Browser initialization
	if(browser.equals("Firefox")){
		cap = DesiredCapabilities.firefox();
		
	}
	
	if(browser.equals("IE")){
		cap = DesiredCapabilities.internetExplorer();
		
	}
	
	if(browser.equals("Chrome")){
		cap = DesiredCapabilities.chrome();
		
	}
	
	if(browser.equals("Android")){
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("device", "Android");
		capabilities.setCapability("VERSION", "5.2.2");
		capabilities.setCapability("deviceName", "Samsung ");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability(CapabilityType.PLATFORM, "WINDOWS");
		
		capabilities.setCapability("app-package",
				"com.iCancerHealth.ICHPatientApp"); 

		capabilities.setCapability("app-activity",
				"com.iCancerHealth.ICHPatientApp.ui.LogoActivityNew"); 

		drv = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),
				capabilities);
				
	}
	
	if(browser.equals("Android2")){
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("device", "Android");
		capabilities.setCapability("VERSION", "5.2.2");
		capabilities.setCapability("deviceName", "Samsung ");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability(CapabilityType.PLATFORM, "WINDOWS");
		 
		capabilities.setCapability("app-package",
				"com.iCancerHealth.ICHPatientApp"); 
		
		capabilities.setCapability("app-activity",
				"com.iCancerHealth.ICHPatientApp.ui.LogoActivityNew"); 

		drv = new AndroidDriver(new URL("http://127.0.0.1:6666/wd/hub"),
				capabilities);
				
	}
	threadDriver.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap));
	  
	System.out.println("This is from the Before Method");
	  
  }
	
	public WebDriver getDriver() {
        return threadDriver.get();
    }
	
	
	
	@SuppressWarnings("rawtypes")
	public AppiumDriver getMDriver() {
        return drv;
    }
	
	
	
  @AfterMethod
  public void afterMethod() {
	  getDriver().quit();	  
	  System.out.println("This is from the After Method");
  }
  
  public ExtentReports getExtent(String driver, ITestContext context){
	  ExtentReports extent = null;
	  
	//Browser initialization
		if(driver.contains("firefox")){
			
			extent = (ExtentReports) context.getAttribute("Firefox");
			
		}
		
		if(driver.contains("internet")){
			extent =(ExtentReports) context.getAttribute("IE");
			
		}
		
		if(driver.contains("chrome")){
			extent =(ExtentReports) context.getAttribute("Chrome");
			
		}
		
		if(driver.contains("Android")){
			extent =(ExtentReports) context.getAttribute("Android");
		}
	  
	  return extent;
  }
}

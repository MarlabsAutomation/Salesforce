package TestScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.model.ITest;

import Core.baseClass;
import junit.framework.Assert;

public class NewTest extends baseClass{
 
	ExtentReports extent;
		
	@Test
  public void Testing(ITestContext context) {
	 	
	 	String bname = getDriver().toString();
	 	
	 	extent = getExtent(bname, context);
	 	
	 	ExtentTest test = extent.startTest(getClass().getSimpleName());
	 	
	 	getDriver().get("http://google.com");
	 	test.log(LogStatus.PASS, "Browser Launched");
	 	
		WebElement element = getDriver().findElement(By.linkText("About"));
		element.click();
		test.log(LogStatus.PASS, "Clicked on the About");
		
		Assert.assertEquals("About Google", getDriver().getTitle());
	    System.out.println("This is testing: "+getDriver().toString()+" - "+getDriver().getTitle());
	    
	       
	    
	    extent.endTest(test);
	    
  }
}

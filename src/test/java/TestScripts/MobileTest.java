package TestScripts;

import org.testng.annotations.Test;

import Core.baseClass;

public class MobileTest extends baseClass{
  @Test
  public void mob() {
	  //getMDriver();
	  System.out.println("This is testing mobile node. "+getMDriver().toString());
  }
}

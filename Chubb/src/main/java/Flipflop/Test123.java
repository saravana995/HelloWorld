package Flipflop;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Test123 extends ProjectWrapper {

	@BeforeClass
	public void beforeClass()
	{   testCaseName = "TC001";
	    testCaseDescription = "Plan1";
	    catergory  = "smoke";
	    author     = "saravana";
	    browserName ="chrome";
		getSheetName ="Tc001";	
	}
	
	@Test
	public void track() throws Throwable
	{
		new Homepage(driver,test)
		.UserName()
		.Password()
		.Login()
		.t1()
		.Men()
		.Thread()
		.Tshirt()
		.Thread()
		.shirt()
		.lastWindow()
		.Thread()
		.getText();
		
	}

}

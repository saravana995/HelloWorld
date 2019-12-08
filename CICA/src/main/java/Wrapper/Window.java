package Wrapper;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

public class Window extends GenericWrapper {

	public Window (RemoteWebDriver locdriver,ExtentTest loctest)
	{
		this.driver =locdriver;
		this.test =loctest;
	}
	
	public Window userName1()
	{
		driver.findElementByXPath(prop.getProperty("Homepage.UserName1"));
		return this;
		
	}
}

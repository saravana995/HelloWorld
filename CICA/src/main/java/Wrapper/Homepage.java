package Wrapper;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

public class Homepage extends GenericWrapper {
	
	public Homepage (RemoteWebDriver locdriver,ExtentTest loctest)
	{
		this.driver =locdriver;
		this.test =loctest;
	}
	
	public Homepage userName()
	{
		enterByXpath(prop.getProperty("Homepage.UserName"),"saravanakumar20.kannan@gmail.com");
		return this;
		
	}
	public Homepage userName1()
	{
		enterByXpath(prop.getProperty("Homepage.UserName1"),"BULLET12345");
		return this;
		
	}
	public Homepage Login()
	{
		clickByXpath(prop.getProperty("Homepage.Login"));
		return this;
		
	}

}

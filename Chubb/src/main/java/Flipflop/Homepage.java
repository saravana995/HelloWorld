package Flipflop;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import Flipflop.Homepage;

public class Homepage extends GenericWrapper{

	public Homepage (RemoteWebDriver locdriver,ExtentTest loctest)
	{
		this.driver = locdriver;
		this.test= loctest;
		
	}

	public Homepage UserName()
	{
		enterByXpath(prop.getProperty("Homepage.UserName"),"Saravanakumar20.kannan@gmail.com");
	return this;
	}
	public Homepage Password()
	{
		enterByXpath(prop.getProperty("Homepage.Password"),"BULLET12345");
	return this;
	}
	public Homepage Login()
	{
		clickByXpath(prop.getProperty("Homepage.Login"));
		return this;
		
	}
	public Homepage t1() throws Throwable
	{
		Thread.sleep(5000);
		return this;
	}
	
	public Homepage Thread() throws InterruptedException
	{
	Thread.sleep(2000);
	return this;
	}
	public Homepage Men()
	{
		moveToElement(prop.getProperty("Homepage.Men"));
		return this;
		
	} 
	public Homepage Tshirt()
	{
		clickByXpath(prop.getProperty("Homepage.Tshirt"));
		return this;
		
	}
	public Homepage shirt()
	{
		clickByXpath(prop.getProperty("Homepage.shirt"));
		return this;
		
	}
	public Homepage lastWindow()
	{
		switchToLastWindow();
		return this;
		
	}
	public Homepage getText()
	{
		getText(prop.getProperty("Homepage.Text"));
		return this;
		
	}
	
}

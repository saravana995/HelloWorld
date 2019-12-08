package Flipflop;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import Flipflop.DP;

public class ProjectWrapper extends GenericWrapper {

	public String browserName;
	public String getSheetName;
	
	@BeforeSuite
	public void Beforesuite() {
		
		startReport();
		
	}
	
	
	
	@BeforeTest
	public void beforeTest()
	{  
		loadobject();
		//reserved
	}
	@BeforeMethod
	public void beforeMethod()
	{ 
		startTest(testCaseName ,testCaseDescription);
		System.out.println("pass12");
		invokeApp("chrome",false);
		
	}
	
	@AfterMethod
	public void afterMethod()
	{
		 //closeAllBrowsers();
		 
		
	}
	
	@AfterClass
	public void afterClass(){
		endTest();
	}
		
		@AfterTest
	public void afterTest(){
		//reserved
	}
		
		@AfterSuite
	public void afterSuite(){
		endReport();
	}
		
		@DataProvider(name ="FETCHDATA")
		public String[][] getInput() throws IOException
		{
			return DP.getData(getSheetName);
		}
	
}

package Flipflop;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public abstract class Reporting {
	
	
	public static ExtentReports report;
	public ExtentTest test;
	public String testCaseName ,testCaseDescription;
	public String author,catergory;
 
	public void startReport()
	{
		report = new ExtentReports("./Report/result.html",false);
		
	}
	
	public void startTest(String testName, String description)
	{
		test = report.startTest(testCaseName, testCaseDescription);
	}
	
	public void reportStep(String details,String status)
	{
		Long snapNumber = (long) 1000001;
		snapNumber = takeSnap();
		if(status.equalsIgnoreCase("PASS"))
		{
			test.log(LogStatus.PASS, details + test.addScreenCapture("../screenshot" + snapNumber +".jpegf"));
		}
	else if(status.equalsIgnoreCase("FAIL")){
		test.log(LogStatus.FAIL, details+ test.addScreenCapture("../screenshots/"+snapNumber+".jpegf"));
	}else if(status.equalsIgnoreCase("INFO")){
		test.log(LogStatus.INFO, details+ test.addScreenCapture("../screenshots/"+snapNumber+".jpegf"));
	}else if(status.equalsIgnoreCase("WARN")){
		test.log(LogStatus.WARNING, details+ test.addScreenCapture("../screenshots/"+snapNumber+".jpegf"));
		
	}
	}
	
	public abstract long takeSnap();	
	
	public void endTest()
	{
		report.endTest(test);

	}
	
	public void endReport()
	{
		report.flush();
	}
	
	
}
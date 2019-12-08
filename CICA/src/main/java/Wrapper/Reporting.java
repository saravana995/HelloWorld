package Wrapper;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public abstract class Reporting {
	public static ExtentReports report;
	public ExtentTest test;
	public String testCaseName,testCaseDescription;
	public String author,catergory;
	
	public void startReport() {
		report = new ExtentReports("./report/result.html",false);
	}
	public void startTestCase(String testName, String description){

		test=	report.startTest(testName, description);
	}
	
	public void reportStep(String details,String status,boolean snap) {
	if(snap)
	{
		if(status.equalsIgnoreCase("PASS"))
		{
			test.log(LogStatus.FAIL, details);
		}else if(status.equalsIgnoreCase("FAIL")){
			test.log(LogStatus.FAIL, details);
		}else if(status.equalsIgnoreCase("INFO")){
			test.log(LogStatus.INFO, details);
		}else if(status.equalsIgnoreCase("WARN")){
			test.log(LogStatus.WARNING, details);
			
	}
	}
	}
	public void reportStep(String details,String status) {
		long snapNumber =1000001;
		snapNumber=takeSnap();
		if(status.equalsIgnoreCase("PASS"))
		{
			test.log(LogStatus.PASS, details+test.addScreenCapture("../screenshots/"+snapNumber+".jpegf"));
	}else if(status.equalsIgnoreCase("FAIL")){
		test.log(LogStatus.FAIL, details+test.addScreenCapture("../screenshots/"+snapNumber+".jpegf"));
	}else if(status.equalsIgnoreCase("INFO")){
		test.log(LogStatus.INFO, details+test.addScreenCapture("../screenshots/"+snapNumber+".jpegf"));
	}else if(status.equalsIgnoreCase("WARN")){
		test.log(LogStatus.WARNING, details+test.addScreenCapture("../screenshots/"+snapNumber+".jpegf"));
		
	}
		
		
		
		
	}
	

		public abstract long takeSnap();
	
	public void endTestCase(){
		report.endTest(test);
	}
	
	
	public void endReport(){
		report.flush();
	}
	
	
	
	
}
	


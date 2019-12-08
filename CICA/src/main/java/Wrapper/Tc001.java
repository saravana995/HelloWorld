package Wrapper;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Tc001 extends ProjectWrapper{

	public String a = null;	
	@BeforeClass
	public void beforeClass()
	{
		testCaseName ="Tc001";
		testCaseDescription ="Plan1";
		catergory="smoke";
		author="sarvan";
		browserName ="chrome";
		getSheetName ="Tc001";	
	}
	
	
	@Test
	public void track() throws InterruptedException
	
	{
	
		new Homepage(driver,test )
		.userName()
		.userName1()
		.Login();
		/*Set<String> s=driver.getWindowHandles();
		System.out.println(s);
		for(String session : s)
			{
				driver.switchTo().window(session);
			break;				
			}
		*/
		

			Thread.sleep(5000);
		
		
		WebElement ab = driver.findElementByXPath("(//*[@class='_3Der3h'])[3]");
		
		
		Actions action = new Actions(driver);
		 
        action.moveToElement(ab).click().perform();
        Thread.sleep(2000);
         driver.findElementByXPath("//a[text()='Shirts']").click();
         driver.findElementByXPath("(//*[@class='_2mylT6'])[2]").click();


         Set<String> s=driver.getWindowHandles();
 		System.out.println(s);
 		for(String session : s)
 			{
 				driver.switchTo().window(session);
 			}
 		
        
 			Thread.sleep(3000);
 		


       a =   driver.findElementByXPath("//div[starts-with(@class,'_1vC4OE')]").getText();
	System.out.println(a);
	}
	
	
}

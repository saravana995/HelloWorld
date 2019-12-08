package saran.CICA;



import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class cica {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		RemoteWebDriver driver = new ChromeDriver();
		driver.get("https://flipkart.com");
			
		driver.manage().window().maximize();
		
		driver.findElementByXPath("//input[@class='_2zrpKA _1dBPDZ']").sendKeys("Saravanakumar20.kannan@gmail.com");
		driver.findElementByXPath("//input[@class='_2zrpKA _3v41xv _1dBPDZ']").sendKeys("BULLET12345");
		driver.findElementByXPath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[3]/button/span").click();
		Set<String> s=driver.getWindowHandles();
		Iterator<String> It=s.iterator();
		It.next(); 
		It.next(); 
		String a=It.next();
		driver.switchTo().window( a);
		
		Thread.sleep(5000);
		
		WebElement ab = driver.findElementByXPath("//span[text()='Men']");
		Actions action = new Actions(driver);
		 
        action.moveToElement(ab).perform();
        
         driver.findElementByXPath("//*[@id=\'container\']/div/div[2]/div/ul/li[3]/ul/li/ul/li[2]/ul/li[4]/a").click();

        
        
		
		
		
	}

}

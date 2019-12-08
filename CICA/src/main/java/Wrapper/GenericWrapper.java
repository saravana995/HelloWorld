package Wrapper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.ElementNotSelectableException;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import Wrapper.Reporting;


public class GenericWrapper extends Reporting implements Wrapper {
	
	/*changes done asap*/
	public  RemoteWebDriver driver;
	
	int i= 1;
    public static Properties prop;
    public  Properties cprop;
	

    
    public String url;
    
    
    
    	 public GenericWrapper(){
    	     
    	     Properties cprop = new Properties();
    		  try {
    			cprop.load(new FileInputStream(new File("./src/test/java/config.properties")));
    			url = cprop.getProperty("URL");
    			
    		} catch (FileNotFoundException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    	 }
    	 
    	     
    	     
    	     
    	     public void loadobject()
    	     {
    	    	 prop =new Properties();
    	    	 try {
    	    	
    	    	 
    	    	 prop.load(new FileInputStream(new File ("./src/test/java/object.Properties")));
    	     }
    	     catch(FileNotFoundException e) {
    	    	 e.printStackTrace();
    	     }catch(IOException e) 
    	     {
    	    	 e.printStackTrace();
    	     }
    	     }
    	     public void unloadobject()
    	     {
    	    	 prop =null;
    	     }
    	    	
    	     public void invokeApp(String browser) {
    	    	 
    	     }
    	     
    	     public void invokeApp(String browser,boolean flag) {
    	 		// TODO Auto-generated method stub
    	    	 try {
    				
    	    		 DesiredCapabilities dc = new DesiredCapabilities();
    	    			dc.setBrowserName(browser);
    	    			dc.setPlatform(Platform.WINDOWS);
    	    			if(flag){
    	    				
               driver = new RemoteWebDriver(new URL("http://192.168.43.186:4444/wd/hub"),dc);
    					
    				 }
    				else if(browser.equalsIgnoreCase("chrome")){
    				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
    				driver=new ChromeDriver();
    				}else if(browser.equalsIgnoreCase("firefox")){
    				System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
    				driver=new FirefoxDriver();
    				}
    					
    				driver.manage().window().maximize();
    				driver.get(url);
    				System.out.println(url);
    				//System.out.println("The browser "+browser+" is launched successfully");
    				reportStep("The browser "+browser+" is launched successfully","PASS");
    			} catch (MalformedURLException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
    			}
    	 		
    				
    	 		
    	    	 
    	     
    	 		/*finally {
    			takeSnap();
    			}		*/
    		    
    		  

	public void enterById(String Id, String value) {
		// TODO Auto-generated method stub
		try {
		driver.findElementById(Id).sendKeys(value);
		}catch(NoSuchElementException e)
		{
			e.printStackTrace();
		}catch(ElementNotInteractableException e)
		{
			
		}
	}

	public void enterByName(String Name, String Value) {
		// TODO Auto-generated method stub
		try {
			driver.findElementByName(Name).sendKeys(Value);
			}catch(NoSuchElementException e)
			{
				e.printStackTrace();
			}catch(ElementNotInteractableException e)
			{
				
			}
	}

	public void enterByXpath(String Xpath, String Value) {
		// TODO Auto-generated method stub
		try {
			driver.findElementByXPath(Xpath).sendKeys(Value);
			}catch(NoSuchElementException e)
			{
				e.printStackTrace();
			}catch(ElementNotInteractableException e)
			{
				
			}
	}

	public void clickById(String Id) {
		// TODO Auto-generated method stub
		try{
			driver.findElementById(Id).click();
		}catch(NoSuchElementException e)
		{ e.printStackTrace();
			}catch(ElementClickInterceptedException e)
		{
				e.printStackTrace();
		}
		catch(ElementNotVisibleException e)
		{
				e.printStackTrace();
		}
		
		
	}

	public void clickByName(String Name) {
		// TODO Auto-generated method stub
		try{
			driver.findElementByName(Name).click();
		}catch(NoSuchElementException e)
		{ e.printStackTrace();
			}catch(ElementClickInterceptedException e)
		{
				e.printStackTrace();
		}
		catch(ElementNotVisibleException e)
		{
				e.printStackTrace();
		}
		
		
	}

		
	

	public void clickByXpath(String Xpath) {
		// TODO Auto-generated method stub
		try{
			driver.findElementByXPath(Xpath).click();
		}catch(NoSuchElementException e)
		{ e.printStackTrace();
			}catch(ElementClickInterceptedException e)
		{
				e.printStackTrace();
		}
		catch(ElementNotVisibleException e)
		{
				e.printStackTrace();
		}
		
		
	
	}

	public void verifyByTitle(String Title) {
		// TODO Auto-generated method stub
		try {
		     String DupTitle = driver.getCurrentUrl();
		if(Title.equalsIgnoreCase(DupTitle))
		{  
			System.out.println("the value is matching ");
		}
			
			}catch(WebDriverException e)
		{
				e.printStackTrace();
		}
		}

	public void getTextById(String Id) {
		// TODO Auto-generated method stub
		String alpha =driver.findElementById(Id).getText();
		System.out.println(alpha);
		}

	public void selectVisibileTextById(String id, String value) {
		// TODO Auto-generated method stub
	try{
		WebElement AP=	driver.findElementById(id);

	Select  select= new Select (AP);
	select.selectByValue(value);
	System.out.println("Drop Down value is selected sucessfully");
	}catch (NoSuchElementException e){
	e.printStackTrace();
	}catch (ElementNotInteractableException e) {
		e.printStackTrace();
	} catch (ElementNotSelectableException e) {
		e.printStackTrace();
	} catch (WebDriverException e) {
		e.printStackTrace();
	}
	}
	

	public void selectByIndex(String Id, int value) {
		// TODO Auto-generated method stub
		try{
			WebElement AP=	driver.findElementById(Id);

		Select  select= new Select (AP);
		select.selectByIndex(value);
		System.out.println("Drop Down value is selected sucessfully");
		}catch (NoSuchElementException e){
		e.printStackTrace();
		}catch (ElementNotInteractableException e) {
			e.printStackTrace();
		} catch (ElementNotSelectableException e) {
			e.printStackTrace();
		} catch (WebDriverException e) {
			e.printStackTrace();
		}
		}
	

	public void switchToParentWindow() {
		// TODO Auto-generated method stub
		try {
			
		
			Set<String>  Window = driver.getWindowHandles();
		for(String session :Window)
		{
			driver.switchTo().window(session);
		break;				
		}
		System.out.println("successfully switched to the parent window");
		}catch(NoSuchElementException e)
		{e.printStackTrace();
	}
	}

	public void switchToLastWindow() {
		// TODO Auto-generated method stub
		try {
			
			
			Set<String>  Window = driver.getWindowHandles();
		for(String session :Window)
		{
			driver.switchTo().window(session);
		break;				
		}
		System.out.println("successfully switched to the parent window");
		}catch(NoSuchElementException e)
		{
			e.printStackTrace();
	}
	
	}
	
	public long takeSnap()
	{long Sat =1000001;
	
	
		 Sat = (long) Math.floor(Math.random()*100000+1000001);
		
		File temp = driver.getScreenshotAs(OutputType.FILE);
		File dest =new File("./screenshot"+ Sat +".jpegf");
		try {
			FileUtils.copyFile(temp,dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
		return Sat;
	
		
	}

	public void acceptAlertText() {
		// TODO Auto-generated method stub
		try 
		{
		driver.switchTo().alert().accept();
	}catch(NoSuchElementException e)
		{
		e.printStackTrace();
		}
	}

	public void dismissAlertText() {
		// TODO Auto-generated method stub
		try 
		{
		driver.switchTo().alert().dismiss();
	}catch(NoSuchElementException e)
		{
		e.printStackTrace();
		}
	}

	public String getAlertText() {
		// TODO Auto-generated method stub
		return null;
	}

	public void closeBrowser() {
		// TODO Auto-generated method stub
		try {
			driver.close();
			System.out.println("Active browser is Closed sucessfully");
			} catch (NoSuchWindowException e) {
		e.printStackTrace();
			}
		
	}

	public void closeAllBrowser() {
		// TODO Auto-generated method stub
		try {
			driver.quit();
			System.out.println("Active browser is Closed sucessfully");
			} catch (NoSuchWindowException e) {
			e.printStackTrace();
			}
	}
	
}
	



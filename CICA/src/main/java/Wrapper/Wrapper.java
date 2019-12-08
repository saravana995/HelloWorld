package Wrapper;

public interface Wrapper {
	
	public void invokeApp(String browser);
	
	
	public void enterById(String Id,String value);
	
	public void enterByName(String Name,String Value);
	
	public void enterByXpath(String Xpath,String Value);
	
	
    public void clickById(String Id);
	
	public void clickByName(String Name);
	
	public void clickByXpath(String Xpath);
	
	public void verifyByTitle(String Title);

	public void getTextById(String Id);
	
	public void selectVisibileTextById(String id, String value);
	
	public void selectByIndex(String Id ,int value);
	
	public void switchToParentWindow();
	
	public void switchToLastWindow();
	
	public void acceptAlertText();
	
	public void dismissAlertText();
	
	public String getAlertText();
	
	public void closeBrowser();
	
	public void closeAllBrowser();
	
	
}

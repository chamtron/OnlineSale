package common;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestBase {
	public WebDriver driver;
	
	//Open single browser
	public void openWebsiteWithSingleBrowser(String browser) {
		//Close message that Chrome is controlled by automated tool
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("useAutomationExtension", false);
		options.setExperimentalOption("excludeSwitches",Collections.singletonList("enable-automation"));    
		//Disable popup save password on Chrome
		Map<String, Object> prefs = new HashMap<String, Object>();
	    prefs.put("credentials_enable_service", false);
	    prefs.put("profile.password_manager_enabled", false);
	    options.setExperimentalOption("prefs", prefs);
		
		
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver","D:\\AutomationProject\\03Practices\\OnlineSaleAutomation\\driver\\chromedriver.exe");
			driver = new ChromeDriver(options);
		} else if (browser.equalsIgnoreCase("winedge")) {
			//new winedge driver
		}
		
		driver.get("http://localhost/banhoa/adm/");
		driver.manage().window().maximize();
	}
	
//	public void navigateOtherLink(String Link) {
//		System.setProperty("webdriver.chrome.driver","D:\\AutomationProject\\03Practices\\OnlineSaleAutomation\\driver\\chromedriver.exe");
//		driver = new ChromeDriver();
//		driver.get(Link);
//		driver.manage().window().maximize();
//	}
	public void inputText(By locator, CharSequence... text) {
		WebElement e = driver.findElement(locator);
		if(e.isDisplayed())
		{
			e.clear();
			e.sendKeys(text);
		}
		
	}
	public void clickOnElement(By locator) {
		WebElement e = driver.findElement(locator);
//		int count = 0;
//		while(e.isDisplayed()|| count < 20)
//			{
//			driver.manage().timeouts().implicitlyWait(1,TimeUnit.SECONDS);
//			
//			}
//		if (e.isDisplayed()) {
			e.click();
//		}else {
//			System.out.println("Element not found");
//		}
//		
	}
	public boolean checkDisplay(By locator) {
		return driver.findElement(locator).isDisplayed();
	}
	public String getTextFromLocator(By locator) {
		WebElement e = driver.findElement(locator);
		String s = e.getText();
		System.out.println("Text content is : " + s);
		return s;
	}
	
	public Boolean GoogleSearch() throws Exception {
			String execScript = "return document.documentElement.scrollHeight>document.documentElement.clientHeight;";
			JavascriptExecutor scrollBarPresent = (JavascriptExecutor) driver;
			Boolean test = (Boolean) (scrollBarPresent.executeScript(execScript));
			if (test == true) {
				System.out.print("Scrollbar is present.");
			} else if (test == false){
				System.out.print("Scrollbar is not present.");
			}
		return test;	
		}
}

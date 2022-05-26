package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import common.TestBase;

public class TestCase {
	public TestBase testBase = new TestBase();
	
	@BeforeMethod
	@Parameters("browser")
	public void openWebsite(String browser) {
		//String browser = "chrome";
		testBase.openWebsiteWithSingleBrowser(browser);
		
	}

}

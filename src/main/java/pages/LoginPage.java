package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage extends Page{
	public By txtTenDangNhap = By.id("txttendangnhap");
	public By txtPassword = By.id("txtpass");
	public By btnDangNhap = By.name("Submit");
	public By rowLoaiHoaSua;	
	public By txtUsernameOrPassWrong = By.xpath("//form[@name='formdangnhapadmin']/table/tbody/tr[4]/td");
	public LoginPage(WebDriver dr) {
		//super(dr);
		testBase.driver = dr;
	}

	public QuanLyLoaiHoaPage login(String tenDangNhap, String password) throws Exception {
		testBase.inputText(txtTenDangNhap, tenDangNhap);
		testBase.inputText(txtPassword, password);
		Thread.sleep(2000);
		testBase.clickOnElement(btnDangNhap);
		//testBase.getTextFromLocator(txtUsernameOrPassWrong);
		return new QuanLyLoaiHoaPage(testBase.driver);

	}
	
	public String GetMessageOnLoginPage() {
		String result = testBase.getTextFromLocator(txtUsernameOrPassWrong);
		return result;
	}
	

}

package tests;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.ExcelUtil;
import pages.LoginPage;
import common.TestBase;
import pages.QuanLyLoaiHoaPage;

public class RegisterPageTest extends TestCase{
	ExcelUtil excel = new ExcelUtil();
	
	
	
	@Test 
	//(dataProvider="Authentication")
	@Parameters({"tenDangNhap","password"})
	public void registrationData(String tenDangNhap, String password) throws Exception {
		LoginPage login = new LoginPage(testBase.driver);
		QuanLyLoaiHoaPage quanLyLoaiHoaPage = login.login(tenDangNhap,password);
		//By txtUsernameOrPassWrong;
		String actualTxtUsernameOrPassWrong = login.GetMessageOnLoginPage();
		assertEquals(actualTxtUsernameOrPassWrong, "Sai Tên Đăng Nhập Hoặc Mật Khẩu");
		
	}
	
//	@DataProvider
//	public Object[][] Authentication() throws Exception{
//
//		Object[][] testObjArray = excel.getTableArray("D:\\AutomationProject\\03Practices\\OnlineSaleAutomation\\TestCase\\WebBanHoa_TestCase_QuanLyLoaiHoa_v2.0.xlsx","DataLogin");
//
//        return (testObjArray);
//
//		}
//	
//	@Test(description="Authen-Pass")
//	public void LoginPass(String tenDangNhap, String password) throws Exception {
//	//excel.getTableArray("D:\\AutomationProject\\03Practices\\OnlineSaleAutomation\\TestCase\\WebBanHoa_TestCase_QuanLyLoaiHoa_v2.0.xlsx", "DataLoginSuccess");
//	LoginPage login = new LoginPage(testBase.driver);
//	//QuanLyLoaiHoaPage quanLyLoaiHoaPage = login.login(excel.getCellData(1, 0),excel.getCellData(1, 1));
//	QuanLyLoaiHoaPage quanLyLoaiHoaPage = login.login(tenDangNhap,password);
//	String currentUrl = testBase.driver.getCurrentUrl();
//	System.out.println(currentUrl);
//	assertEquals(currentUrl, "http://localhost/banhoa/adm/");
//	
//	}

   @AfterMethod

   public void afterMethod() {

 	    testBase.driver.close();

   	}

}

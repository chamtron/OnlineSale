package tests;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.ExcelUtil;
import common.TestBase;
import pages.LoginPage;
import pages.Page;
import pages.QuanLyHoaPage;
import pages.QuanLyLoaiHoaPage;

public class QuanLyHoaTest extends TestCase {
	
//ExcelUtil excel = new ExcelUtil();
//	
//	@Test (dataProvider = "SuaTenHoaPage")
//	public void verifySuccessEdit(String maHoa, String tenHoa, String tenHoaMoi) throws Exception {
//		
//		LoginPage loginPage = new LoginPage(testBase.driver);
//		//TestBase testBase = new TestBase();
//		QuanLyHoaPage QLH_Page = new QuanLyHoaPage(testBase.driver);
//		QuanLyLoaiHoaPage quanLyHoaPage = loginPage.login("admin","admin");
//		testBase.clickOnElement(QLH_Page.btnQuanLyHoa);
//		excel.getTableArray("D:\\AutomationProject\\03Practices\\OnlineSaleAutomation\\TestCase\\WebBanHoa_TestCase_QuanLyLoaiHoa_v2.0.xlsx", "DataQuanLyHoaPage");
//		QLH_Page.testBase.clickOnElement(QLH_Page.QLH_getButtonSuaByLoaiHoa(maHoa));
//		QLH_Page.QLH_inputNewTenHoa(tenHoa, tenHoaMoi);
//		String actualTxtQLHPage = testBase.getTextFromLocator(QLH_Page.txtQLHEditSucces);
//		assertEquals(actualTxtQLHPage, "Đã Lưu Thành Công Thay Đỗi Của Bạn");
//	}
//	
//	@DataProvider(name = "SuaTenHoaPage")
//	public Object[][]SuaTenHoa() throws Exception{
//
//		Object[][] testObjArray = excel.getTableArray("D:\\AutomationProject\\03Practices\\OnlineSaleAutomation\\TestCase\\WebBanHoa_TestCase_QuanLyLoaiHoa_v2.0.xlsx", "DataQuanLyHoaPage");
//
//        return (testObjArray);
//
//		}
	@Test()
	@Parameters({"tenDangNhap","password"})
	public void themMoiLoaiHoa(String tenDangNhap, String password) throws Exception {
		LoginPage loginPage = new LoginPage(testBase.driver);
		
		QuanLyLoaiHoaPage quanLyHoaPage = loginPage.login(tenDangNhap,password);
		
		QuanLyHoaPage QLH_Page = new QuanLyHoaPage(testBase.driver);
		testBase.clickOnElement(QLH_Page.btnQuanLyHoa);
		testBase.clickOnElement(QLH_Page.btnThemHoaMoi);
		testBase.inputText(QLH_Page.txtInputTenHoa, "Them Moi 3");
		testBase.clickOnElement(QLH_Page.btnThemMoi);
		String actualTxtQLHThemMoi = testBase.getTextFromLocator(QLH_Page.messThemMoi);
		assertEquals(actualTxtQLHThemMoi, "Đã Thêm Thành Công Hoa Váo Cơ Sở Dữ Liệu");
	}
	@AfterMethod

	   public void afterMethod() {

	 	    testBase.driver.close();

	   	}


}

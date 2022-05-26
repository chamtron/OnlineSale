package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.QuanLyLoaiHoaPage;
import common.ExcelUtil;

public class QuanLyLoaiHoaTest extends TestCase{
	//ExcelUtil excel = new ExcelUtil();
//	
//	@Test (dataProvider="SuaTenLoaiHoa")
//	public void verifySuccessEdit(String tenLoaiHoa, String tenLoaiHoaMoi) throws Exception {
//		
//		LoginPage loginPage = new LoginPage(testBase.driver);
//		QuanLyLoaiHoaPage quanLyLoaiHoaPage = loginPage.login("admin","admin");
//		excel.getTableArray("D:\\AutomationProject\\03Practices\\OnlineSaleAutomation\\TestCase\\WebBanHoa_TestCase_QuanLyLoaiHoa_v2.0.xlsx", "DataSuaTenLoaiHoa");
//		quanLyLoaiHoaPage.testBase.clickOnElement(quanLyLoaiHoaPage.getButtonSuaByLoaiHoa(tenLoaiHoa));
//		QuanLyLoaiHoaPage suaLoaiHoa = new QuanLyLoaiHoaPage(testBase.driver);
//		
//		suaLoaiHoa.inputNewLoaiHoa(tenLoaiHoa, tenLoaiHoaMoi);
//		String actualTxtBamDeVeQLBHPage = testBase.getTextFromLocator(quanLyLoaiHoaPage.txtBamDeVeQuanLyBanHoaPage);
//		String actualTxtSuaSuccess = testBase.getTextFromLocator(quanLyLoaiHoaPage.txtSuaSuccess);
//		
//		//assertTrue(quanLyLoaiHoaPage.testBase.checkDisplay(quanLyLoaiHoaPage.txtSuaSuccess));
//		assertEquals(actualTxtSuaSuccess, "Sửa Thành Công!");
//		assertEquals(actualTxtBamDeVeQLBHPage, "Bấm Vào Đây Để Về Trang Quản Lý Loại Hoa");
//	}
	
//	@DataProvider
//	public Object[][] SuaTenLoaiHoa() throws Exception{
//
//		Object[][] testObjArray = excel.getTableArray("D:\\AutomationProject\\03Practices\\OnlineSaleAutomation\\TestCase\\WebBanHoa_TestCase_QuanLyLoaiHoa_v2.0.xlsx","DataSuaTenLoaiHoa");
//
//        return (testObjArray);
//
//		}
	
	@Test (description = "check visible scrollbar when list hoa <= 18 ")
	@Parameters({"tenDangNhap","password"})
	public void checkScrollbar(String tenDangNhap, String password) throws Exception {
		Boolean expectResult;
		LoginPage loginPage = new LoginPage(testBase.driver);
		QuanLyLoaiHoaPage quanLyLoaiHoaPage = loginPage.login(tenDangNhap,password);
		JavascriptExecutor js = (JavascriptExecutor) testBase.driver;
	    String script = "window.close()";
	    js.executeScript(script);
	    
	    if(quanLyLoaiHoaPage.findColumn(testBase.driver) <= 19)
	    	{
	    	
	    	 expectResult = false;
	    }else {
	    	
	    	 expectResult = true;
	    }
	    Boolean actualResult = testBase.GoogleSearch();	
		assertEquals(actualResult, expectResult);
		
		}
	
//	@Test (description = "SuaTenLoaiHoa")
//	@Parameters({"tenDangNhap","password","tenLoaiHoa","tenLoaiHoaMoi"})
//	public void verifySuccessEdit(String tenDangNhap, String password, String tenLoaiHoa, String tenLoaiHoaMoi) throws Exception {
//		
//		LoginPage loginPage = new LoginPage(testBase.driver);
//		QuanLyLoaiHoaPage quanLyLoaiHoaPage = loginPage.login(tenDangNhap,password);
//		quanLyLoaiHoaPage.testBase.clickOnElement(quanLyLoaiHoaPage.getButtonSuaByLoaiHoa(tenLoaiHoa));
//		QuanLyLoaiHoaPage suaLoaiHoa = new QuanLyLoaiHoaPage(testBase.driver);
//		
//		suaLoaiHoa.inputNewLoaiHoa(tenLoaiHoa, tenLoaiHoaMoi);
//		String actualTxtBamDeVeQLBHPage = testBase.getTextFromLocator(quanLyLoaiHoaPage.txtBamDeVeQuanLyBanHoaPage);
//		String actualTxtSuaSuccess = testBase.getTextFromLocator(quanLyLoaiHoaPage.txtSuaSuccess);
//		
//		//assertTrue(quanLyLoaiHoaPage.testBase.checkDisplay(quanLyLoaiHoaPage.txtSuaSuccess));
//		assertEquals(actualTxtSuaSuccess, "Sửa Thành Công!");
//		assertEquals(actualTxtBamDeVeQLBHPage, "Bấm Vào Đây Để Về Trang Quản Lý Loại Hoa");
//	}
//	
//	@Test (invocationCount=1)
//	@Parameters({"tenDangNhap","password","QLLH_tenHoaMoi"})
//	public void QLLH_ThemHoa (String tenDangNhap, String password, String QLLH_tenHoaMoi) throws Exception {
//		LoginPage loginPage = new LoginPage(testBase.driver);
//		QuanLyLoaiHoaPage quanLyLoaiHoaPage1 = loginPage.login(tenDangNhap,password);
//		QuanLyLoaiHoaPage themMoi = new QuanLyLoaiHoaPage(testBase.driver);
//		themMoi.testBase.clickOnElement(themMoi.btnQLLHThemMoi);
//		themMoi.themLoaiHoaMoi(QLLH_tenHoaMoi);
//		
//		String actualMessThemMoi = testBase.getTextFromLocator(quanLyLoaiHoaPage1.messThemMoi);
//		String expectMessThemMoi = testBase.getTextFromLocator(quanLyLoaiHoaPage1.messQLLHThemMoi(QLLH_tenHoaMoi));
//		assertEquals(actualMessThemMoi, expectMessThemMoi);
//	}
//	
//	@Test (priority=2)
//	@Parameters({"tenDangNhap","password","QLLH_tenHoaMoi"})
//	public void QLLH_XoaHoa (String tenDangNhap, String password, String QLLH_tenHoaMoi) throws Exception {
//		LoginPage loginPage2 = new LoginPage(testBase.driver);
//		QuanLyLoaiHoaPage quanLyLoaiHoaPage2 = loginPage2.login(tenDangNhap,password);
//		QuanLyLoaiHoaPage xoaHoa = new QuanLyLoaiHoaPage(testBase.driver);
//		xoaHoa.testBase.clickOnElement(xoaHoa.getXpathXoaButton(QLLH_tenHoaMoi));
//		testBase.driver.switchTo().alert().accept();
//		String actualMessXoaLoaiHoa = testBase.getTextFromLocator(xoaHoa.messXoaLoaiHoa);
//		assertEquals(actualMessXoaLoaiHoa, "Xóa Thành Công Loại Hoa");
//	}
//	@AfterMethod
//
//	   public void afterMethod() {
//
//	 	    testBase.driver.close();
//
//	   	}

}

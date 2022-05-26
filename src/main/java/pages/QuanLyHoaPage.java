package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.xml.sax.Locator;

public class QuanLyHoaPage extends Page{
public By btnCapNhat=By.xpath("//input[@value='Cập Nhật']");
public By txtQLHEditSucces=By.xpath("//span[text()='Đã Lưu Thành Công Thay Đỗi Của Bạn']");
public By btnQuanLyHoa = By.xpath("//a[text()='Quản Lý Hoa']");
public By btnThemHoaMoi = By.xpath("//a[text()='Thêm Hoa Mới']");
public By txtInputTenHoa = By.id("tenhoa");
public By btnThemMoi = By.xpath("//*[@value='Thêm Mới']");
public By messThemMoi = By.xpath("//span[text()='Đã Thêm Thành Công Hoa Váo Cơ Sở Dữ Liệu']");
	
	public QuanLyHoaPage(WebDriver dr) {
		testBase.driver=dr;
	}

	
	public By QLH_getButtonSuaByLoaiHoa(String MaHoa) {
		return By.xpath("//a[text()='Sửa' and contains(@onclick,'"+MaHoa+"')]");
	}
	
	public By QLH_getTxtBoxTenHoa(String tenHoa) {
		return By.xpath("//input[@value='"+tenHoa+"']");
	}
	
	public void QLH_inputNewTenHoa(String tenHoa, String tenHoaMoi) {
		testBase.inputText(QLH_getTxtBoxTenHoa(tenHoa), tenHoaMoi);
		testBase.clickOnElement(btnCapNhat);
	}
	
	
}

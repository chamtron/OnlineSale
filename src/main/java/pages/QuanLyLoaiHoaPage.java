package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class QuanLyLoaiHoaPage extends Page {
	public By lblSuaTen=By.xpath("//form[@name='themloaihoa']/table/tbody/tr[1]/td");
	public By btnSuaTenHoa=By.name("Submit");
	public By txtSuaSuccess=By.xpath("/html/body/table/tbody/tr[3]/td[2]/div/table/tbody/tr/td/center/span");
	public By txtBamDeVeQuanLyBanHoaPage = By.xpath("//a[contains(@onclick,'adm_chuyentrang') and text()='Bấm Vào Đây Để Về Trang Quản Lý Loại Hoa']");
	public By btnQLLHThemMoi = By.xpath("//a[text()='Thêm Loại Hoa Mới']");
	public By lblQLLHBox = By.xpath("//input[@name = 'tenloaihoa']");
	public By btnQLLHThem = By.xpath("//input[@value = 'Thêm']");
	public By messThemMoi = By.xpath("//span[contains(., 'Thêm Thành Công Loai Hoa')]");
	public By messXoaLoaiHoa = By.xpath("//span[text()='Xóa Thành Công Loại Hoa']");
	
	public QuanLyLoaiHoaPage(WebDriver dr) {
		testBase.driver=dr;
	}

	
	public By getButtonSuaByLoaiHoa(String tenLoaiHoa) {
		return By.xpath("//a[text()='"+tenLoaiHoa+"']/../following-sibling::td[1]/a");
	}
	
	public By getTxtBoxLoaiHoa(String tenLoaiHoa) {
		return By.xpath("//*[@name='tenloaihoa' and @value='"+tenLoaiHoa+"']");
	}
	
	public By getXpathXoaButton(String QLLH_tenHoaMoi) {
		return By.xpath("//a[text()='"+QLLH_tenHoaMoi+"']/../following-sibling::td[2]/a");
	}
	public By messQLLHThemMoi(String QLLH_tenHoaMoi) {
		return By.xpath("//span[text()='Thêm Thành Công Loai Hoa: "+QLLH_tenHoaMoi+" Vào Cơ Sở Dữ Liệu!']");
	}
	
	public void inputNewLoaiHoa(String tenLoaiHoa, String tenLoaiHoaMoi) {
		testBase.inputText(getTxtBoxLoaiHoa(tenLoaiHoa), tenLoaiHoaMoi);
		testBase.clickOnElement(btnSuaTenHoa);
	}
	
	public void themLoaiHoaMoi(String QLLH_tenHoaMoi) {
		testBase.inputText(lblQLLHBox, QLLH_tenHoaMoi);
		testBase.clickOnElement(btnQLLHThem);
	}
	
	public int findColumn(WebDriver dr) {
    	dr = testBase.driver;
//	         
//        //No.of Columns
//        List <WebElement> col = dr.findElements(By.xpath(".//table[@class='admintable']"));
//        int totalColumn = col.size();
//        System.out.println(totalColumn);
        
      //No.of rows 
    	WebElement table= dr.findElement(By.xpath("//table[@class='admintable']//tbody"));
    	//Creating object for all row elements except header
    	List<WebElement> tableRows= table.findElements(By.tagName("tr")); 
    	int totalRow = tableRows.size();
        System.out.println(totalRow);
        return totalRow ;
    }
}
	
	


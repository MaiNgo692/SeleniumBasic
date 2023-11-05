package automation.testsuite;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_Account;
import automation.pagelocator.LoginPageFactory;
import automation.pagelocator.SiginPageAlada;

public class SiginAlada_hw_Day14 extends CommonBase {
	@BeforeMethod
	public void openChorme() {
		driver = initDriverTest(CT_Account.webURLAladaSigIn);
	}
	
	@Test(priority = 1)
	public void sigInAladaSuccessfully() {
		SiginPageAlada page = new SiginPageAlada(driver);
		page.SigInFunction("NgoMai","ngomai69@gmail.com", "ngomai69@gmail.com","123456","123456","0346984521");
		assertEquals(true, driver.findElement(By.xpath("(//a[text()=" + "Khóa học của tôi" +"])[1]")).isDisplayed());
		System.out.println("Passed testcase");
	}
	
	@Test(priority = 2)
	public void changeAccountInfSuccessfully() {
		SiginPageAlada page = new SiginPageAlada(driver);
		page.changeAccountInfFunction("123456", "654321", "654321");
		assertEquals(true,"Cập nhật mật khẩu mới thành công!"== driver.switchTo().alert().getText() );
		System.out.println("Passed testcase");
	}
	
}

package automation.testsuite;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.NewCommonBase;
import automation.constant.CT_Account;
import automation.pagelocator.LoginPageALada;
import automation.pagelocator.SiginPageAlada;

public class Day16_hw extends NewCommonBase{
	@BeforeMethod
	public void openChorme() {
		driver = initChromeDriver(CT_Account.webURLAladaLogIn);
	}
	
	@Test(priority = 1)
	public void logInAladaSuccessfully() {
		LoginPageALada page = new LoginPageALada(driver);
		page.logInFunction("ngomai6@gmail.com","123456");
		WebDriverWait wait = new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[text()='Khóa học của tôi'])[1]")));
		assertEquals(true, driver.findElement(By.xpath("(//a[text()='Khóa học của tôi'])[1]")).isDisplayed());
		
	}
	@Test(priority = 2)
	public void changeAccountInfSuccessfully() {
		logInAladaSuccessfully();
		LoginPageALada page = new LoginPageALada(driver);
		page.changeAccountInfFunction("123456", "654321", "654321");
		WebDriverWait wait = new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.alertIsPresent());
//		assertEquals(true,"Cập nhật mật khẩu mới thành công!"== driver.switchTo().alert().getText() );
		driver.switchTo().alert().accept();
		System.out.println("Passed testcase");
	}
	
	@AfterMethod
	public void closeChorme() {
		quitDriver(driver);
	}
}

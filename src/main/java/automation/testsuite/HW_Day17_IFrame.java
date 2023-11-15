package automation.testsuite;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.NewCommonBase;
import automation.constant.CT_Account;

public class HW_Day17_IFrame extends NewCommonBase{

	@BeforeMethod
	public void openChorme() {
		driver = initChromeDriver(CT_Account.webCodeStar);
	}
	
	@Test
	public void findIFrameIndextChat() {
		pause(15000);
			int totalFrame = driver.findElements(By.tagName("iframe")).size();
			System.out.println("Tong so ifrem: " + totalFrame);
			for (int i=0; i<totalFrame; i++) {
				driver.switchTo().frame(i);
				int checkElement = driver.findElements(By.xpath("//span[text()='Bắt đầu chat']")).size();
				System.out.println("checkElement" +checkElement);//iframe 5
				driver.switchTo().defaultContent();
			}
	}
	
	@Test
	public void handleIframeChat() {
		pause(15000);
//		isElementPresent(By.xpath("//span[text()='Bắt đầu chat']"));
		driver.switchTo().frame(5);
		click(By.xpath("//span[text()='Bắt đầu chat']"));
		assertTrue(isElementPresent(By.xpath("//div[text()='Đăng nhập']")));
		driver.switchTo().defaultContent();
	}
	
	@Test
	public void findIFrameIndextSend() {
		pause(15000);
			int totalFrame = driver.findElements(By.tagName("iframe")).size();
			System.out.println("Tong so ifrem: " + totalFrame);
			for (int i=0; i<totalFrame; i++) {
				driver.switchTo().frame(i);
				int checkElement = driver.findElements(By.xpath("//button[text()='Gửi ngay']")).size();
				System.out.println("checkElement" +checkElement);//iframe 1
				driver.switchTo().defaultContent();
			}
	}
	
	@Test
	public void handleIframeSend() {
		scrollToElement(By.xpath("//h2[contains(text(),'Đăng kí nhận tư vấn')]"));
		driver.switchTo().frame(1);
		type(By.xpath("(//input[@placeholder='VD: 0123456789'])[1]"),"0123456789");
		click(By.xpath("//button[text()='Gửi ngay']"));
		assertTrue(isElementPresent(By.xpath("//button[text()='Gửi ngay']")));
		driver.switchTo().defaultContent();
	}
	
	@AfterMethod
	public void closeChorme() {
		quitDriver(driver);
	}
}

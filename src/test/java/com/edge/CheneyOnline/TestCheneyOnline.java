package com.edge.CheneyOnline;

import org.testng.annotations.Test;

import com.util.framework.SendMailSSL;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

public class TestCheneyOnline extends CommonCheney {
	private WebDriver driver;

	@BeforeClass
	public void setup() {
		System.out.println("*************Cheney************");
	}

	@AfterClass
	public void AfterClass() {
		System.out.println("************End***********");
	}

	@BeforeMethod
	public void beforeTest() {
		System.out.println("***********StartTest*********");
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ashsaxen\\Downloads\\chromedriver_win32\\chromedriver.exe");
		// RandomAction.setDownloadFilePath();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		// BrowserAction.ClearBrowserCache(driver);
		driver.manage().window().maximize();

	}

	@AfterMethod
	public void pretearDown() {
		if (driver != null) {
			driver.quit();
			System.out.println("*******EndTest*********");

		}
	}

	@Test(priority = 1)
	public void Dada_Cheney() throws InterruptedException {
		// check if login is success

		LoginCheney(driver, "025991-00CBI", "Dada2599");
		// Thread.sleep(2000);
		// check the flow to exports
		// StepsToExportCheney(driver);
		// rename downloadeds
		// String CurrentPath = RandomAction.setdownloadDir();
		// File GFS_OG = RandomAction.getLatestFilefromDir(CurrentPath);
		SendMailSSL.sendMailAction("Cheney", "Dada of Delray");
	}

	@Test(priority = 2)
	public void House_Cheney() throws InterruptedException {
		// check if login is success
		LoginCheney(driver, "60030538CBI", "Hkab3053");
		// check the flow to exports
		// StepsToExportCheney(driver);
		// rename downloadeds
		// String CurrentPath = RandomAction.setdownloadDir();
		// File GFS_OG = RandomAction.getLatestFilefromDir(CurrentPath);
		SendMailSSL.sendMailAction("Cheney", "House");
	}

	@Test(priority = 3)
	public void Howleys_Cheney() throws InterruptedException {
		// check if login is success
		LoginCheney(driver, "046348-00CBI", "Howl6348");
		// check the flow to exports
		// StepsToExportCheney(driver);
		// rename downloadeds
		// String CurrentPath = RandomAction.setdownloadDir();
		// File GFS_OG = RandomAction.getLatestFilefromDir(CurrentPath);
		SendMailSSL.sendMailAction("Cheney", "Howleys Restaurant");
	}

	@Test(priority = 4)
	public void Boynton_Cheney() throws InterruptedException {
		// check if login is success
		LoginCheney(driver, "011171-01CBI", "Pasta4930");
		// check the flow to exports
		// StepsToExportCheney(driver);
		// rename downloadeds
		// String CurrentPath = RandomAction.setdownloadDir();
		// File GFS_OG = RandomAction.getLatestFilefromDir(CurrentPath);
		SendMailSSL.sendMailAction("Cheney - Offline GP", "Agliolio Boynton Italian Bistro & Bar");
	}

	@Test(priority = 5)
	public void Wellington_Cheney() throws InterruptedException {
		// check if login is success
		LoginCheney(driver, "011170-01CBI", "Fresh3847");
		// check the flow to exports
		// StepsToExportCheney(driver);
		// rename downloadeds
		// String CurrentPath = RandomAction.setdownloadDir();
		// File GFS_OG = RandomAction.getLatestFilefromDir(CurrentPath);
		SendMailSSL.sendMailAction("Cheney - Offline GP", "Agliolio Wellington Fresh Pasta & Wine");
	}

	@Test(priority = 6)
	public void CafeHeavenly_Cheney() throws InterruptedException {
		// check if login is success
		LoginCheney(driver, "043074-00CBI", "ChardoggyCBI1");
		// check the flow to exports
		// StepsToExportCheney(driver);
		// rename downloadedsg
		// String CurrentPath = RandomAction.setdownloadDir();
		// File GFS_OG = RandomAction.getLatestFilefromDir(CurrentPath);
		SendMailSSL.sendMailAction("Cheney - Offline GP", "Cafe Heavenly");
	}

	@Test(priority = 7)
	public void Oceans234_Cheney() throws InterruptedException {
		// check if login is success
		LoginCheney(driver, "067633-00CBI", "Ocea6330");
		// check the flow to exports
		// StepsToExportCheney(driver);
		// System.out.println();
		// rename downloadeds
		// String CurrentPath = RandomAction.setdownloadDir();
		// File GFS_OG = RandomAction.getLatestFilefromDir(CurrentPath);
		SendMailSSL.sendMailAction("Cheney - Offline GP", "Oceans 234");
	}

	@Test(priority = 8)
	public void ShulaBurgerKendall_Cheney() throws InterruptedException {
		// check if login is success
		CustomLoginCheney(driver, "Shula Burger Kendall 02-27-17", "084348-01CBI", "Shula4801");
		// check the flow to exports
		// StepsToExportCheney(driver);
		// rename downloadeds
		// String CurrentPath = RandomAction.setdownloadDir();
		// File GFS_OG = RandomAction.getLatestFilefromDir(CurrentPath);
		SendMailSSL.sendMailAction("Cheney - Offline GP", "Shula Burger Kendall");
	}

	@Test(priority = 9)
	public void ShulaBurgerPC_Cheney() throws InterruptedException {
		// check if login is success
		CustomLoginCheney(driver, "Custom Guide", "60023492CBI", "Sbpc2349");
		// check the flow to exports
		// StepsToExportCheney(driver);
		// rename downloadeds
		// String CurrentPath = RandomAction.setdownloadDir();
		// File GFS_OG = RandomAction.getLatestFilefromDir(CurrentPath);
		SendMailSSL.sendMailAction("Cheney", "Shula Burger PC");
	}

	@Test(priority = 10)
	public void TrumpIntl_Cheney() throws InterruptedException {
		// check if login is success
		LoginCheney(driver, "092233-00cbi", "Trump00");
		// check the flow to exports
		// StepsToExportCheney(driver);
		// rename downloadeds
		// String CurrentPath = RandomAction.setdownloadDir();
		// File GFS_OG = RandomAction.getLatestFilefromDir(CurrentPath);
		SendMailSSL.sendMailAction("Cheney - Offline GP", "Trump International Beach Resort");
	}

	@Test(priority = 11)
	public void TrumpNational_Cheney() throws InterruptedException {
		// check if login is success
		LoginCheney(driver, "092280-00cbi", "Trump9228");
		// check the flow to exports
		// StepsToExportCheney(driver);
		// rename downloadeds
		// String CurrentPath = RandomAction.setdownloadDir();
		// File GFS_OG = RandomAction.getLatestFilefromDir(CurrentPath);
		SendMailSSL.sendMailAction("Cheney - Offline GP", "Trump National Golf Club");
	}

	@Test(priority = 12)
	public void Wycliff_Cheney() throws InterruptedException {
		// check if login is success
		LoginCheney(driver, "098697-01CBI", "Club201");
		// check the flow to exports
		// StepsToExportCheney(driver);
		// rename downloadeds
		// String CurrentPath = RandomAction.setdownloadDir();
		// File GFS_OG = RandomAction.getLatestFilefromDir(CurrentPath);
		SendMailSSL.sendMailAction("Cheney - Offline GP", "Wycliffe Golf & Country Club");
	}

	@Test(priority = 13)
	public void BocaLago_Cheney() throws InterruptedException {
		// check if login is success
		LoginCheney(driver, "016236-01CBI", "BL16236");
		// check the flow to exports
		// StepsToExportCheney(driver);
		// rename downloadeds
		// String CurrentPath = RandomAction.setdownloadDir();
		// File GFS_OG = RandomAction.getLatestFilefromDir(CurrentPath);
		SendMailSSL.sendMailAction("Cheney Brothers", "Boca Lago Country Club");
	}

	@Test(priority = 14)
	public void Woodfield_Cheney() throws InterruptedException {
		// check if login is success
		LoginCheney(driver, "098657-01CBI", "Wood2003");
		// check the flow to exports
		// StepsToExportCheney(driver);
		// rename downloadeds
		// String CurrentPath = RandomAction.setdownloadDir();
		// File GFS_OG = RandomAction.getLatestFilefromDir(CurrentPath);
		SendMailSSL.sendMailAction("Cheney Brothers Inc, Hybrid", "Woodfield Country Club");
	}

	@Test(priority = 15)
	public void ConchRep_Cheney() throws InterruptedException {
		// check if login is success
		LoginCheney(driver, "022965-00CBI", "Republic1");
		// check the flow to exports
		// StepsToExportCheney(driver);
		// rename downloadeds
		// String CurrentPath = RandomAction.setdownloadDir();
		// File GFS_OG = RandomAction.getLatestFilefromDir(CurrentPath);
		SendMailSSL.sendMailAction("Cheney Brothers, Inc", "The Conch Republic");
	}
}

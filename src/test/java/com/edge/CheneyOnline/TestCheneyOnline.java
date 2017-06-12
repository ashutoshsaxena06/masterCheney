package com.edge.CheneyOnline;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.util.framework.RandomAction;
import com.util.framework.SendMailSSL;

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
		RandomAction.deleteFiles("C:\\Users\\Edge\\Downloads");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Edge\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver(options);

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
		System.out.println("1, Dada_Cheney");
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
		System.out.println("2, House_Cheney");
		// check if login is success
		LoginCheney(driver, "60030538CBI", "Hkab3053");
		// check the flow to exports
		// StepsToExportCheney(driver);
		// rename downloadeds
		// String CurrentPath = RandomAction.setdownloadDir();
		// File GFS_OG = RandomAction.getLatestFilefromDir(CurrentPath);
		SendMailSSL.sendMailAction("Cheney", "House T&K");
		SendMailSSL.sendMailAction("Cheney - Offline GP", "Town Kitchen & Bar");
	}

	@Test(priority = 3)
	public void Howleys_Cheney() throws InterruptedException {
		System.out.println("3, Howleys_Cheney");
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
		System.out.println("4, Boynton_Cheney");
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
		System.out.println("5, Wellington_Cheney");
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
		System.out.println("6, CafeHeavenly_Cheney");
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
		System.out.println("7, Oceans234_Cheney");
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
		System.out.println("8, ShulaBurgerKendall_Cheney");
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
		System.out.println("9, ShulaBurgerPC_Cheney");
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
		System.out.println("10, TrumpIntl_Cheney");
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
		System.out.println("11, TrumpNational_Cheney");
		// check if login is success
		LoginCheney(driver, "092280-00cbi", "Trump9228");
		// check the flow to exports
		// StepsToExportCheney(driver);
		// rename downloadeds
		// String CurrentPath = RandomAction.setdownloadDir();
		// File GFS_OG = RandomAction.getLatestFilefromDir(CurrentPath);
		SendMailSSL.sendMailAction("Cheney - Offline GP", "Trump National Golf Club");
	}

	// @Test(priority = 12)
	// public void Wycliff_Cheney() throws InterruptedException {
	// System.out.println("12, Wycliff_Cheney");
	// // check if login is success
	// LoginCheney(driver, "098697-01CBI", "Club201");
	// // check the flow to exports
	// // StepsToExportCheney(driver);
	// // rename downloadeds
	// // String CurrentPath = RandomAction.setdownloadDir();
	// // File GFS_OG = RandomAction.getLatestFilefromDir(CurrentPath);
	// SendMailSSL.sendMailAction("Cheney - Offline GP", "Wycliffe Golf &
	// Country Club");
	// }

	@Test(priority = 13)
	public void BocaLago_Cheney() throws InterruptedException {
		System.out.println("13, BocaLago_Cheney");
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
		System.out.println("14, Woodfield_Cheney");
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
		System.out.println("15, ConchRep_Cheney");
		// check if login is success
		LoginCheney(driver, "022965-00CBI", "Republic1");
		// check the flow to exports
		// StepsToExportCheney(driver);
		// rename downloadeds
		// String CurrentPath = RandomAction.setdownloadDir();
		// File GFS_OG = RandomAction.getLatestFilefromDir(CurrentPath);
		SendMailSSL.sendMailAction("Cheney Brothers, Inc", "The Conch Republic");
	}

	// @Test(priority = 16)
	// public void KeeGrill_Cheney() throws InterruptedException {
	//
	// LoginCheney(driver, "60008181CBI", "Kegr8181");
	// // check the flow to exports
	// // StepsToExportCheney(driver);
	// // rename downloadeds
	// // String CurrentPath = RandomAction.setdownloadDir();
	// // File GFS_OG = RandomAction.getLatestFilefromDir(CurrentPath);
	// SendMailSSL.sendMailAction("Cheney - Offline GP", "Kee Grill
	// Restaurant");
	// }

//	@Test(priority = 17)
//	public void Lucilles_Cheney() throws InterruptedException {
//
//		LoginCheney(driver, "60021442CBI", "Lbbq2144");
//		// check the flow to exports
//		// StepsToExportCheney(driver);
//		// rename downloadeds
//		// String CurrentPath = RandomAction.setdownloadDir();
//		// File GFS_OG = RandomAction.getLatestFilefromDir(CurrentPath);
//		SendMailSSL.sendMailAction("Cheney Brothers Inc, Offline", "Lucille's BBQ");
//	}

	@Test(priority = 18)
	public void SamHudsonBeachBar_Cheney() throws InterruptedException {
		System.out.println("18, Sam80210");
		// check if login is success
		LoginCheney(driver, "080210-00CBI", "Sam80210");
		// check the flow to exports
		// StepsToExportCheney(driver);
		// rename downloadeds
		// String CurrentPath = RandomAction.setdownloadDir();
		// File GFS_OG = RandomAction.getLatestFilefromDir(CurrentPath);
		SendMailSSL.sendMailAction("Cheney - Offline GP", "Sams Hudson Beach Bar");
	}

//	@Test(priority = 18)
//	public void OrangeBlossom_Cheney() throws InterruptedException {
//		System.out.println("18, Sam80210");
//		// check if login is success
//		LoginCheney(driver, "60008022CBI", "FMK123");
//		// check the flow to exports
//		// StepsToExportCheney(driver);
//		// rename downloadeds
//		// String CurrentPath = RandomAction.setdownloadDir();
//		// File GFS_OG = RandomAction.getLatestFilefromDir(CurrentPath);
//		SendMailSSL.sendMailAction("Cheney - Offline GP", "Orange Blossom Hills");
//	}

}

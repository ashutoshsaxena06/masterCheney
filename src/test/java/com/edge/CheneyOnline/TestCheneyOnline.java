package com.edge.CheneyOnline;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.util.framework.CommonCheney;
import com.util.framework.RandomAction;
import com.util.framework.SendMailSSL;


public class TestCheneyOnline extends CommonCheney {
	public static String path = System.getProperty("user.home")+"\\Downloads\\chromedriver_win32\\chromedriver.exe";

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
		RandomAction.deleteFiles(System.getProperty("user.home")+"\\Downloads");
		driver = RandomAction.openBrowser("Chrome", path);
		System.out.println("Invoked browser .. ");

	}

	@AfterMethod
	public void pretearDown() {
		if (driver != null) {
			driver.quit();
			System.out.println("*******EndTest*********");
		}
	}

	@Test
	public void Lucille_Cheney() throws InterruptedException {
		System.out.println("1, Lucille_Cheney");
		// check if login is success
		LoginCheney(driver, "60021442CBI", "Lbbq2144");
		// check the flow to exports
		// StepsToExportCheney(driver);
		// rename downloadeds
		// String CurrentPath = RandomAction.setdownloadDir();
		// File GFS_OG = RandomAction.getLatestFilefromDir(CurrentPath);
	//	SendMailSSL.sendMailAction("Cheney - Offline GP", "Agliolio Boynton Italian Bistro & Bar");
		SendMailSSL.sendMailActionXlsx("Cheney - Offline GP", "Lucille's BBQ");
		
	}

}

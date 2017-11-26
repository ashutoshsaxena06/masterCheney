package com.edge.CheneyOnline;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriverException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.util.framework.ExcelFunctions;
import com.util.framework.PageAction;
import com.util.framework.SendMailSSL;

public class TestCheneyExecutor extends CommonCheney {

	static final int maxtry = 3;
	static int retry = 0;
	public static int rowIndex;
	public static String projectPath = System.getProperty("user.dir");
	public static String inputFile = "C:\\Users\\Ashu\\Desktop\\ExportEngineInput.xlsx";
	// projectPath + "\\config\\ExportEngineInput.xlsx";
	public static String reportFile = "C:\\Users\\Ashu\\Desktop\\ExportSummary_Cheney_"
			+ new Date().toString().replace(":", "").replace(" ", "") + ".xlsx";
	// projectPath+ "\\Output_Summary\\ExportSummary_Cheney_" + new
	// Date().toString().replace(":", "").replace(" ", "")+".xlsx";
	public static int acno;
	public static XSSFWorkbook exportworkbook;
	public static XSSFSheet inputsheet;
	public static int AcColStatus, AcColdetail;
	public static FileOutputStream out;
	public static SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
	public static int totalNoOfRows;
	public static String folderDate;
	public static String currList = "";
	public static String emailMessageExport = "";
	public static String path = "C:\\Users\\Ashu\\Downloads\\chromedriver.exe";
	public static String project = "Cheney";

	private final static Logger logger = Logger.getLogger(TestCheneyExecutor.class);

	@BeforeTest
	public void beforeData() throws Exception {
		// read excel data

		// get active accounts
		// launch browser

		// -- fail ->
		exportworkbook = ExcelFunctions.openFile(inputFile);
		logger.info("Test data read.");
		inputsheet = exportworkbook.getSheet(project);
		AcColStatus = ExcelFunctions.getColumnNumber("Export Status", inputsheet);
		AcColdetail = ExcelFunctions.getColumnNumber("Detailed Export Status", inputsheet);
		// to get the browser on which the UI test has to be performed.
		driver = PageAction.openBrowser("Chrome",path);
		logger.info("Exiting before data.");
		// copy config file to report folder
		// ExcelFunctions.copySheet(exportworkbook, , );
	}

	@AfterTest
	public void closeResources() throws SQLException, IOException {
		logger.info("Closing the resources!");

		if (out != null) {
			logger.info("Closing file output stream object!");
			out.close();
		}
		if (driver != null) {
			logger.info("Closing the browser!");
			// TestCases.driver.close();
			driver.quit();
		}

		if (exportworkbook != null) {
			exportworkbook.close();
		}
	}

	@AfterMethod
	public static void writeExcel() throws IOException {
		logger.info("Running Excel write method!");
		out = new FileOutputStream(new File(reportFile));
		exportworkbook.write(out);
		acno++;
	}

	@DataProvider(name = "testData")
	public static Object[][] testData() throws IOException {
		logger.info("Inside Dataprovider. Creating the Object Array to store test data inputs.");
		Object[][] td = null;
		try {
			// Get TestCase sheet data
			int totalNoOfCols = inputsheet.getRow(inputsheet.getFirstRowNum()).getPhysicalNumberOfCells();
			totalNoOfRows = inputsheet.getLastRowNum();
			logger.info(totalNoOfRows + " Accounts and Columns are: " + totalNoOfCols);
			td = new String[totalNoOfRows][totalNoOfCols];
			for (int i = 1; i <= totalNoOfRows; i++) {
				for (int j = 0; j < totalNoOfCols; j++) {
					td[i - 1][j] = ExcelFunctions.getCellValue(inputsheet, i, j);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Test Cases captured in the Object Array. Exiting dataprovider.");
		return td;
	}

	@Test(dataProvider = "testData")
	public void Export_Mail_OG(
			String active, 
			String accountID, 
			String purveyor, 
			String restaurant_name,
			String username,
			String password, 
			String listname, 
			String exportstatus, 
			String detailedstatus) {
		Boolean result;
		logger.info("Inside OG Export : Started exporting OG for different accounts");
		XSSFCell cell1, cell2;
		TestCheneyExecutor.rowIndex = Math.floorMod(TestCheneyExecutor.acno, TestCheneyExecutor.totalNoOfRows) + 1;
		
		System.out.println("Test Case test #"+TestCheneyExecutor.rowIndex);
		cell1 = TestCheneyExecutor.exportworkbook.getSheet(project).getRow(TestCheneyExecutor.rowIndex).createCell(TestCheneyExecutor.AcColStatus);
		cell1.setCellValue("");
		cell2 = TestCheneyExecutor.exportworkbook.getSheet(project).getRow(TestCheneyExecutor.rowIndex).createCell(TestCheneyExecutor.AcColdetail);
		cell2.setCellValue("");
//		if((cell1=TestCheneyExecutor.exportworkbook.getSheet(project).getRow(TestCheneyExecutor.rowIndex).getCell(TestCheneyExecutor.AcColStatus))==null){
//			cell1 = TestCheneyExecutor.exportworkbook.getSheet(project).getRow(TestCheneyExecutor.rowIndex).createCell(TestCheneyExecutor.AcColStatus);
//			cell1.setCellValue("");
//		}
//		if((cell2=TestCheneyExecutor.exportworkbook.getSheet(project).getRow(TestCheneyExecutor.rowIndex).getCell(TestCheneyExecutor.AcColdetail))==null){
//			cell2 = TestCheneyExecutor.exportworkbook.getSheet(project).getRow(TestCheneyExecutor.rowIndex).createCell(TestCheneyExecutor.AcColdetail);
//			cell2.setCellValue("");
//		}
		exportstatus=cell1.getStringCellValue();
		detailedstatus=cell2.getStringCellValue();

		try {
			if (active.equalsIgnoreCase("Yes")) {
				// if list is not empty
				logger.info(restaurant_name + " for purveryor " + purveyor + " is Active !!");
				if (listname != null && listname.length() == 0) {
					result = LoginCheney(driver, listname.trim(), username.trim(), password.trim());
				} else { // default OG
					result = LoginCheney(driver, username.trim(), password.trim());
				}
				if (result.equals(true)) {
					emailMessageExport = "Pass";
					exportstatus = "Pass";
					detailedstatus = "OG exported succesfully";
				} else {
					emailMessageExport = "Failed";
					exportstatus = "Failed";
					detailedstatus = "OG export Failed";
				}
				SendMailSSL.sendMailAction(purveyor.trim(), restaurant_name.trim());
				logger.info("Mail send successfully for : " + restaurant_name);
			} else {
				logger.info(restaurant_name + " for purveryor " + purveyor + " is not Active !!");
				exportstatus = "Not Active";
			}
			cell1.setCellValue(exportstatus);
			cell2.setCellValue(detailedstatus);
			
			logger.info("Exiting test method");
			
		}catch (WebDriverException ue) {
			ue.printStackTrace();
			driver = PageAction.openBrowser("Chrome",path);
			logger.info("Re-invoked browser instance");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info(emailMessageExport.trim());
	}

	
	////////////////////////////////////////////////
	@AfterClass
	public static void sendMail() {
		try {
			String emailMsg = "Daily "+ project +" OG Export Status:\n";
			if (!emailMessageExport.equals("")) {
				emailMsg = emailMsg + "\n" + sdf + ":\n" + emailMessageExport;
			}
			SendMailSSL.sendReport(emailMsg, reportFile);
			logger.info("Email Sent with Attachment");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	////////////////////////////////////////////////////

}

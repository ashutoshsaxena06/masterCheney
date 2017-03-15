package com.edge.CheneyOnline;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonCheney {

	WebDriver driver;
	WebDriverWait wait;

	public boolean LoginCheney(WebDriver driver, String usernameCBI, String passwordCBI) throws InterruptedException {
		// TODO Auto-generated method stub

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		// launch URL for iTrade
		driver.get("http://www.procurement.itradenetwork.com/Platform/Membership/Login");
		
		Thread.sleep(2000);
		// Wait For Page To Loads
		if (driver.getCurrentUrl().equalsIgnoreCase("https://sts.gemalto.com/adfs/ls/")) {
			driver.findElement(By.xpath("//input[@id='userNameInput']")).sendKeys("ashsaxen@gemalto.com");
			driver.findElement(By.xpath("//input[@id='passwordInput']")).sendKeys("Companyof4");
			driver.findElement(By.xpath("//span[@id='submitButton']")).click();			
		}
		
		// pass login credentials
		wait = new WebDriverWait(driver, 30);
		// enter username
		WebElement chb_Username = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[contains(@id,'username')]"))));
		chb_Username.sendKeys(usernameCBI);
		
		//enter password
		WebElement chb_Password = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[contains(@id,'password')]"))));
		chb_Password.sendKeys(passwordCBI);

		driver.findElement(By.xpath("//input[contains(@id,'rememberMe')]")).click();
		
		// click login
		WebElement btn_Login = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//input[contains(@value,'Login')]"))));
		btn_Login.click();
		
		System.out.println("Login Successful");

		Thread.sleep(2000);
		// ordering
		WebElement lnk_Ordering = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[contains(.,'Ordering')]"))));
		lnk_Ordering.click();
		
		// **** Order Guide / Entire Order Guide Selection *** 
		List<WebElement> allElements = wait.until(ExpectedConditions.visibilityOfAllElements(driver
				.findElements(By.xpath("//a[contains(.,'Ordering')]/following-sibling::div/ul/li/*/*/div/a"))));
		System.out.println(allElements.size());

		for (WebElement element : allElements) {

			if (element.getText().equalsIgnoreCase("Order Guide / Entire Order Guide")) {
				String OG_text = element.getText();
				element.click();
				System.out.println("Clicked on link - " + OG_text);
				break;
			}

		}

		// Export grid button to show list
		WebElement lnk_ExportGridBtn = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//a[contains(@id,'ExportGridButton')]/span/*"))));
		lnk_ExportGridBtn.click();
		System.out.println("Clicked - Export Grid");


		// Click on option to select from Export Type
		WebElement lnk_ExportTyp = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[contains(@id,'ExportType')]/span/*"))));
		lnk_ExportTyp.click();

		// choose default type as Excel
		WebElement ddl_Excel = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[contains(.,'Excel')]"))));
		ddl_Excel.click();
		System.out.println("format choosen as Excel");
		// div[@id='ExportTypeContainer']/div/ul/li[2]/a/span

		Thread.sleep(2000);

		// Select columns for OG - Item no., Pack, Brand, Description, Price &
		// caseUom

		try {
			ArrayList<String> removeColumns = new ArrayList<String>();
			List<WebElement> OG_Col = driver.findElements(By.xpath("//ul[@id='Sortable']/*"));
			System.out.println(OG_Col.size());
			String Col_id;
			Iterator<WebElement> iterator = OG_Col.iterator();
			while (iterator.hasNext()) {
				WebElement element = (WebElement) iterator.next();
				//Thread.sleep(2000);
				
				Col_id = element.getAttribute("id");
				if (Col_id.equalsIgnoreCase("DistributorNumber") || Col_id.equalsIgnoreCase("CasePack")
						|| Col_id.equalsIgnoreCase("Brand") || Col_id.equalsIgnoreCase("Description")
						|| Col_id.equalsIgnoreCase("CasePrice") || Col_id.equalsIgnoreCase("CaseUom")) {
					System.out.println("selected column :- " + Col_id);
					iterator.remove();
				} 
				
				else {
					
					removeColumns.add(Col_id);

				}
			}

			System.out.println(removeColumns.size()+" and "+OG_Col.size());
			
			for (int i = 0; i < removeColumns.size(); i++) {
				WebElement ll_removeCol = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//li[contains(@id,'"+ removeColumns.get(i) +"')]"))));// remove column
				driver.findElement(By.xpath("//li[contains(@id,'"+ removeColumns.get(i) +"')]/table/tbody/tr/td[2]/img")).click();
				Thread.sleep(5000);
				System.out.println("removed column :- " + removeColumns.get(i) );
			}
		

		} catch (StaleElementReferenceException e) {

			e.printStackTrace();
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		// Click Download Button
		WebElement lnk_Download = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//a[contains(@id,'DownloadButton')]"))));
		lnk_Download.click();
		
		// Choose Logout option
		WebElement lnk_Logout = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//a[contains(.,'Logout')]"))));
		lnk_Logout.click();
		
		Thread.sleep(5000);

		return true;

	}

	public boolean CustomLoginCheney(WebDriver driver, String OGName, String usernameCBI, String passwordCBI)
			throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		// launch URL for iTrade
		driver.get("http://www.procurement.itradenetwork.com/Platform/Membership/Login");

		Thread.sleep(2000);
		// Wait For Page To Loads
		if (driver.getCurrentUrl().equalsIgnoreCase("https://sts.gemalto.com/adfs/ls/")) {
			driver.findElement(By.xpath("//input[@id='userNameInput']")).sendKeys("ashsaxen@gemalto.com");
			driver.findElement(By.xpath("//input[@id='passwordInput']")).sendKeys("Companyof4");
			driver.findElement(By.xpath("//span[@id='submitButton']")).click();			
		}
		
		// pass login credentials
		wait = new WebDriverWait(driver, 30);
		// enter username
		WebElement chb_Username = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[contains(@id,'username')]"))));
		chb_Username.sendKeys(usernameCBI);
		
		//enter password
		WebElement chb_Password = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[contains(@id,'password')]"))));
		chb_Password.sendKeys(passwordCBI);

		driver.findElement(By.xpath("//input[contains(@id,'rememberMe')]")).click();
		
		// click login
		WebElement btn_Login = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//input[contains(@value,'Login')]"))));
		btn_Login.click();
		
		System.out.println("Login Successful");

		Thread.sleep(2000);
		// ordering
		WebElement lnk_Ordering = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[contains(.,'Ordering')]"))));
		lnk_Ordering.click();
		
		// **** Custom Order Guide Selection *** 
		List<WebElement> allElements = driver
				.findElements(By.xpath("//a[contains(.,'Ordering')]/following-sibling::div/ul/li/*/*/div/a"));
		System.out.println(allElements.size());

		for (WebElement element : allElements) {

			if (element.getText().equalsIgnoreCase("Custom Order Guides")) {
				String OG_text = element.getText();
				element.click();
				System.out.println("Clicked on link - " + OG_text);
				break;
			}

		}
		
		Thread.sleep(2000);
		// Check and Select ListName
		WebElement ListName = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//td/a[contains(.,'" + OGName + "')]"))));
		ListName.isDisplayed();
		ListName.click();
		
		// Export grid button to show list
		WebElement lnk_ExportGridBtn = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[contains(@id,'ExportGridButton')]/span/*"))));
		lnk_ExportGridBtn.click();
		System.out.println("Clicked - Export Grid");

		// Click on option to select from Export Type
		WebElement lnk_ExportTyp = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[contains(@id,'ExportType')]/span/*"))));
		lnk_ExportTyp.click();

		// choose default type as Excel
		WebElement ddl_Excel = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[contains(.,'Excel')]"))));
		ddl_Excel.click();
		System.out.println("format choosen as Excel");
		// div[@id='ExportTypeContainer']/div/ul/li[2]/a/span

		Thread.sleep(2000);

		// Select columns for OG - Item no., Pack, Brand, Description, Price &
		// caseUom

		try {
			ArrayList<String> removeColumns = new ArrayList<String>();
			List<WebElement> OG_Col = driver.findElements(By.xpath("//ul[@id='Sortable']/*"));
			System.out.println(OG_Col.size());
			String Col_id;
			Iterator<WebElement> iterator = OG_Col.iterator();
			while (iterator.hasNext()) {
				WebElement element = (WebElement) iterator.next();
				//Thread.sleep(2000);
				
				Col_id = element.getAttribute("id");
				if (Col_id.equalsIgnoreCase("DistributorNumber") || Col_id.equalsIgnoreCase("CasePack")
						|| Col_id.equalsIgnoreCase("Brand") || Col_id.equalsIgnoreCase("Description")
						|| Col_id.equalsIgnoreCase("CasePrice") || Col_id.equalsIgnoreCase("CaseUom")) {
					System.out.println("selected column :- " + Col_id);
					iterator.remove();
				} 
				
				else {
					
					removeColumns.add(Col_id);

				}
			}

			System.out.println(removeColumns.size()+" and "+OG_Col.size());
			
			for (int i = 0; i < removeColumns.size(); i++) {
				
				WebElement ll_removeCol = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//li[contains(@id,'"+ removeColumns.get(i) +"')]/table/tbody/tr/td[2]/img"))));// remove column
				ll_removeCol.click();
				System.out.println("removed column :- " + removeColumns.get(i) );
			}
			
		} catch (StaleElementReferenceException e) {

			e.printStackTrace();
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		// Click Download Button
		WebElement lnk_Download = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//a[contains(@id,'DownloadButton')]"))));
		lnk_Download.click();
		
		// Choose Logout option
		WebElement lnk_Logout = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//a[contains(.,'Logout')]"))));
		lnk_Logout.click();
		
		Thread.sleep(5000);

		return true;


	}


}

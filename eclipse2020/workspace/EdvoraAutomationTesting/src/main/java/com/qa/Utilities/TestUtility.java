package com.qa.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.Utilities.Constants;
import com.qa.baseClass.BaseTest;


public class TestUtility extends BaseTest{

	public static Workbook book;
	public static Sheet sheet;

	public static Actions actions;
	public static Select select;
	public static Alert alert;

	//DataProvider Utility is used for getting Data from Excel ==>> Should be used with @DataProvider.
	public static Object[][] getTestData(String sheetName) 
	{
		FileInputStream file = null;
		try 
		{
			file = new FileInputStream(Constants.TEST_DATA_SHEET_PATH);
		} 
		catch(FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		try 
		{
			book = WorkbookFactory.create(file);
		} 
		catch(IOException e) 
		{
			e.printStackTrace();
		}

		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i = 0; i < sheet.getLastRowNum(); i++) 
		{
			for(int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) 
			{
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
			}
		}
		return data;
	}

	// javascript executor
	public void jsExecutorMethod(WebDriver driver, WebElement element){
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0]. click();", element);
	}

	//To Take Screenshot at End Of Test.
	public static void takeScreenshotAtEndOfTest() throws IOException 
	{
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/Screenshots/" + System.currentTimeMillis() + ".png"));
	}

	//Explicit Wait to Click on WebElement.
	public static void clickOn(WebDriver driver, WebElement element, int timeout) 
	{
		new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}

	//Explicit Wait to Send Data to WebElement.
	public static void sendKeys(WebDriver driver, WebElement element, int timeout, String value) 
	{
		new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOf(element));
		element.sendKeys(value);
	}

	//Explicit Wait for Element To Be Visible.
	public static void waitForElementToBeVisible(WebDriver driver, By locator, int timeout)
	{
		new WebDriverWait(driver, timeout).
		until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	//To Handle Multiple Windows or Switch Between Multiple Windows.
	public void switchWindow(WebDriver driver, String firstWindow, String secondWindow) 
	{
		Set<String> windowHandles = driver.getWindowHandles();
		for(String windows : windowHandles) 
		{
			if(!windows.equals(firstWindow) && !windows.equals(secondWindow)) 
			{
				driver.switchTo().window(windows);
			}
		}
	}

	//To Check Element is Displayed or No.
	public static void isElementDisplayed(WebElement element) 
	{
		boolean elementDisplayed = element.isDisplayed();
		if(elementDisplayed) 
		{
			System.out.println("Element is Displayed");
		} 
		else 
		{
			System.out.println("Element is not Displayed");
		}
	}

	//To Check Element is Enabled or No.
	public static void isElementEnabled(WebElement element) 
	{
		boolean elementEnabled = element.isEnabled();
		if(elementEnabled) 
		{
			System.out.println("Element is Enabled");
		} 
		else 
		{
			System.out.println("Element is not Enabled");
		}
	}

	//To Accept Alert Pop-Up.
	public static void acceptAlertPopup() throws InterruptedException 
	{
		try 
		{
			alert = driver.switchTo().alert();
			System.out.println(alert.getText());
			Thread.sleep(2000);
			alert.accept();
			System.out.println("Alert Accepted Successfully");
		} 
		catch(Exception e) 
		{
			e.printStackTrace();
			System.out.println("Something Went Wrong ==>> Please Check ::: " +e.getMessage());
		}
	}

	//To Dismiss Alert Pop-Up.
	public static void dismissAlertPopup() throws InterruptedException 
	{
		try 
		{
			alert = driver.switchTo().alert();
			System.out.println(alert.getText());
			Thread.sleep(2000);
			alert.dismiss();
			System.out.println("Alert Dismissed Successfully");
		} 
		catch(Exception e) 
		{
			System.out.println("Something Went Wrong ==>> Please Check ::: " + e.getMessage());
		}
	}

	//To Click on Element using Actions Class.
	public void clickOnElementUsingActions(WebElement element) 
	{
		actions = new Actions(driver);
		actions.moveToElement(element).click().perform();
	}

	//To Mouse Hover and Click or Select an Element using Actions Class.
	public static void moveToElement(WebDriver driver, WebElement element) 
	{
		actions = new Actions(driver);
		actions.moveToElement(element).build().perform();
	}

	//Extent Report - 1.
	public static String getSystemDate() 
	{
		DateFormat dateFormat = new SimpleDateFormat("_ddMMyyyy_HHmmss");
		Date date = new Date();
		return dateFormat.format(date);
	}

	//Extent Report - 2.
	public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException 
	{
		String dateName = new SimpleDateFormat("_ddMMyyyy_HHmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);

		String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/" + screenshotName + dateName + ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}

	//Set Date For Log4J.
	public static void setDateForLog4j()
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("_ddMMyyyy_HHmmss");
		System.setProperty("current_date", dateFormat.format(new Date()));
		PropertyConfigurator.configure("./src/main/resources/Log4j.properties");
	}





}

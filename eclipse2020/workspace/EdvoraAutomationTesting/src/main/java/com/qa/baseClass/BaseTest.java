package com.qa.baseClass;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.qa.Utilities.Constants;
import com.qa.Utilities.ReadConfig;

public class BaseTest {

	ReadConfig rc = new ReadConfig();
	public String eURL = rc.getURL();
	public String eUserName = rc.getUserName();
	public String ePassword = rc.getPassword();
	public String eChromeDriverPath = rc.getChromeDriverPath();

	public static WebDriver driver;
	public static Logger logger;
	ExtentReports extent;
	ExtentTest extentTest;
	ExtentSparkReporter sparkReport;

	@BeforeMethod
	public void setup()
	{

		sparkReport = new ExtentSparkReporter("extentReport.html");
		//create ExtentReports and attach reporter(s)
		extent = new ExtentReports();
		extent.attachReporter(sparkReport);

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.manage().timeouts().pageLoadTimeout(Constants.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT, TimeUnit.SECONDS);

	}

	@AfterMethod(alwaysRun=true)
	public void tearDown() throws IOException
	{
		driver.quit();
		//logger.info("Browser Terminated");
		//logger.info("-----------------------------------------------");
	}
}

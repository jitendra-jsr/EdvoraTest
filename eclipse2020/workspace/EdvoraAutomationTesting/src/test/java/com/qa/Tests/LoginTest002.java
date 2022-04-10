package com.qa.Tests;

import org.junit.Assert;import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.Pages.LoginPage;
import com.qa.Utilities.Constants;
import com.qa.Utilities.TestUtility;
import com.qa.baseClass.BaseTest;

public class LoginTest002 extends BaseTest
{
	LoginPage lp;
	
	
	public LoginTest002()
	{
		super();
	}
	
	@Test(priority = 1)
	public void LoginPageTest() throws InterruptedException
	{
		driver.get(eURL);
		lp = new LoginPage(driver);
		
		lp.createUN(eUserName);
		lp.createPwd(ePassword);
		
		//ct.createLogin(eUserName,ePassword);
		//ct.createLogin(prop.getProperty("username"), prop.getProperty("password"));
		lp.clickCreateAccButton();
		Thread.sleep(5000);	
	
		Assert.assertEquals(driver.getCurrentUrl(), Constants.LOGIN_PAGE_URL);
	
	}
	
	
	
}

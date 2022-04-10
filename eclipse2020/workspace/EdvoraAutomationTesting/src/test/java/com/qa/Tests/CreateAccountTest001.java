package com.qa.Tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.Pages.CreateAccountPage;
import com.qa.Utilities.TestUtility;
import com.qa.baseClass.BaseTest;

public class CreateAccountTest001 extends BaseTest
{
	CreateAccountPage ct;
	
	
	public CreateAccountTest001()
	{
		super();
	}
	
	
	@Test
	public void createAccTest() throws InterruptedException
	{
		driver.get(eURL);
		ct = new CreateAccountPage(driver); 
		
		ct.clickSignIn();
		
		ct.createUN(eUserName);
		
		ct.createPwd(ePassword);
		
		ct.clickCreateAccButton();
		
		
		try {
			TestUtility.acceptAlertPopup();
		} catch (InterruptedException e) {
			e.getMessage();
		}
	}
	
}

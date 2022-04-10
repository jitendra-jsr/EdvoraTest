package com.qa.Tests;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import com.qa.Pages.LoginPage;
import com.qa.Pages.SettingsPage;
import com.qa.Utilities.DProviders;
import com.qa.Utilities.TestUtility;
import com.qa.Utilities.Xls_Reader;
import com.qa.Utilities.Xlxs_Reader;
import com.qa.baseClass.BaseTest;

public class SettingsTest003 extends BaseTest {

	
	@Test(dataProvider = "data-provider", dataProviderClass = DProviders.class)
	public void updateSettings(String fName, String uName, String mNo, String address ) throws Exception
	{
		LoginPage lp = new LoginPage(driver);
		driver.get(eURL);
				
		lp.createUN(eUserName);
		lp.createPwd(ePassword);
		lp.clickCreateAccButton();
		
		SettingsPage sp = new SettingsPage(driver);
		sp.clickEdit();
		
		sp.fullName(fName);
		sp.mobileNumber(mNo);
		sp.address(address);
		
		TestUtility.clickOn(driver, sp.saveButton, 2);
		
		
	}
	
}

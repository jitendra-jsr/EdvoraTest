package com.qa.Utilities;

import org.testng.annotations.DataProvider;

public class DProviders {

	@DataProvider (name = "data-provider")
	public Object[][] dpMethod(){
		return new Object[][] {{"ABC","123A","23324234","1st avenue"}};
		
		//Object data [][] = TestUtility.getTestData("Sheet1");
		//return data;
	}
}

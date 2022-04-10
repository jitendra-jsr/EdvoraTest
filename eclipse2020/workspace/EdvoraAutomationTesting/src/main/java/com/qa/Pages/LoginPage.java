package com.qa.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.baseClass.BaseClass;
import com.qa.baseClass.BaseTest;

public class LoginPage extends BaseTest
{
	WebDriver ldriver;
	
	@FindBy(xpath="//div[@class='css-llqj01']//div[1]//div[1]//input[1]")
	WebElement username;
	
	@FindBy(xpath="//div[@class='css-llqj01']//div[2]//div[1]//input[1]")
	WebElement password;

	@FindBy(xpath="//button[contains(text(),'Login')]")
	WebElement createAccountButton;
	
	public LoginPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
//	public CreateAccountPage()
//	{
//		PageFactory.initElements(driver, this);
//	}
	
//	public void createLogin(String userName, String pwd)
//	{
//		username.sendKeys(userName);
//		password.sendKeys(pwd);
//	}
	
	public void createUN(String userName)
	{
		username.sendKeys(userName);
	}
	public void createPwd(String pwd)
	{
		password.sendKeys(pwd);
	}
	public void clickCreateAccButton()
	{
		createAccountButton.click();
	}
}

package com.qa.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.baseClass.BaseClass;

public class CreateAccountPage 
{
	WebDriver ldriver;
	
	@FindBy(xpath="//button[contains(text(),'SignIn')]")
	WebElement signIn;
	
	@FindBy(xpath="//div[@class='css-llqj01']//div[1]//div[1]//input[1]")
	WebElement username;
	
	@FindBy(xpath="//div[@class='css-llqj01']//div[2]//div[1]//input[1]")
	WebElement password;

	@FindBy(xpath="//button[contains(text(),'Create Account')]")
	WebElement createAccountButton;
	
	public CreateAccountPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	public void clickSignIn()
	{
		signIn.click();
	}
	
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

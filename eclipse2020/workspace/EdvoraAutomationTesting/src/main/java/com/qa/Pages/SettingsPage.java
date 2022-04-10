package com.qa.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SettingsPage {

	WebDriver ldriver;

	public SettingsPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath="//button[normalize-space()='Edit']")
	WebElement clickEditButton;
	
	@FindBy(xpath="//body/div[@id='__next']/div[1]/main[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]")
	WebElement fulName;
	
	@FindBy(xpath="//body/div[@id='__next']/div[1]/main[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]")
	WebElement uname;
	
	@FindBy(xpath="//body/div[@id='__next']/div[1]/main[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[3]/div[1]/input[1]")
	WebElement mobileNo;

	@FindBy(xpath="//body/div[@id='__next']/div[1]/main[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/input[1]")
	WebElement dob;

	@FindBy(xpath="//body/div[@id='__next']/div[1]/main[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[3]/div[1]/input[1]")
	WebElement address;
	
	@FindBy(xpath="//div[@class='css-0']//div[1]//div[1]//div[1]//div[1]//button[1]")
	public
	WebElement saveButton;
	
	@FindBy(xpath="//body/div[@id='__next']/div[1]/main[1]/div[1]/div[1]/div[2]/div[2]/button[1]")
	public WebElement cancelButton;
	
	
	//
	public void clickEdit()
	{
		clickEditButton.click();
	}
	
	public void fullName(String fName)
	{
		fulName.sendKeys(fName);
	}
	
	public void createUN(String userName)
	{
		uname.sendKeys(userName);
	}

	public void mobileNumber(String mobile)
	{
		mobileNo.sendKeys(mobile);
	}
	
	public void dateOfB(String doB)
	{
		dob.sendKeys(doB);
	}
	
	
	public void address(String Address)
	{
		address.sendKeys(Address);
	}
	
	public void savebutton()
	{
		saveButton.click();
	}

	public void cancelbutton()
	{
		cancelButton.click();
	}
}

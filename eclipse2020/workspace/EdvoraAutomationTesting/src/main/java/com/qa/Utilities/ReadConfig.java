package com.qa.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	public static Properties prop;

	// read data from the config file
	public ReadConfig()
	{
		File src = new File("./Configuration/config.properties");
		try {
			FileInputStream fis = new FileInputStream(src);
			prop = new Properties();
			prop.load(fis);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Get url 
	public String getURL()
	{
		String url = prop.getProperty("baseURL");
		return url;
	}

	// get username
	public String getUserName()
	{
		String userName = prop.getProperty("username");
		return userName;
	}

	// get password
	public String getPassword()
	{
		String Password = prop.getProperty("password");
		return Password;
	}

	// get driver path
	public String getChromeDriverPath()
	{
		String chromeDriver = prop.getProperty("chromeDriverPath");
		return chromeDriver;
	}



}

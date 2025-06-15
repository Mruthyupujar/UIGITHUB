package com.convo.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	//similar to POM
	Properties pro;
	//contrustor
	public ReadConfig()
	{
		File src = new File ("./Configuration Files/config.properties");
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exception is "+ e.getMessage());
		}
		
	}
	
	public String getApplicationURL () 
{
	String url = pro.getProperty("baseURL");
	return url;
}
	public String getUsername ()
	{
		String username = pro.getProperty("username");
		return username;
		
	}
	public String getPassword() 
	{
		String password = pro.getProperty("password");
		return password;
		
	}
	public String getChromePAth()
	{
		String chromepath = pro.getProperty("chromepath");
		return chromepath;
	}
	public String getFirefoxPath()
	{
		String firefoxpath = pro.getProperty("firefox");
		return firefoxpath;
	}
	
}

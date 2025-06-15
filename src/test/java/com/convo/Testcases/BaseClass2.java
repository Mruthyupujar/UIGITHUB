package com.convo.Testcases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.convo.utilities.ReadConfig;

import freemarker.log.Logger;

public class BaseClass2 {
	
	//creating obj form utilitis methods call
	ReadConfig readconfig = new ReadConfig ();
	
	public String baseurl = readconfig.getApplicationURL();
	public String username = readconfig.getUsername();
	public String password = readconfig.getPassword();
	public static WebDriver driver;
	public static Logger logger ;
	
	
	@BeforeClass
	public void setup(String br)
	{
		
		//adding log messages for every step 
		 logger = Logger.getLogger("convo");
		PropertyConfigurator.configure ("Log4j.properties");
		
		
		if (br.equals("chrome")) 
		{
			System.setProperty("Webdriver.chrome.driver", readconfig.getChromePAth());
			driver = new ChromeDriver();
		}
		else if (br.equals("firefox")) 
		{
			System.setProperty("Webdriver.gecko.driver", readconfig.getFirefoxPath());
			driver = new FirefoxDriver();	
		}
			
		
		driver.manage().window().maximize();
		
		driver.get(baseurl);
		
	}
	/*@AfterClass
	public void tearDown()
	{
		driver.quit();
	}*/
	public void captureScreen (WebDriver driver, String tname ) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir")+ "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot Taken");
	}

	
	
	
	

}

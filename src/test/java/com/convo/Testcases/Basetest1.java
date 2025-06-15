package com.convo.Testcases;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Basetest1 {
	
		public static void main(String[] args) throws InterruptedException {
			// TODO Auto-generated method stub
			WebDriver driver1 = new ChromeDriver();
			//WebDriver driver1 = new FirefoxDriver();
			
			
			System.setProperty("webdriver.chrome.driver", "D:/chromedriver_win32/chromedriver.exe");
			//System.setProperty("webdriver.gecko.driver", "D:/firefoxe1/geckodriver.exe");
			driver1.manage().window().maximize();
			driver1.get("https://v2-dot-qa-tvelp.uc.r.appspot.com/"); //waiting for page is fully ready
			//driver1.navigate().to("https://qa-tvelp.firebaseapp.com");
			//driver1.navigate().back();
			//driver1.navigate().forward();
			driver1.findElement(By.xpath("//button[normalize-space()='Login']")).click();
			//click on google icon
			driver1.findElement(By.xpath("//div[@class = 'login_g-label__fAhLX']")).click();
			Thread.sleep(3000);
			Set <String> windows = driver1.getWindowHandles();
			Iterator<String> it = windows.iterator();
			String p = it.next(); //parent window
			String c = it.next();// child window
			driver1.switchTo().window(c);
			Thread.sleep(3000);
			driver1.findElement(By.xpath("//input[@type='email']")).sendKeys("mruthyupujar@gmail.com");
			driver1.findElement(By.xpath("//span[text()='Next']")).click();
			driver1.findElement(By.xpath("//input[@type='password']")).sendKeys("Muttu@1994");
			 driver1.findElement(By.xpath("//span[text()='Next']")).click();
			  Thread.sleep(5000);
			driver1.close();


		}}

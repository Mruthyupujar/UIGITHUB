package com.convo.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver ldriver ;
	
	public LoginPage (WebDriver rdriver )
	{
	ldriver = rdriver;
	 PageFactory.initElements(rdriver,this );	
	}
	@FindBy(id = "login-email")
	@CacheLookup
	WebElement txtUserName;
	@FindBy(name = "password")
	@CacheLookup
	WebElement txtPassword;
	@FindBy(id = "show-signup")
	@CacheLookup
	WebElement btnLogin;
	@FindBy(xpath = "//div[@class='navbar-fixed-top']//button[1]")
	@CacheLookup
	WebElement profiledropdown;
	@FindBy(xpath = "//a[@role='button']")
	@CacheLookup
	WebElement logout;
	
	
	
	
	public void setUserName (String uname)
	{
		txtUserName.sendKeys(uname);
	}
	public void setPassWord (String pwd)
	{
		txtPassword.sendKeys(pwd);
	}
	public void clickSubmit ()
	{
		btnLogin.click();
	}
	public void Profile ()
	{
		profiledropdown.click();
		//logout.click();
	}
	

}


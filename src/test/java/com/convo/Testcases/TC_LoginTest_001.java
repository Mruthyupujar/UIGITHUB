package com.convo.Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.convo.pageobjects.LoginPage;
import com.convo.pageobjects.ProductPage;



public class TC_LoginTest_001 extends BaseClass
{
	@Test
	public void loginTest () throws InterruptedException
	{
		
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		lp.setPassWord(password);
		lp.clickSubmit();
		Thread.sleep(3000);
		//.Profile();
		
		//review after add
		if (driver.getPageSource().equals("https://qa-sde.useconvo.com/")) {
			Assert.assertTrue(false);
			
		}
		else {
			Assert.assertTrue(true);
		}
		
	}
	/*@Test (priority = 1)
	public void productPage () throws InterruptedException
	{
		ProductPage prod = new ProductPage(driver);
		prod.clickProdpage();
		Thread.sleep(3000);
		prod.addProd();	
		prod.enterDetails();
		prod.productType();
		Thread.sleep(5000);
		prod.price();
		prod.appId();
		Thread.sleep(3000);
		
		
	}*/
}

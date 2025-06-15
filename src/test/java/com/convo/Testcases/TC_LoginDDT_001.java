package com.convo.Testcases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.convo.pageobjects.LoginPage;
import com.convo.utilities.XLUtils;

public class TC_LoginDDT_001 extends BaseClass
{
	//data driven testcase 
	@Test (dataProvider = "LoginData")
	public void loginDDT (String user, String pwd) throws InterruptedException
	{
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(user);
		logger.info("user name provoded");
		lp.setPassWord(pwd);
		logger.info("user password provoded");
		lp.clickSubmit();
		Thread.sleep(3000);
		//when login is failed for invalid data

		if (isAlertPresent()==true)
		{
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("login failed");
		}
		else
		{
			Assert.assertTrue(true);
			logger.warn("login Passed");
			//lp.Profile();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();//close logout alert
			driver.switchTo().defaultContent();
		}
			

		}








	
	public boolean isAlertPresent () //user defined method created to check alert is present or not
	{
		try {
			driver.switchTo().alert();
			return true;
		}
		catch (NoAlertPresentException e)
		{
			return false;
		}


	}





	@DataProvider (name = "LoginData")
	String [][]getData() throws IOException
	{
		//create 2d array for getting data from xcell files 
		String path = System.getProperty("user.dir")+ "/src/test/java/com/convo/Testdata/LoginData.xlsx";
		int rownum = XLUtils.getRowCount(path, "sheet1");
		int colcount = XLUtils.getCellCount(path, "Sheet1", 1);
		String logindata[][]= new String [rownum][colcount];
		for (int i = 0; i<=rownum;i++)
		{
			for (int j = 0;j<colcount;j++)
			{
				logindata [i-1] [j] = XLUtils.getCellData(path, "sheet1", i, j); //1,0

			}
		}
		return logindata;




	}




}

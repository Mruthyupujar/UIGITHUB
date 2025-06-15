package com.convo.utilities;
// listener class used to generate extent reports
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter 
{
	public ExtentSparkReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest logger;
	
	public void onstart (ITestContext testcontext) throws IOException
	{
		String timeStamp = new SimpleDateFormat("yyyy.mm.dd.h.mm.ss").format(new Date());//time stamp
		String repName = "Test-Report" + timeStamp+ ".html";
		
		
		htmlReporter = new ExtentSparkReporter (System.getProperty("user.dir")+ "/test-output/" + repName);//specify location
		htmlReporter.loadXMLConfig(System.getProperty("user.dir")+ "extent-config.xml");
		
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Hostname", "localhost");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("user", "Muttu");
		
		htmlReporter.config().setDocumentTitle("Convo Test Project"); //Tile of report
		htmlReporter.config().setReportName("Functional Test Automation Report"); //name of the report
		htmlReporter.config().setTheme(Theme.DARK);

	}
	public void onTestSucess(ITestResult tr)
	{
	logger = extent.createTest(tr.getName()); //create nee entry in the Report
	logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
		
	}
	
	public void onTestFailure (ITestResult tr)
	{
	logger = extent.createTest(tr.getName()); //create new entry to report
	logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));//send the Passed INformation
	String ScreenshotPath = System.getProperty("user.dir")+ "\\Screenshots\\"+tr.getName()+".png";
	
	File f = new File(ScreenshotPath);
	if (f.exists())
	{
		try {
		logger.fail("screenshot is below:" + logger.addScreenCaptureFromPath(ScreenshotPath));
	}
		catch (Exception e)
		{
			// TODO: handle exception
			e.printStackTrace();
		}
			
	}
	}
	public void onTestSkipped (ITestResult tr )
	{
		logger = extent.createTest(tr.getName()); //create new entry in the Report
		logger.log(Status.SKIP,MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));
	}
	
	}


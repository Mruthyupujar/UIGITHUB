package com.convo.pageobjects;





import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
	
	WebDriver ldriver ;
	
	public ProductPage (WebDriver rdriver )
	{
		ldriver = rdriver;
		 PageFactory.initElements(rdriver,this );
	}
	@FindBy(xpath = "//a[@class='active']")
	@CacheLookup
	WebElement ProductPage;
	
	//add product btn 
	@FindBy (xpath = "//button[@class='btn blue medium']")
	@CacheLookup
	WebElement AddProductButton;
	//display name add prodcu page 
	@FindBy(xpath = "//input[@id='title']")
	@CacheLookup
	WebElement Displayname ;
	//ading subscription
	@FindBy(xpath = "//button[normalize-space()='Choose a product type']")
	@CacheLookup
	WebElement ProuctType;
	//select 1 option 
	@FindBy(xpath = "(//span[normalize-space()='Annual Subscription'])[1]")
	@CacheLookup
	WebElement AnnualSubscription;
	//selecting timperiod 
	@FindBy(xpath = "//button[normalize-space()='Choose a trial length']")
	@CacheLookup
	WebElement TrailLength;
	//selecting length
	@FindBy(xpath = "//div[contains(@class,'dropdown-content left show')]//li[2]")
	@CacheLookup
	WebElement month;
	//adding price
	@FindBy(id = "price")
	@CacheLookup
	WebElement price;
	
	//adding discounted price
	@FindBy(id = "discounted-price")
	@CacheLookup
	WebElement discountedprice;
	
	//adding Appid 
	@FindBy(xpath = "//button[normalize-space()='Choose an App ID']")
	@CacheLookup
	WebElement ChooseAppid;
	
	//selecting appid 
	@FindBy(xpath = "(//li[contains(@class,'selected-option')])[7]")
	@CacheLookup
	WebElement Appid;
	
	//clicking save button 
	@FindBy(xpath = "//button[normalize-space()='Save']")
	@CacheLookup
	WebElement save;
	
	//selecting webelement 
	@FindBy(xpath = "//tbody/tr[1]/td[1]/input[1]")
	@CacheLookup
	WebElement selectProd;
	
	//delete selected product 
	@FindBy(xpath = "//button[contains(@class,'table-icon red-delete')]")
	@CacheLookup
	WebElement delete;
	
	
	public void clickProdpage() 
	{
		ProductPage.click(); //product page displayed 
	}
	
	public void addProd()
	{
		AddProductButton.click();
		//product page appears 
	}
	public void enterDetails()
	{
		Displayname.sendKeys("Automation");

	}
	public void productType ()
	{
		ProuctType.click();
		AnnualSubscription.click();
		TrailLength.click();
		month.click();
	}
	public void price()
	{
		price.sendKeys("12345");
		discountedprice.sendKeys("123");
	}
	public void appId()
	{
		ChooseAppid.click();
		Appid.click();
			
	}
	public void save()
	{
		save.click();
	}
	
	
}

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Convo {

	public static void main(String[] args) throws InterruptedException  {
		// TODO Auto-generated method stub
		
		
		WebDriver driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
		driver.manage().window().maximize();
		//hit the url 
		driver.get("https://www.google.com/");
		//waiting for page is fully ready for getting error message 
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.navigate().to("https://qa-sde.useconvo.com/");
		driver.navigate().back();
		driver.navigate().forward();
		
		
		
		driver.findElement(By.id("login-email")).sendKeys("mruthyunjay+329@useblitz.com");
		driver.findElement(By.id("password")).sendKeys("qwddfdfderty");
		driver.findElement(By.xpath("//button[@type ='submit']")).click();
		//getting error message 
		
		Thread.sleep(3000);
		System.out.println(driver.findElement(By.className("error")).getText()); 
	Assert.assertEquals(driver.findElement(By.className("error")).getText(), "user password is invalid");
	

		
		
		
		
		
		
	//	driver.close();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}

package testng;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderDemo {
	
	WebDriver driver;
	
	@BeforeClass
	void setup()
	{
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		
	}
	
	@Test(dataProvider="dp")
	void testLogin(String email,String pass) throws InterruptedException
	{
        driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
		
		driver.findElement(By.id("input-email")).sendKeys(email);
		driver.findElement(By.id("input-password")).sendKeys(pass);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		Thread.sleep(3000);
		
		
				WebElement title =driver.findElement(By.xpath("//h2[normalize-space()='My Account']"));
				System.out.println(title.getText());
						boolean status = title.isDisplayed();
		
		if(status==true)
		{
			driver.findElement(By.xpath("//a[@class='list-group-item'][normalize-space()='Logout']")).click();
			Assert.assertTrue(true);
		}
		else
		{
			Assert.fail();
		}
			
		
	}
	
	@AfterClass
	void tearDown()
	{
		driver.quit();
	}
	
	
	@DataProvider(name="dp",indices= {0,1})
	Object [][] loginData()
	{
		Object data [][] = 
			{
				{"abc@gmail.com","test123"},
				{"sinu1234@gmail.com","Roshan@1712"},
				{"admin123@gmail.com","Admin123"},
				{"xyz@gmail.com","test@123"}
		     };
		return data;
	}
	

}

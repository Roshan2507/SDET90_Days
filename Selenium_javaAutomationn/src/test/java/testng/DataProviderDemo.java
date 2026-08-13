package testng;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DataProviderDemo {
	
	WebDriver driver;
	
	@BeforeClass
	void setup()
	{
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		
	}
	
	@Test
	void testLogin() throws InterruptedException
	{
        driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
		
		driver.findElement(By.id("input-email")).sendKeys("Sinu1234@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("Roshan@1712");
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

}

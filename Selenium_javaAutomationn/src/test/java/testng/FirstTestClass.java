package testng;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FirstTestClass {
	
	
	WebDriver driver;
	@Test(priority =1)
	void openapp()
	{
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize(); 
		
	}
	
	@Test(priority=2)
	void loginapp()
	{
		System.out.println("login into app....");
	}
	
	@Test(priority=3)
	void logout()
	{
		System.out.println("logout app....");
		driver.quit();
	}

}

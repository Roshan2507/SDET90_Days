package handleBrowserWindow;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwtichtoChildWindow {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		String parentWindow =driver.getWindowHandle();
		
		driver.findElement(By.xpath("//button[@onclick='myFunction()']")).click();
		
		Set<String> childWindow =driver.getWindowHandles();
		
		//System.out.println(parentWindow);
		
		for(String allwindow:childWindow)
		{
			if(!allwindow.equals(parentWindow))
			{
				driver.switchTo().window(allwindow);
				driver.manage().window().maximize();
				System.out.println(allwindow);
			}
		}
		driver.findElement(By.xpath("//input[@class='gsc-input']")).sendKeys("Selenium");
		
		Thread.sleep(3000);
		driver.quit();;
	}

}

package handleAlerts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertHandling {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Alert']")).click();
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Confirm']")).click();
		Thread.sleep(2000);
		driver.switchTo().alert().dismiss();
		
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Prompt']")).click();
		Alert jsAlert= driver.switchTo().alert();
		System.out.println("text msg on alert : "+jsAlert.getText());
		jsAlert.sendKeys("Roshan");
		jsAlert.accept();
		
		
		String res=driver.findElement(By.xpath("//p[@id='result']")).getText();
		if(res.contains("Roshan"))
		{
			System.out.println("Test Passed!");
		}
		else
		{
			System.out.println("Test Failed!");
		}
		 
		Thread.sleep(2000);
		driver.quit();
		
		
	}

}

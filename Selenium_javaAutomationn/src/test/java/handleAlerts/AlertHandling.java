package handleAlerts;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertHandling {

	public static void main(String[] args) throws InterruptedException {
		
		

		WebDriver driver = new ChromeDriver();
		
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		
//		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
//		wait.until(ExpectedConditions.alertIsPresent());
//		
//		Wait <WebDriver> wait1 = new FluentWait<>(driver)
//				.withTimeout(Duration.ofSeconds(5))
//				.pollingEvery(Duration.ofSeconds(5))
//				.ignoring(NoSuchElementException.class);
//
//
//		WebElement element = wait.until(
//		        ExpectedConditions.visibilityOfElementLocated(By.id("username")));
//		
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

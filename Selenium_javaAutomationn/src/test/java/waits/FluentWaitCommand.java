package waits;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;


public class FluentWaitCommand {

	public static void main(String[] args) 
	{

		// Use WebDriverManager to download/configure the correct chromedriver binary

		WebDriver driver = new ChromeDriver();

		Wait<WebDriver> mywait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class);

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();

		WebElement textusername = mywait.until(new Function<WebDriver, WebElement>() 
		{
			public WebElement apply(WebDriver driver) 
			{
				WebElement txtusername= driver.findElement(By.xpath("//input[@placeholder='Username']"));
				return txtusername;
			}
		});
		textusername.sendKeys("Admin");

		driver.quit();
	}

}
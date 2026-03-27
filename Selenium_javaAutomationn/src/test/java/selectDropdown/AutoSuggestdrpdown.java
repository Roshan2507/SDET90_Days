package selectDropdown;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestdrpdown {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		
		
		driver.findElement(By.xpath("//textarea[@name='q']")).sendKeys("Selenium");
		Thread.sleep(3000);
		
		List<WebElement> option = driver.findElements(By.xpath("//ul[@role='listbox']//li//div[@role='option']"));
		
		for(WebElement op:option)
		{
			if(op.getText().equalsIgnoreCase("Selenium Webdriver"))
			{
			
				System.out.println(op.getText());
				op.click();
			}
		}
		
		
		driver.quit();
		
	}

}

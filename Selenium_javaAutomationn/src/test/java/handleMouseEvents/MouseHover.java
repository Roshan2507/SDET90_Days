package handleMouseEvents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseHover {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		WebElement icon =driver.findElement(By.xpath("//button[contains(text(),'Point Me')]"));
		WebElement laptopOption = driver.findElement(By.xpath("//a[contains(text(),'Laptops')]"));
		
		Actions actions = new Actions(driver);
		actions.moveToElement(icon).moveToElement(laptopOption).click().build().perform();
		
		driver.quit();
		
	}

}

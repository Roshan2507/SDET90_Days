package handleMouseEvents;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class KeywordACtions {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.diffchecker.com/");
		driver.manage().window().maximize();
		
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//div[@aria-label='Original text input']")).sendKeys("Welcome Roshan!");
		
		Actions act = new Actions(driver);
		
		//CTRL+A
		act.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).perform();
		//CTRL+C
		act.keyDown(Keys.CONTROL).sendKeys("C").keyUp(Keys.CONTROL).perform();
		//TAB
		Thread.sleep(2000);
		act.keyDown(Keys.TAB).keyUp(Keys.TAB).keyDown(Keys.TAB).keyUp(Keys.TAB).perform();
		Thread.sleep(2000);
		//CTRL+V
		act.keyDown(Keys.CONTROL).sendKeys("V").keyUp(Keys.CONTROL).perform();
		
		Thread.sleep(5000);
		
		WebElement ele = driver.findElement(By.xpath("//div[@aria-label='Changed text input']"));
		String text =ele.getText();
		System.out.println(text);
			
		
		
		driver.quit();
		
	}

}

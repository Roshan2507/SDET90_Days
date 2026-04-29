package handleMouseEvents;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class NewTabUsingrightClick {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");

		driver.manage().window().maximize();

		WebElement home = driver.findElement(By.xpath("//div[@id='PageList2']//a[normalize-space()='Home']"));

		Actions act = new Actions(driver);

		act.keyDown(Keys.CONTROL).click(home).keyUp(Keys.CONTROL).perform();

		// switching to registration page

		List<String> ids = new ArrayList(driver.getWindowHandles());

		// Registration
		driver.switchTo().window(ids.get(1));
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Sinu");

		// switch to home page
		driver.switchTo().window(ids.get(0));
		WebElement search = driver.findElement(By.xpath("//input[@id='Wikipedia1_wikipedia-search-input']"));
		search.sendKeys("Tshirt");
		act.keyDown(Keys.ENTER).keyUp(Keys.ENTER).perform();
		
		driver.quit(); 

	}

}

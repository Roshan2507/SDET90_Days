package handleMouseEvents;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class NewTabUsingrightClick {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();	
		driver.get("https://demo.nopcommerce.com/");
		
		driver.manage().window().maximize();
		
		WebElement reg=driver.findElement(By.xpath("//a[@class='ico-register']"));
		
		Actions act = new Actions(driver);
		
		act.keyDown(Keys.CONTROL).click(reg).keyUp(Keys.CONTROL).perform();;
	}

}

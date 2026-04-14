package handleMouseEvents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Slider {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");
		
		Actions act = new Actions(driver);
		
		WebElement min_slider=driver.findElement(
				By.xpath("//span[contains(@class,'ui-slider-handle ui-corner-all ui-state-default')][1]"));
		System.out.println("Default location of the min slider : "+min_slider.getLocation());
		act.dragAndDropBy(min_slider, 200,249).perform();
		System.out.println("location of the min slider after moving : "+min_slider.getLocation());
		
		WebElement max_slider= driver.findElement(
				By.xpath("//span[contains(@class,'ui-slider-handle ui-corner-all ui-state-default')][2]"));
		System.out.println("Default location of the max slider : "+max_slider.getLocation());
		
		act.dragAndDropBy(max_slider, -200, 247).perform();
		System.out.println("location of the max slider after moving : "+max_slider.getLocation());
		
		Thread.sleep(5000);
		driver.quit();
		
	}

}

package handleFrames;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleFrames {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		
		driver.get("https://ui.vision/demo/webtest/frames/");
		driver.manage().window().maximize();
	    WebElement fr=	driver.findElement(By.xpath("//frame[@src='frame_2.html']"));
		driver.switchTo().frame(fr);
		
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Roshan");
		
	}

}

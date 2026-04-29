package jsexcutor;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ZoomInOut {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		Thread.sleep(4000);
		
		JavascriptExecutor js =(JavascriptExecutor)driver;
		
		js.executeScript("document.body.style.zoom='50%'");
		Thread.sleep(4000);
		js.executeScript("document.body.style.zoom='80%'");
		Thread.sleep(4000);
		
		
	}

}

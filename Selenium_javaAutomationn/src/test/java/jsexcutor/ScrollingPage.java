package jsexcutor;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScrollingPage {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.countries-ofthe-world.com/flags-of-the-world.html");
		driver.manage().window().maximize();
		
		WebElement ele=driver.findElement(By.xpath("//img[@src='flags-normal/flag-of-India.png']"));
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
	/*	//scroll down the page by pixel number
		js.executeScript("arguments[0].scrollIntoView();", ele);
		System.out.println(js.executeScript("return window.pageYOffset;"));
		*/
		//scroll till end of the page
		
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		System.out.println(js.executeScript("return window.pageYOffset;"));
		
		Thread.sleep(3000);
		//scroll upto initial position
		js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
		System.out.println(js.executeScript("return window.pageXOffset;"));
		
		Thread.sleep(3000);
		
		driver.quit();
	}

}

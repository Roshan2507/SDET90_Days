package navigation_commands;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class navigateCommands {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {

		WebDriver driver = new ChromeDriver();
		
		URL myurl = new URL("https://rahulshettyacademy.com/AutomationPractice/");
		driver.navigate().to("https://demo.nopcommerce.com/");
		driver.navigate().to(myurl);


		driver.navigate().back();
	    System.out.println(	driver.getCurrentUrl());
	    
		driver.navigate().forward();
		System.out.println(driver.getCurrentUrl());
		
		Thread.sleep(10000);
		
		driver.navigate().refresh();
		driver.close();
	}

}

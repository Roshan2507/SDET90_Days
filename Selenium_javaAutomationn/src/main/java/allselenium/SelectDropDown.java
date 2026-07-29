package allselenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class SelectDropDown {
	public static void main(String[] args) throws InterruptedException {
		
		
		ChromeOptions coptions = new ChromeOptions();
		coptions.addArguments("--start-maximized");
		WebDriver driver = new ChromeDriver(coptions);
		
		driver.get("https://testautomationpractice.blogspot.com/");
		
		WebElement country =driver.findElement(By.xpath("//select[@id='country']"));
		
		Select select = new Select(country);
		select.selectByVisibleText("India");
		
		Thread.sleep(5000);
		
		driver.quit();
	}

}

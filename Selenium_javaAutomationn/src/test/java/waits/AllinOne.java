package waits;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AllinOne {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demo.nopcommerce.com/");
		
		//using implicit wait
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String title =driver.getTitle();
		
		//using explicit wait
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		
		System.out.println(title);
		
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("https://demo.nopcommerce.com/")));
		
		driver.close();
	}

}

package takescreenshots;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CaprureScreenshotfullPage {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		driver.get("https://demo.nopcommerce.com/");
		Thread.sleep(5000);
		
		TakesScreenshot ts =(TakesScreenshot) driver;
		
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destinamtion = new File(System.getProperty("user.dir")+"\\target\\screenshots\\fullpage3.png");
		source.renameTo(destinamtion);
		//fileUtils.copyFile(source, destinamtion);
		
		// capture the specific section of the page
		WebElement product = driver.findElement(By.xpath("//section[contains(@class,'category-grid')]"));
		
		File src=product.getScreenshotAs(OutputType.FILE);
		File dest = new File(System.getProperty("user.dir")+"\\target\\screenshots\\product.png");
		src.renameTo(dest);
		
		
	
		//capture web element
		
		WebElement featureProducts=driver.findElement(By.xpath("//img[@alt='Picture of Build your own computer']"));
		
		File sourceFile = featureProducts.getScreenshotAs(OutputType.FILE);
		File targetFile = new File(System.getProperty("user.dir"+"\\\\target\\\\screenshots\\\\computerImg.png"));
		
		sourceFile.renameTo(targetFile);
		
		
		driver.quit();
		

		
	}

}

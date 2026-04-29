package uploadfile;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUploadUsingSendKeys {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://practice-automation.com/file-upload/");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		
	WebElement file=	driver.findElement(By.xpath("//input[@id='file-upload']"));
		//js.executeAsyncScript("arguments[0].scrollIntoView()",file );
		
		file.sendKeys("C:\\Users\\ratho\\OneDrive\\Documents\\emailFormat.txt");
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//input[@id='upload-btn']")).click();
		
		String filename =driver.findElement(By.xpath("//div[contains(text(),'It has been sent.')]")).getText();
		
		System.out.println(filename);
		if(filename.contains("It has been sent"))
		{
			System.out.println("File uploded successfully");
		}
		else
		{
			System.out.println("plz upload the file");
		}
		
		
		//driver.quit();
	}

}

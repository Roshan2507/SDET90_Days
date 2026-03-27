package handleBrowserWindow;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class getWindowHandle {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		driver.findElement(By.linkText("OrangeHRM, Inc")).click();
		
		Set<String> windowIDs =driver.getWindowHandles();
		
		//Approch 1
		//convert set into list to access id individually
		
	/*	List<String> windowList = new ArrayList(windowIDs);
		String paranetId = windowList.get(0);
		String childId   = windowList.get(1);
		
		driver.switchTo().window(childId);
		
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("roshan");
		
		driver.switchTo().window(paranetId);
		
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
		
		*/
		//Approch 2
		//using loop
		for(String winId:windowIDs)
		{
			String title =driver.switchTo().window(winId).getTitle();
			if(title.equals("Human Resources Management Software | HRMS | OrangeHRM"))
			{
				System.out.println(driver.getCurrentUrl());
			}
		}
		
		driver.quit();
		
	}

}

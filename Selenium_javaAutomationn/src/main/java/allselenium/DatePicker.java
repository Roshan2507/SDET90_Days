package allselenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DatePicker {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		WebElement sendDate=driver.findElement(By.xpath("//input[@id='datepicker']"));
		
		//sendDate.sendKeys("12/17/1999");
		
		
		//using datepicker
		
		sendDate.click();
		
		
		String year="2027";
		String month="December";
		String date = "17";
	
		
		
		
		
		
		// next and prev button
		
		while(true)
		{
			WebElement presentMonth= driver.findElement(By.xpath("//span[@class='ui-datepicker-month']"));
			wait.until(ExpectedConditions.visibilityOfAllElements(presentMonth));
			String actualMonth= presentMonth.getText();
			
			WebElement presentYear=driver.findElement(By.xpath("//span[@class='ui-datepicker-year']"));
			wait.until(ExpectedConditions.visibilityOfAllElements(presentYear));
			String actualYear =presentYear.getText();
			
			
				if(actualMonth.equals(month) && actualYear.equals(year))
				{
					break;
				}
				WebElement prevButton = driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']"));
				WebElement nextButton = driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']"));
				
				//prevButton.click();
				nextButton.click();
		}
		
		List<WebElement> dates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody/tr/td/a"));
		
		for(WebElement capturedDate: dates)
		{
			if(capturedDate.getText().equals(date))
			{
				capturedDate.click();
				break;
			}
		}
		
		driver.quit();
	}

}

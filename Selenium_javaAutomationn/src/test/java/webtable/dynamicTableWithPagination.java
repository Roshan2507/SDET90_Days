package webtable;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class dynamicTableWithPagination {

	public static void main(String[] args) {

	
	WebDriver driver = new ChromeDriver();
	
	driver.get("https://practice.expandtesting.com/dynamic-pagination-table");
	driver.manage().window().maximize();
	
	
	 String text =driver.findElement(By.xpath("//div[@class='dataTables_info']")).getText();
	 
			
	String res=	text.substring(text.indexOf("of")+3,text.indexOf("entries")-1);
	int totalPages =Integer.parseInt(res);
	System.out.println(totalPages);
	
	WebElement selPage=driver.findElement(By.xpath("//select[@name='example_length']"));
	Select sel = new Select(selPage);
	sel.selectByValue("10");
	
	for(int i=1;i<=totalPages;i++)
	{
		int tableRow = driver.findElements(By.xpath("//table[@id='example']//tr")).size();
		int tableCol =driver.findElements(By.xpath("//table[@id='example']//th")).size();
		for(int r=1;r<=tableRow-1;r++)
		{
			for(int c=1;c<=tableCol;c++)
			{
				String tabData =driver.findElement(By.xpath("//table[@id='example']//tr["+r+"]//td["+c+"]")).getText();
				System.out.print(tabData+"\t ");
			}
			System.out.println();
		}
		System.out.println(" ");
		System.out.println();
		
		// 1. Find the button
		WebElement nextButton = driver.findElement(By.xpath("//li[contains(@id,'example_next')]//a"));

		// 2. Identify the current first row of data (to track when the page actually changes)
		WebElement firstRowBeforeClick = driver.findElement(By.xpath("//table[@id='example']/tbody/tr[1]"));

		// 3. Force the click using JavaScript (This ignores the ad blocking it)
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", nextButton);

		// 4. CRITICAL: Wait for the old data to go stale (This fixes the "11 times same data" issue)
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.stalenessOf(firstRowBeforeClick));
		
		/*
		WebElement nextButton = driver.findElement(By.xpath("//li[contains(@id,'example_next')]//a"));

	    // 2. Scroll it into view (aligns to the top to avoid bottom-screen overlays)
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].scrollIntoView({block: 'center'});", nextButton);

	    // 3. Wait until it's actually ready
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.elementToBeClickable(nextButton));

	    // 4. If standard click still fails, use JS Click as the ultimate fallback
	    try {
	        nextButton.click();
	    } catch (Exception e) {
	        js.executeScript("arguments[0].click();", nextButton);
	    }
	    */
	}
	
	driver.quit();
			
	}

}

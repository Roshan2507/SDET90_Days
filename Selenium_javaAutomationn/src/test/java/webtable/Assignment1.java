package webtable;

import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment1 {

	@SuppressWarnings("unlikely-arg-type")
	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.get("https://blazedemo.com/");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(0));

		WebElement departure = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@name='fromPort']")));

		Select departureDrpdown = new Select(departure);
		departureDrpdown.selectByVisibleText("Mexico City");

		WebElement destination = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@name='toPort']")));

		Select destinationDrpdown = new Select(destination);
		destinationDrpdown.selectByVisibleText("Berlin");

		driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();
		// Thread.sleep(5000);

		int tableRow = driver.findElements(By.xpath("//table[@class='table']//tbody//tr")).size();

		int tableCol = driver.findElements(By.xpath("//table[@class='table']//tbody//td")).size();
		
		//capture the price then store in array
		
		//String priceArr[] = new String[tableRow];
		int [] arr = new int[tableRow];
		
		for(int r=1;r<=tableRow;r++)
		{
			String price = driver.findElement(By.xpath("//table[@class='table']//tbody//tr["+r+"]//td[6]")).getText();
			arr[r-1]+=Double.parseDouble(price.replace("$", ""));// adding price into array
			
		}
		//System.out.println(arr);
		
		//sort the price then find lower price value
		
		for(int arrValue:arr)
		{
			System.out.println(arrValue);
		}
		
		Arrays.sort(arr);//this will sort string 
		int lowestPrice =arr[0];
	    System.out.println("Lowest Price :"+lowestPrice);
		
		//find record in table having lower price
		
		for(int r=1;r<=tableRow;r++)
		{
			String price = driver.findElement(By.xpath("//table[@class='table']//tr["+r+"]/td[6]")).getText();
			System.out.println(price);
			if(price.equals(lowestPrice))
			{
				//.findElement(By.xpath("//input[@type='submit']")).click();
				driver.findElement(By.xpath("//table[@class='table']//tbody//tr["+r+"]/td[1]//input")).click();
				break;
			}
			
		}
		//fill the details then click on purchase flight button
		driver.findElement(By.xpath("//input[@id='inputName']")).sendKeys("Roshan");
		driver.findElement(By.id("address")).sendKeys("1403 American Beauty Ln");
		driver.findElement(By.id("city")).sendKeys("Columbus");
		driver.findElement(By.id("state")).sendKeys("OH");
		driver.findElement(By.id("zipCode")).sendKeys("456789");
		driver.findElement(By.id("creditCardNumber")).sendKeys("97564543567654");
		driver.findElement(By.id("creditCardYear")).clear();
		driver.findElement(By.id("creditCardYear")).sendKeys("2028");
		driver.findElement(By.id("nameOnCard")).sendKeys("Roshan R");
		driver.findElement(By.xpath("//input[@value='Purchase Flight']")).click();
		
		//validate
		String msg = driver.findElement(By.xpath("//h1")).getText();
		
		if(msg.contains("Thank you for your purchase"))
		{
			System.out.println("Success !! Passed");
		}
		else
		{
			System.out.println("failed");
		}
		
		
		driver.quit();

	}

}

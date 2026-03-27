package selectDropdown;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDropDown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://testautomationpractice.blogspot.com/");
		
		WebElement country = driver.findElement(By.xpath("//select[@id='country']"));
		
		Select select = new Select(country);
		
		select.selectByVisibleText("India");
		select.selectByIndex(1);
		select.selectByValue("japan");
		
		List<WebElement> options =select.getOptions();
		System.out.println(options.size());
		
		//using for loop
	/*	for(int i=0;i<options.size();i++)
		{
			System.out.println(options.get(i).getText());
		}
		
	*/
		//using enhanced for loop
		for(WebElement op:options)
		{
			if(op.getText().equalsIgnoreCase("India"))
			{
			System.out.println(op.getText());
			}
		}
		Thread.sleep(4000);
		
		driver.quit();
		
	}

}

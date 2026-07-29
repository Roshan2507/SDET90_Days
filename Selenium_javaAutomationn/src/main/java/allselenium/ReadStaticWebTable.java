package allselenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReadStaticWebTable {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		
		driver.get("https://practice.expandtesting.com/dynamic-table");
		
		driver.manage().window().maximize();
		
		
		int row = driver.findElements(By.xpath("//table[@class='table table-striped']//tr")).size();
		
		int col = driver.findElements(By.xpath("//table[@class='table table-striped']//th")).size();
		
		
		for(int r=1;r<row;r++)
		{
			for(int c=1;c<col;c++)
			{
				String value = driver.findElement(By.xpath("//table[@class='table table-striped']//tr["+r+"]//td["+c+"]")).getText();
				System.out.print(value+"\t");
			}
			System.out.println();
		}
		
		driver.quit();
		
	}

}

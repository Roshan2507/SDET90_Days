package webtable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaticWebTable {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		
		driver.get("https://testautomationpractice.blogspot.com/");
		
		driver.manage().window().maximize();
		
		int rows = driver.findElements(By.xpath("//table[@name='BookTable']//tr")).size();
		
		System.out.println("Total Rows :"+rows);
		
		int cols =driver.findElements(By.xpath("//table[@name='BookTable']//th")).size();
		System.out.println("Total Cols :"+cols);
		
		//WebElement bookName = driver.findElement(By.xpath("//table[@name='BookTable']//tr[5]//td[1]"));
		//System.out.println(bookName.getText());
		
		/*List<WebElement> list = driver.findElements(By.xpath("//table[@name='BookTable']//tr//td[1]"));
		
		for(WebElement li:list)
		{
			System.out.println(li.getText());
		}
	*/
		//read all the data from table column and row
	/*	for(int r=2;r<=rows;r++)
		{
			for(int c=1;c<=cols;c++)
			{
				String value = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td["+c+"]")).getText();
				System.out.print(value+"\t ");
			}
			System.out.println();
		}
		
		*/
		//find total price of all the books
		int totalPrice =0;
		
		for(int r=2;r<=rows;r++)
		{
			String price =driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[4]")).getText();
			totalPrice+=Integer.parseInt(price);
			
		}
		System.out.println(totalPrice);
		driver.quit();
	}

}

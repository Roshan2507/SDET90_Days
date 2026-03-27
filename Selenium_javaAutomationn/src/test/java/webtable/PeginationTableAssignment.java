package webtable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PeginationTableAssignment {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://testautomationpractice.blogspot.com/");
		
	int rows=	driver.findElements(By.xpath("//table[@id='productTable']//tr")).size();
	int col =   driver.findElements(By.xpath("//table[@id='productTable']//th")).size();
	int totalPage = driver.findElements(By.xpath("//ul[@class='pagination']//li")).size();
	System.out.println("Total Row :"+rows+" And "+"Total Col :"+col +"\n");
	
		
		
		for(int i=1;i<=totalPage;i++)
		{
			driver.findElement(By.xpath("//ul//a[@href='#' and contains(text(),'"+i+"')]")).click();
			Thread.sleep(2000);
			for(int r=1;r<rows;r++)
			{
				for(int c=1;c<col;c++)
				{
					String res =driver.findElement(By.xpath("//table[@id='productTable']//tr["+r+"]//td["+c+"]")).getText();
					
					System.out.print(res+"\t");
				}
				driver.findElement(By.xpath("//table[@id='productTable' ]//tr["+r+"]//input")).click();
				System.out.println( );
			}
			System.out.println("\n");
			
		}
		driver.quit();
		
	}

}

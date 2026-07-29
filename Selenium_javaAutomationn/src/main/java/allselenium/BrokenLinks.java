package allselenium;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrokenLinks {

	public static void main(String[] args) throws IOException {
		
		ChromeOptions coptions = new ChromeOptions();
		coptions.addArguments("--start-maximized");

		WebDriver driver = new ChromeDriver(coptions);
		
		driver.get("https://testautomationpractice.blogspot.com/");
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		
		int totalLinks = links.size();
		
		System.out.println(totalLinks);
		
		for(WebElement link :links)
		{
			String url = link.getAttribute("href");
			//skip if href is null or empty
			if(url==null || url.isEmpty())
			{
				continue;
			}
			
			//Create URL Object
			URL linkUrl = new URL(url);
			
			//open Connection
			HttpURLConnection urlConn =  (HttpURLConnection)linkUrl.openConnection();
			urlConn.connect();
			
			//get response code
			
			int responseCode= urlConn.getResponseCode();
			
			//validate link using response code
			
			if(responseCode>=400)
			{
				System.out.println(url+" : Link is broken");
			}
			else
			{
				System.out.println(url+" : Valid link");
			}
			
			
			
		}
		driver.quit();
	}

}

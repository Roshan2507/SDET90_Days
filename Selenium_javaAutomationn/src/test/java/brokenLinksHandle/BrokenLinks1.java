package brokenLinksHandle;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks1 {
	/*
	 * 1) Link href ="https://xyz.com" 2) https://xyz.com ---> server ---> status
	 * code 3) status code >= 400 broken link status code <400 not broken link
	 */
	public static void main(String[] args) throws IOException {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://www.deadlinkcity.com/");
		driver.manage().window().maximize();

		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("total available link : " + links.size());

		int noOfBrokenLinks = 0;
		int noofNonBrokenLinks = 0;

		try {
			for (WebElement link : links) {
				String hrefAttValue = link.getAttribute("href");
				if (hrefAttValue == null || hrefAttValue.isEmpty()) {
					System.out.println("href attribute value is null or empty. so not posssible to check");
					continue;
				}

				URL linkUrl = new URL(hrefAttValue);

				HttpURLConnection conn = (HttpURLConnection) linkUrl.openConnection();// open connection to the server
				conn.connect();
				if (conn.getResponseCode() >= 400) {
					System.out.println(hrefAttValue + " ==> Broken Link");
					noOfBrokenLinks++;
				} else {
					System.out.println(hrefAttValue + " ==> Not A Broken Link");
					noofNonBrokenLinks++;
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Total Broken Links :" + noOfBrokenLinks);
		System.out.println("Total Non Broken Links : " + noofNonBrokenLinks);
		driver.quit();

	}

}

package brokenLinksHandle;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://testautomationpractice.blogspot.com/");

        List<WebElement> links = driver.findElements(By.tagName("a"));

        for (WebElement link : links) {

            String url = link.getAttribute("href");

            try {
             
				URL linkURL = new URL(url);
                HttpURLConnection conn = (HttpURLConnection) linkURL.openConnection();
                conn.setConnectTimeout(3000);
                conn.connect();

                int responseCode = conn.getResponseCode();

                if (responseCode >= 400) {
                    System.out.println(url + " → Broken Link");
                } else {
                    System.out.println(url + " → Valid Link");
                }

            } catch (Exception e) {
                System.out.println(url + " → Error");
            }
        }

        driver.quit();
    }
}
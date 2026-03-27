package webtable;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicTableWIthPegination2 {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://practice.expandtesting.com/dynamic-pagination-table");
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // ✅ Loop added (IMPORTANT)
        while (true) 
        {

            // 🔹 Print table data
            int rows = driver.findElements(By.xpath("//table[@id='example']//tbody//tr")).size();
            int cols = driver.findElements(By.xpath("//table[@id='example']//thead//th")).size();

            for (int r = 1; r <= rows; r++) 
            {
                for (int c = 1; c <= cols; c++)
                {
                    String data = driver.findElement(
                            By.xpath("//table[@id='example']//tbody//tr[" + r + "]//td[" + c + "]"))
                            .getText();
                    System.out.print(data + "\t ");
                }
                System.out.println();
            }

            System.out.println("---- NEXT PAGE ----");

            // 🔹 Check if Next is disabled
            WebElement nextBtnLi = driver.findElement(By.id("example_next"));
            if (nextBtnLi.getAttribute("class").contains("disabled")) {
                break; // ✅ now valid
            }

            // 🔹 Wait for next button
            WebElement nextBtn = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.id("example_next")));

            // 🔹 Scroll to bottom
            ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");

            Thread.sleep(500); // small stability wait

            // 🔹 Store table before click
            WebElement table = driver.findElement(By.id("example"));

            // 🔹 JS Click (fix for intercept issue)
            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].click();",
                    nextBtn.findElement(By.tagName("a"))
            );

            // 🔹 Wait for table refresh
            wait.until(ExpectedConditions.stalenessOf(table));
        }

        driver.quit();
    }
}
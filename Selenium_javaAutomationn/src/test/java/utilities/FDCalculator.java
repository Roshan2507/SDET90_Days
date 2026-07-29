package utilities;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FDCalculator {
	
	// Helper method to safely click elements
	private static void safeClick(WebDriver driver, WebDriverWait wait, By locator) {
		try {
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
			// Scroll element into view
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
			Thread.sleep(500); // Small delay to allow scroll to complete
			element.click();
		} catch (Exception e) {
			// If normal click fails, try JavaScript click
			WebElement element = driver.findElement(locator);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
		}
	}
	
	public static void main(String[] args) throws IOException, InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		driver.get(
				"https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india/fixed-deposit-calculator-SBI-BSB001.html");
		driver.manage().window().maximize();
		Thread.sleep(2000); // Wait for page to fully load
		String filePath = System.getProperty("user.dir") + "\\testdata\\CalculateData.xlsx";

		int rows = ExcelUtils.getRowCount(filePath, "Sheet1");

		for (int i = 1; i <= rows; i++) {

			// Read data from excel sheet

			String pric = ExcelUtils.getCellData(filePath, "Sheet1", i, 0);
			String rateOfInterest = ExcelUtils.getCellData(filePath, "Sheet1", i, 1);
			String per1 = ExcelUtils.getCellData(filePath, "Sheet1", i, 2);
			String per2 = ExcelUtils.getCellData(filePath, "Sheet1", i, 3);
			String fre = ExcelUtils.getCellData(filePath, "Sheet1", i, 4);
			String exp_mvalue = ExcelUtils.getCellData(filePath, "Sheet1", i, 5);

			// Pass above data into application
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id("principal"))).sendKeys(pric);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='interest']"))).sendKeys(rateOfInterest);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='tenure']"))).sendKeys(per1);

			Select tenuredrpdown = new Select(wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[@id='tenurePeriod']"))));
			tenuredrpdown.selectByVisibleText(per2);

			Select freqdrpdown = new Select(wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[@id='frequency']"))));
			freqdrpdown.selectByVisibleText(fre);

			// Wait for the calculate button to be clickable
			safeClick(driver, wait, By.xpath("//div[@class='CTR PT15']//a[1]"));

			// validation
			WebElement matvalElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@id='resp_matval']//strong")));
			String act_mvalue = matvalElement.getText();

			if (Double.parseDouble(exp_mvalue) == Double.parseDouble(act_mvalue)) {
				System.out.println("Test is Passed!...");
				ExcelUtils.setCellData(filePath, "Sheet1", i, 7, "Passed");
				ExcelUtils.fillGreenColor(filePath, "Sheet1", i, 7);
			} else {
				System.out.println("Test Failed...");
				ExcelUtils.setCellData(filePath, "Sheet1", i, 7, "Failed");
				ExcelUtils.fillRedColor(filePath, "Sheet1", i, 7);
			}

			Thread.sleep(3000);
			// Wait for the reset button to be clickable
			safeClick(driver, wait, By.xpath("//div[@class='CTR PT15']//a[2]"));

		}
		driver.quit();
	}

}

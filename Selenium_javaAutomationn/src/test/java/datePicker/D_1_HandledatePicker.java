package datePicker;

import java.time.Duration;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class D_1_HandledatePicker {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter :Future: for future date or Enter :Past: for past date :");
		String enterDateIs = sc.next();

		System.out.print("Enter Year :");
		String expectedYear = sc.next();

		System.out.print("Enter Month :");
		String expectedMonth = sc.next();

		System.out.print("Enter Date :");
		String expectedDate = sc.next();

		driver.get("https://jqueryui.com/datepicker/");
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.switchTo().frame(0);

		WebElement dateInputBox = driver.findElement(By.xpath("//input[@id='datepicker']"));
		WebElement inputdate = wait.until(ExpectedConditions.elementToBeClickable(dateInputBox));
		inputdate.click();

		if (enterDateIs.equals("Future")) {
			selectFutureDate(driver, expectedDate, expectedMonth, expectedYear);
		} else {
			selectPastDate(driver, expectedDate, expectedMonth, expectedYear);
		}

		Thread.sleep(5000);

		driver.quit();
	}

	// for selecting future dates
	static void selectFutureDate(WebDriver driver, String expectedDate, String expectedMonth, String expectedYear) {
		while (true) {
			String year = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
			String month = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();

			if (expectedMonth.equals(month) && expectedYear.equals(year)) {
				System.out.print("Selected date is :" + year + " " + month);
				break;
			}

			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();

		}

		List<WebElement> allDates = driver
				.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td//a"));

		for (WebElement dt : allDates) {
			if (dt.getText().equals(expectedDate)) {
				String d = dt.getText();
				System.out.print(" " + d);
				dt.click();
				break;
			}
		}

	}

	// for selecting past dates
	static void selectPastDate(WebDriver driver, String expectedDate, String expectedMonth, String expectedYear) {
		while (true) {
			String year = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
			String month = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();

			if (expectedMonth.equals(month) && expectedYear.equals(year)) {
				System.out.print("Selected date is :" + year + " " + month);
				break;
			}

			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();

		}

		List<WebElement> allDates = driver
				.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td//a"));

		for (WebElement dt : allDates) {
			if (dt.getText().equals(expectedDate)) {
				String d = dt.getText();
				System.out.print(" " + d);
				dt.click();
				break;
			}
		}

	}

}

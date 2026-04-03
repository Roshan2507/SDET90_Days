package datePicker;

import java.time.Duration;
import java.time.Month;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class D_2_HandleDatePicker {
	
	//user defined method for converting month from String -->month
	static Month convertMonth(String month)
	{
		HashMap<String,Month>monthMap = new HashMap<String, Month>();
		monthMap.put("January", Month.JANUARY);
		monthMap.put("January", Month.FEBRUARY);
		monthMap.put("January", Month.MARCH);
		monthMap.put("January", Month.APRIL);
		monthMap.put("January", Month.MAY);
		monthMap.put("January", Month.JUNE);
		monthMap.put("January", Month.JULY);
		monthMap.put("January", Month.AUGUST);
		monthMap.put("January", Month.SEPTEMBER);
		monthMap.put("January", Month.OCTOBER);
		monthMap.put("January", Month.NOVEMBER);
		monthMap.put("January", Month.DECEMBER);
		
		Month vmonth =monthMap.get(month);
		if(vmonth==null)
		{
			System.out.println("Invalid Month....");
		}
		return vmonth;
	}
	static void selectDate(WebDriver driver,String requiredYear,String requiredMonth,String requiredDate)
	{
		//select year
		WebElement yearDropDown = driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
		Select selectYear = new Select(yearDropDown);
		selectYear.selectByVisibleText(requiredYear);
		
		//select month
		while(true)
		{
			String displayMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			
			//convert requiredMonth & displayMonth in to Month Objects
			
			Month expectedMonth = convertMonth(requiredMonth);
			Month currentMonth = convertMonth(displayMonth);
			
			//compare
			int result = expectedMonth.compareTo(currentMonth);
			//0 months are equal
			//>0 future month
			// <0 past month
			if(result<0)
			{
				driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();
				
			}
			else if(result>0)
			{
				driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
				
			}
			else
			{
				break;
			}
		}
		//date selection
		
		List<WebElement> allDates = driver.findElements(By.xpath("//table[@class=ui-datepicker-calendar']//tbody//tr//td//a"));
		for(WebElement dt:allDates)
		{
			if(dt.getText().equals(requiredDate))
			{
				dt.click();
				break;
			}
		}
	}

	public static void main(String[] args) 
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://testautomationpractice.blogspot.com/");
		
		//input DOB
		String requiredYear ="2021";
		String requiredMonth = "June";
		String requiredDate = "17";
		
    	driver.switchTo().frame("frame-one796456169");
		driver.findElement(By.xpath("//span[@class='icon_calendar']")).click();
		selectDate(driver,requiredYear,requiredMonth,requiredDate);

		
	}

}

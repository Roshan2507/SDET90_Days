package uploadfile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleFileUpload {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		
		driver.get("https://davidwalsh.name/demo/multiple-file-upload.php");
		driver.manage().window().maximize();
		
		String file1="C:\\Users\\ratho\\OneDrive\\Documents\\text1.txt";
		String file2="C:\\Users\\ratho\\OneDrive\\Documents\\text2.txt";
		driver.findElement(By.xpath("//input[@id='filesToUpload']")).sendKeys(file1+"\n"+file2);
		
		
		int fileCount=driver.findElements(By.xpath("//ul[@id='fileList']//li")).size();
		if(fileCount==2)
		{
			System.out.println(fileCount+" file is uploaded.");
		}
		else
		{
			System.out.println("upload file again");
		}
		
		for (int i=1;i<fileCount;i++)
		{
			if(driver.findElement(By.xpath("//ul[@id='fileList']//li["+i+"]")).getText().equals("text1.txt"));
			{
				System.out.println(driver.findElement(By.xpath("//ul[@id='fileList']//li["+i+"]")).getText());
			}
		}
	}

}

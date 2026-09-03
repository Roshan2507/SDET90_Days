package testnglistners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyTestListener implements ITestListener{
	
	 public void onStart(ITestContext context) {
		   System.out.println("On Start Method...");
		  }
	
	 public void onTestStart(ITestResult result) {

		 System.out.println("On Test Start Method...");
	 }
	 
	 public void onTestSuccess(ITestResult result) {

		 System.out.println("On Test Success Method...");
	 }
	 
	 public void onTestFailure(ITestResult result) {

		 System.out.println("On Test Failure...");
	 }
	 
	 public void onTestSkipped(ITestResult result) {
		 System.out.println("On Test Skipped Method...");
		 
		  }
	 public void onFinish(ITestResult result)
	 {
		 System.out.println("on Finish Method...");
	 }

}

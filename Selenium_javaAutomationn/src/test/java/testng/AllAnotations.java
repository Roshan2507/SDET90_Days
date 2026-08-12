package testng;

import org.testng.annotations.*;

public class AllAnotations {

	@BeforeSuite
	void bs()
	{
		System.out.println("This is before suite...");
	}
	
	@AfterSuite
	void as()
	{
		System.out.println("This is after suite...");
	}
	
	@BeforeTest
	void bt()
	{
		System.out.println("This is before test method...");
	}
	
	@AfterTest
	void at()
	{
		System.out.println("This is after test method");
	}
	
	@BeforeClass
	void bc()
	{
		System.out.println("This is before class");
	}
	
	@AfterClass
	void ac()
	{
		System.out.println("This is after class");
	}
	
	@BeforeMethod
	void bm()
	{
		System.out.println("This is before method...");
	}
	
	@AfterMethod
	void am()
	{
		System.out.println("This is after method");
	}
	
	@Test(priority=1)
	void tm1()
	{
		System.out.println("This is Test method1...");
	}
	
	@Test(priority =2)
	void tm2()
	{
		System.out.println("This is test method2...");
	}
}

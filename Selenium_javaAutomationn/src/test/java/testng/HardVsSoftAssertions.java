package testng;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HardVsSoftAssertions {

	@Test
	void test_hardassertions()
	{
		System.out.println("Testing...");
		System.out.println("Testing...");
		
		Assert.assertEquals(1, 2);
		
		System.out.println("Testing...");
		System.out.println("Testing...");
	}
	
	@Test
	void test_softAssertion()
	{
		System.out.println("Testing...");
		System.out.println("Testing...");
		
		SoftAssert sa = new SoftAssert();
		
		sa.assertEquals(1, 2);
		

		System.out.println("Testing...");
		System.out.println("Testing..."); 
		
		sa.assertAll();
	}
}

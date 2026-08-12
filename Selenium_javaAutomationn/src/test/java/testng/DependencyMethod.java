package testng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependencyMethod {

	@Test(priority=1)
	void openapp()
	{
		Assert.assertTrue(true);
	}
	
	@Test(priority=2, dependsOnMethods= {"openapp"})
	void login()
	{
		Assert.assertTrue(true);
	}
	
	@Test(priority=3,dependsOnMethods = {"login"} )
	void search()
	{
		Assert.assertTrue(true);
	}
	
	@Test(priority=4,dependsOnMethods= {"search"})
	void advsearch()
	{
		Assert.assertTrue(true);
	}
	
	@Test(priority=5,dependsOnMethods = {"advsearch"})
	void logout()
	{
		Assert.assertTrue(true);
	}
}

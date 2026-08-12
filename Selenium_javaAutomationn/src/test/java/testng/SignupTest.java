package testng;

import org.testng.annotations.Test;

public class SignupTest {
	
	@Test(priority=1,groups= {"regression"})
	void signupByemail()
	{
		System.out.println("this is signup by email");
	}
	

	@Test(priority=2,groups= {"regression"})
	void signupByfaceboo()
	{
		System.out.println("this is signup by facebook");
	}

	@Test(priority=3,groups= {"regression"})
	void signupBytwitter()
	{
		System.out.println("this is signup by twitter");
	}

}

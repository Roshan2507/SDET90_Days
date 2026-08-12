package testng;

import org.testng.annotations.Test;

public class PaymentTests {

	@Test(priority=1,groups= {"sanity","regression","functional"})
	void paymentInRupees()
	{
		System.out.println("Payment in rupees...");
	}
	

	@Test(priority=2,groups= {"sanity","regression","functional"})
	void paymentInDollers()
	{
		System.out.println("Payment in dollers...");
	}
}

package day_4;

public abstract class Bank {
	
	private static final String BANK_NAME="HDFC Bank";
	

	public abstract void createAccount(String document);
	
	
	public abstract boolean validateDocuments(String document);

}

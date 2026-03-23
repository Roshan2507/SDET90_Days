package day_4;

public class MumbaiBranch extends Bank {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean validateDocuments(String document) {

		if(document.equalsIgnoreCase("EB"))
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}

	@Override
	public void createAccount(String document) {
		if(validateDocuments(document))
		{
			System.out.println("Account created Successfuly with "+document+" for Mumbai Branch");
		}
		else
		{
			System.out.println("Need EB for mumbai branch");
		}
		
	}

}

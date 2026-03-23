package day_4;

public class DelhiBranch extends Bank{

	@Override
	public boolean validateDocuments(String document) {

		if(document.equalsIgnoreCase("passport"))
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
			System.out.println("Account created Successfuly with "+document+" for Delhi Branch");
		}
		else
		{
			System.out.println("Need passport for delhi branch");
		}
	}

}

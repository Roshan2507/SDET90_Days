package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

public class ReadingPropertiesFile {

	public static void main(String[] args) throws IOException {

		
		
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"//testdata//config.properties");
		Properties prop = new Properties();
		
		prop.load(file);
		
		//Reading data from properties file
		String url = prop.getProperty("appurl");
		String email = prop.getProperty("email");
		String pwd = prop.getProperty("pass");
		String orid = prop.getProperty("orderid");
		String custid=prop.getProperty("customerid");
		
		System.out.println(url+" "+email+" "+pwd+" "+orid+" "+custid);
		
		
		
		//Reading all the keys from properties file
		
		Set<String> key=prop.stringPropertyNames();
		
		for(String s:key)
		{
			System.out.println(s);
		}
		
		file.close();
	}

}

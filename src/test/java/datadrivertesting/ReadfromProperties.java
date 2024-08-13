package datadrivertesting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadfromProperties {

	public static void main(String[] args) throws IOException {
		FileInputStream fis=new FileInputStream("./src/test/resources/data.properties");
	Properties property=new Properties();
	property.load(fis);
	System.out.println(property.getProperty("url"));

	}
 
}

package learnPropertiesFile;

import java.io.*;
import java.sql.Statement;
import java.util.Properties;

public class App {
	public static void main(String[] args){
		createPropertyFile();
		displayContents();
	}

	private static void displayContents() {
		Properties prop = new Properties();
		InputStream input = null;
		
		try {
			input = new FileInputStream("config.properties");
			 // Load properties file
			prop.load(input);
			
			//get property value and print it out 
			System.out.println(prop.getProperty("database"));
			System.out.println(prop.getProperty("dbuser"));
			System.out.println(prop.getProperty("dbpassword"));
			
		}
		catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}		
	}

	private static void createPropertyFile() {
		Properties prop = new Properties();
		OutputStream output = null;
		
		try {
			File f = new File("config.properties");
			if(f.exists() || f.isDirectory()) return;
			output = new FileOutputStream("config.properties");
			
			//set the properties value
			prop.setProperty("database", "lcalhost");
			prop.setProperty("dbuser", "mkyong");
			prop.setProperty("dbpassword", "password");
			 
			// save properties to project root folder
			prop.store(output, null);
		}
		catch(IOException io) {
			io.printStackTrace();
		} finally {
			if(output != null) {
				try {
					output.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}

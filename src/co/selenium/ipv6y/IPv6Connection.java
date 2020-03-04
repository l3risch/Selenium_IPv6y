package co.selenium.ipv6y;

	import java.io.IOException;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

	public class IPv6Connection extends Connection {
		
	 public static void main(String [] args) {
		 		 
	   long startTime = System.nanoTime();
	   Connection con = new Connection();
	   
	   con.buildConnection();
	   ChromeDriver driver = con.getConnectionDriver();
	   try {
		Connection.measureConnection(driver);
	} catch (IOException e) {
		e.printStackTrace();
	}
	   long elapsedTime = System.nanoTime() - startTime;
	   
	   System.out.println("Execution Time: " + elapsedTime/1000000);
	 
	}
	 
	 
 }



package co.selenium.ipv6y;

	import java.io.IOException;

import org.openqa.selenium.firefox.FirefoxDriver;

	public class IPv6Connection extends Connection {
		
	 public static void main(String [] args) {
		 
	   Connection con = new Connection();
	   
	   con.buildConnection();
	   FirefoxDriver driver = con.getConnectionDriver();
	   try {
		Connection.measureConnection(driver);
	} catch (IOException e) {
		e.printStackTrace();
	}
	 
	 }
}


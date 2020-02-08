package co.selenium.ipv6y;

import java.io.IOException;

import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Proxy extends Connection{
	
	public static FirefoxDriver _driver;
	
	public Proxy()
	{
		   this.buildConnection();
		   try {
			Connection.measureConnection(_driver);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String [] args) {
		   long startTime = System.nanoTime();
		   new Proxy();
		   long elapsedTime = System.nanoTime() - startTime;
		   
		   System.out.println("Execution Time: " + elapsedTime/1000000);
	}
	
	public void buildConnection()
	{
		super.buildConnection();
		
		
		DesiredCapabilities dc;
		dc = DesiredCapabilities.firefox();              
		System.setProperty("https.proxyHost","10.100.21.11");
		//enabling access over http
		System.setProperty("https.proxyPort","80"); 
		System.setProperty("https.proxyHost","10.100.21.11");
		//enabling access over https
		System.setProperty("https.proxyPort","443");                    
		
		dc.setCapability(FirefoxOptions.FIREFOX_OPTIONS, _firefoxOptions);
		_driver = new FirefoxDriver(dc);
	}

}


package co.selenium.ipv6y;

import java.io.BufferedWriter;


import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.net.Inet6Address;
import java.net.InetAddress; 


public class Connection {

	public static FirefoxOptions _firefoxOptions;
	public static FirefoxDriver _driver;
		
	public void buildConnection()
	{
		FirefoxBinary firefoxBinary = new FirefoxBinary();
		   firefoxBinary.addCommandLineOptions("--headless");
		   System.setProperty("webdriver.gecko.driver", "resources/geckodriver-v0.24.0-win64/geckodriver.exe");
		   _firefoxOptions = new FirefoxOptions();
		   _firefoxOptions.setBinary(firefoxBinary);
		   _driver = new FirefoxDriver(_firefoxOptions);
		   
	}
	
	public FirefoxDriver getConnectionDriver()
	{
		return _driver;
	
	}
	
	public FirefoxOptions getBrowserOptions()
	{
		return _firefoxOptions;
	}
	
	public static void measureConnection(FirefoxDriver driver) throws IOException
	{
		JavascriptExecutor jsx = (JavascriptExecutor) driver;
		BufferedWriter writer = new BufferedWriter(new FileWriter("./resources/StatisticalData.txt", false));
		   
		/**
		 * Auf https umstellen
		 */
		   List<String> ipv6websites = new ArrayList<String>();
		   ipv6websites.add("https://www.google.com");
		   ipv6websites.add("https://www.youtube.com");
		   ipv6websites.add("https://www.facebook.com");
		   ipv6websites.add("https://www.wikipedia.org");
		 //ipv6websites.add("https://www.yahoo.com");  not reachable over IPv6 
		   ipv6websites.add("https://www.Netflix.com");
		   ipv6websites.add("https://www.Blogspot.com");
		   ipv6websites.add("https://www.bing.com");
		   ipv6websites.add("https://www.instagram.com");
		   ipv6websites.add("https://www.office.com");
		   ipv6websites.add("https://www.google.com.hk");
	    // ipv6websites.add("https://www.google.com.in"); not reachable over IPv6 
		   ipv6websites.add("https://www.yandex.ru");
		// ipv6websites.add("https://www.mail.ru");  not reachable over IPv6 
		   ipv6websites.add("https://www.dropbox.com");
		   ipv6websites.add("https://www.linkedin.com");
       //  ipv6websites.add("https://www.google.com.jp"); not reachable over IPv6 
		   ipv6websites.add("https://www.google.de");
	     //ipv6websites.add("https://www.xhamster.com"); 
		   ipv6websites.add("https://www.google.com.br");
		   ipv6websites.add("https://www.medium.com");
		 //ipv6websites.add("https://www.bbc.com");  not reachable over IPv6 
		   ipv6websites.add("https://www.cnn.com");
		   ipv6websites.add("https://www.google.ru");
		   ipv6websites.add("https://www.google.it");
		   ipv6websites.add("https://www.google.cn");
	//     ipv6websites.add("https://www.onlinesbi.com");

		   //Set iterations
		   int iterations = 20;
		   long[][] Messungen = new long[ipv6websites.size()][iterations];
			   
		   List<Long> einzelmessungen = new ArrayList<Long>();
		   
		   int countloop = 0;
		   int countwebsite = 0;
		   long loadingTime = 0;

           writer.write("###########################################################################################");

		   
			   while(countloop < iterations)
			   {
		
				 for (String ipv6website : ipv6websites)
				 {
					 
				     driver.get(ipv6website);
				     
				     /**
				      * Break of 1 sec
				      */
				     //driver.manage().timeouts().implicitlyWait(1,
				       //  TimeUnit.SECONDS);
				     
				     //Messung der einzelnen Zeitpunkte beim Seitenaufruf
				     long navigationStart = (long) jsx.executeScript("return performance.timing.navigationStart;");
				     //long fetchStart = (long) jsx.executeScript("return performance.timing.fetchStart;");
				     //long unloadEventStart = (long) jsx.executeScript("return performance.timing.unloadEventStart;");
				     //long unloadEventEnd = (long) jsx.executeScript("return performance.timing.unloadEventEnd;");
				     //long domainLookupStart = (long) jsx.executeScript("return performance.timing.domainLookupStart;");
				     //long domainLookupEnd = (long) jsx.executeScript("return performance.timing.domainLookupEnd;");
				     //long secureConnectionStart = (long) jsx.executeScript("return performance.timing.secureConnectionStart;");
				     //long loadEventStart = (long) jsx.executeScript("return performance.timing.loadEventStart;");
				     //long loadEventEnd = (long) jsx.executeScript("return performance.timing.loadEventEnd;");
				     //long connectStart = (long) jsx.executeScript("return performance.timing.connectStart;");
				     //long connectEnd = (long) jsx.executeScript("return performance.timing.connectEnd;");	     
				     //long requestStart = (long) jsx.executeScript("return performance.timing.requestStart;");
				     //long responseStart = (long) jsx.executeScript("return performance.timing.responseStart;");
				     long responseEnd = (long) jsx.executeScript("return performance.timing.responseEnd;");	     
				     //long domComplete = (long) jsx.executeScript("return performance.timing.domComplete;");	     
				     
				     long loadingTimeDif = responseEnd-navigationStart;
				     
				     //Speichern der Messergebnisse für die einzelnen Webseiten
				     switch(ipv6website)
				     {
				     case "https://www.google.com": 
				    	Messungen[0][countloop] = loadingTimeDif; 
				     break;
				     case "https://www.youtube.com": 
					   	Messungen[1][countloop] = loadingTimeDif; 
				     break;
				     case "https://www.facebook.com": 
						   	Messungen[2][countloop] = loadingTimeDif; 
				     break;
				     case "https://www.wikipedia.org": 
						   	Messungen[3][countloop] = loadingTimeDif; 
					 break;
				     case "https://www.Netflix.com": 
					    	Messungen[4][countloop] = loadingTimeDif; 
					 break;
					 case "https://www.Blogspot.com": 
						   	Messungen[5][countloop] = loadingTimeDif; 
					 break;
					 case "https://www.bing.com": 
						   	Messungen[6][countloop] = loadingTimeDif; 
				     break;
				     case "https://www.instagram.com": 
						   	Messungen[7][countloop] = loadingTimeDif; 
					 break;
				     case "https://www.office.com": 
						   	Messungen[8][countloop] = loadingTimeDif; 
					 break;
				     case "https://www.google.com.hk": 
						   	Messungen[9][countloop] = loadingTimeDif; 
					 break;
				     case "https://www.yandex.ru": 
						   	Messungen[10][countloop] = loadingTimeDif; 
					 break;
				     case "https://www.dropbox.com": 
					   	Messungen[11][countloop] = loadingTimeDif; 
				     break;
				     case "https://linkedin.com": 
						   	Messungen[12][countloop] = loadingTimeDif; 
				     break;
				     case "https://www.google.de": 
						   	Messungen[13][countloop] = loadingTimeDif; 
					 break;  
					 case "https://www.google.com.br": 
						   	Messungen[14][countloop] = loadingTimeDif; 
					 break;
					 case "https://www.medium.com": 
						   	Messungen[15][countloop] = loadingTimeDif; 
				     break;  
				     case "https://www.cnn.com": 
						   	Messungen[16][countloop] = loadingTimeDif; 
					 break;
				     case "https://www.google.ru": 
						   	Messungen[17][countloop] = loadingTimeDif; 
					 break;
				     case "https://www.google.it": 
						   	Messungen[18][countloop] = loadingTimeDif; 
					 break;
				     case "https://www.google.cn": 
						   	Messungen[19][countloop] = loadingTimeDif; 
					 break;
				     }
				     
				     
				     //Events sortiert nach Zeitpunkt
				     /**writer.write("Connection[" + i + "]: " + "\nNavigation Start: "+ navigationStart +
				    		 			"\nsecureConnectionStart" + secureConnectionStart +
				    		 			"\nFetch Start: " + fetchStart +  
				    		 			"\ndomainLookupStart: " + domainLookupStart +
				    		 			"\ndomainLookupEnd: " + domainLookupEnd +
				    		 			"\nconnectStart: " + connectStart + 
				    		 			"\nconnectEnd: " + connectEnd + 
				    		 			"\nrequestStart: " + requestStart +
				    		 			"\nresponseStart: " + responseStart +
				    		 			"\nresponseEnd: " + responseEnd + 
				    		 			"\nunloadEVentStart: "+ unloadEventStart +
				    		 			"\nunloadEventEnd: " + unloadEventEnd +
				    		 			"\nloadEventStart: " + loadEventStart + 
				    		 			"\nloadEventEnd: " + loadEventEnd + 
				    		 			"\ndomComplete: " + domComplete + "\n" );
				    */
				     writer.write("\n"+countloop + ") " + "Loading Time for " + ipv6website + ": " + loadingTimeDif );
				     
				     //Summierung der Ladezeiten
				     loadingTime = loadingTime + loadingTimeDif;
				     einzelmessungen.add(loadingTimeDif);
				     
				    countwebsite++;
			
				   }
				 
			   writer.write("\n");
			   countloop++; 
			   System.out.println("Loop: " + countloop);
			   
			   }
		
		   //Berechnung statistischer Kennzahlen
		   countwebsite = countwebsite / countloop;
		   
		   long[] websitemeans = new long[20];
		   long[] websitevariances = new long[20];
		   long[] websitestds = new long[20];
		   for(int i = 0; i < countwebsite; i++)
		   {
			   List<Long> einzelmessungenweb = new ArrayList<Long>();
			   for(int j = 0; j < countloop; j++)
			   {
				   websitemeans[i] += Messungen[i][j]; 
				   einzelmessungenweb.add(Messungen[i][j]);
			   }
			   websitemeans[i] = websitemeans[i]/countloop;
			   websitevariances[i] = calcVariance(websitemeans[i], einzelmessungenweb, countloop);
			   websitestds[i] = (long) Math.sqrt(websitevariances[i]);
		   }
		   
		   
		   long overallmean = loadingTime / (countwebsite*countloop);
		   long overallvariance = calcVariance(overallmean, einzelmessungen, countloop * countwebsite);
		   long overallstd = (long) Math.sqrt(overallvariance);

		   writer.write("\n----------------------------------------------------------------");
		   writer.write("\nMeans:\n");
		   
		   for(int i = 0; i < 20; i++)
		   {
			   writer.write("\n" + ipv6websites.get(i) + " Mean: " + websitemeans[i]);
		   }
		  

		   writer.write("\n----------------------------------------------------------------");
		   writer.write("\nStandard Deviations:\n");
		   for(int i = 0; i < 20; i++)
		   {
			   writer.write("\n" + ipv6websites.get(i) + " STD: " + websitestds[i]);
		   }
		   
		   writer.write("\n----------------------------------------------------------------\n");
		   writer.write("\nOverall Mean: " + overallmean);
		   writer.write("\nOverall Variance: " + overallvariance);
		   writer.write("\nOverall Standard Deviation: " + overallstd);

		   Runtime runtime = Runtime.getRuntime();
		     // Run the garbage collector
		     runtime.gc();
		     // Calculate the used memory
		     long memory = runtime.totalMemory() - runtime.freeMemory();
		     System.out.println("Total memory is: " + runtime.totalMemory());
		     System.out.println("Used memory is: " + memory);
		   writer.close();
		   
		   driver.quit();
	}
	

	private static long calcVariance(long mean, List<Long> einzelmessungen, int sample) 
	{
		 long sumResults = 0;
		   for(long result : einzelmessungen)
		   {
			   sumResults += (result - mean)*(result-mean);
		   }
		long variance = sumResults / sample; 
		return variance;
		 
	}
	
}

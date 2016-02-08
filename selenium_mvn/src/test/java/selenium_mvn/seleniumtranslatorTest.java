package selenium_mvn;

import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.*;
import com.csvreader.CsvReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.*;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.csvreader.CsvReader;


			
public class seleniumtranslatorTest{

	
	
	
			
	

	@Test
	public void StartChromeWebDriver() throws InterruptedException, IOException{
			System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
	

			  WebDriver driver = new ChromeDriver();
		  Thread.sleep(10000); 
		  driver.get("https://www.bing.com/translator");
			
			
			CsvReader Reader = new CsvReader("C://Translate.csv");
			
			Reader.readHeaders();
			
	       //Text,To,From 
			while  (Reader.readRecord())
			{
				String TextToTrans = Reader.get("Text");
				String SrcLang = Reader.get("From");
				String DstLang = Reader.get("To");
				System.out.println(TextToTrans + ":" + SrcLang + ":" + DstLang);
			
			if(!SrcLang.equals("")) 
			{
			Thread.sleep(1000);
			
			driver.findElement(By.id("Header_SrcLangList")).click();
			Thread.sleep(1000);
			
			driver.findElement(By.linkText(SrcLang)).click();
		
			Thread.sleep(1000);
			driver.findElement(By.id("InputText")).clear();
			driver.findElement(By.id("InputText")).sendKeys(TextToTrans);
			
		  
					
			Thread.sleep(1000);
			driver.findElement(By.id("Header_DstLangList")).click();
			Thread.sleep(1000);
			
			driver.findElement(By.linkText(DstLang)).click();
			Thread.sleep(1000);
			}
			else  System.out.println("empty value"+ SrcLang);
			Thread.sleep(1000);
			
			}
			Reader.close();
			  driver.quit();
	}
	
	//@Category(test)
	@Test
	public void StartFireFoxWebDriver() throws InterruptedException, IOException{
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.bing.com/translator");
	
	
		CsvReader Reader = new CsvReader("C://Translate.csv");
		
		Reader.readHeaders();
		
       //Text,To,From 
		while  (Reader.readRecord())
		{
			String TextToTrans = Reader.get("Text");
			String SrcLang = Reader.get("From");
			String DstLang = Reader.get("To");
			System.out.println(TextToTrans + ":" + SrcLang + ":" + DstLang);
		
		if(!SrcLang.equals("")) 
		{
		Thread.sleep(500);
		
		driver.findElement(By.id("Header_SrcLangList")).click();
		Thread.sleep(500);
		
		driver.findElement(By.linkText(SrcLang)).click();
	
		Thread.sleep(500);
		driver.findElement(By.id("InputText")).clear();
		driver.findElement(By.id("InputText")).sendKeys(TextToTrans);
		
	  
				
		Thread.sleep(500);
		driver.findElement(By.id("Header_DstLangList")).click();
		Thread.sleep(500);
		
		driver.findElement(By.linkText(DstLang)).click();
		Thread.sleep(500);
		}
		else  System.out.println("empty value"+ SrcLang);

		
		}
		Reader.close();
		 driver.quit();
	}	


/*	@Test
	public void StartIEWebDriver() throws InterruptedException{
		
		  
		 System.setProperty("webdriver.ie.driver", "C:\\Program Files\\Internet Explorer\\iexplore.exe");
		  /*  DesiredCapabilities cap = DesiredCapabilities.internetExplorer();
		    cap.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
		    baseUrl = "http//www.google.com";
		    driver = new InternetExplorerDriver(cap);
		    driver.manage().deleteAllCookies();
		    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 WebDriver driver =new InternetExplorerDriver();
		driver.get("https://www.bing.com/translator");
		System.out.println("test");
	}
*/
}

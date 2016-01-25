package selenium_mvn;

import org.junit.Test;

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
import com.csvreader.CsvReader;


			
public class seleniumtranslatorTest{

	
	
	String SourceArray[];
	String DestinationArray[];
	String TextToTranslateArray[];
	
	
			
/*	@Test
	public void StartChromeWebDriver(){
	
		System.setProperty("webdriver.chrome.driver", "C://Program Files (x86)//Google//Chrome//Application//Chrome.exe");
		ChromeDriver driver = new ChromeDriver(); 
		//driver.get("https://www.bing.com/translator");
		
		driver.get("http://www.google.com");
		System.out.println("test");
	}*/
	@Test
	public void StartFireFoxWebDriver() throws InterruptedException, IOException{
		WebDriver driver2 = new FirefoxDriver();
		driver2.get("https://www.bing.com/translator");
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
		
		driver2.findElement(By.id("Header_SrcLangList")).click();
		Thread.sleep(500);
		
		driver2.findElement(By.linkText(SrcLang)).click();
	
		Thread.sleep(500);
		driver2.findElement(By.id("InputText")).clear();
		driver2.findElement(By.id("InputText")).sendKeys(TextToTrans);
		
	  
				
		Thread.sleep(500);
		driver2.findElement(By.id("Header_DstLangList")).click();
		Thread.sleep(500);
		
		driver2.findElement(By.linkText(DstLang)).click();
		Thread.sleep(500);
		}
		else  System.out.println("empty value"+ SrcLang);

		
		}
		Reader.close();
	}	
}
	/*
	@Test
	public void StartIEWebDriver() throws InterruptedException{
		System.setProperty("webdriver.ie.driver", "C://Iexplore.exe");
		//ChromeDriver driver = new ChromeDriver(); 
		//driver.get("https://www.bing.com/translator");
		WebDriver driver = new InternetExplorerDriver();
		Thread.sleep(500);
		driver.navigate().to("http://www.google.com");
		System.out.println("test");
	}*/



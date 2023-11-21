package org.testscripts.tests;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;

//import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;


public class App 
{
    public static void main( String[] args ) throws InterruptedException, IOException
    {

	    System.out.println("Script Started");	
	     
	    //System.setProperty("webdriver.chrome.driver", "C:/Users/Dell/Downloads/chromedriver-win64/chromedriver-win64/chromedriver.exe");
	    WebDriverManager.chromedriver().setup();
	   
	    ChromeOptions chromeOptions = new ChromeOptions();
	    
	 
	    System.out.println("Driver opening up the url in browser");	
	    WebDriver driver = new ChromeDriver(chromeOptions);
	    driver.get("http://54.196.163.29:8081//contact.html");	
	    
	 
	    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	    
	    System.out.println("Enter details in the form");
	  
	    
	    driver.findElement(By.id("inputName")).sendKeys("Sushmitha");
	    Thread.sleep(2000);
	  
	    driver.findElement(By.id("inputNumber")).sendKeys("9988998899");
	    Thread.sleep(2000);
	   
	    driver.findElement(By.id("inputMail")).sendKeys("sushmitha@xyz.com");
	
	    driver.findElement(By.id("inputMessage")).sendKeys("Hi, Iam intrested in insurance");
	  
	   
	    driver.findElement(By.id("my-button")).click();
	    String response = driver.findElement(By.id("response")).getText();
	    System.out.println(response);
	    System.out.println("Test scripts executed");
	    TakesScreenshot scrShot = ((TakesScreenshot)driver);
	    File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
	    //File destFile = new File("C:\\Users\\Dell\\Documents\\test-reports.jpg");
	    File destFile = new File("/var/lib/jenkins/workspace/insure-me-test-scripts/test-reports.jpg");
	    FileUtils.copyFile(srcFile,destFile);
	    Thread.sleep(2000);
	    driver.quit();
    
    
        System.out.println( "Hello World!" );
    }  
}


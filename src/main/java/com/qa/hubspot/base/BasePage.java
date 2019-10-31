package com.qa.hubspot.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * 
 * @author PK
 *
 */
public class BasePage {
	public WebDriver driver;
	public Properties prop;
	public WebDriver initialize_driver(Properties prop){
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome")){
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browserName.equals("firefox")){
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if(browserName.equals("ie")){
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}
		else{
			System.out.println("Browser "+browserName+" is not defined in properties file, please give the correct browser name.");
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().fullscreen();
		driver.get(prop.getProperty("url"));
		
		return driver;
	}
	
	/**
	 * This method is used to initialize properties and it will return properties reference
	 * @return prop
	 */
	public Properties initialize_properties(){
		prop = new Properties();
		try{
			FileInputStream ip = new FileInputStream("/Users/priti/Documents/workspace/PomFramework/src/main/java/com/"
					+ "qa/hubspot/configration/config.properties");
			prop.load(ip);
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
		return prop;
	} 
	 
	 

}

package com.absa.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.absa.qa.utils.WebEventListener;



public class TestBase {
	public static WebDriver driver;
	public static Properties prop;

	public static EventFiringWebDriver e_driver;
	
	public static WebEventListener eventListener;
	
	public TestBase()
	{
		try
			{
			prop= new Properties();
			FileInputStream fis = new FileInputStream("E:\\My_Automation\\QA_Test\\src\\main\\java\\com\\absa\\qa\\config\\Config1");
			System.out.println("file path:"+fis.toString());
			prop.load(fis);
			}
			catch(FileNotFoundException e)
			{
				e.printStackTrace();
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
			catch(NullPointerException e)
			{
				e.printStackTrace();
			}
			//System.out.println(prop.getProperty("browser"));
		}
	
	
	
	public static void initialization( )
	{
	String browserName = prop.getProperty("browser");
	if(browserName.equalsIgnoreCase("chrome"))
	{
		System.setProperty("webdriver.chrome.driver","E:\\My_Automation\\QA_Test\\DriverInstance\\chromedriver.exe");
	driver= new ChromeDriver();
	}
	else
	if(browserName.equalsIgnoreCase("firefox"))
	{
	System.setProperty("webdriver.gecko.driver","E:\\My_Automation\\QA_Test\\DriverInstance\\geckodriver.exe");
	driver= new FirefoxDriver();
	
	}
	
	e_driver = new EventFiringWebDriver(driver);
	// Now create object of EventListerHandler to register it with EventFiringWebDriver
	
	WebEventListener eventListener = new WebEventListener();
	e_driver.register(eventListener);
	driver = e_driver;
	
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
	

	driver.get(prop.getProperty("url")); 
	}
}



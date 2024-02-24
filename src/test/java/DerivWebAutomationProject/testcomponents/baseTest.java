package DerivWebAutomationProject.testcomponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


import DerivWebAutomationProject.PageObjects.OrangeHrmLogInPage;


public class baseTest {
	
	public WebDriver driver;
	public OrangeHrmLogInPage lp;
	
	public String getPropertyValue(String property) throws IOException
	{
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"//src//main//java//DerivWebAutomationProject//resources/globaldata.properties");
		prop.load(fis);
		return prop.getProperty(property);
		
	}
	
	public WebDriver initializeDriver() throws IOException
	{
	
		String browser=System.getProperty("browser")!=null ? System.getProperty("browser") : getPropertyValue("browser");
		
		if(browser.contains("Chrome"))
		{
			ChromeOptions options = new ChromeOptions();
			
			if (browser.contains("headless"))
			{
			options.addArguments("headless");
			} 
			driver=new ChromeDriver(options);
			driver.manage().window().setSize(new Dimension(1440,900));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
			driver.manage().window().maximize();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			//firefox
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.manage().window().maximize();
		return driver;
	}
	
	@BeforeMethod(alwaysRun=true)
	public OrangeHrmLogInPage launchApplication() throws IOException
	{
		driver=initializeDriver();
		lp=new OrangeHrmLogInPage(driver);
		lp.goToUrl(getPropertyValue("url"));	
		return lp;
	}
	
	@AfterMethod(alwaysRun=true)
	public void closeDriver()
	{
		driver.close();
	}
	
	
	public String takeScreenshort(String testcasename, WebDriver driver) throws IOException
	{
		TakesScreenshot s=(TakesScreenshot)driver;
		File source=s.getScreenshotAs(OutputType.FILE);
		File destination=new File(System.getProperty("user.dir")+"//reports//"+testcasename+".png");
		
		FileHandler.copy(source, destination);
		return System.getProperty("user.dir")+"//reports//"+testcasename+".png";
		
	}

}

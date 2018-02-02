package mavenPackage.MyMavenProject.testBase;

import java.io.File;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class TestBase {
	
	public static final Logger log = Logger.getLogger(TestBase.class.getName());
	public WebDriver driver;
	
	public void intialize(String browser, String url)
	{
		openBrowser(browser);
		getUrl(url);
		String log4jConfigPath = "log4jProperties";
		PropertyConfigurator.configure(log4jConfigPath);
	}
	public void getUrl(String url)
	{
		log.info("Navigating to the URL: "+url);
		driver.get(url);
	}
	public void openBrowser(String browser)
	{
		log.info("Opening the browser: "+browser);
		if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\VD57\\Downloads\\SeleniumDrivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			File pathBinary = new File("C:\\Users\\VD57\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
			FirefoxBinary firefoxBinary = new FirefoxBinary(pathBinary);
			FirefoxProfile firefoxProfile = new FirefoxProfile();       
			driver = new FirefoxDriver(firefoxBinary, firefoxProfile);
		}
	}

}

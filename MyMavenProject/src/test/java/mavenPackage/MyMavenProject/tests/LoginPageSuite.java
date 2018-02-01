package mavenPackage.MyMavenProject.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import mavenPackage.MyMavenProject.pageActionsLibrary.LoginPageActions;
import mavenPackage.MyMavenProject.pageObjectLibrary.LoginPage;

public class LoginPageSuite {
	
	WebDriver driver;
	LoginPageActions loginPageActions;
	@BeforeMethod
	public void beforeTest()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\VD57\\Downloads\\SeleniumDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://opensource.demo.orangehrmlive.com/");
	}
	@Test
	public void verifyLoginWithInvalidCredentials()
	{	
		loginPageActions = new LoginPageActions(driver);
		loginPageActions.enterUserName("Admin");
		loginPageActions.enterPassword("Admin123");
		loginPageActions.clickLoginButton();
//		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
//		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
//		driver.findElement(By.id("btnLogin")).click();
		String expMessage = "Invalid credentials";
		String actMessage = driver.findElement(By.id("spanMessage")).getText();
		System.out.println("Invalid Login Error Message is: "+actMessage);
		Assert.assertEquals(actMessage, expMessage);
	}
	
	@Test
	public void verifyLoginWithValidCredentials()
	{	
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin");
		driver.findElement(By.id("btnLogin")).click();
		String expTitle = "OrangeHRM";
		String actTitle = driver.getTitle();
		Assert.assertEquals(actTitle, expTitle);
	}
	
	@AfterMethod
	public void afterTest()
	{
		driver.close();
	}

}

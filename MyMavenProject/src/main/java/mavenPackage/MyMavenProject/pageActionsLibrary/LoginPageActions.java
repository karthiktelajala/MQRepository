package mavenPackage.MyMavenProject.pageActionsLibrary;

import org.apache.commons.logging.Log;
import org.openqa.selenium.WebDriver;
import org.testng.log4testng.Logger;

import mavenPackage.MyMavenProject.pageObjectLibrary.LoginPage;

public class LoginPageActions extends LoginPage {

	public LoginPageActions(WebDriver driver) {
		super(driver);
	}
	
	public void enterUserName(String username)
	{
		txtUserName.sendKeys(username);
	}
	
	public void enterPassword(String password)
	{
		txtPassword.sendKeys(password);
	}
	
	public void clickLoginButton()
	{
		btnLoginButton.click();;
	}
	
	public String getInvalidLoginMessage()
	{
		return invlaidLoginMessage.getText();
	}

}

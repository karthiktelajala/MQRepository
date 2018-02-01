package mavenPackage.MyMavenProject.pageActionsLibrary;

import org.openqa.selenium.WebDriver;

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

}

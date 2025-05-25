package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RSA_Login {
	@FindBy(id = "userEmail")
	public WebElement RSA_Login_Username;

	@FindBy(id = "userPassword")
	public WebElement RSA_Login_Password;

	@FindBy(id = "login")
	public WebElement RSA_Login_Login;
}

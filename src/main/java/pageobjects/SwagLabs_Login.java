package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SwagLabs_Login {
	@FindBy(id = "user-name")
	public WebElement SwagLabs_Login_Username;

	@FindBy(id = "password")
	public WebElement SwagLabs_Login_Password;

	@FindBy(id = "login-button")
	public WebElement SwagLabs_Login_Login;
}

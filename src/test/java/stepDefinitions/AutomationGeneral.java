package stepDefinitions;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.When;
import utils.DriverFactory;
import utils.ElementFetcher;
import utils.TestDataLoader;
import utils.Utils;

public class AutomationGeneral {

	WebDriver driver;
	Properties prop;
	String appURL = "";
	ElementFetcher fetcher;

	public AutomationGeneral() {
		this.driver = DriverFactory.getDriver();
		this.fetcher = new ElementFetcher(driver);
		this.prop = new Properties();
	}

	private String getTestData(String key) {
		return TestDataLoader.get(key);
	}

	@When("the user launches the application {string}")
	public void launchApp(String URL) {
		String appURL = "";
		try {
			appURL = Utils.getGlobalValue(URL);
		} catch (IOException e) {
			System.err.println("Failed to load application URL from properties file.");
			e.printStackTrace();
			throw new RuntimeException("Error loading application URL for: " + URL, e);
		}

		driver.get(appURL);

	}

	@When("^the user enters the \"(.+?)\" into the \"(.+?)\" textbox at the \"(.+?)\" page$")
	public void enterText(String inputValue, String objName, String objPageName) {
		String valueToEnter = inputValue;

		// Handle test data keys wrapped as #(key)
		if (inputValue.matches("#\\(.+?\\)")) {
			String key = inputValue.replaceAll("[#()]", "");
			valueToEnter = getTestData(key);
		}

		WebElement element = fetcher.getElement(objName, objPageName);
		element.sendKeys(valueToEnter);
	}

	@When("^the user clicks on the \"(.+?)\" at the \"(.+?)\" page$")
	public void clickOnElement(String objName, String objPageName) {
		WebElement element = fetcher.getElement(objName, objPageName);
		element.click();
	}

}

package utils;

import java.lang.reflect.Field;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ElementFetcher {

	private WebDriver driver;

	public ElementFetcher(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getElement(String elementName, String pageObjectClassName) {
		try {
			// Full class name (package + class)
			String fullClassName = "pageobjects." + pageObjectClassName;

			// Load the class dynamically
			Class<?> clazz = Class.forName(fullClassName);
			Object pageObject = clazz.getDeclaredConstructor().newInstance();

			// Initialize elements using PageFactory
			PageFactory.initElements(driver, pageObject);
			// Use reflection to get the WebElement
			Field field = clazz.getDeclaredField(elementName);
			field.setAccessible(true);

			return (WebElement) field.get(pageObject);

		} catch (Exception e) {
			throw new RuntimeException("Failed to get element '" + elementName + "' from " + pageObjectClassName, e);
		}
	}
}

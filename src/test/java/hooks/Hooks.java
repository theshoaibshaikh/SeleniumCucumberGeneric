package hooks;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.TestDataLoader;

public class Hooks {

	// Thread-safe WebDriver
	private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	@Before(order = 0)
	public void loadDriver(Scenario scenario) {
		System.out.println("Launching browser for scenario: " + scenario.getName());

		WebDriver localDriver = new ChromeDriver();
		localDriver.manage().window().maximize();
		localDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.set(localDriver); // Set WebDriver for current thread
	}

	@Before(order = 1)
	public void beforeScenario(Scenario scenario) {
		String scenarioName = scenario.getName().replaceAll(" ", "");
		TestDataLoader.loadData(scenarioName);
	}

	@After
	public void cleanUp(Scenario scenario) {
		System.out.println("Closing browser for scenario: " + scenario.getName());

		WebDriver localDriver = driver.get();
		if (localDriver != null) {
			localDriver.quit();
			driver.remove(); // to prevent memory leaks
		}
	}

	// Get thread-safe WebDriver
	public static WebDriver getDriver() {
		return driver.get();
	}
}

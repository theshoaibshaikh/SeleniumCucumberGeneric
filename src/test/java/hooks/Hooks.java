package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.DriverFactory;
import utils.TestDataLoader;

public class Hooks {

	@Before(order = 0)
	public void loadDriver(Scenario scenario) {
		System.out.println("Launching browser for scenario: " + scenario.getName());
		DriverFactory.initDriver();
	}

	@Before(order = 1)
	public void beforeScenario(Scenario scenario) {
		String scenarioName = scenario.getName().replaceAll(" ", "");
		TestDataLoader.loadData(scenarioName);
	}

	@After
	public void cleanUp(Scenario scenario) {
		System.out.println("Closing browser for scenario: " + scenario.getName());
		DriverFactory.quitDriver();
	}
}

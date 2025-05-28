package hooks;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.service.ExtentService;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.DriverFactory;
import utils.TestDataLoader;

public class Hooks {

	private static boolean isExtentMetaSet = false;

	@Before(order = 0)
	public void loadDriver(Scenario scenario) {
		System.out.println("Launching browser for scenario: " + scenario.getName());
		DriverFactory.initDriver();

		// Set Extent metadata only once
		if (!isExtentMetaSet) {
			ExtentService.getInstance().setSystemInfo("Environment", "QA");
			ExtentService.getInstance().setSystemInfo("Browser", "Chrome");
			ExtentService.getInstance().setSystemInfo("Tester", "Shoaib Shaikh");
			ExtentService.getInstance().setSystemInfo("OS", System.getProperty("os.name"));
			isExtentMetaSet = true;
		}
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

	@AfterStep
	public void AddScreenshot(Scenario scenario) throws IOException {
		WebDriver driver = DriverFactory.getDriver();
//		if (scenario.isFailed()) {
//			// screenshot
//			File sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//			byte[] fileContent = FileUtils.readFileToByteArray(sourcePath);
//			scenario.attach(fileContent, "image/png", "image");
//
//		}
		File sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		byte[] fileContent = FileUtils.readFileToByteArray(sourcePath);

		String label = "Screenshot - " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));

		scenario.attach(fileContent, "image/png", label);

	}

}

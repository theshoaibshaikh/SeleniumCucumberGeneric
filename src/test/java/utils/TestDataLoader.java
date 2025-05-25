package utils;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Map;

import com.google.gson.Gson;

public class TestDataLoader {
	private static Map<String, String> dataMap;

	public static void loadData(String scenarioName) {
		String filePath = "src/test/resources/Features/" + scenarioName + ".json";
		try (Reader reader = new FileReader(filePath)) {
			Gson gson = new Gson();
			dataMap = gson.fromJson(reader, Map.class);
		} catch (IOException e) {
			throw new RuntimeException("Failed to load test data for scenario: " + scenarioName, e);
		}
	}

	public static String get(String key) {
		if (dataMap == null) {
			throw new IllegalStateException("Test data not loaded. Call loadData() first.");
		}
		return dataMap.getOrDefault(key, "");
	}
}

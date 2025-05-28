package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Utils {
	public static String getGlobalValue(String key) throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "/src/test/resources/GlobalData.properties");
		prop.load(fis);
		return prop.getProperty(key);
	}
}

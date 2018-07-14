package zero.pomdesign;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ZeroBankUtilities {

	static Properties prop = new Properties();
	
	static {
		prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream("ZeroBankConfig.properties");
			prop.load(fis);
			fis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getMyValue(String key) {
		return prop.getProperty(key);
	}

}

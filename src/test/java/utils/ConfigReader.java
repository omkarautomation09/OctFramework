package utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

    Properties prop;

    public ConfigReader() throws Exception {

        String path = System.getProperty("user.dir")
                + "/src/test/resources/config.properties";

        FileInputStream fis = new FileInputStream(path);

        prop = new Properties();

        prop.load(fis);
    }

    public String getUrl() {

        return prop.getProperty("url");
    }

    public String getBrowser() {

        return prop.getProperty("browser");
    }

    public String getTimeout() {

        return prop.getProperty("timeout");
    }
}
package com.demoqa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class StaticConfigFileReader {

    private static String propertyFilePath;
    private static Properties properties;

    static {
        propertyFilePath = "src/main/resources/application.properties";
        properties = new Properties();
        try (BufferedReader reader = new BufferedReader(new FileReader(propertyFilePath))) {
            properties.load(reader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String getProperty(String propertyKey) {
        var propertyValue = properties.getProperty(propertyKey);
        if (propertyValue != null) {
            return propertyValue;
        }
        throw new RuntimeException(propertyKey + "is not found");
    }

    public static String getBaseUrl() {
        return getProperty("base.url");
    }
}

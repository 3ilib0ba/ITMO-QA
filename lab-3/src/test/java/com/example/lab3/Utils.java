package com.example.lab3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Utils {
    public static final String CHROME_SYSTEM_PROPERTY_NAME = "webdriver.chrome.driver";
    public static final String FIREFOX_SYSTEM_PROPERTY_NAME = "webdriver.gecko.driver";
    public static final String BASE_URL = "https://ask.fm/";

    private static ChromeDriver getChromeDriver() {
        if (!System.getProperties().containsKey(CHROME_SYSTEM_PROPERTY_NAME)) {
            throw new RuntimeException("Chrome driver not set properly");
        }
        return new ChromeDriver();
    }

    private static FirefoxDriver getFirefoxDriver() {
        if (!System.getProperties().containsKey(FIREFOX_SYSTEM_PROPERTY_NAME)) {
            throw new RuntimeException("Firefox driver not set properly");
        }
        return new FirefoxDriver();
    }

    public static List<WebDriver> getDrivers() {
        List<WebDriver> drivers = new ArrayList<>();
        try {
            List<String> properties = Files.readAllLines(Paths.get("lab-3.properties"));
            for (String property : properties) {
                if (property.startsWith("WEB_DRIVER")) {
                    switch (property.toLowerCase().split("=")[1]) {
                        case "chrome":
                            drivers.add(getChromeDriver()); return drivers;
                        case "firefox":
                            drivers.add(getFirefoxDriver()); return drivers;
                        case "both":
                            drivers.add(getChromeDriver());
                            drivers.add(getFirefoxDriver());
                            return drivers;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        throw new RuntimeException("Web driver is not specified");
    }

    public static void prepareDrivers() {
        WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();
        //System.setProperty("webdriver.http.factory", "jdk-http-client");
    }
}

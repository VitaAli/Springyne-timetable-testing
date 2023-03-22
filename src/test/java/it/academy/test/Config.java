package it.academy.test;

import org.openqa.selenium.remote.Browser;

public class Config {

    public static final String developerUrl = "http://localhost:3000/?#/";

    public static final String baseUrl = System.getProperty("baseUrl", "https://tomcat.akademijait.vtmc.lt/springyne/");
    public static final String host = System.getProperty("host", "saucelabs");
    public static final String browserName = System.getProperty("browserName", "Firefox");
    public static final String browserVersion = System.getProperty("browserVersion", "latest");
    public static final String platformName = System.getProperty("platformName", "Windows 10");
    public static final String sauceUser = System.getenv("SAUCE_USERNAME");
    public static final String sauceKey = System.getenv("SAUCE_ACCESS_KEY");
}

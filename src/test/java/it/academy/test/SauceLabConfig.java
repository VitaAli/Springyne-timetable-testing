package it.academy.test;

public class SauceLabConfig {

    public static final String browserName = System.getProperty("browserName", "Firefox");
    public static final String browserVersion = System.getProperty("browserVersion", "latest");
    public static final String platformName = System.getProperty("platformName", "Windows 10");
    public static final String sauceUser = System.getenv("SAUCE_USERNAME");
    public static final String sauceKey = System.getenv("SAUCE_ACCESS_KEY");
}

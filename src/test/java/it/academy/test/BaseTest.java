package it.academy.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class BaseTest {

    public static WebDriver driver;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://tomcat.akademijait.vtmc.lt/springyne/");

    }

    @AfterEach
    public void closeDriver() {
        driver.quit();
    }
}
package it.academy.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static it.academy.test.SauceLabConfig.*;


public class BaseTestSauceLab {

    protected RemoteWebDriver driver;

    @BeforeEach
    public void setUp(TestInfo testInfo) throws MalformedURLException {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        MutableCapabilities sauceOptions = new MutableCapabilities();
        sauceOptions.setCapability("username", sauceUser);
        sauceOptions.setCapability("accesskey", sauceKey);
        sauceOptions.setCapability("name", testInfo.getDisplayName());
        MutableCapabilities options;
        switch (browserName) {
            case "Firefox": {
                options = new FirefoxOptions();
                break;
            }
            case "MicrosoftEdge": {
                options = new EdgeOptions();
                break;
            }
            default: {
                options = new ChromeOptions();
                break;
            }
        }
        options.setCapability("browserName", browserName);
        options.setCapability("browserVersion", browserVersion);
        options.setCapability("platformName", platformName);
        options.setCapability("sauce:options", sauceOptions);
        URL url = new URL("https://ondemand.eu-central-1.saucelabs.com/wd/hub");
        driver = new RemoteWebDriver(url, options);
        driver.manage().window().maximize();
        driver.get("https://tomcat.akademijait.vtmc.lt/springyne/");
    }

    @AfterEach
    public void closeDriver() {
        driver.quit();
    }
}

package it.academy.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class BaseTest {

//    public static WebDriver driver;

    protected RemoteWebDriver driver;

//    @RegisterExtension
//    public SauceTestWatcher watcher = new SauceTestWatcher();

    @BeforeEach
    public void setUp(TestInfo testInfo) throws MalformedURLException {
        System.setProperty("webdriver.http.factory", "jdk-http-client");

        ChromeOptions options = new ChromeOptions();
        options.setPlatformName("Windows 10");
        options.setBrowserVersion("latest");

        Map<String, Object> sauceOptions = new HashMap<>();
        sauceOptions.put("username", System.getenv("SAUCE_USERNAME"));
        sauceOptions.put("accessKey", System.getenv("SAUCE_ACCESS_KEY"));
        sauceOptions.put("name", testInfo.getDisplayName());

        options.setCapability("sauce:options", sauceOptions);
        URL url = new URL("https://oauth-vitalija.alisauskiene-96ae5:f5bfb19e-74aa-47f7-b004-c0b0b768f7b4@ondemand.eu-central-1.saucelabs.com:443/wd/hub");

        driver = new RemoteWebDriver(url, options);
        driver.manage().window().maximize();
        driver.get("https://tomcat.akademijait.vtmc.lt/springyne/");
    }

    @AfterEach
    public void closeDriver() {
        driver.quit();
    }
}

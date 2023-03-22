package it.academy.test;

import org.junit.jupiter.api.TestInfo;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static it.academy.test.Config.*;
import static it.academy.test.Config.platformName;

public class BrowserManager {

    protected RemoteWebDriver driver;

    public void manageDifferentBrowsers(TestInfo testInfo) throws MalformedURLException {

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
        URL url = new URL("https://oauth-vitalija.alisauskiene-96ae5:f5bfb19e-74aa-47f7-b004-c0b0b768f7b4@ondemand.eu-central-1.saucelabs.com:443/wd/hub");

        driver = new RemoteWebDriver(url, options);

    }
}

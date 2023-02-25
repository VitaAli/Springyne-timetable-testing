package it.academy.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {

    public static void waitForJS(WebDriver driver) {
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(dr -> ((Long) ((JavascriptExecutor) dr)
                .executeScript("return jQuery.active") == 0));
    }

    public static void setImplicitWait(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
}

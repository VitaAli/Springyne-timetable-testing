package it.academy.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
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

    public static void waitForMessageNoRecordsFound(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("tr td:nth-child(" + "1)"), "Įrašų nerasta"));
    }
}


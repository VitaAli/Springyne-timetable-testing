package it.academy.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {

    public static void setImplicitWait(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public static void waitForMessageNoRecordsFound(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("tr td:nth-child(1)")
                , "Įrašų nerasta"));
    }

    public static void waitForResult(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//tfoot/tr/td[1]")));
    }

    public static void waitForSuccessMessage(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.presenceOfElementLocated(By
                .cssSelector(".mx-3 > div:nth-of-type(1) .MuiAlert-message")));
    }



    public static void waitForErrorMessage(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.presenceOfElementLocated(By
                        .cssSelector(".mx-3 > div:nth-of-type(2) .MuiAlert-message")));
    }




    public static void waitUntilRestoreButtonAppears(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait((driver), Duration.ofSeconds(3));
        wait.until((ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//button[.='Atstatyti']"))));
    }
}


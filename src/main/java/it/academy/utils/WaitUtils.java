package it.academy.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {

    public static void waitForMessageNoRecordsFound(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("tr td:nth-child(1)")
                , "Įrašų nerasta"));
    }

    public static void waitForMessageRecordsAreFound(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//tfoot/tr/td[1]")));
    }

    public static void waitUntilRestoreButtonAppears(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait((driver), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By
                        .cssSelector("button.btn-secondary")
                , "Atstatyti"));
    }

    public static void waitForMessageRecordIsCreated(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.cssSelector(".mx-3 > div:nth-of-type(1) .MuiAlert-message")));
    }

    public static void waitForMessageRecordIsNotCreated(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By
                        .cssSelector(".mx-3 > div:nth-of-type(2) .MuiAlert-message")
                , "Įrašo nepavyko sukurti"));
    }

    public static void waitForMessageRecordUpdated(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.cssSelector(".mx-3 > div:nth-of-type(1) .MuiAlert-message")));
    }

    public static void waitForMessageRecordDeleted(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By
                        .cssSelector(".mx-3 > div:nth-of-type(1) .MuiAlert-message")
                , "Įrašas sėkmingai ištrintas"));
    }

    public static void waitForMessageRecordRestored(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By
                        .cssSelector(".mx-3 > div:nth-of-type(2) .MuiAlert-message")
                , "Įrašas sėkmingai atstatytas"));
    }

    public static void waitForMessageShiftUpdated(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.cssSelector(".mx-3 > div:nth-of-type(3) .MuiAlert-message")));
    }

    public static void waitForMessageSubjectUpdated(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//div[contains(text(),'Įrašas sėkmingai atnaujintas')]")));
    }

}


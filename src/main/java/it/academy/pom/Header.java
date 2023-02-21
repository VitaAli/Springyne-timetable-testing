package it.academy.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Header {

    @FindBy(xpath = "//a[normalize-space()='Pagrindinis']")
    private WebElement home;
    @FindBy(xpath = "//a[normalize-space()='Moduliai']")
    private WebElement modules;
    @FindBy(xpath = "//a[normalize-space()='Kabinetai']")
    private WebElement rooms;
    @FindBy(xpath = "//a[normalize-space()='Pamainos']")
    private WebElement shifts;
    @FindBy(xpath = "//a[normalize-space()='Dalykai']")
    private WebElement subjects;
    @FindBy(xpath = "//a[normalize-space()='Mokytojai']")
    private WebElement teachers;

    public Header(WebDriver driver) {
        super();
    }

    public void openHome() {
        home.click();
    }

    public void openModules() {
        modules.click();
    }

    public void openRooms() {
        rooms.click();
    }

    public void openShifts() {
        shifts.click();
    }

    public void openSubjects() {
        subjects.click();
    }

    public void openTeachers() {
        teachers.click();
    }
}

package it.academy.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Header {

    @FindBy(css = "a[href='#/']")
    private WebElement home;
    @FindBy(css = "a[href='#/modules']")
    private WebElement modules;
    @FindBy(css = "a[href='#/rooms']")
    private WebElement rooms;
    @FindBy(css = "a[href='#/shifts']")
    private WebElement shifts;
    @FindBy(css = "a[href='#/subjects']")
    private WebElement subjects;
    @FindBy(css = "a[href='#/teachers']")
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

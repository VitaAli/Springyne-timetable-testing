package it.academy.pom.teachers;

import it.academy.pom.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TeacherAddPage extends AbstractPage {

    @FindBy (css = "#create-teacher-name-with-error")
    private WebElement inputTeacherName;

    @FindBy (css = "#create-teacher-teams_mail-with-error")
    private WebElement inputTeacherUsername;

    @FindBy (css = "#create-teacher-hours-with-error")
    private WebElement inputTeacherNumberOfHours;

    @FindBy (css = "#add-select-subject")
    private WebElement inputTeacherSubject;

    @FindBy (css = "#select-shift")
    private WebElement inputTeacherShift;

    @FindBy (css = "#menu- li:first-of-type")
    private WebElement firstValueFromList;



    public TeacherAddPage(WebDriver driver) {
        super(driver);
    }

    public TeacherAddPage enterTeacherName(String name) {
        inputTeacherName.sendKeys(name);
        return this;
    }

    public TeacherAddPage enterTeacherUsername(String username) {
        inputTeacherUsername.sendKeys(username);
        return this;
    }

    public TeacherAddPage enterTeacherNumbersOfHours(String hours) {
        inputTeacherNumberOfHours.sendKeys(hours);
        return this;
    }

    public TeacherAddPage selectTeacherSubject() {
        inputTeacherSubject.click();
        firstValueFromList.click();
        return this;
    }

    public TeacherAddPage selectTeacherShift() {
        inputTeacherShift.click();
        firstValueFromList.click();
        return this;
    }

}

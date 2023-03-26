package it.academy.pom.programs;

import it.academy.pom.AbstractPage;
import it.academy.pom.teachers.TeacherAddPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProgramAddPage extends AbstractPage {

    @FindBy (css = "#create-program-name-with-error")
    private WebElement inputProgramName;

    @FindBy (css = "#create-teacher-description-error")
    private WebElement inputProgramDescription;

    @FindBy (css = "#create-subject-hours-with-error")
    private WebElement inputSubjectHours;

    @FindBy (css = "#add-select-subject")
    private WebElement inputSubject;

    @FindBy (css = "#menu- li:first-of-type")
    private WebElement firstSubjectFromList;

    @FindBy(css = "button[type='submit']")
    private WebElement buttonAdd;

    @FindBy(css = ".mx-3 > div:nth-of-type(1) .MuiAlert-message")
    private WebElement successMessage;

    public ProgramAddPage(WebDriver driver) {
        super(driver);
    }

    public ProgramAddPage enterProgramName(String name) {
        inputProgramName.sendKeys(name);
        return this;
    }

    public ProgramAddPage enterProgramDescription(String description) {
        inputProgramDescription.sendKeys(description);
        return this;
    }

    public ProgramAddPage enterSubjectHours(String hours) {
        inputSubjectHours.sendKeys(hours);
        return this;
    }

    public ProgramAddPage selectSubject() {
        inputSubject.click();
        firstSubjectFromList.click();
        return this;
    }

    public ProgramAddPage pressButtonAdd() {
        buttonAdd.click();
        return this;
    }

    public String getSuccessMessage() {
        return successMessage.getText();
    }
}

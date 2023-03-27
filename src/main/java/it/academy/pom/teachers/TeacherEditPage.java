package it.academy.pom.teachers;

import it.academy.pom.AbstractPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TeacherEditPage extends AbstractPage {

    @FindBy(css = "#teacher-name-with-error")
    private WebElement inputTeacherName;

    @FindBy(xpath = "//form/div[2]//input")
    private WebElement inputTeacherUsername;

    @FindBy(xpath = "//form/div[3]//input")
    private WebElement inputTeacherEmail;

    @FindBy(xpath = "//form/div[4]//input")
    private WebElement inputTeacherMobile;

    @FindBy(xpath = "//form/div[5]//input")
    private WebElement inputTeacherNumberOfHours;

    @FindBy(css = "#add-select-subject")
    private WebElement inputTeacherSubject;

    @FindBy (css = "#menu- li:first-of-type")
    private WebElement firstValueFromList;

    @FindBy(css = "#select-shift")
    private WebElement inputTeacherShift;

    @FindBy(css = "button.btn-primary")
    private WebElement buttonEdit;

    @FindBy(css = "button.btn-danger")
    private WebElement buttonDelete;

    @FindBy(css = "button.btn-secondary")
    private WebElement buttonRestore;

    @FindBy(xpath = "//div[contains(text(),'Įrašas sėkmingai atnaujintas')]")
    private WebElement successMessage;

    public TeacherEditPage(WebDriver driver) {
        super(driver);
    }

    public TeacherEditPage editTeacherName(String name) {
        inputTeacherName.click();
        inputTeacherName.click();
        inputTeacherName.sendKeys(Keys.CONTROL + "a");
        inputTeacherName.sendKeys(Keys.DELETE);
        inputTeacherName.sendKeys(name);
        return this;
    }

    public TeacherEditPage enterTeacherUsername(String username) {
        inputTeacherUsername.click();
        inputTeacherUsername.sendKeys(Keys.CONTROL + "a");
        inputTeacherUsername.sendKeys(Keys.DELETE);
        inputTeacherUsername.sendKeys(username);
        return this;
    }

    public TeacherEditPage enterTeacherEmail(String email) {
        inputTeacherEmail.click();
        inputTeacherEmail.sendKeys(Keys.CONTROL + "a");
        inputTeacherEmail.sendKeys(Keys.DELETE);
        inputTeacherEmail.sendKeys(email);
        return this;
    }

    public TeacherEditPage enterTeacherMobile(String mobile) {
        inputTeacherMobile.click();
        inputTeacherMobile.sendKeys(Keys.CONTROL + "a");
        inputTeacherMobile.sendKeys(Keys.DELETE);
        inputTeacherMobile.sendKeys(mobile);
        return this;
    }

    public TeacherEditPage enterTeacherNumbersOfHours(String hours) {
        inputTeacherNumberOfHours.click();
        inputTeacherNumberOfHours.sendKeys(Keys.CONTROL + "a");
        inputTeacherNumberOfHours.sendKeys(Keys.DELETE);
        inputTeacherNumberOfHours.sendKeys(hours);
        return this;
    }

    public TeacherEditPage selectTeacherSubject() {
        inputTeacherSubject.click();
        firstValueFromList.click();
        return this;
    }

    public TeacherEditPage selectTeacherShift() {
        inputTeacherShift.click();
        firstValueFromList.click();
        return this;
    }

    public TeacherEditPage pressButtonEdit() {
        buttonEdit.click();
        return this;
    }

    public TeacherEditPage pressButtonDelete() {
        buttonDelete.click();
        return this;
    }

    public TeacherEditPage pressButtonRestore() {
        buttonRestore.click();
        return this;
    }

    public String getSuccessMessage() {
        return successMessage.getText();
    }
}

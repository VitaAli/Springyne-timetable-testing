package it.academy.pom.subjects;

import it.academy.pom.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SubjectAddPage extends AbstractPage {

    @FindBy (css = "#create-subject-name-with-error")
    private WebElement inputSubjectName;

    @FindBy (css = "#create-subject-description-with-error")
    private WebElement inputSubjectDescription;

    @FindBy (css = "#add-select-module")
    private WebElement moduleList;

    @FindBy (xpath = "//div[3]/div/input")
    private WebElement moduleInvalidValue;

    @FindBy (css = "#add-select-room")
    private WebElement roomList;

    @FindBy (xpath = "//div[4]/div/input")
    private WebElement roomInvalidValue;

    @FindBy (css = "#menu- li:first-of-type")
    private WebElement firstValueFromList;

    @FindBy(css = "button[type='submit']")
    private WebElement buttonAdd;

    @FindBy (css = ".mx-3 > div:nth-of-type(1) .MuiAlert-message")
    private WebElement successMessage;

    @FindBy (css = ".mx-3 > div:nth-of-type(1) .MuiAlert-message")
    private WebElement errorMessage;

    public SubjectAddPage(WebDriver driver) {
        super(driver);
    }

    public SubjectAddPage enterSubjectName(String name) {
        inputSubjectName.sendKeys(name);
        return this;
    }

    public SubjectAddPage enterSubjectDescription(String description) {
        inputSubjectDescription.sendKeys(description);
        return this;
    }

    public SubjectAddPage selectModule() {
        moduleList.click();
        firstValueFromList.click();
        return this;
    }

    public SubjectAddPage selectRoom() {
        roomList.click();
        firstValueFromList.click();
        return this;
    }

    public SubjectAddPage pressButtonAdd() {
        buttonAdd.click();
        return this;
    }

    public String getSuccessMessage() {
        return successMessage.getText();
    }

    public boolean getNameInvalidValue() {
        return Boolean.parseBoolean(inputSubjectName.getAttribute("aria-invalid"));
    }

    public boolean getRoomInvalidValue() {
        return Boolean.parseBoolean(roomInvalidValue.getAttribute("aria-hidden"));
    }

    public boolean getModuleInvalidValue() {
        return Boolean.parseBoolean(moduleInvalidValue.getAttribute("aria-hidden"));
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }

}

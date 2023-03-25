package it.academy.pom.subjects;

import it.academy.pom.AbstractPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SubjectEditPage extends AbstractPage {

    @FindBy(css = "#subject-name")
    private WebElement inputSubjectName;

    @FindBy(css = "#subject-description")
    private WebElement inputSubjectDescription;

    @FindBy(css = "#add-select-module")
    private WebElement inputSubjectModule;

    @FindBy(xpath = "//*[@id='menu-']/div[3]/ul/li[2]")
    private WebElement firstModuleFromList;

    @FindBy(css = "#add-select-room")
    private WebElement inputSubjectRoom;

    @FindBy(css = "#menu- li:first-of-type")
    private WebElement firstRoomFromList;

    @FindBy(css = "button.btn-primary")
    private WebElement buttonEditSubject;

    @FindBy(css = "button.btn-danger.me-2")
    private WebElement buttonDelete;

    @FindBy(css = "button.btn-secondary")
    private WebElement buttonRestore;

    @FindBy(xpath = "//div[contains(text(),'Įrašas sėkmingai atnaujintas')]")
    private WebElement successMessage;

    public SubjectEditPage(WebDriver driver) {
        super(driver);
    }

    public SubjectEditPage enterSubjectName(String name) {
        inputSubjectName.click();
        inputSubjectName.sendKeys(Keys.CONTROL + "a");
        inputSubjectName.sendKeys(Keys.DELETE);
        inputSubjectName.sendKeys(name);
        return this;
    }

    public SubjectEditPage enterSubjectDescription(String description) {
        inputSubjectDescription.click();
        inputSubjectDescription.sendKeys(Keys.CONTROL + "a");
        inputSubjectDescription.sendKeys(Keys.DELETE);
        inputSubjectDescription.sendKeys(description);
        return this;
    }

    public SubjectEditPage selectSubjectModule() {
        inputSubjectModule.click();
        firstModuleFromList.click();
        return this;
    }

    public SubjectEditPage selectSubjectRoom() {
        inputSubjectRoom.click();
        firstRoomFromList.click();
        return this;
    }

    public SubjectEditPage pressButtonEditSubject() {
        buttonEditSubject.click();
        return this;
    }

    public SubjectEditPage pressButtonDelete() {
        buttonDelete.click();
        return this;
    }

    public void pressButtonRestore() {
        buttonRestore.click();
    }

    public String getSuccessMessage() {
        return successMessage.getText();
    }
}

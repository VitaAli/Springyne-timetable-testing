package it.academy.pom.shifts;

import it.academy.pom.AbstractPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShiftEditPage extends AbstractPage {

    @FindBy(css = "#edit-module-number-with-error")
    private WebElement inputName;

    @FindBy(css = "button[type='submit']")
    private WebElement buttonEdit;

    @FindBy(css = "button.btn-danger")
    private WebElement buttonDelete;

    @FindBy(css = "button.btn-secondary")
    private WebElement buttonRestore;

    @FindBy (css = ".mx-3 > div:nth-of-type(3) .MuiAlert-message")
    private WebElement successMessage;

    public ShiftEditPage(WebDriver driver) {
        super(driver);
    }

    public ShiftEditPage editShiftName(String name) {
        inputName.click();
        inputName.sendKeys(Keys.CONTROL + "a");
        inputName.sendKeys(Keys.DELETE);
        inputName.sendKeys(name);
        return this;
    }

    public void pressButtonEdit() {
        buttonEdit.click();
    }

    public void pressButtonDelete() {
        buttonDelete.click();
    }

    public void pressButtonRestore() {
        buttonRestore.click();
    }

    public String getSuccessMessage() {
        return successMessage.getText();
    }
}

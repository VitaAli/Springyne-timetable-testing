package it.academy.pom.shifts;

import it.academy.pom.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShiftAddPage extends AbstractPage {

    @FindBy(css = "#create-shift-name")
    private WebElement inputName;

    @FindBy (css = "button[type='submit']")
    private WebElement buttonAdd;

    @FindBy (css = ".mx-3 > div:nth-of-type(1) .MuiAlert-message")
    private WebElement successMessage;

    @FindBy (css = ".mx-3 > div:nth-of-type(2) .MuiAlert-message")
    private WebElement errorMessage;

    public ShiftAddPage(WebDriver driver) {
        super(driver);
    }

    public ShiftAddPage enterShiftName(String name) {
        inputName.sendKeys(name);
        return this;
    }

    public ShiftAddPage pressButtonAdd() {
        buttonAdd.click();
        return this;
    }

    public String getSuccessMessage() {
        return successMessage.getText();
    }

    public boolean getNumberInvalidValue() {
        return Boolean.parseBoolean(inputName.getAttribute("aria-invalid"));
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }
}

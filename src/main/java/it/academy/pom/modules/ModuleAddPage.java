package it.academy.pom.modules;

import it.academy.pom.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ModuleAddPage extends AbstractPage {

    @FindBy (css = "div:nth-child(1) > div:nth-child(2) > input:nth-child(1)")
    private WebElement inputNumber;

    @FindBy (css = "div:nth-child(2) > div:nth-child(2) > input:nth-child(1)")
    private WebElement inputName;

    @FindBy (css = "button[type='submit']")
    private WebElement buttonAdd;

    @FindBy (css = ".mx-3 > div:nth-of-type(1) .MuiAlert-message")
    private WebElement successMessage;

    @FindBy (css = ".mx-3 > div:nth-of-type(2) .MuiAlert-message")
    private WebElement errorMessage;

    public ModuleAddPage(WebDriver driver) {
        super(driver);
    }

    public void enterNumber(String number) {
        inputNumber.sendKeys(number);
    }

    public void enterName(String name) {
        inputName.sendKeys(name);
    }

    public void pressButtonAdd() {
        buttonAdd.click();
    }

    public String getSuccessMessage() {
        return successMessage.getText();
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }

    public boolean getAriaInvalidValue() {
        return Boolean.parseBoolean(inputName.getAttribute("aria-invalid"));
    }
}

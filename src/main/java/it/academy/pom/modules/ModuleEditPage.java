package it.academy.pom.modules;

import it.academy.pom.AbstractPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ModuleEditPage extends AbstractPage {

    @FindBy(css = "#edit-module-number-with-error")
    private WebElement inputNumber;

    @FindBy(css = "#edit-module-name-with-error")
    private WebElement inputName;

    @FindBy(css = "button[type='submit']")
    private WebElement buttonEdit;

    @FindBy(css = "button.btn-danger")
    private WebElement buttonDelete;

    @FindBy(css = ".mx-3 > div:nth-of-type(1) .MuiAlert-message")
    private WebElement successMessage;

    public ModuleEditPage(WebDriver driver) {
        super(driver);
    }

    public ModuleEditPage editModuleNumber(String number) {
        inputNumber.click();
        inputNumber.sendKeys(Keys.CONTROL + "a");
        inputNumber.sendKeys(Keys.DELETE);
        inputNumber.sendKeys(number);
        return this;
    }

    public ModuleEditPage editModuleName(String name) {
        inputName.click();
        inputName.sendKeys(Keys.CONTROL + "a");
        inputName.sendKeys(Keys.DELETE);
        inputName.sendKeys(name);
        return this;
    }

    public ModuleEditPage pressButtonEditModule() {
        buttonEdit.click();
        return this;
    }

    public ModuleEditPage pressButtonDelete() {
        buttonDelete.click();
        return this;
    }

    public String getSuccessMessage() {
        return successMessage.getText();
    }

}

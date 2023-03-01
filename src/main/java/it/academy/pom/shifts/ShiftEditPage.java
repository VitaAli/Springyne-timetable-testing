package it.academy.pom.shifts;

import it.academy.pom.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShiftEditPage extends AbstractPage {

    @FindBy(css = "#create-module-number-with-error")
    private WebElement inputName;

    @FindBy(xpath = "//button[.='Redaguoti']")
    private WebElement buttonEdit;

    @FindBy(xpath = "//button[.='Ištrinti']")
    private WebElement buttonDelete;

    @FindBy(xpath = "//button[.='Atstatyti']")
    private WebElement buttonRestore;

    @FindBy (css = ".mx-3 > div:nth-of-type(3) .MuiAlert-message")
    private WebElement successMessage;

    public ShiftEditPage(WebDriver driver) {
        super(driver);
    }

    public void enterName(String name) {
        inputName.sendKeys(name);
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

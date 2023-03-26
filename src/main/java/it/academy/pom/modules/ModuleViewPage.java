package it.academy.pom.modules;

import it.academy.pom.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ModuleViewPage extends AbstractPage {

    @FindBy(xpath = "//button[.='Ištrinti']")
    private WebElement buttonDelete;

    @FindBy(xpath = "//button[.='Atstatyti']")
    private WebElement buttonRestore;

    @FindBy (css = ".mx-3 > div:nth-of-type(1) .MuiAlert-message")
    private WebElement successMessageAfterDeletion;

    @FindBy (css = ".mx-3 > div:nth-of-type(2) .MuiAlert-message")
    private WebElement successMessageAfterRestore;

    public ModuleViewPage(WebDriver driver) {
        super(driver);
    }

    public ModuleViewPage pressButtonDelete() {
        buttonDelete.click();
        return this;
    }

    public ModuleViewPage pressButtonRestore() {
        buttonRestore.click();
        return this;
    }

    public String getSuccessMessageAfterDeletion() {
        return successMessageAfterDeletion.getText();
    }

    public String getSuccessMessageAfterRestore() {
        return successMessageAfterRestore.getText();
    }
}

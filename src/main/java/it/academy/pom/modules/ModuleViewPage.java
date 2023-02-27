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
    private WebElement successMessageAfterReset;

    public ModuleViewPage(WebDriver driver) {
        super(driver);
    }

    public void pressButtonDelete() {
        buttonDelete.click();
    }

    public void pressButtonRestore() {
        buttonRestore.click();
    }

    public String getSuccessMessageAfterDeletion() {
        return successMessageAfterDeletion.getText();
    }

    public String getSuccessMessageAfterReset() {
        return successMessageAfterReset.getText();
    }
}

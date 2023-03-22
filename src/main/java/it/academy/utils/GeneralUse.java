package it.academy.utils;

import it.academy.pom.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GeneralUse extends AbstractPage {

    @FindBy(css = "button[type='submit']")
    private WebElement buttonAdd;

    @FindBy (css = ".mx-3 > div:nth-of-type(1) .MuiAlert-message")
    private WebElement successMessage;

    public GeneralUse(WebDriver driver) {
        super(driver);
    }

    public GeneralUse pressButtonAdd() {
        buttonAdd.click();
        return this;
    }

    public String getSuccessMessage() {
        return successMessage.getText();
    }
}

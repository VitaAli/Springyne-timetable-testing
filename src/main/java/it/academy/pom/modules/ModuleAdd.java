package it.academy.pom.modules;

import it.academy.pom.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ModuleAdd extends AbstractPage {

    @FindBy (css = ".btn-primary")
    private WebElement buttonAdd;

    @FindBy (css = "div:nth-child(1) > div:nth-child(2) > input:nth-child(1)")
    private WebElement inputNumber;

    @FindBy (css = "div:nth-child(2) > div:nth-child(2) > input:nth-child(1)")
    private WebElement inputName;

    @FindBy (css = "button[type='submit']")
    private WebElement buttonAddModule;

    public ModuleAdd(WebDriver driver) {
        super(driver);
    }

    public void pressButtonAdd() {
        buttonAdd.click();
    }
}

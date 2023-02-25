package it.academy.pom.modules;

import it.academy.pom.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ModuleEditPage extends AbstractPage {

    @FindBy(css = "#edit-module-number-with-error")
    private WebElement inputNumber;

    @FindBy(css = "#edit-module-name-with-error")
    private WebElement inputName;

    @FindBy(xpath = "//button[.='Redaguoti']")
    private WebElement buttonEdit;

    @FindBy(xpath = "//button[.='Ištrinti']")
    private WebElement buttonDelete;

    @FindBy(xpath = "//button[.='Atstatyti']")
    private WebElement buttonRestore;

    public ModuleEditPage(WebDriver driver) {
        super(driver);
    }
}

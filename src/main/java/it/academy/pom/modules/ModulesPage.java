package it.academy.pom.modules;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ModulesPage {

    @FindBy (css = "#search-name-input")
    private WebElement inputByName;

    @FindBy (css = "button[type='submit']")
    private WebElement buttonEnter;

    public ModuleListPage(WebDriver driver) {
        super();
    }

    public void searchModuleByName(String name) {
        inputByName.sendKeys(name);
    }

    public void pressButtonEnter() {
        buttonEnter.click();
    }

}

package it.academy.pom.modules;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ModulesPage {

    @FindBy (xpath = "//input[@id='search-name-input']")
    private WebElement inputByName;

    @FindBy (xpath = "//button[@type='submit']")
    private WebElement buttonEnter;

    @FindBy (xpath = "//td[normalize-space()='Test name1']")
    private WebElement searchedModule;

    public ModulesPage(WebDriver driver) {
        super();
    }

    public void searchModuleByName(String name) {
        inputByName.sendKeys(name);
    }

    public void pressButtonEnter() {
        buttonEnter.click();
    }

    public void getNameOfSearchedModule() {
        searchedModule.getText();
    }

}

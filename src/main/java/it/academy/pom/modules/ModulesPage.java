package it.academy.pom.modules;

import it.academy.pom.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class ModulesPage extends AbstractPage {

    @FindBy (css = "#search-name-input")
    private WebElement inputByName;

    @FindBy (css = "button[type='submit']")
    private WebElement buttonEnter;

    @FindBy (css = "tr td:nth-child(2)")
    private List<WebElement> modulesList;

    public ModulesPage(WebDriver driver) {
        super(driver);
    }

    public void searchModuleByName(String name) {
        inputByName.sendKeys(name);
    }

    public void pressButtonEnter() {
        buttonEnter.click();
    }

    public List getModulesList() {
        ArrayList<String> moduleNames = new ArrayList<>();
        for (int index = 0; index < modulesList.size(); index++) {
            moduleNames.add(modulesList.get(index).getText());
        }
        return moduleNames;
    }

}

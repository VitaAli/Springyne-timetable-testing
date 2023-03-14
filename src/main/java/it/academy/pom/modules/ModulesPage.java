package it.academy.pom.modules;

import it.academy.pom.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class ModulesPage extends AbstractPage {

    @FindBy(css = "#search-name-input")
    private WebElement inputByName;

    @FindBy(css = "button[type='submit']")
    private WebElement buttonSearch;

    @FindBy(css = "tr td:nth-child(2)")
    private List<WebElement> modulesList;

    @FindBy(xpath = "//td[contains(text(),'Įrašų nerasta')]")
    private WebElement messageNoRecords;

    @FindBy (css = ".btn-primary")
    private WebElement buttonAddModule;

    @FindBy (xpath = "//tbody/tr[1]/td[last()]/button[2]")
    private WebElement buttonEditModule;

    @FindBy (xpath = "//tbody/tr[1]/td[last()]/button[1]")
    private WebElement buttonViewModule;

    @FindBy (xpath = "//tbody/tr[1]/td[last()]/button[3]")
    private WebElement buttonDeleteModule;

    @FindBy (xpath = "//tbody/tr[last()]/td[3]")
    private WebElement lastModuleState;

    @FindBy (xpath = "//tbody/tr[1]/td[3]")
    private WebElement firstModuleState;

    public ModulesPage(WebDriver driver) {
        super(driver);
    }

    public void searchModuleByName(String name) {
        inputByName.sendKeys(name);
    }

    public void pressButtonSearch() {
        buttonSearch.click();
    }

    public List<String> getModuleNames() {

        ArrayList<String> moduleNames = new ArrayList<>();
        for (int index = 0; index < modulesList.size(); index++) {
            moduleNames.add(modulesList.get(index).getText());
        }
        return moduleNames;
    }

    public List<String> getPartialModuleNames() {
        ArrayList<String> moduleNames = new ArrayList<>();
        for (int index = 0; index < modulesList.size(); index++) {
            moduleNames.add(modulesList.get(index).getText());
        }

        ArrayList<String> partialModuleNames = new ArrayList<>();
        for (int index = 0; index < moduleNames.size(); index++) {
            String moduleName = moduleNames.get(index);
            String[] result = moduleName.split(" ", 2);
            partialModuleNames.add(result[0]);
        }
        return partialModuleNames;
    }

    public String getTextOfMessageNoRecords() {
        return messageNoRecords.getText();
    }

    public void pressButtonAdd() {
        buttonAddModule.click();
    }

    public void pressButtonEdit() {
        buttonEditModule.click();
    }

    public void pressButtonView() {
        buttonViewModule.click();
    }

    public void pressButtonDelete() {
        buttonDeleteModule.click();
    }

    public String getLastModuleState() {
        return lastModuleState.getText();
    }

}

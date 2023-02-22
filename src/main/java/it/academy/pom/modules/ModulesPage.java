package it.academy.pom.modules;

import it.academy.pom.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

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

    @FindBy(css = "#page-size-select")
    private WebElement pageSize;

    public ModulesPage(WebDriver driver) {
        super(driver);
    }

    public void searchModuleByName(String name) {
        inputByName.sendKeys(name);
    }

    public void pressButtonSearch() {
        buttonSearch.click();
    }

    public String getModuleNames(String valueFromFile) {

        if (valueFromFile == "Testavimo metodikų taikymas") {

            ArrayList<String> moduleNames = new ArrayList<>();
            for (int index = 0; index < modulesList.size(); index++) {
                moduleNames.add(modulesList.get(index).getText());
            }
            return null;
        }

        return null;

    }

    public List getFirstWordsOfModuleNames() {

        ArrayList<String> moduleNames = new ArrayList<>();
        for (int index = 0; index < modulesList.size(); index++) {
            moduleNames.add(modulesList.get(index).getText());
        }

        ArrayList<String> firstWords = new ArrayList<>();
        for (int index = 0; index < moduleNames.size(); index++) {
            String moduleName = moduleNames.get(index);
            String[] result = moduleName.split(" ", 2);
            firstWords.add(result[0]);
        }
        return firstWords;
    }

    public String getTextOfMessageNoRecords() {
        return messageNoRecords.getText();
    }

    public void selectPageSize10() {

        Select pageSize10 = new Select(pageSize);
        pageSize10.selectByIndex(1);
    }

    public int getModulesListSize() {
        return modulesList.size() - 1;
    }

}

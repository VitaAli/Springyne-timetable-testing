package it.academy.pom.subjects;

import it.academy.pom.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class SubjectsPage extends AbstractPage {

    @FindBy(css = "form > div:first-child #search-name-input")
    private WebElement inputByName;

    @FindBy(css = "form > div:nth-child(2) #search-module-input")
    private WebElement inputByModule;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement buttonSearch;

    @FindBy(css = "tr td:nth-child(1)")
    private List<WebElement> subjectsListByName;

    @FindBy(css = "tr td:nth-child(2)")
    private List<WebElement> subjectsListByModule;

    @FindBy(xpath = "//td[contains(.,'Įrašų nerasta')]")
    private WebElement messageNoRecords;

    @FindBy(xpath = "//td[contains(text(),'Rasta įrašų: ')]")
    private WebElement messageRecordsAreFound;

    @FindBy(css = ".btn-primary")
    private WebElement buttonAddSubject;

    @FindBy(xpath = "//tbody/tr[1]/td[last()]/button[2]")
    private WebElement buttonEditSubject;

    @FindBy (xpath = "//tbody/tr[1]/td[last()]/button[1]")
    private WebElement buttonViewSubject;

    @FindBy (xpath = "//tbody/tr[1]/td[last()]/button[3]")
    private WebElement buttonDeleteSubject;

    public SubjectsPage(WebDriver driver) {
        super(driver);
    }

    public SubjectsPage searchSubjectsByName(String name) {
        inputByName.sendKeys(name);
        return this;
    }

    public SubjectsPage searchSubjectsByModule(String name) {
        inputByModule.sendKeys(name);
        return this;
    }

    public SubjectsPage pressButtonSearch() {
        buttonSearch.click();
        return this;
    }

    public List getSubjectsByName() {
        ArrayList<String> subjectNames = new ArrayList<>();
        for (int index = 0; index < subjectsListByName.size(); index++) {
            subjectNames.add(subjectsListByName.get(index).getText());
        }
        return subjectNames;
    }

    public List<String> getSubjectsByPartialName() {
        ArrayList<String> subjectNames = new ArrayList<>();
        for (int index = 0; index < subjectsListByName.size(); index++) {
            subjectNames.add(subjectsListByName.get(index).getText());
        }

        ArrayList<String> partialSubjectNames = new ArrayList<>();
        for (int index = 0; index < subjectNames.size(); index++) {
            String subjectName = subjectNames.get(index);
            String[] result = subjectName.split(" ", 2);
            partialSubjectNames.add(result[0]);
        }
        return partialSubjectNames;
    }

    public List getSubjectsByModuleName() {
        ArrayList<String> subjectNames = new ArrayList<>();
        for (int index = 0; index < subjectsListByModule.size(); index++) {
            subjectNames.add(subjectsListByModule.get(index).getText());
        }
        return subjectNames;
    }

    public List<String> getSubjectsByPartialModuleName() {
        ArrayList<String> moduleNames = new ArrayList<>();
        for (int index = 0; index < subjectsListByModule.size(); index++) {
            moduleNames.add(subjectsListByModule.get(index).getText());
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

    public SubjectsPage pressButtonAddSubject() {
        buttonAddSubject.click();
        return this;
    }

    public SubjectsPage pressButtonEditSubject() {
        buttonEditSubject.click();
        return this;
    }

    public SubjectsPage pressButtonViewSubject() {
        buttonViewSubject.click();
        return this;
    }

    public SubjectsPage pressButtonDeleteSubject() {
        buttonDeleteSubject.click();
        return this;
    }
}

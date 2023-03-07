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

    public SubjectsPage(WebDriver driver) {
        super(driver);
    }

    public void searchSubjectsByName(String name) {
        inputByName.sendKeys(name);
    }

    public void searchSubjectsByModule(String name) {
        inputByModule.sendKeys(name);
    }

    public void pressButtonSearch() {
        buttonSearch.click();
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
            subjectNames.add(subjectsListByName.get(index).getText().substring(0, 2));
        }
        return subjectNames;
    }
}

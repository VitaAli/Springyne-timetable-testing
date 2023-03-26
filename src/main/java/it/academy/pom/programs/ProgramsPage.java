package it.academy.pom.programs;

import it.academy.pom.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class ProgramsPage extends AbstractPage {

    @FindBy (css = "#search-name-input")
    private WebElement inputProgramName;

    @FindBy(css = "button[type='submit']")
    private WebElement buttonSearch;

    @FindBy(css = "tr td:nth-child(1)")
    private List<WebElement> programsList;

    @FindBy(css = ".btn-primary")
    private WebElement buttonAddProgram;

    public ProgramsPage(WebDriver driver) {
        super(driver);
    }

    public ProgramsPage searchProgramByName(String name) {
        inputProgramName.sendKeys(name);
        return this;
    }

    public ProgramsPage pressButtonSearch() {
        buttonSearch.click();
        return this;
    }

    public List<String> getProgramNames() {
        ArrayList<String> programNames = new ArrayList<>();
        for (int index = 0; index < programsList.size(); index++) {
            programNames.add(programsList.get(index).getText());
        }
        return programNames;
    }

    public ProgramsPage pressButtonAddProgram() {
        buttonAddProgram.click();
        return this;
    }
}

package it.academy.pom.shifts;

import it.academy.pom.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class ShiftsPage extends AbstractPage {

    @FindBy(css = "#search-name-input")
    private WebElement inputByName;

    @FindBy(css = "button[type='submit']")
    private WebElement buttonSearch;

    @FindBy(css = "tr td:nth-child(1)")
    private List<WebElement> shiftsList;

    @FindBy(xpath = "//td[contains(.,'Įrašų nerasta')]")
    private WebElement messageNoRecords;

    @FindBy(css = ".btn-primary")
    private WebElement buttonAddShift;

    @FindBy(css = "tr[id='1'] button[title='Redaguoti']")
    private WebElement buttonEditShift;

    @FindBy(css = "button[title='Ištrinti']")
    private WebElement buttonDeleteShift;

    public ShiftsPage(WebDriver driver) {
        super(driver);
    }

    public void searchShiftByName(String name) {
        inputByName.sendKeys(name);
    }

    public void pressButtonSearch() {
        buttonSearch.click();
    }

    public List<String> getShiftNames() {

        ArrayList<String> shiftNames = new ArrayList<>();
        for (int index = 0; index < shiftsList.size(); index++) {
            shiftNames.add(shiftsList.get(index).getText());
        }
        return shiftNames;
    }

    public List<String> getPartialShiftNames() {
        ArrayList<String> shiftNames = new ArrayList<>();
        for (int index = 0; index < shiftsList.size(); index++) {
            shiftNames.add(shiftsList.get(index).getText().substring(0, 3));
        }
        return shiftNames;
    }

    public String getTextOfMessageNoRecords() {
        return messageNoRecords.getText();
    }

    public void pressButtonAdd() {
        buttonAddShift.click();
    }

    public void pressButtonEdit() {
        buttonEditShift.click();
    }

    public void pressButtonDelete() {
        buttonDeleteShift.click();
    }


}

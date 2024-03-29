package it.academy.pom.teachers;

import it.academy.pom.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class TeachersPage extends AbstractPage {

    @FindBy(css = "#search-name-input")
    private WebElement inputByName;

    @FindBy(xpath = "//td[1]")
    private List<WebElement> namesList;

    @FindBy(css = "button[type='submit']")
    private WebElement buttonSearch;

    @FindBy(css = ".btn-primary")
    private WebElement buttonAddTeacher;

    @FindBy(xpath = "//tbody/tr[1]/td[last()]/div/button[2]")
    private WebElement buttonEditTeacher;

    @FindBy (xpath = "//tbody/tr[1]/td[last()]/div/button[1]")
    private WebElement buttonViewTeacher;

    public TeachersPage(WebDriver driver) {
        super(driver);
    }

    public List<String> getNamesFromTeacherList() {
        ArrayList<String> names = new ArrayList<>();
        for (int i = 0; i < namesList.size(); i++) {
            names.add(namesList.get(i).getText());
        }
        return names;
    }

    public String getFirstNameFromTeacherList() {
        String firstName = getNamesFromTeacherList().get(0);
        return firstName;
    }

    public TeachersPage searchTeacherByName(String name) {
        inputByName.sendKeys(name);
        return this;
    }

    public TeachersPage pressButtonSearch() {
        buttonSearch.click();
        return this;
    }

    public TeachersPage pressButtonAddTeacher() {
        buttonAddTeacher.click();
        return this;
    }

    public TeachersPage pressButtonEditTeacher() {
        buttonEditTeacher.click();
        return this;
    }

    public TeachersPage pressButtonViewTeacher() {
        buttonViewTeacher.click();
        return this;
    }
}

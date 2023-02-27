package it.academy.pom.shifts;

import it.academy.pom.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShiftAddPage extends AbstractPage {

    @FindBy(css = "#create-shift-name")
    private WebElement inputName;

    @FindBy (css = "button[type='submit']")
    private WebElement buttonAdd;

    public ShiftAddPage(WebDriver driver) {
        super(driver);
    }

    public void enterName(String name) {
        inputName.sendKeys(name);
    }

    public void pressButtonAdd() {
        buttonAdd.click();
    }
}

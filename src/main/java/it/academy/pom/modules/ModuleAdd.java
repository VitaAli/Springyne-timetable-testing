package it.academy.pom.modules;

import it.academy.pom.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ModuleAdd extends AbstractPage {

    @FindBy (css = "div:nth-child(1) > div:nth-child(2) > input:nth-child(1)")
    private WebElement inputNumber;

    @FindBy (css = "div:nth-child(2) > div:nth-child(2) > input:nth-child(1)")
    private WebElement inputName;

    @FindBy (css = "button[type='submit']")
    private WebElement buttonAdd;

    @FindBy (css = "")
    private WebElement message;

    public ModuleAdd(WebDriver driver) {
        super(driver);
    }

    public void enterNumber(String number) {
        inputNumber.sendKeys(number);
    }

    public void enterName(String name) {
        inputName.sendKeys(name);
    }

    public void pressButtonAdd() {
        buttonAdd.click();
    }

    public String getMessage() {
        return null;
    }
}

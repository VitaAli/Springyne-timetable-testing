package it.academy.pom.modules;

import it.academy.pom.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ModuleAdd extends AbstractPage {

    @FindBy (css = ".btn-primary")
    private WebElement buttonAdd;

    public ModuleAdd(WebDriver driver) {
        super(driver);
    }

    public void pressButtonAdd() {
        buttonAdd.click();
    }
}

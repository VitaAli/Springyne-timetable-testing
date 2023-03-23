package it.academy.pom.subjects;

import it.academy.pom.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SubjectEditPage extends AbstractPage {

    @FindBy(css = "button.btn-danger.me-2")
    private WebElement buttonDelete;

    @FindBy(css = "button.btn-secondary")
    private WebElement buttonRestore;

    @FindBy(xpath = "//div[contains(text(),'Įrašas sėkmingai atnaujintas')]")
    private WebElement successMessage;

    public SubjectEditPage(WebDriver driver) {
        super(driver);
    }

    public void pressButtonDelete() {
        buttonDelete.click();
    }

    public void pressButtonRestore() {
        buttonRestore.click();
    }


    public String getSuccessMessage() {
        return successMessage.getText();
    }
}

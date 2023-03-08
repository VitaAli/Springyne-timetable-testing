package it.academy.pom.rooms;

import it.academy.pom.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RoomEditPage extends AbstractPage {
    @FindBy(css = "button[type='submit']")
    private WebElement buttonEdit;

    public RoomEditPage(WebDriver driver) {
        super(driver);
    }
    public void pressButtonEdit() {
        buttonEdit.click();
    }
}

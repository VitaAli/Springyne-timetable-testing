package it.academy.pom.rooms;

import it.academy.pom.AbstractPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RoomEditPage extends AbstractPage {
    @FindBy(xpath = "//input[@id='edit-room-name-with-error']")
    private WebElement inputRoomName;

    @FindBy(xpath = "//input[@id='edit-room-building-with-error']")
    private WebElement inputBuildingName;

    @FindBy(xpath = "//input[@id='edit-room-building-with-error']")
    private WebElement inputDescription;

    @FindBy(css = "button[type='submit']")
    private WebElement buttonSubmit;

    @FindBy(css = "button.btn-danger")
    private WebElement buttonDelete;

    @FindBy(css = "button.btn-secondary")
    private WebElement buttonRestore;

    @FindBy(css = "div:nth-of-type(1) .MuiAlert-message")
    private WebElement successMessage;

    public RoomEditPage(WebDriver driver) {
        super(driver);
    }

    public void enterRoomName(String number){
        inputRoomName.click();
        inputRoomName.sendKeys(Keys.CONTROL + "a");
        inputRoomName.sendKeys(Keys.DELETE);
        inputRoomName.sendKeys(number);
    }
    public void enterBuildingName(String number){
        inputBuildingName.click();
        inputBuildingName.sendKeys(Keys.CONTROL + "a");
        inputBuildingName.sendKeys(Keys.DELETE);
        inputBuildingName.sendKeys(number);
    }
    public void enterDescription(String name) {
        inputDescription.click();
        inputDescription.sendKeys(Keys.CONTROL + "a");
        inputDescription.sendKeys(Keys.DELETE);
        inputDescription.sendKeys(name);
    }
    public void pressButtonSubmit() {
        buttonSubmit.click();
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

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

    public RoomEditPage editRoomName(String number) {
        inputRoomName.click();
        inputRoomName.sendKeys(Keys.CONTROL + "a");
        inputRoomName.sendKeys(Keys.DELETE);
        inputRoomName.sendKeys(number);
        return this;
    }

    public RoomEditPage editRoomBuilding(String number) {
        inputBuildingName.click();
        inputBuildingName.sendKeys(Keys.CONTROL + "a");
        inputBuildingName.sendKeys(Keys.DELETE);
        inputBuildingName.sendKeys(number);
        return this;
    }

    public RoomEditPage editRoomDescription(String name) {
        inputDescription.click();
        inputDescription.sendKeys(Keys.CONTROL + "a");
        inputDescription.sendKeys(Keys.DELETE);
        inputDescription.sendKeys(name);
        return this;
    }

    public RoomEditPage pressButtonSubmit() {
        buttonSubmit.click();
        return this;
    }

    public RoomEditPage pressButtonDelete() {
        buttonDelete.click();
        return this;
    }

    public RoomEditPage pressButtonRestore() {
        buttonRestore.click();
        return this;
    }

    public String getSuccessMessage() {
        return successMessage.getText();
    }
}

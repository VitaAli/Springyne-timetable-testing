package it.academy.pom.rooms;

import it.academy.pom.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class RoomAddPage extends AbstractPage {
    @FindBy(css = ".btn-primary")
    private WebElement buttonAddRoom;

    @FindBy (xpath ="(//input[@id='create-room-number-with-error'])[1]")
    private WebElement inputRoomNumber;

    @FindBy (xpath ="(//input[@id='create-room-number-with-error'])[2]")
    private WebElement inputRoomName;

    @FindBy (xpath ="(//input[@id='create-room-number-with-error'])[3]")
    private WebElement inputRoomDescription;

    @FindBy (css = "button[type='submit']")
    private WebElement buttonSaveRecord;

    @FindBy (css = ".mx-3 > div:nth-of-type(1) .MuiAlert-message")
    private WebElement successMessage;

    @FindBy (css = ".mx-3 > div:nth-of-type(2) .MuiAlert-message")
    private WebElement errorMessage;

    public RoomAddPage(WebDriver driver) {
        super(driver);
    }
    public void pressButtonAddRoom() {
        buttonAddRoom.click();
    }
    public void enterNumber(String number) {
        inputRoomNumber.sendKeys(number);
    }
    public void enterName(String name) {
        inputRoomName.sendKeys(name);
    }
    public void enterDescription(String description) {
        inputRoomDescription.sendKeys(description);
    }

    public void pressButtonSaveRecord() {
        buttonSaveRecord.click();
    }
    public String getSuccessMessage() {
        return successMessage.getText();
    }

    public boolean getNameInvalidValue() {
        return Boolean.parseBoolean(inputRoomName.getAttribute("aria-invalid"));
    }

    public boolean getNumberInvalidValue() {
        return Boolean.parseBoolean(inputRoomNumber.getAttribute("aria-invalid"));
    }
}


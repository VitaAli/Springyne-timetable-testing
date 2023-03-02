package it.academy.pom.rooms;

import it.academy.pom.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class RoomsPage extends AbstractPage {
    @FindBy(xpath = "(//input[@id='search-name-input'])[1]")
    private WebElement inputByName;

    @FindBy(xpath = "(//input[@id='search-name-input'])[2]")
    private WebElement inputByBuilding;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement buttonSearch;

    @FindBy(css = "tr td:nth-child(1)")
    private List<WebElement> roomsListByName;

    @FindBy(css = "tr td:nth-child(2)")
    private List<WebElement> roomsListByBuilding;

    @FindBy(xpath = "//td[contains(text(),'Įrašų nerasta')]")
    private WebElement messageNoRecords;

    @FindBy(xpath = "//td[contains(text(),'Rasta įrašų: ')]")
    private WebElement messageRecordsAreFound;

    @FindBy (xpath = "//a[starts-with(@href, '#/rooms/create')]")
     private WebElement buttonAddRoom;

    public RoomsPage(WebDriver driver) {
        super(driver);
    }

    public void searchRoomsByName(String name) {
        inputByName.sendKeys(name);
    }

    public void searchRoomsByBuilding(String name) {
        inputByBuilding.sendKeys(name);
    }

    public void pressButtonSearch() {
        buttonSearch.click();
    }

      public List getRoomsByName() {
        ArrayList<String> roomNames = new ArrayList<>();
        for (int index = 0; index < roomsListByName.size(); index++) {
            roomNames.add(roomsListByName.get(index).getText());
        }
        return roomNames;
    }

    public List<String> getRoomByPartialName() {
        ArrayList<String> roomNames = new ArrayList<>();
        for (int index = 0; index < roomsListByName.size(); index++) {
            roomNames.add(roomsListByName.get(index).getText().substring(0,2));
            }
        return roomNames;
    }

    public List getRoomsByBuildingName() {
        ArrayList<String> roomsBuilding = new ArrayList<>();
        for (int index = 0; index < roomsListByBuilding.size(); index++) {
            roomsBuilding.add(roomsListByBuilding.get(index).getText());
        }
        return roomsBuilding;
    }


    public List<String> getRoomByBuildingPartialName() {
        ArrayList<String> roomsBuilding = new ArrayList<>();
        for (int index = 0; index < roomsListByBuilding.size(); index++) {
            roomsBuilding.add(roomsListByBuilding.get(index).getText());
        }

        ArrayList<String> roomsPartialBuildingName = new ArrayList<>();
        for (int index = 0; index < roomsBuilding.size(); index++) {
            String roomBuilding = roomsBuilding.get(index);
            String[] result = roomBuilding.split(" ", 2);
            roomsPartialBuildingName.add(result[0]);
        }
      return roomsPartialBuildingName;
    }

    public String getMessageWhenNoRecords() {
        return messageNoRecords.getText();

    }
    public void buttonAddRoom(){
        buttonAddRoom.click();
    }

}

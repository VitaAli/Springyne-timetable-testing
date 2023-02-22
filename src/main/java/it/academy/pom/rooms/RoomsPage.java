package it.academy.pom.rooms;

import it.academy.pom.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.ArrayList;
import java.util.List;

public class RoomsPage extends AbstractPage {

    @FindBy (css = "a[href='#/rooms/create']")
    private WebElement buttonAddRooms ;

    @FindBy (xpath = "(//input[@type='text'])[1]")
    private WebElement inputByName;
    @FindBy (xpath = "//div[@class='mx-3']//div[2]//form[1]//button[1]")
    private WebElement buttonSearchByName;

    @FindBy (xpath = "(//input[@type='text'])[2]")
    private WebElement inputByBuilding;
    @FindBy (xpath = "//div[@class='mx-3']//div[1]//form[1]//button[1]")
    private WebElement buttonSearchByBuilding;

    @FindBy (css = "tr td:nth-child(1)")
    private List<WebElement> roomsListByName;

    @FindBy (css = "tr td:nth-child(2)")
    private List<WebElement> roomsListByBuilding;

    public RoomsPage(WebDriver driver) {
        super(driver);
    }
    public void searchRoomsByName(String name) {
        inputByName.sendKeys(name);
    }

    public void pressButtonSearchByName() {
        buttonSearchByName.click();
    }

    public List getRoomsListByName() {
        ArrayList<String> roomNames = new ArrayList<>();
        for (int index = 0; index < roomsListByName.size(); index++) {
            roomNames.add(roomsListByName.get(index).getText());
        }
        return roomNames;
    }

    public void searchRoomsByBuilding(String name) {
        inputByBuilding.sendKeys(name);
    }

    public void pressButtonSearchByBuilding() {
        buttonSearchByBuilding.click();
    }

    public List getRoomsListByBuilding() {
        ArrayList<String> roomsBuilding = new ArrayList<>();
        for (int index = 0; index < roomsListByBuilding.size(); index++) {
            roomsBuilding.add(roomsListByBuilding.get(index).getText());
        }
        return roomsBuilding;
    }


    }

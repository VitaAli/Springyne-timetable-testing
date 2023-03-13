package it.academy.test.rooms;

import it.academy.pom.Header;
import it.academy.pom.rooms.RoomEditPage;
import it.academy.pom.rooms.RoomsPage;
import it.academy.test.BaseTest;
import org.junit.jupiter.api.Test;

import static it.academy.utils.GenerateDataUtils.generateRandomName;
import static it.academy.utils.WaitUtils.waitForMessageModuleUpdated;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoomEditPageTest extends BaseTest {

    private Header header;

    private RoomsPage roomsPage;

    private RoomEditPage roomEditPage;

    void performInitialSteps() {
        header = new Header(driver);
        roomsPage = new RoomsPage(driver);
        roomEditPage = new RoomEditPage(driver);
        header.openRooms();
        roomsPage.pressButtonEdit();
    }
    @Test
    public void roomNameAndBuildingAndDescriptionCanBeEdited() {
        performInitialSteps();
        roomEditPage.enterRoomName(generateRandomName());
        roomEditPage.enterBuildingName(generateRandomName());
        roomEditPage.enterDescription(generateRandomName());
        roomEditPage.pressButtonSubmit();
        waitForMessageModuleUpdated(driver);

        assertEquals("Įrašas sėkmingai atnaujintas", roomEditPage.getSuccessMessage()
                , "The room name and building fields are mandatory.");
    }
}
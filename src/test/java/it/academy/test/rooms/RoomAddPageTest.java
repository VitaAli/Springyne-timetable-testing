package it.academy.test.rooms;

import it.academy.pom.Header;
import it.academy.pom.rooms.RoomAddPage;
import it.academy.pom.rooms.RoomsPage;
import it.academy.test.BaseTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static it.academy.utils.GenerateDataUtils.generateRandomNum;
import static it.academy.utils.WaitUtils.waitForMessageRecordIsCreated;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RoomAddPageTest extends BaseTest {
    private Header header;
    private RoomsPage roomsPage;
    private RoomAddPage roomAddPage;

    void performInitialSteps() {
        header = new Header(driver);
        roomsPage = new RoomsPage(driver);
        roomAddPage = new RoomAddPage(driver);
        header.openRooms();
        roomsPage.pressButtonAddRoom();
    }

    @Test
    @Tag("smoke")
    @Tag("regression")
    public void roomShouldBeCreatedWithNameBuildingAndDescription() {
        performInitialSteps();
        roomAddPage
                .enterRoomName("RoomName" + generateRandomNum())
                .enterRoomBuilding("RoomBuilding" + generateRandomNum())
                .enterRoomDescription("RoomDescription" + generateRandomNum())
                .pressButtonAdd();
        waitForMessageRecordIsCreated(driver);

        assertEquals("Įrašas sėkmingai sukurtas", roomAddPage.getSuccessMessage()
                , "The number and name fields are mandatory. The number must be unique");
    }

    @Test
    @Tag("regression")
    public void roomShouldBeCreatedWithNameBuildingAndNoDescription() {
        performInitialSteps();
        roomAddPage
                .enterRoomName("RoomName" + generateRandomNum())
                .enterRoomBuilding("RoomBuilding" + generateRandomNum())
                .pressButtonAdd();
        waitForMessageRecordIsCreated(driver);

        assertEquals("Įrašas sėkmingai sukurtas", roomAddPage.getSuccessMessage()
                , "The number and name fields are mandatory. The number must be unique");
    }

    @Test
    @Tag("regression")
    public void roomShouldNotBeCreatedWithNameAndNoBuilding() {
        performInitialSteps();
        roomAddPage
                .enterRoomName("RoomName" + generateRandomNum())
                .enterRoomBuilding("")
                .pressButtonAdd();

        assertTrue(roomAddPage.getNameInvalidValue()
                , "User must see validation error message when he wants to create a room with no name");
    }

    @Test
    @Tag("regression")
    public void roomShouldNotBeCreatedWithNoNameAndAnyBuilding() {
        performInitialSteps();
        roomAddPage
                .enterRoomName("")
                .enterRoomBuilding("RoomBuilding" + generateRandomNum())
                .pressButtonAdd();

        assertTrue(roomAddPage.getNumberInvalidValue()
                , "User must see validation error message when he wants to create a room with no number");
    }
}

package it.academy.test.rooms;

import it.academy.pom.Header;
import it.academy.pom.rooms.RoomEditPage;
import it.academy.pom.rooms.RoomsPage;
import it.academy.test.BaseTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static it.academy.utils.GenerateDataUtils.generateRandomNum;
import static it.academy.utils.WaitUtils.waitForMessageRecordUpdated;
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
    @Tag("smoke")
    @Tag("regression")
    public void roomNameAndBuildingAndDescriptionCanBeEdited() {
        performInitialSteps();
        roomEditPage
                .editRoomName("RoomName" + generateRandomNum())
                .editRoomBuilding("RoomBuilding" + generateRandomNum())
                .editRoomDescription("RoomDescription" + generateRandomNum())
                .pressButtonSubmit();
        waitForMessageRecordUpdated(driver);

        assertEquals("Įrašas sėkmingai atnaujintas", roomEditPage.getSuccessMessage()
                , "The room name and building fields are mandatory.");
    }
}
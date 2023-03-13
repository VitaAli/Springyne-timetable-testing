package it.academy.test.rooms;

import it.academy.pom.Header;
import it.academy.pom.rooms.RoomAddPage;
import it.academy.pom.rooms.RoomsPage;
import it.academy.test.BaseTest;
import org.junit.jupiter.api.Test;

import static it.academy.utils.GenerateDataUtils.generateRandomNumber;
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
    public void roomShouldBeCreatedWithNumberNameAndDescription() {
        performInitialSteps();
        roomAddPage.enterNumber(generateRandomNumber());
        roomAddPage.enterName("name");
        roomAddPage.enterDescription("description");
        roomAddPage.pressButtonSaveRecord();

        waitForMessageRecordIsCreated(driver);
        assertEquals("Įrašas sėkmingai sukurtas", roomAddPage.getSuccessMessage()
                , "The number and name fields are mandatory. The number must be unique");
    }

    @Test
    public void roomShouldBeCreatedWithNumberNameAndNoDescription() {
        performInitialSteps();
        roomAddPage.enterNumber(generateRandomNumber());
        roomAddPage.enterName("name");
        roomAddPage.pressButtonSaveRecord();

        waitForMessageRecordIsCreated(driver);
        assertEquals("Įrašas sėkmingai sukurtas", roomAddPage.getSuccessMessage()
                , "The number and name fields are mandatory. The number must be unique");
    }

    @Test
    public void roomShouldNotBeCreatedWithNumberAndNoName() {
        performInitialSteps();
        roomAddPage.enterNumber(generateRandomNumber());
        roomAddPage.enterName("");
        roomAddPage.pressButtonSaveRecord();

        assertTrue(roomAddPage.getNameInvalidValue()
                , "User must see validation error message when he wants to create a room with no name");
    }

    @Test
    public void roomShouldNotBeCreatedWithNoNumberAndAnyName() {
        performInitialSteps();
        roomAddPage.enterNumber("");
        roomAddPage.enterName("name");
        roomAddPage.pressButtonSaveRecord();

        assertTrue(roomAddPage.getNumberInvalidValue()
                , "User must see validation error message when he wants to create a room with no number");
    }
}

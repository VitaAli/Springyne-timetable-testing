package it.academy.test.rooms;

import it.academy.pom.Header;
import it.academy.pom.rooms.RoomAddPage;
import it.academy.pom.rooms.RoomsPage;
import it.academy.test.BaseTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.List;

import static it.academy.utils.GenerateDataUtils.generateRandomNum;
import static it.academy.utils.WaitUtils.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RoomsPageTest extends BaseTest {
    private Header header;
    private RoomsPage roomsPage;
    private RoomAddPage roomAddPage;

    void performInitialSteps() {
        header = new Header(driver);
        roomsPage = new RoomsPage(driver);
        header.openRooms();
    }

    @Test
    @Tag("smoke")
    @Tag("regression")
    public void roomsCanBeFilteredByRoomName() {
        header = new Header(driver);
        roomsPage = new RoomsPage(driver);
        roomAddPage = new RoomAddPage(driver);
        header.openRooms();
        roomsPage.pressButtonAddRoom();
        String roomName = "RoomName" + generateRandomNum();
        roomAddPage
                .enterRoomName(roomName)
                .enterRoomBuilding("RoomBuilding" + generateRandomNum())
                .enterRoomDescription("RoomDescription" + generateRandomNum())
                .pressButtonAdd();
        waitForMessageRecordIsCreated(driver);
        header.openRooms();
        roomsPage.searchRoomsByName(roomName)
                .pressButtonSearch();
        waitForMessageRecordsAreFound(driver);
        List<String> rooms = roomsPage.getRoomsByName();

        assertTrue(rooms.contains(roomName),
                "The list should be filtered by the room name");
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/RoomTestByPartialName.txt")
    @Tag("regression")
    public void roomsCanBeFilteredByPartialName(String valueFromFile) {
        performInitialSteps();
        List<String> rooms = roomsPage.getRoomByPartialName();
        roomsPage
                .searchRoomsByName(valueFromFile)
                .pressButtonSearch();
        waitForMessageRecordsAreFound(driver);

        assertTrue(rooms.contains(valueFromFile),
                "The list should be filtered by the partial room name");
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/RoomTestByBuildingName.txt")
    @Tag("smoke")
    @Tag("regression")
    public void roomsCanBeFilteredByRoomsBuilding(String valueFromFile) {
        performInitialSteps();
        List<String> rooms = roomsPage.getRoomsByBuildingName();
        roomsPage
                .searchRoomsByBuilding(valueFromFile)
                .pressButtonSearch();
        waitForMessageRecordsAreFound(driver);

        assertTrue(rooms.contains(valueFromFile),
                "The list should be filtered by the building");
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/RoomTestByPartialBuildingName.txt")
    @Tag("regression")
    public void roomsCanBeFilteredByPartialBuildingName(String valueFromFile) {
        performInitialSteps();
        List<String> rooms = roomsPage.getRoomsByBuildingPartialName();
        roomsPage
                .pressButtonSearch()
                .searchRoomsByBuilding(valueFromFile)
                .pressButtonSearch();
        waitForMessageRecordsAreFound(driver);

        assertTrue(rooms.contains(valueFromFile),
                "The list should be filtered by the partial building name");
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/RoomTestBySymbols.txt")
    @Tag("regression")
    public void roomsShouldNotBeFound(String valueFromFile) {
        performInitialSteps();
        roomsPage
                .pressButtonSearch()
                .searchRoomsByName(valueFromFile)
                .pressButtonSearch();
        waitForMessageNoRecordsFound(driver);

        assertEquals(
                "Įrašų nerasta", roomsPage.getMessageWhenNoRecords()
                , "Rooms cannot be filtered by room name using random words or symbols");
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/RoomTestBySymbols.txt")
    @Tag("regression")
    public void roomsBuildingShouldNotBeFound(String valueFromFile) {
        performInitialSteps();
        roomsPage
                .pressButtonSearch()
                .searchRoomsByBuilding(valueFromFile)
                .pressButtonSearch();
        waitForMessageNoRecordsFound(driver);

        assertEquals("Įrašų nerasta", roomsPage.getMessageWhenNoRecords()
                , "Rooms cannot be filtered by building using random words or symbols");
    }
}


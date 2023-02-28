package it.academy.test.rooms;

import it.academy.pom.Header;
import it.academy.pom.rooms.RoomsPage;
import it.academy.test.BaseTest;
import it.academy.utils.WaitUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;


import static org.junit.jupiter.api.Assertions.assertTrue;

public class RoomsPageTest extends BaseTest {
    private Header header;
    private RoomsPage roomsPage;


    void performInitialSteps() {
        header = new Header(driver);
        roomsPage = new RoomsPage(driver);
        header.openRooms();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/TestRoomsPageByNameData.txt")
    public void roomsCanBeFilteredByRoomName(String valueFromFile) {
        performInitialSteps();
        roomsPage.searchRoomsByName(valueFromFile);
        roomsPage.pressButtonSearch();

        assertTrue(roomsPage.getRoomsByName().contains(valueFromFile),
                "The list should be filtered by the value");
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/TestRoomsPageByBuildingNameData.txt")
    public void roomsCanBeFilteredByRoomsBuilding(String valueFromFile) {
        performInitialSteps();
        roomsPage.searchRoomsByBuilding(valueFromFile);
        roomsPage.pressButtonSearch();

        Assertions.assertTrue(roomsPage.getRoomsByBuildingName().contains(valueFromFile),
                "The list should be filtered by the value");
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/TestRoomsPageByPartialBuildingNameData.txt")
    public void roomsCanBeFilteredByPartialBuildingName(String valueFromFile) {
        performInitialSteps();
        roomsPage.searchRoomsByBuilding(valueFromFile);
        roomsPage.pressButtonSearch();

        Assertions.assertTrue(roomsPage.getRoomByBuildingPartialName().contains(valueFromFile),
                "The list should be filtered by the value");
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/TestData3.txt")
    public void roomsShouldNotBeFound(String valueFromFile) {
        performInitialSteps();
        roomsPage.searchRoomsByName(valueFromFile);
        roomsPage.pressButtonSearch();

        WaitUtils.waitForMessageNoRecordsFound(driver);
        Assertions.assertEquals("Įrašų nerasta", roomsPage.getMessageWhenNoRecords()
                , "Rooms cannot be filtered by random words or symbols");
    }
    @ParameterizedTest
    @CsvFileSource(resources = "/TestData3.txt")
    public void roomsBuildingShouldNotBeFound(String valueFromFile) {
        performInitialSteps();
        roomsPage.searchRoomsByBuilding(valueFromFile);
        roomsPage.pressButtonSearch();

        WaitUtils.waitForMessageNoRecordsFound(driver);
        Assertions.assertEquals("Įrašų nerasta", roomsPage.getMessageWhenNoRecords()
                , "Rooms cannot be filtered by random words or symbols");
    }
}



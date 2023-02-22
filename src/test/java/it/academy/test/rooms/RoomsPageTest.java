package it.academy.test.rooms;

import it.academy.pom.Header;
import it.academy.pom.rooms.RoomsPage;
import it.academy.test.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RoomsPageTest extends BaseTest {
    private Header header;
    private RoomsPage roomsPage;

    @Test
    public void roomsCanBeFilteredByRoomsName() {

        header = new Header(driver);
        roomsPage = new RoomsPage(driver);

        header.openRooms();
        roomsPage.searchRoomsByName("101");
        roomsPage.pressButtonSearchByName();

        Assertions.assertTrue(roomsPage.getRoomsListByName().contains("101"));

        }
    @Test
    public void roomsCanBeFilteredByRoomsBuilding() {

        header = new Header(driver);
        roomsPage = new RoomsPage(driver);

        header.openRooms();
        roomsPage.searchRoomsByBuilding("Lakūnų g. 3, LT-09108 Vilnius");
        roomsPage.pressButtonSearchByBuilding();

        Assertions.assertTrue(roomsPage.getRoomsListByBuilding().contains("Lakūnų g. 3, LT-09108 Vilnius"));
    }
}

package it.academy.test.rooms;

import it.academy.pom.Header;
import it.academy.pom.rooms.RoomAddPage;
import it.academy.pom.rooms.RoomsPage;
import it.academy.test.BaseTest;

public class RoomAddPageTest extends BaseTest {
    private Header header;
    private RoomsPage roomsPage;
    private RoomAddPage roomAddPage;

    void performInitialSteps(){
        header = new Header(driver);
        roomsPage = new RoomsPage(driver);
        roomAddPage = new RoomAddPage(driver);
        header.openRooms();
        roomsPage.pressButtonSearch();


    }

}

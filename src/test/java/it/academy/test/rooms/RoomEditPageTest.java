package it.academy.test.rooms;

import it.academy.pom.Header;
import it.academy.pom.rooms.RoomAddPage;
import it.academy.pom.rooms.RoomEditPage;
import it.academy.pom.rooms.RoomsPage;
import it.academy.test.BaseTest;

public class RoomEditPageTest extends BaseTest {

    private Header header;

    private RoomsPage roomsPage;

    private RoomEditPage roomEditPage;

    void performInitialSteps() {
        header = new Header(driver);
        roomsPage = new RoomsPage(driver);
        roomEditPage = new RoomEditPage(driver);
        header.openRooms();
        roomEditPage.pressButtonEdit();

    }

}

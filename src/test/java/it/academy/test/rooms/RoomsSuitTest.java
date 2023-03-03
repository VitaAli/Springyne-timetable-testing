package it.academy.test.rooms;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({RoomsPageTest.class, RoomAddPageTest.class})
public class RoomsSuitTest {

}

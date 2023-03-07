package it.academy.test;

import it.academy.test.modules.ModuleAddPageTest;
import it.academy.test.modules.ModuleEditPageTest;
import it.academy.test.modules.ModuleViewPageTest;
import it.academy.test.modules.ModulesPageTest;
import it.academy.test.rooms.RoomAddPageTest;
import it.academy.test.rooms.RoomsPageTest;
import it.academy.test.shifts.ShiftAddPageTest;
import it.academy.test.shifts.ShiftEditPageTest;
import it.academy.test.shifts.ShiftsPageTest;
import it.academy.test.subjects.SubjectsPageTest;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({ModulesPageTest.class, ModuleAddPageTest.class, ModuleEditPageTest.class, ModuleViewPageTest.class
        , RoomsPageTest.class, RoomAddPageTest.class
        , ShiftsPageTest.class, ShiftAddPageTest.class, ShiftEditPageTest.class
        , SubjectsPageTest.class })
public class SuitTest {
}

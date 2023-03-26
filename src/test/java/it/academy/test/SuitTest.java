package it.academy.test;

import it.academy.test.modules.ModuleAddPageTest;
import it.academy.test.modules.ModuleEditPageTest;
import it.academy.test.modules.ModuleViewPageTest;
import it.academy.test.modules.ModulesPageTest;
import it.academy.test.programs.ProgramAddPageTest;
import it.academy.test.programs.ProgramsPageTest;
import it.academy.test.rooms.RoomAddPageTest;
import it.academy.test.rooms.RoomEditPageTest;
import it.academy.test.rooms.RoomsPageTest;
import it.academy.test.shifts.ShiftAddPageTest;
import it.academy.test.shifts.ShiftEditPageTest;
import it.academy.test.shifts.ShiftsPageTest;
import it.academy.test.subjects.SubjectAddPageTest;
import it.academy.test.subjects.SubjectEditPageTest;
import it.academy.test.subjects.SubjectViewPageTest;
import it.academy.test.subjects.SubjectsPageTest;
import it.academy.test.teachers.TeacherAddPageTest;
import it.academy.test.teachers.TeacherEditPageTest;
import it.academy.test.teachers.TeacherViewPageTest;
import it.academy.test.teachers.TeachersPageTest;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({ModulesPageTest.class, ModuleAddPageTest.class, ModuleEditPageTest.class, ModuleViewPageTest.class
        , RoomsPageTest.class, RoomAddPageTest.class, RoomEditPageTest.class
        , ShiftsPageTest.class, ShiftAddPageTest.class, ShiftEditPageTest.class
        , SubjectsPageTest.class, SubjectAddPageTest.class, SubjectEditPageTest.class, SubjectViewPageTest.class
        , TeachersPageTest.class, TeacherAddPageTest.class, TeacherEditPageTest.class, TeacherViewPageTest.class
        , ProgramsPageTest.class, ProgramAddPageTest.class })
public class SuitTest {
}

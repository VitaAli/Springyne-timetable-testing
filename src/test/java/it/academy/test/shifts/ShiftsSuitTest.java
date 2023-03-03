package it.academy.test.shifts;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({ShiftsPageTest.class, ShiftAddPageTest.class, ShiftEditPageTest.class})
public class ShiftsSuitTest {

}

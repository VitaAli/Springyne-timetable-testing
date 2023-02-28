package it.academy.test.shifts;

import it.academy.pom.Header;
import it.academy.pom.modules.ModulesPage;
import it.academy.pom.shifts.ShiftAddPage;
import it.academy.pom.shifts.ShiftsPage;
import it.academy.test.BaseTest;

public class ShiftAddPageTest extends BaseTest {

    private Header header;
    private ShiftsPage shiftsPage;
    private ShiftAddPage shiftAddPage;

    void performInitialSteps() {
        header = new Header(driver);
        shiftsPage = new ShiftsPage(driver);
        shiftAddPage = new ShiftAddPage(driver);
        header.openShifts();
        shiftsPage.pressButtonAdd();
    }

}

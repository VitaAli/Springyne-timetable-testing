package it.academy.test.shifts;

import it.academy.pom.Header;
import it.academy.pom.shifts.ShiftEditPage;
import it.academy.pom.shifts.ShiftsPage;
import it.academy.test.BaseTest;
import it.academy.utils.WaitUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShiftEditPageTest extends BaseTest {

    private Header header;
    private ShiftsPage shiftsPage;
    private ShiftEditPage shiftEditPage;

    void performInitialSteps() {
        header = new Header(driver);
        shiftsPage = new ShiftsPage(driver);
        shiftEditPage = new ShiftEditPage(driver);
        header.openShifts();
        shiftsPage.pressButtonEdit();
    }

    @Test
    public void shiftNameShouldBeEdited() {
        performInitialSteps();
        shiftEditPage.enterName("Rytas");

        shiftEditPage.pressButtonEdit();
        WaitUtils.waitMessageRecordSuccessfullyUpdated(driver, 10);

        Assertions.assertEquals("Įrašas sėkmingai atnaujintas", shiftEditPage.getSuccessMessage()
        , "Record is not updated");

    }

    @Test
    public void shiftShouldBeInvalidated() {
        performInitialSteps();
        shiftEditPage.pressButtonDelete();


    }
}

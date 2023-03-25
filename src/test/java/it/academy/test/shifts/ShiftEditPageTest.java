package it.academy.test.shifts;

import it.academy.pom.Header;
import it.academy.pom.shifts.ShiftEditPage;
import it.academy.pom.shifts.ShiftsPage;
import it.academy.test.BaseTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static it.academy.utils.GenerateDataUtils.generateRandomNum;
import static it.academy.utils.WaitUtils.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
    @Tag("smoke")
    public void shiftShouldBeRestoredAfterDeletion() {
        performInitialSteps();
        waitUntilDeleteButtonAppears(driver);
        shiftEditPage.pressButtonDelete();
        waitUntilRestoreButtonAppears(driver);
        shiftEditPage.pressButtonRestore();
        waitForMessageShiftUpdated(driver);

        assertEquals("Įrašas sėkmingai atnaujintas", shiftEditPage.getSuccessMessage()
                , "No success message received");
    }

    @Test
    @Tag("smoke")
    public void shiftCanBeEdited() {
        performInitialSteps();
        shiftEditPage.enterName("ShiftName" + generateRandomNum());
        shiftEditPage.pressButtonEdit();
        waitForMessageShiftUpdated(driver);

        assertEquals("Įrašas sėkmingai atnaujintas", shiftEditPage.getSuccessMessage()
                , "No success message received");
    }

}

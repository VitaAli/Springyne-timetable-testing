package it.academy.test.shifts;

import it.academy.pom.Header;
import it.academy.pom.shifts.ShiftAddPage;
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
    private ShiftAddPage shiftAddPage;
    private ShiftEditPage shiftEditPage;

    void performInitialSteps() {
        header = new Header(driver);
        shiftsPage = new ShiftsPage(driver);
        shiftAddPage = new ShiftAddPage(driver);
        shiftEditPage = new ShiftEditPage(driver);
        header.openShifts();
        shiftsPage.pressButtonAdd();
        String shiftName = "ShiftName" + generateRandomNum();
        shiftAddPage
                .enterShiftName(shiftName)
                .pressButtonAdd();
        header.openShifts();
        shiftsPage
                .pressButtonSearch()
                .searchShiftByName(shiftName)
                .pressButtonSearch()
                .pressButtonEdit();
    }

    @Test
    @Tag("smoke")
    @Tag("regression")
    public void shiftShouldBeRestoredAfterDeletion() {
        performInitialSteps();
        shiftEditPage.pressButtonDelete();
        waitUntilRestoreButtonAppears(driver);
        shiftEditPage.pressButtonRestore();
        waitForMessageShiftUpdated(driver);

        assertEquals("Įrašas sėkmingai atnaujintas", shiftEditPage.getSuccessMessage()
                , "No success message received");
    }

    @Test
    @Tag("smoke")
    @Tag("regression")
    public void shiftCanBeEdited() {
        performInitialSteps();
        shiftEditPage
                .editShiftName("ShiftName" + generateRandomNum())
                .pressButtonEdit();
        waitForMessageShiftUpdated(driver);

        assertEquals("Įrašas sėkmingai atnaujintas", shiftEditPage.getSuccessMessage()
                , "No success message received");
    }

}

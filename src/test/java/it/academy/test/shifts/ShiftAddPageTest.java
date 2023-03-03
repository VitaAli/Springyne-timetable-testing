package it.academy.test.shifts;

import it.academy.pom.Header;
import it.academy.pom.shifts.ShiftAddPage;
import it.academy.pom.shifts.ShiftsPage;
import it.academy.test.BaseTest;
import org.junit.jupiter.api.Test;

import static it.academy.utils.GenerateDataUtils.generateRandomModuleName;
import static it.academy.utils.WaitUtils.waitForMessageRecordIsCreated;
import static it.academy.utils.WaitUtils.waitForMessageRecordIsNotCreated;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

    @Test
    public void shiftShouldBeCreatedWithUniqueName() {
        performInitialSteps();
        shiftAddPage.enterName(generateRandomModuleName());
        shiftAddPage.pressButtonAdd();
        waitForMessageRecordIsCreated(driver);

        assertEquals("Įrašas sėkmingai sukurtas", shiftAddPage.getSuccessMessage()
                , "Shift name must be unique");
    }

    @Test
    public void shiftShouldNotBeCreatedWithNoName () {
        performInitialSteps();
        shiftAddPage.enterName("");
        shiftAddPage.pressButtonAdd();

        assertTrue(shiftAddPage.getNumberInvalidValue()
                , "The shift name is mandatory for adding a new shift");
    }

    @Test
    public void shiftShouldNotBeCreatedWithNonUniqueName() {
        performInitialSteps();
        shiftAddPage.enterName("Rytinė");
        shiftAddPage.pressButtonAdd();
        waitForMessageRecordIsNotCreated(driver);

        assertEquals("Įrašo nepavyko sukurti", shiftAddPage.getErrorMessage()
                , "The shift name must be unique");
    }

}

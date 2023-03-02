package it.academy.test.shifts;

import it.academy.pom.Header;
import it.academy.pom.shifts.ShiftAddPage;
import it.academy.pom.shifts.ShiftsPage;
import it.academy.test.BaseTest;
import it.academy.utils.WaitUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
        shiftAddPage.enterName("test3");
        shiftAddPage.pressButtonAdd();
        WaitUtils.waitForMessageRecordSuccessfullyCreated(driver, 10);

        String expectedMessage = "Įrašas sėkmingai sukurtas";
        String actualMessage = shiftAddPage.getSuccessMessage();

        Assertions.assertEquals(expectedMessage, actualMessage, "Shift name must be unique");
    }

    @Test
    public void shiftShouldNotBeCreatedWithNoName () {
        performInitialSteps();
        shiftAddPage.enterName("");
        shiftAddPage.pressButtonAdd();

        Assertions.assertTrue(shiftAddPage.getNumberInvalidValue()
                , "The shift name is mandatory for adding a new shift");
    }

    @Test
    public void shiftShouldNotBeCreatedWithNonUniqueName() {
        performInitialSteps();
        shiftAddPage.enterName("name");
        shiftAddPage.pressButtonAdd();
        WaitUtils.waitForMessageRecordCouldNotBeCreated(driver, 10);

        String expectedMessage = "Įrašo nepavyko sukurti";
        String actualMessage = shiftAddPage.getErrorMessage();

        Assertions.assertEquals(expectedMessage, actualMessage, "The shift name must be unique");
    }

}

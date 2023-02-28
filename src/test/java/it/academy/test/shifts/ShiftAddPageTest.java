package it.academy.test.shifts;

import it.academy.pom.Header;
import it.academy.pom.shifts.ShiftAddPage;
import it.academy.pom.shifts.ShiftsPage;
import it.academy.test.BaseTest;
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
    public void shiftShouldBeCreatedWithUniqueName() throws InterruptedException {
        performInitialSteps();
        shiftAddPage.enterName("name1");
        shiftAddPage.pressButtonAdd();

        Thread.sleep(3000);

        String expectedMessage = "Įrašas sėkmingai sukurtas";
        String actualMessage = shiftAddPage.getSuccessMessage();

        Assertions.assertEquals(expectedMessage, actualMessage, "Shift name must be unique");
    }

    @Test
    public void shiftShouldNotBeCreatedWithNoName () throws InterruptedException {
        performInitialSteps();
        shiftAddPage.enterName("name");
        shiftAddPage.pressButtonAdd();

        Thread.sleep(3000);

        Assertions.assertTrue(shiftAddPage.getNumberInvalidValue()
                , "The shift name is mandatory for adding a new shift");
    }

    @Test
    public void shiftShouldNotBeCreatedWithNonUniqueName() throws InterruptedException {
        performInitialSteps();
        shiftAddPage.enterName("name");
        shiftAddPage.pressButtonAdd();

        Thread.sleep(3000);

        String expectedMessage = "Įrašo nepavyko sukurti";
        String actualMessage = shiftAddPage.getErrorMessage();

        Assertions.assertEquals(expectedMessage, actualMessage, "The shift name must be unique");
    }

}

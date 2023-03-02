package it.academy.test.shifts;

import it.academy.pom.Header;
import it.academy.pom.shifts.ShiftsPage;
import it.academy.test.BaseTest;
import it.academy.utils.WaitUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static it.academy.utils.WaitUtils.waitForMessageFoundRecords;
import static it.academy.utils.WaitUtils.waitForMessageNoRecordsFound;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ShiftsPageTest extends BaseTest {

    private Header header;
    private ShiftsPage shiftsPage;

    void performInitialSteps() {
        header = new Header(driver);
        shiftsPage = new ShiftsPage(driver);
        header.openShifts();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/ShiftTestData1.txt")
    public void shiftsShouldBeFilteredByName(String valueFromFile) {
        performInitialSteps();
        shiftsPage.searchShiftByName(valueFromFile);
        shiftsPage.pressButtonSearch();
        waitForMessageFoundRecords(driver, 10);

        assertTrue(shiftsPage.getShiftNames().contains(valueFromFile)
                , "The list should be filtered by the value");
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/ShiftTestData2.txt")
    public void shiftsShouldBeFilteredByPartialName(String valueFromFile) {
        performInitialSteps();
        shiftsPage.searchShiftByName(valueFromFile);
        shiftsPage.pressButtonSearch();
        waitForMessageFoundRecords(driver, 10);

        assertTrue(shiftsPage.getPartialShiftNames().contains(valueFromFile)
                , "The list should be filtered by the value");
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/ShiftTestData3.txt")
    public void shiftsShouldNotBeFound(String valueFromFile) {
        performInitialSteps();
        shiftsPage.searchShiftByName(valueFromFile);
        shiftsPage.pressButtonSearch();
        waitForMessageNoRecordsFound(driver);

        assertEquals("Įrašų nerasta", shiftsPage.getTextOfMessageNoRecords()
                , "Shifts cannot be filtered by random words or symbols");
    }
}

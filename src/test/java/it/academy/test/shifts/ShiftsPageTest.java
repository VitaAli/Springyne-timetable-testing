package it.academy.test.shifts;

import it.academy.pom.Header;
import it.academy.pom.shifts.ShiftsPage;
import it.academy.test.BaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.List;

import static it.academy.utils.WaitUtils.waitForMessageRecordsAreFound;
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
        List<String> shifts = shiftsPage.getShiftNames();
        shiftsPage.searchShiftByName(valueFromFile);
        shiftsPage.pressButtonSearch();
        waitForMessageRecordsAreFound(driver);

        assertTrue(shifts.contains(valueFromFile)
                , "The list should be filtered by the name");
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/ShiftTestData2.txt")
    public void shiftsShouldBeFilteredByPartialName(String valueFromFile) {
        performInitialSteps();
        List<String> shifts = shiftsPage.getPartialShiftNames();
        shiftsPage.searchShiftByName(valueFromFile);
        shiftsPage.pressButtonSearch();
        waitForMessageRecordsAreFound(driver);

        assertTrue(shifts.contains(valueFromFile)
                , "The list should be filtered by the partial name");
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

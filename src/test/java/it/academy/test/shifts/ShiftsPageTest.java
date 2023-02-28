package it.academy.test.shifts;

import it.academy.pom.Header;
import it.academy.pom.modules.ModulesPage;
import it.academy.pom.shifts.ShiftsPage;
import it.academy.test.BaseTest;
import it.academy.utils.WaitUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

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

        Assertions.assertTrue(shiftsPage.getShiftNames().contains(valueFromFile)
                , "The list should be filtered by the value");
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/ShiftTestData2.txt")
    public void shiftsShouldBeFilteredByPartialName(String valueFromFile) throws InterruptedException {
        performInitialSteps();
        shiftsPage.searchShiftByName(valueFromFile);
        shiftsPage.pressButtonSearch();

        Thread.sleep(3000);

        Assertions.assertTrue(shiftsPage.getPartialShiftNames().contains(valueFromFile)
                , "The list should be filtered by the value");
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/ShiftTestData3.txt")
    public void shiftsShouldNotBeFound(String valueFromFile) throws InterruptedException {
        performInitialSteps();
        shiftsPage.searchShiftByName(valueFromFile);
        shiftsPage.pressButtonSearch();

        Thread.sleep(3000);

        Assertions.assertEquals("Įrašų nerasta", shiftsPage.getTextOfMessageNoRecords()
                , "Shifts cannot be filtered by random words or symbols");
    }
}

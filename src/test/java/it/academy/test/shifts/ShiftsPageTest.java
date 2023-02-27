package it.academy.test.shifts;

import it.academy.pom.Header;
import it.academy.pom.modules.ModulesPage;
import it.academy.pom.shifts.ShiftsPage;
import it.academy.test.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class ShiftsPageTest extends BaseTest {

    private Header header;
    private ModulesPage modulesPage;
    private ShiftsPage shiftsPage;

    void performInitialSteps() {
        header = new Header(driver);
        modulesPage = new ModulesPage(driver);
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
}

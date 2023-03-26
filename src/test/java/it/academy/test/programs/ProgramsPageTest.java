package it.academy.test.programs;

import it.academy.pom.Header;
import it.academy.pom.programs.ProgramsPage;
import it.academy.test.BaseTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.List;

import static it.academy.utils.WaitUtils.waitForMessageRecordsAreFound;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProgramsPageTest extends BaseTest {

    private Header header;
    private ProgramsPage programsPage;

    void performInitialSteps() {
        header = new Header(driver);
        programsPage = new ProgramsPage(driver);
        header.openPrograms();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/ProgramTestData1.txt")
    @Tag("smoke")
    @Tag("regression")
    public void programsShouldBeFilteredByName(String valueFromFile) {
        performInitialSteps();
        List<String> programs = programsPage.getProgramNames();
        programsPage
                .searchProgramByName(valueFromFile)
                .pressButtonSearch();
        waitForMessageRecordsAreFound(driver);

        assertTrue(programs.contains(valueFromFile)
                , "The list should be filtered by the name");
    }
}

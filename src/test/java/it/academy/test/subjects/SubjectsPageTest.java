package it.academy.test.subjects;

import it.academy.pom.Header;
import it.academy.pom.subjects.SubjectsPage;
import it.academy.test.BaseTest;
import it.academy.utils.WaitUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.List;

import static it.academy.utils.WaitUtils.waitForMessageRecordsAreFound;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SubjectsPageTest extends BaseTest {

    private Header header;
    private SubjectsPage subjectsPage;

    void performInitialSteps() {
        header = new Header(driver);
        subjectsPage = new SubjectsPage(driver);
        header.openSubjects();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/SubjectTestData1.txt")
    public void subjectsCanBeFilteredBySubjectName(String valueFromFile) {
        performInitialSteps();
        List<String> subjects = subjectsPage.getSubjectsByName();
        subjectsPage.searchSubjectsByName(valueFromFile);
        subjectsPage.pressButtonSearch();
        waitForMessageRecordsAreFound(driver);

        assertTrue(subjects.contains(valueFromFile),
                "The list should be filtered by the subject name");
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/SubjectTestData2.txt")
    public void subjectsCanBeFilteredByPartialSubjectName(String valueFromFile) {
        performInitialSteps();
        List<String> subjects = subjectsPage.getSubjectsByPartialName();
        subjectsPage.searchSubjectsByName(valueFromFile);
        subjectsPage.pressButtonSearch();
        waitForMessageRecordsAreFound(driver);

        assertTrue(subjects.contains(valueFromFile),
                "The list should be filtered by the partial subject name");
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/SubjectTestData3.txt")
    public void subjectsCanBeFilteredByModuleName(String valueFromFile) {
        performInitialSteps();
        List<String> subjects = subjectsPage.getSubjectsByModuleName();
        subjectsPage.searchSubjectsByModule(valueFromFile);
        subjectsPage.pressButtonSearch();
        waitForMessageRecordsAreFound(driver);

        assertTrue(subjects.contains(valueFromFile),
                "The list should be filtered by the module name");
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/SubjectTestData4.txt")
    public void subjectsCanBeFilteredByPartialModuleName(String valueFromFile) {
        performInitialSteps();
        List<String> subjects = subjectsPage.getSubjectsByPartialModuleName();
        subjectsPage.searchSubjectsByModule(valueFromFile);
        subjectsPage.pressButtonSearch();
        waitForMessageRecordsAreFound(driver);

        assertTrue(subjects.contains(valueFromFile),
                "The list should be filtered by the partial module name");
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/GeneralTestData.txt")
    public void subjectsShouldNotBeFound(String valueFromFile) {
        performInitialSteps();
        subjectsPage.searchSubjectsByName(valueFromFile);
        subjectsPage.pressButtonSearch();
        WaitUtils.waitForMessageNoRecordsFound(driver);

        assertEquals("Įrašų nerasta", subjectsPage.getTextOfMessageNoRecords()
                , "Subjects cannot be filtered by subject name using random words or symbols");
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/GeneralTestData.txt")
    public void subjectsByModuleShouldNotBeFound(String valueFromFile) {
        performInitialSteps();
        subjectsPage.searchSubjectsByModule(valueFromFile);
        subjectsPage.pressButtonSearch();
        WaitUtils.waitForMessageNoRecordsFound(driver);

        assertEquals("Įrašų nerasta", subjectsPage.getTextOfMessageNoRecords()
                , "Subjects cannot be filtered by module name using random words or symbols");
    }
}

package it.academy.test.subjects;

import it.academy.pom.Header;
import it.academy.pom.subjects.SubjectsPage;
import it.academy.test.BaseTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.List;

import static it.academy.utils.WaitUtils.waitForMessageNoRecordsFound;
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
    @Tag("smoke")
    @Tag("regression")
    public void subjectsCanBeFilteredBySubjectName(String valueFromFile) {
        performInitialSteps();
        List<String> subjects = subjectsPage.getSubjectsByName();
        subjectsPage
                .searchSubjectsByName(valueFromFile)
                .pressButtonSearch();
        waitForMessageRecordsAreFound(driver);

        assertTrue(subjects.contains(valueFromFile),
                "The list should be filtered by the subject name");
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/SubjectTestData2.txt")
    @Tag("regression")
    public void subjectsCanBeFilteredByPartialSubjectName(String valueFromFile) {
        performInitialSteps();
        List<String> subjects = subjectsPage.getSubjectsByPartialName();
        subjectsPage
                .searchSubjectsByName(valueFromFile)
                .pressButtonSearch();
        waitForMessageRecordsAreFound(driver);

        assertTrue(subjects.contains(valueFromFile),
                "The list should be filtered by the partial subject name");
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/SubjectTestData3.txt")
    @Tag("smoke")
    @Tag("regression")
    public void subjectsCanBeFilteredByModuleName(String valueFromFile) {
        performInitialSteps();
        List<String> subjects = subjectsPage.getSubjectsByModuleName();
        subjectsPage
                .searchSubjectsByModule(valueFromFile)
                .pressButtonSearch();
        waitForMessageRecordsAreFound(driver);

        assertTrue(subjects.contains(valueFromFile),
                "The list should be filtered by the module name");
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/SubjectTestData4.txt")
    @Tag("regression")
    public void subjectsCanBeFilteredByPartialModuleName(String valueFromFile) {
        performInitialSteps();
        List<String> subjects = subjectsPage.getSubjectsByPartialModuleName();
        subjectsPage
                .searchSubjectsByModule(valueFromFile)
                .pressButtonSearch();
        waitForMessageRecordsAreFound(driver);

        assertTrue(subjects.contains(valueFromFile),
                "The list should be filtered by the partial module name");
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/GeneralTestData.txt")
    @Tag("regression")
    public void subjectsShouldNotBeFound(String valueFromFile) {
        performInitialSteps();
        subjectsPage
                .pressButtonSearch()
                .searchSubjectsByName(valueFromFile)
                .pressButtonSearch();
        waitForMessageNoRecordsFound(driver);

        assertEquals("Įrašų nerasta", subjectsPage.getTextOfMessageNoRecords()
                , "Subjects cannot be filtered by subject name using random words or symbols");
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/GeneralTestData.txt")
    @Tag("regression")
    public void subjectsByModuleShouldNotBeFound(String valueFromFile) {
        performInitialSteps();
        subjectsPage
                .pressButtonSearch()
                .searchSubjectsByModule(valueFromFile)
                .pressButtonSearch();
        waitForMessageNoRecordsFound(driver);

        assertEquals("Įrašų nerasta", subjectsPage.getTextOfMessageNoRecords()
                , "Subjects cannot be filtered by module name using random words or symbols");
    }
}

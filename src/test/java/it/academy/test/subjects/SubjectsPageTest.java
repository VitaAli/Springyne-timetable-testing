package it.academy.test.subjects;

import it.academy.pom.Header;
import it.academy.pom.subjects.SubjectAddPage;
import it.academy.pom.subjects.SubjectsPage;
import it.academy.test.BaseTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.List;

import static it.academy.utils.GenerateDataUtils.generateRandomNum;
import static it.academy.utils.WaitUtils.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SubjectsPageTest extends BaseTest {

    private Header header;
    private SubjectsPage subjectsPage;
    private SubjectAddPage subjectAddPage;

    void performInitialSteps() {
        header = new Header(driver);
        subjectsPage = new SubjectsPage(driver);
        subjectAddPage = new SubjectAddPage(driver);
        header.openSubjects();
    }

    @Test
    @Tag("smoke")
    @Tag("regression")
    public void subjectsCanBeFilteredBySubjectName() throws InterruptedException {
        performInitialSteps();
        subjectsPage.pressButtonAddSubject();
        String subjectName = "SubjectName" + generateRandomNum();
        subjectAddPage
                .enterSubjectName(subjectName)
                .enterSubjectDescription("SubjectDescription" + generateRandomNum())
                .selectModule();
        Thread.sleep(3000);
        subjectAddPage.selectRoom();
        Thread.sleep(3000);
        subjectAddPage.pressButtonAdd();
        waitForMessageRecordIsCreated(driver);
        header.openSubjects();
        subjectsPage.searchSubjectsByName(subjectName);
        subjectsPage.pressButtonSearch();
        waitForMessageRecordsAreFound(driver);
        List<String> subjects = subjectsPage.getSubjectsByName();

        assertTrue(subjects.contains(subjectName),
                "The list should be filtered by the subject name");

        driver.navigate().refresh();
        subjectsPage.searchSubjectsByName(subjectName);
        subjectsPage.pressButtonSearch();
        waitForMessageRecordsAreFound(driver);
        subjectsPage.pressButtonDeleteSubject();
    }

    @Test
    @Tag("regression")
    public void subjectsCanBeFilteredByPartialSubjectName() throws InterruptedException {
        performInitialSteps();
        subjectsPage
                .pressButtonAddSubject();
        String subjectName = "SubjectName" + generateRandomNum();
        subjectAddPage
                .enterSubjectName(subjectName)
                .enterSubjectDescription("SubjectDescription" + generateRandomNum())
                .selectModule();
        Thread.sleep(3000);
        subjectAddPage
                .selectRoom()
                .pressButtonAdd();
        waitForMessageRecordIsCreated(driver);
        header.openSubjects();
        subjectsPage.searchSubjectsByName("SubjectName");
        subjectsPage.pressButtonSearch();
        waitForMessageRecordsAreFound(driver);
        List<String> subjects = subjectsPage.getSubjectsByName();

        assertTrue(subjects.contains(subjectName),
                "The list should be filtered by the partial subject name");

        driver.navigate().refresh();
        subjectsPage.searchSubjectsByName(subjectName);
        subjectsPage.pressButtonSearch();
        waitForMessageRecordsAreFound(driver);
        subjectsPage.pressButtonDeleteSubject();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/SubjectTestByModule.txt")
    @Tag("smoke")
    @Tag("regression")
    public void subjectsCanBeFilteredByModuleName(String valueFromFile) {
        performInitialSteps();
        List<String> subjects = subjectsPage.getSubjectsByModuleName();
        subjectsPage
                .pressButtonSearch()
                .searchSubjectsByModule(valueFromFile)
                .pressButtonSearch();
        waitForMessageRecordsAreFound(driver);

        assertTrue(subjects.contains(valueFromFile),
                "The list should be filtered by the module name");
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/SubjectTestByPartialModule.txt")
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

package it.academy.test.subjects;

import it.academy.pom.Header;
import it.academy.pom.subjects.SubjectAddPage;
import it.academy.pom.subjects.SubjectEditPage;
import it.academy.pom.subjects.SubjectViewPage;
import it.academy.pom.subjects.SubjectsPage;
import it.academy.test.BaseTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static it.academy.utils.GenerateDataUtils.generateRandomNum;
import static it.academy.utils.WaitUtils.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SubjectViewPageTest extends BaseTest {

    private Header header;
    private SubjectsPage subjectsPage;
    private SubjectAddPage subjectAddPage;
    private SubjectViewPage subjectViewPage;

    void performInitialSteps() {
        header = new Header(driver);
        subjectsPage = new SubjectsPage(driver);
        subjectAddPage = new SubjectAddPage(driver);
        subjectViewPage = new SubjectViewPage(driver);
        header.openSubjects();
        subjectsPage.pressButtonAddSubject();
        String subjectName = "SubjectName" + generateRandomNum();
        subjectAddPage
                .enterSubjectName(subjectName)
                .enterSubjectDescription("SubjectDescription" + generateRandomNum())
                .selectModule()
                .selectRoom()
                .pressButtonAdd();
        waitForMessageRecordIsCreated(driver);
        header.openSubjects();
        subjectsPage.pressButtonSearch();
        subjectsPage.searchSubjectsByName(subjectName);
        subjectsPage.pressButtonSearch();
        waitForMessageRecordsAreFound(driver);
        subjectsPage.pressButtonViewSubject();
    }

    @Test
    @Tag("smoke")
    @Tag("regression")
    public void subjectShouldBeInvalidated() {
        performInitialSteps();
        subjectViewPage.pressButtonDelete();
        waitForMessageRecordDeleted(driver);

        assertEquals("Įrašas sėkmingai ištrintas", subjectViewPage.getSuccessMessageAfterDeletion()
                , "No success message received after subject deletion");
    }

    @Test
    @Tag("smoke")
    @Tag("regression")
    public void invalidatedSubjectShouldBeRestored() {
        performInitialSteps();
        subjectViewPage.pressButtonDelete();
        waitUntilRestoreButtonAppears(driver);
        subjectViewPage.pressButtonRestore();
        waitForMessageRecordRestored(driver);

        assertEquals("Įrašas sėkmingai atstatytas", subjectViewPage.getSuccessMessageAfterRestore()
                , "No success message received after subject restoring");
    }

}

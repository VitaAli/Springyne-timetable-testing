package it.academy.test.subjects;

import it.academy.pom.Header;
import it.academy.pom.subjects.SubjectViewPage;
import it.academy.pom.subjects.SubjectsPage;
import it.academy.test.BaseTest;
import org.junit.jupiter.api.Test;

import static it.academy.utils.WaitUtils.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SubjectViewPageTest extends BaseTest {

    private Header header;
    private SubjectsPage subjectsPage;
    private SubjectViewPage subjectViewPage;

    void performInitialSteps() {
        header = new Header(driver);
        subjectsPage = new SubjectsPage(driver);
        subjectViewPage = new SubjectViewPage(driver);
        header.openSubjects();
        subjectsPage.pressButtonViewSubject();
    }

    @Test
    public void subjectShouldBeInvalidated() {
        performInitialSteps();
        subjectViewPage.pressButtonDelete();
        waitForMessageRecordDeleted(driver);

        assertEquals("Įrašas sėkmingai ištrintas", subjectViewPage.getSuccessMessageAfterDeletion()
                , "No success message received after module deletion");
    }

    @Test
    public void invalidatedModuleShouldBeRestored() {
        performInitialSteps();
        subjectViewPage.pressButtonDelete();
        waitUntilRestoreButtonAppears(driver);
        subjectViewPage.pressButtonRestore();
        waitForMessageRecordRestored(driver);

        assertEquals("Įrašas sėkmingai atstatytas", subjectViewPage.getSuccessMessageAfterRestore()
                , "No success message received");

    }

}

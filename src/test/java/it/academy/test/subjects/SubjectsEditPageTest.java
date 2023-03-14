package it.academy.test.subjects;

import it.academy.pom.Header;
import it.academy.pom.subjects.SubjectEditPage;
import it.academy.pom.subjects.SubjectsPage;
import it.academy.test.BaseTest;
import org.junit.jupiter.api.Test;

import static it.academy.utils.WaitUtils.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SubjectsEditPageTest extends BaseTest {


    private Header header;
    private SubjectsPage subjectsPage;
    private SubjectEditPage subjectEditPage;

    void performInitialSteps() {
        header = new Header(driver);
        subjectsPage = new SubjectsPage(driver);
        subjectEditPage = new SubjectEditPage(driver);
        header.openSubjects();
        subjectsPage.pressButtonEditSubject();
    }

    @Test
    public void subjectShouldBeInvalidated() {
        performInitialSteps();
        waitUntilDeleteButtonAppears(driver);
        subjectEditPage.pressButtonDelete();
        waitForMessageSubjectUpdated(driver);

        assertEquals("Įrašas sėkmingai atnaujintas", subjectEditPage.getSuccessMessage()
                , "No success message received");
    }
}

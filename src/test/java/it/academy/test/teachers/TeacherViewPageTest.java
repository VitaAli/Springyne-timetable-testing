package it.academy.test.teachers;

import it.academy.pom.Header;
import it.academy.pom.teachers.TeacherViewPage;
import it.academy.pom.teachers.TeachersPage;
import it.academy.test.BaseTest;
import org.junit.jupiter.api.Test;

import static it.academy.utils.WaitUtils.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TeacherViewPageTest extends BaseTest {

    private Header header;
    private TeachersPage teachersPage;
    private TeacherViewPage teacherViewPage;

    void performInitialSteps() {
        header = new Header(driver);
        teachersPage = new TeachersPage(driver);
        teacherViewPage = new TeacherViewPage(driver);
        header.openTeachers();
        teachersPage.pressButtonViewTeacher();
    }

    @Test
    public void teacherShouldBeInvalidated() {
        performInitialSteps();
        teacherViewPage.pressButtonDelete();
        waitForMessageRecordDeleted(driver);

        assertEquals("Įrašas sėkmingai ištrintas", teacherViewPage.getSuccessMessageAfterDeletion()
                , "No success message received after teacher deletion");
    }

    @Test
    public void invalidatedTeacherShouldBeRestored() {
        performInitialSteps();
        teacherViewPage.pressButtonDelete();
        waitUntilRestoreButtonAppears(driver);
        teacherViewPage.pressButtonRestore();
        waitForMessageRecordRestored(driver);

        assertEquals("Įrašas sėkmingai atstatytas", teacherViewPage.getSuccessMessageAfterRestore()
                , "No success message received after teacher restoring");

    }
}

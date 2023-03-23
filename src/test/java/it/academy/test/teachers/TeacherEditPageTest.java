package it.academy.test.teachers;

import it.academy.pom.Header;
import it.academy.pom.teachers.TeacherEditPage;
import it.academy.pom.teachers.TeachersPage;
import it.academy.test.BaseTest;
import org.junit.jupiter.api.Test;

import static it.academy.utils.GenerateDataUtils.generateRandomNum;
import static it.academy.utils.WaitUtils.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TeacherEditPageTest extends BaseTest {

    private Header header;
    private TeachersPage teachersPage;
    private TeacherEditPage teacherEditPage;

    void performInitialSteps() {
        header = new Header(driver);
        teachersPage = new TeachersPage(driver);
        teacherEditPage = new TeacherEditPage(driver);
        header.openTeachers();
        teachersPage.pressButtonEditTeacher();
    }

    @Test
    public void teacherShouldBeEditedByEditingAllFields() {
        performInitialSteps();
        teacherEditPage.enterTeacherName("TeacherName" + generateRandomNum())
                .enterTeacherUsername("TeacherUserName" + generateRandomNum())
                .enterTeacherEmail("TeacherEmail" + generateRandomNum())
                .enterTeacherMobile("TeacherMobile" + generateRandomNum())
                .enterTeacherNumbersOfHours("40")
                .selectTeacherSubject()
                .selectTeacherShift()
                .pressButtonEdit();
        waitForMessageRecordUpdated(driver);

        assertEquals("Įrašas sėkmingai atnaujintas", teacherEditPage.getSuccessMessage()
                , "Teacher was not edited. All mandatory fields must be fill in");
    }

    @Test
    public void teacherShouldBeInvalidated() {
        performInitialSteps();
        waitUntilDeleteButtonAppears(driver);
        teacherEditPage.pressButtonDelete();
        waitForMessageSubjectUpdated(driver);

        assertEquals("Įrašas sėkmingai atnaujintas", teacherEditPage.getSuccessMessage()
                , "No success message received");
    }
}

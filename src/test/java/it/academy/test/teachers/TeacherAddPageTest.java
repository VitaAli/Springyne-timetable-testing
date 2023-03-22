package it.academy.test.teachers;

import it.academy.pom.Header;
import it.academy.pom.teachers.TeacherAddPage;
import it.academy.pom.teachers.TeachersPage;
import it.academy.test.BaseTest;
import it.academy.utils.GeneralUse;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static it.academy.utils.GenerateDataUtils.generateRandomNum;
import static it.academy.utils.WaitUtils.waitForMessageRecordIsCreated;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TeacherAddPageTest extends BaseTest {

    private Header header;
    private TeachersPage teachersPage;
    private TeacherAddPage teacherAddPage;

    private GeneralUse generalUse;

    public void performInitialSteps() {
        header = new Header(driver);
        teachersPage = new TeachersPage(driver);
        teacherAddPage = new TeacherAddPage(driver);
        generalUse = new GeneralUse(driver);
        header.openTeachers();
        teachersPage.pressButtonAddTeacher();
    }

    @Test
    @Tag("smoke")
    public void teacherShouldBeAddedByEnteringMandatoryFields() {
        performInitialSteps();
        teacherAddPage
                .enterTeacherName("TeacherName" + generateRandomNum())
                .enterTeacherUsername("TeacherUsername" + generateRandomNum())
                .enterTeacherNumbersOfHours("40")
                .selectTeacherSubject()
                .selectTeacherShift();
        generalUse.pressButtonAdd();
        waitForMessageRecordIsCreated(driver);

        assertEquals("Įrašas sėkmingai sukurtas", generalUse.getSuccessMessage()
                , "All mandatory fields must be filled in when creating a record");
    }
}

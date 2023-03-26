package it.academy.test.teachers;

import it.academy.pom.Header;
import it.academy.pom.teachers.TeacherAddPage;
import it.academy.pom.teachers.TeachersPage;
import it.academy.test.BaseTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static it.academy.utils.GenerateDataUtils.generateRandomNum;
import static it.academy.utils.WaitUtils.waitForMessageRecordIsCreated;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TeacherAddPageTest extends BaseTest {

    private Header header;
    private TeachersPage teachersPage;
    private TeacherAddPage teacherAddPage;

    public void performInitialSteps() {
        header = new Header(driver);
        teachersPage = new TeachersPage(driver);
        teacherAddPage = new TeacherAddPage(driver);
        header.openTeachers();
        teachersPage.pressButtonAddTeacher();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/TeacherAddTestData.txt")
    @Tag("smoke")
    @Tag("regression")
    public void teacherShouldBeAddedByEnteringMandatoryFields(String valueFromFile) {
        performInitialSteps();
        teacherAddPage
                .enterTeacherName(valueFromFile)
                .enterTeacherUsername("TeacherUsername" + generateRandomNum())
                .enterTeacherNumbersOfHours("40")
                .selectTeacherSubject()
                .selectTeacherShift();
        teacherAddPage.pressButtonAdd();
        waitForMessageRecordIsCreated(driver);

        assertEquals("Įrašas sėkmingai sukurtas", teacherAddPage.getSuccessMessage()
                , "All mandatory fields must be filled in when creating a record");
    }
}

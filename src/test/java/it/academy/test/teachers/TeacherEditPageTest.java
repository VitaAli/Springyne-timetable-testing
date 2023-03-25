package it.academy.test.teachers;

import it.academy.pom.Header;
import it.academy.pom.teachers.TeacherEditPage;
import it.academy.pom.teachers.TeachersPage;
import it.academy.test.BaseTest;
import it.academy.utils.WaitUtils;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

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
    @Tag("smoke")
    public void teacherShouldBeEditedByEditingAllFields() throws InterruptedException {
        performInitialSteps();
        teacherEditPage.enterTeacherName("TeacherName" + generateRandomNum())
                .enterTeacherUsername("TeacherUserName" + generateRandomNum())
                .enterTeacherEmail("TeacherEmail" + generateRandomNum())
                .enterTeacherMobile("TeacherMobile" + generateRandomNum())
                .enterTeacherNumbersOfHours("40")
                .selectTeacherSubject()
                .selectTeacherShift();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
        Thread.sleep(3000);

        teacherEditPage.pressButtonEdit();
        waitForMessageRecordUpdated(driver);

        assertEquals("Įrašas sėkmingai atnaujintas", teacherEditPage.getSuccessMessage()
                , "Teacher was not edited. All mandatory fields must be fill in");
    }

    @Test
    @Tag("smoke")
    public void teacherShouldBeInvalidated() throws InterruptedException {
        performInitialSteps();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
        Thread.sleep(3000);
        teacherEditPage.pressButtonEdit()
                .pressButtonDelete();
        waitForMessageSubjectUpdated(driver);

        assertEquals("Įrašas sėkmingai atnaujintas", teacherEditPage.getSuccessMessage()
                , "No success message received");
    }

    @Test
    @Tag("smoke")
    public void invalidatedTeacherShouldBeRestored() throws InterruptedException {
        performInitialSteps();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
        Thread.sleep(3000);
        teacherEditPage.pressButtonEdit()
                .pressButtonDelete()
                .pressButtonRestore();
        waitForMessageSubjectUpdated(driver);

        assertEquals("Įrašas sėkmingai atnaujintas", teacherEditPage.getSuccessMessage()
                , "No success message received");
    }

}

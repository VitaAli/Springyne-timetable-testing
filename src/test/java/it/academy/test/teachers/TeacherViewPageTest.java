package it.academy.test.teachers;

import it.academy.pom.Header;
import it.academy.pom.teachers.TeacherAddPage;
import it.academy.pom.teachers.TeacherViewPage;
import it.academy.pom.teachers.TeachersPage;
import it.academy.test.BaseTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;

import static it.academy.utils.GenerateDataUtils.generateRandomNum;
import static it.academy.utils.WaitUtils.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TeacherViewPageTest extends BaseTest {

    private Header header;
    private TeachersPage teachersPage;
    private TeacherAddPage teacherAddPage;
    private TeacherViewPage teacherViewPage;

    void performInitialSteps() throws InterruptedException {
        header = new Header(driver);
        teachersPage = new TeachersPage(driver);
        teacherAddPage = new TeacherAddPage(driver);
        teacherViewPage = new TeacherViewPage(driver);
        header.openTeachers();
        teachersPage.pressButtonAddTeacher();
        String teacherName = "TeacherName" + generateRandomNum();
        teacherAddPage
                .enterTeacherName(teacherName)
                .enterTeacherUsername("TeacherUsername" + generateRandomNum())
                .enterTeacherNumbersOfHours("40")
                .selectTeacherSubject();
        Thread.sleep(3000);
        teacherAddPage.selectTeacherShift();
        teacherAddPage.pressButtonAdd();
        waitForMessageRecordIsCreated(driver);
        header.openTeachers();
        teachersPage.searchTeacherByName(teacherName);
        teachersPage.pressButtonSearch();
        waitForMessageRecordsAreFound(driver);
        teachersPage.pressButtonViewTeacher();
    }

    @Test
    @Tag("smoke")
    @Tag("regression")
    public void teacherShouldBeInvalidated() throws InterruptedException {
        performInitialSteps();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        Thread.sleep(3000);

        teacherViewPage.pressButtonDelete();
        waitForMessageRecordDeleted(driver);

        assertEquals("Įrašas sėkmingai ištrintas", teacherViewPage.getSuccessMessageAfterDeletion()
                , "No success message received after teacher deletion");
    }

    @Test
    @Tag("smoke")
    @Tag("regression")
    public void invalidatedTeacherShouldBeRestored() throws InterruptedException {
        performInitialSteps();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        Thread.sleep(3000);

        teacherViewPage.pressButtonDelete();
        waitUntilRestoreButtonAppears(driver);

        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        Thread.sleep(3000);

        teacherViewPage.pressButtonRestore();
        waitForMessageRecordRestored(driver);

        assertEquals("Įrašas sėkmingai atstatytas", teacherViewPage.getSuccessMessageAfterRestore()
                , "No success message received after teacher restoring");
    }
}

package it.academy.test.subjects;

import it.academy.pom.Header;
import it.academy.pom.subjects.SubjectEditPage;
import it.academy.pom.subjects.SubjectsPage;
import it.academy.test.BaseTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;

import static it.academy.utils.GenerateDataUtils.generateRandomNum;
import static it.academy.utils.WaitUtils.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SubjectEditPageTest extends BaseTest {

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
    @Tag("smoke")
    public void subjectInformationShouldBeEditedByChangingAllFields() throws InterruptedException {
        performInitialSteps();
        subjectEditPage.enterSubjectName("SubjectName" + generateRandomNum())
                .enterSubjectDescription("SubjectDescription" + generateRandomNum())
                .selectSubjectModule()
                .selectSubjectRoom();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
        Thread.sleep(3000);

        subjectEditPage.pressButtonEditSubject();
        waitForMessageRecordUpdated(driver);

        assertEquals("Įrašas sėkmingai atnaujintas", subjectEditPage.getSuccessMessage()
                , "Teacher was not edited. All mandatory fields must be fill in");
    }

    @Test
    @Tag("smoke")
    public void subjectShouldBeInvalidated() throws InterruptedException {
        performInitialSteps();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
        Thread.sleep(3000);

        subjectEditPage.pressButtonDelete();
        waitForMessageSubjectUpdated(driver);

        assertEquals("Įrašas sėkmingai atnaujintas", subjectEditPage.getSuccessMessage()
                , "No success message received");
    }

    @Test
    @Tag("smoke")
    public void invalidatedSubjectShouldBeRestored() throws InterruptedException {
        performInitialSteps();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
        Thread.sleep(3000);

        subjectEditPage.pressButtonDelete();

        js.executeScript("window.scrollBy(0,500)");
        Thread.sleep(3000);

        subjectEditPage.pressButtonRestore();
        waitForMessageSubjectUpdated(driver);


        assertEquals("Įrašas sėkmingai atnaujintas", subjectEditPage.getSuccessMessage()
                , "No success message received");
    }
}

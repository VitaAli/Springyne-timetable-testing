package it.academy.test.subjects;

import it.academy.pom.Header;
import it.academy.pom.subjects.SubjectAddPage;
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
    private SubjectAddPage subjectAddPage;
    private SubjectEditPage subjectEditPage;

    void performInitialSteps() {
        header = new Header(driver);
        subjectsPage = new SubjectsPage(driver);
        subjectAddPage = new SubjectAddPage(driver);
        subjectEditPage = new SubjectEditPage(driver);
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
        subjectsPage.pressButtonEditSubject();
    }

    @Test
    @Tag("smoke")
    @Tag("regression")
    public void subjectInformationShouldBeEditedByChangingNameAndDescription() throws InterruptedException {
        performInitialSteps();
        subjectEditPage
                .enterSubjectName("SubjectName" + generateRandomNum())
                .enterSubjectDescription("SubjectDescription" + generateRandomNum());

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        Thread.sleep(3000);

        subjectEditPage.pressButtonEditSubject();
        waitForMessageRecordUpdated(driver);

        assertEquals("Įrašas sėkmingai atnaujintas", subjectEditPage.getSuccessMessage()
                , "Teacher was not edited. All mandatory fields must be fill in");
    }

    @Test
    @Tag("smoke")
    @Tag("regression")
    public void subjectShouldBeInvalidated() throws InterruptedException {
        performInitialSteps();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        Thread.sleep(3000);

        subjectEditPage.pressButtonDelete();
        waitForMessageSubjectUpdated(driver);

        assertEquals("Įrašas sėkmingai atnaujintas", subjectEditPage.getSuccessMessage()
                , "No success message received");
    }

    @Test
    @Tag("smoke")
    @Tag("regression")
    public void invalidatedSubjectShouldBeRestored() throws InterruptedException {
        performInitialSteps();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        Thread.sleep(3000);

        subjectEditPage.pressButtonDelete();

        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        Thread.sleep(3000);

        subjectEditPage.pressButtonRestore();
        waitForMessageSubjectUpdated(driver);


        assertEquals("Įrašas sėkmingai atnaujintas", subjectEditPage.getSuccessMessage()
                , "No success message received");
    }
}

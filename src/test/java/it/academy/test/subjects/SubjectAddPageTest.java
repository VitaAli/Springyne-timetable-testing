package it.academy.test.subjects;

import it.academy.pom.Header;
import it.academy.pom.subjects.SubjectAddPage;
import it.academy.pom.subjects.SubjectsPage;
import it.academy.test.BaseTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static it.academy.utils.GenerateDataUtils.generateRandomNum;
import static it.academy.utils.WaitUtils.waitForMessageRecordIsCreated;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SubjectAddPageTest extends BaseTest {

    private Header header;
    private SubjectsPage subjectsPage;
    private SubjectAddPage subjectAddPage;

    void performInitialSteps() {
        header = new Header(driver);
        subjectsPage = new SubjectsPage(driver);
        subjectAddPage = new SubjectAddPage(driver);
        header.openSubjects();
        subjectsPage.pressButtonAddSubject();
    }

    @Test
    @Tag("smoke")
    @Tag("regression")
    public void subjectShouldBeCreatedByFillingInMandatoryFields() {
        performInitialSteps();
        subjectAddPage
                .enterSubjectName("SubjectName" + generateRandomNum())
                .enterSubjectDescription("SubjectDescription" + generateRandomNum())
                .selectModule()
                .selectRoom()
                .pressButtonAdd();
        waitForMessageRecordIsCreated(driver);

        assertEquals("Įrašas sėkmingai sukurtas", subjectAddPage.getSuccessMessage()
                , "The name, description, module and room fields are mandatory. The name must be unique");
    }

    @Test
    @Tag("regression")
    public void subjectShouldNotBeCreatedWithNoName() {
        performInitialSteps();
        subjectAddPage
                .enterSubjectDescription("SubjectDescription" + generateRandomNum())
                .selectModule()
                .selectRoom()
                .pressButtonAdd();

        assertTrue(subjectAddPage.getNameInvalidValue()
                , "User must see validation error message when he wants to create a subject with no name");
    }

    @Test
    @Tag("regression")
    public void subjectShouldNotBeCreatedWithNoRoom() {
        performInitialSteps();
        subjectAddPage
                .enterSubjectName("SubjectName" + generateRandomNum())
                .enterSubjectDescription("SubjectDescription" + generateRandomNum())
                .selectModule()
                .pressButtonAdd();

        assertTrue(subjectAddPage.getRoomInvalidValue()
                , "User must see validation error message when he wants to create a subject with no room");
    }

    @Test
    @Tag("regression")
    public void subjectShouldNotBeCreatedWithNoModule() {
        performInitialSteps();
        subjectAddPage
                .enterSubjectName("SubjectName" + generateRandomNum())
                .enterSubjectDescription("SubjectDescription" + generateRandomNum())
                .selectRoom()
                .pressButtonAdd();

        assertTrue(subjectAddPage.getModuleInvalidValue()
                , "User must see validation error message when he wants to create a subject with no module");
    }
}

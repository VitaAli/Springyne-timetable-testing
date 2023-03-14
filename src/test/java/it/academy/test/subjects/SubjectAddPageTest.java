package it.academy.test.subjects;

import it.academy.pom.Header;
import it.academy.pom.subjects.SubjectAddPage;
import it.academy.pom.subjects.SubjectsPage;
import it.academy.test.BaseTest;
import org.junit.jupiter.api.Test;

import static it.academy.utils.GenerateDataUtils.generateRandomName;
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
    public void subjectShouldBeCreatedByFillingInMandatoryFields() {
        performInitialSteps();
        subjectAddPage.enterSubjectName(generateRandomName());
        subjectAddPage.enterSubjectDescription("description");
        subjectAddPage.selectModule();
        subjectAddPage.selectRoom();
        subjectAddPage.pressButtonAdd();
        waitForMessageRecordIsCreated(driver);

        assertEquals("Įrašas sėkmingai sukurtas", subjectAddPage.getSuccessMessage()
                , "The name, description, module and room fields are mandatory. The name must be unique");
    }

    @Test
    public void subjectShouldNotBeCreatedWithNoName() {
        performInitialSteps();
        subjectAddPage.enterSubjectDescription("description");
        subjectAddPage.selectModule();
        subjectAddPage.selectRoom();
        subjectAddPage.pressButtonAdd();

        assertTrue(subjectAddPage.getNameInvalidValue()
                , "User must see validation error message when he wants to create a subject with no name");
    }

    @Test
    public void subjectShouldNotBeCreatedWithNoRoom() {
        performInitialSteps();
        subjectAddPage.enterSubjectName(generateRandomName());
        subjectAddPage.enterSubjectDescription("description");
        subjectAddPage.selectModule();
        subjectAddPage.pressButtonAdd();

        assertTrue(subjectAddPage.getRoomInvalidValue()
                , "User must see validation error message when he wants to create a subject with no room");
    }

    @Test
    public void subjectShouldNotBeCreatedWithNoModule() {
        performInitialSteps();
        subjectAddPage.enterSubjectName(generateRandomName());
        subjectAddPage.enterSubjectDescription("description");
        subjectAddPage.selectRoom();
        subjectAddPage.pressButtonAdd();

        assertTrue(subjectAddPage.getModuleInvalidValue()
                , "User must see validation error message when he wants to create a subject with no module");
    }
}

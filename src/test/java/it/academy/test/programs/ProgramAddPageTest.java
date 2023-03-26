package it.academy.test.programs;

import it.academy.pom.Header;
import it.academy.pom.programs.ProgramAddPage;
import it.academy.pom.programs.ProgramsPage;
import it.academy.test.BaseTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static it.academy.utils.GenerateDataUtils.generateRandomNum;
import static it.academy.utils.WaitUtils.waitForMessageRecordIsCreated;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProgramAddPageTest extends BaseTest {

    private Header header;
    private ProgramsPage programsPage;
    private ProgramAddPage programAddPage;

    public void performInitialSteps() {
        header = new Header(driver);
        programsPage = new ProgramsPage(driver);
        programAddPage = new ProgramAddPage(driver);
        header.openPrograms();
        programsPage.pressButtonAddProgram();
    }

    @Test
    @Tag("smoke")
    @Tag("regression")
    public void programShouldBeAddedByEnteringMandatoryFields() {
        performInitialSteps();
        programAddPage
                .enterProgramName("ProgramName" + generateRandomNum())
                .enterProgramDescription("ProgramDescription" + generateRandomNum())
                .enterSubjectHours("20")
                .selectSubject()
                .pressButtonAdd();
        waitForMessageRecordIsCreated(driver);

        assertEquals("Įrašas sėkmingai sukurtas", programAddPage.getSuccessMessage()
                , "All mandatory fields must be filled in when creating a record");
    }
}

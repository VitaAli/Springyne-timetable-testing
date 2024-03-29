package it.academy.test.teachers;

import it.academy.pom.Header;
import it.academy.pom.teachers.TeachersPage;
import it.academy.test.BaseTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.List;

import static it.academy.utils.WaitUtils.waitForMessageRecordsAreFound;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TeachersPageTest extends BaseTest {

    private Header header;
    private TeachersPage teachersPage;

    void performInitialSteps() {
        header = new Header(driver);
        teachersPage = new TeachersPage(driver);
        header.openTeachers();
    }

    @Test
    @Tag("smoke")
    @Tag("regression")
    public void teachersShouldBeFilteredByName() {
        performInitialSteps();
        teachersPage.pressButtonSearch();
        List<String> results = teachersPage.getNamesFromTeacherList();
        String result = teachersPage.getFirstNameFromTeacherList();
        teachersPage.searchTeacherByName(result);
        teachersPage.pressButtonSearch();
        waitForMessageRecordsAreFound(driver);

        assertTrue(results.contains(result)
                , "The teacher list should be filtered by the teacher name");
    }
}

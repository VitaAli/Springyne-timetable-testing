package it.academy.test.modules;

import it.academy.pom.Header;
import it.academy.pom.modules.ModulesPage;
import it.academy.test.BaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.List;

import static it.academy.utils.WaitUtils.waitForMessageRecordsAreFound;
import static it.academy.utils.WaitUtils.waitForMessageNoRecordsFound;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ModulesPageTest extends BaseTest {

    private Header header;
    private ModulesPage modulesPage;

    void performInitialSteps() {
        header = new Header(driver);
        modulesPage = new ModulesPage(driver);
        header.openModules();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/ModuleTestData1.txt")
    public void modulesShouldBeFilteredByName(String valueFromFile) {
        performInitialSteps();
        modulesPage.searchModuleByName(valueFromFile);
        modulesPage.pressButtonSearch();
        waitForMessageRecordsAreFound(driver);

        assertTrue(modulesPage.getModuleNames().contains(valueFromFile)
                , "The list should be filtered by the value");
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/ModuleTestData2.txt")
    public void modulesShouldBeFilteredByPartialName(String valueFromFile) {
        performInitialSteps();
        List<String> modules = modulesPage.getPartialModuleNames();
        modulesPage.searchModuleByName(valueFromFile);
        modulesPage.pressButtonSearch();
        waitForMessageRecordsAreFound(driver);

        assertTrue(modules.contains(valueFromFile)
                , "The list should be filtered by the value");
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/ModuleTestData3.txt")
    public void modulesShouldNotBeFound(String valueFromFile) {
        performInitialSteps();
        modulesPage.searchModuleByName(valueFromFile);
        modulesPage.pressButtonSearch();
        waitForMessageNoRecordsFound(driver);

        assertEquals("Įrašų nerasta", modulesPage.getTextOfMessageNoRecords()
                , "Modules cannot be filtered by random words or symbols");
    }

}

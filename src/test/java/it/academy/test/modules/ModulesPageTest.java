package it.academy.test.modules;

import it.academy.pom.Header;
import it.academy.pom.modules.ModuleAddPage;
import it.academy.pom.modules.ModuleEditPage;
import it.academy.pom.modules.ModulesPage;
import it.academy.test.BaseTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.List;

import static it.academy.utils.GenerateDataUtils.generateRandomNum;
import static it.academy.utils.WaitUtils.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ModulesPageTest extends BaseTest {

    private Header header;
    private ModulesPage modulesPage;
    private ModuleAddPage moduleAddPage;
    private ModuleEditPage moduleEditPage;

    void performInitialSteps() {
        header = new Header(driver);
        modulesPage = new ModulesPage(driver);
        moduleAddPage = new ModuleAddPage(driver);
        moduleEditPage = new ModuleEditPage(driver);
        header.openModules();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/ModuleTestData1.txt")
    @Tag("smoke")
    @Tag("regression")
    public void modulesShouldBeFilteredByName(String valueFromFile) {
        performInitialSteps();
        List<String> modules = modulesPage.getModuleNames();
        modulesPage
                .searchModuleByName(valueFromFile)
                .pressButtonSearch();
        waitForMessageRecordsAreFound(driver);

        assertTrue(modules.contains(valueFromFile)
                , "The list should be filtered by the name");
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/ModuleTestData2.txt")
    @Tag("regression")
    public void modulesShouldBeFilteredByPartialName(String valueFromFile) {
        performInitialSteps();
        List<String> modules = modulesPage.getPartialModuleNames();
        modulesPage
                .searchModuleByName(valueFromFile)
                .pressButtonSearch();
        waitForMessageRecordsAreFound(driver);

        assertTrue(modules.contains(valueFromFile)
                , "The list should be filtered by the partial name");
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/ModuleTestData3.txt")
    @Tag("regression")
    public void modulesShouldNotBeFound(String valueFromFile) {
        performInitialSteps();
        modulesPage
                .pressButtonSearch()
                .searchModuleByName(valueFromFile)
                .pressButtonSearch();
        waitForMessageNoRecordsFound(driver);

        assertEquals("Įrašų nerasta", modulesPage.getTextOfMessageNoRecords()
                , "Modules cannot be filtered by random words or symbols");
    }

    @Test
    @Tag("smoke")
    @Tag("regression")
    public void moduleShouldBeInvalidated() {
        performInitialSteps();
        String moduleName = "ModuleName" + generateRandomNum();
        modulesPage.pressButtonAdd();
        moduleAddPage
                .enterModuleNumber("ModuleNumber" + generateRandomNum())
                .enterModuleName(moduleName)
                .pressButtonAdd();
        header
                .openModules();
        modulesPage
                .pressButtonSearch()
                .searchModuleByName(moduleName)
                .pressButtonSearch();
        waitForMessageRecordsAreFound(driver);
        modulesPage.pressButtonDelete();
        waitForMessageRecordDeleted(driver);

        assertEquals("Ištrintas", modulesPage.getLastModuleState()
                , "Module is not deleted and has no state");
    }

}

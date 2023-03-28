package it.academy.test.modules;

import it.academy.pom.Header;
import it.academy.pom.modules.ModuleAddPage;
import it.academy.pom.modules.ModulesPage;
import it.academy.test.BaseTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static it.academy.utils.GenerateDataUtils.generateRandomNum;
import static it.academy.utils.WaitUtils.waitForMessageRecordIsCreated;
import static it.academy.utils.WaitUtils.waitForMessageRecordIsNotCreated;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ModuleAddPageTest extends BaseTest {

    private Header header;
    private ModulesPage modulesPage;
    private ModuleAddPage moduleAddPage;

    void performInitialSteps() {
        header = new Header(driver);
        modulesPage = new ModulesPage(driver);
        moduleAddPage = new ModuleAddPage(driver);
        header.openModules();
        modulesPage.pressButtonAdd();
    }

    @Test
    @Tag("smoke")
    @Tag("regression")
    public void moduleShouldBeCreatedWithUniqueNumberAndAnyName() {
        performInitialSteps();
        moduleAddPage
                .enterModuleNumber("ModuleNumber" + generateRandomNum())
                .enterModuleName("ModuleName" + generateRandomNum())
                .pressButtonAdd();

        waitForMessageRecordIsCreated(driver);
        assertEquals("Įrašas sėkmingai sukurtas", moduleAddPage.getSuccessMessage()
                , "The number and name fields are mandatory. The number must be unique");
    }

    @Test
    @Tag("regression")
    public void moduleShouldNotBeCreatedWithNonUniqueNumberAndNoName() {
        performInitialSteps();
        moduleAddPage
                .enterModuleNumber("ModuleNumber" + generateRandomNum())
                .enterModuleName("")
                .pressButtonAdd();

        assertTrue(moduleAddPage.getNameInvalidValue()
                , "User must see validation error message when he wants to create a module with no name");
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/ModuleAddTestData.txt")
    @Tag("regression")
    public void moduleShouldNotBeCreatedWithNoNumberAndAnyName(String valueFromFile) {
        performInitialSteps();
        moduleAddPage
                .enterModuleNumber("")
                .enterModuleName(valueFromFile)
                .pressButtonAdd();

        assertTrue(moduleAddPage.getNumberInvalidValue()
                , "User must see validation error message when he wants to create a module with no number");
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/ModuleAddTestData.txt")
    @Tag("regression")
    public void moduleShouldNotBeCreatedWithNonUniqueNumberAndAnyName(String valueFromFile) {
        performInitialSteps();
        moduleAddPage
                .enterModuleNumber("001")
                .enterModuleName(valueFromFile)
                .pressButtonAdd();

        waitForMessageRecordIsNotCreated(driver);
        assertEquals("Įrašo nepavyko sukurti", moduleAddPage.getErrorMessage()
                , "The module number must be unique");
    }
}

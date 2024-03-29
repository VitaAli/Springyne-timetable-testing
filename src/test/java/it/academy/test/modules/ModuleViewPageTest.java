package it.academy.test.modules;

import it.academy.pom.Header;
import it.academy.pom.modules.ModuleAddPage;
import it.academy.pom.modules.ModuleViewPage;
import it.academy.pom.modules.ModulesPage;
import it.academy.test.BaseTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static it.academy.utils.GenerateDataUtils.generateRandomNum;
import static it.academy.utils.WaitUtils.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ModuleViewPageTest extends BaseTest {

    private Header header;
    private ModulesPage modulesPage;
    private ModuleAddPage moduleAddPage;
    private ModuleViewPage moduleViewPage;

    void performInitialSteps() {
        header = new Header(driver);
        modulesPage = new ModulesPage(driver);
        moduleAddPage = new ModuleAddPage(driver);
        moduleViewPage = new ModuleViewPage(driver);
        header.openModules();
        String moduleName = "ModuleName" + generateRandomNum();
        modulesPage.pressButtonAdd();
        moduleAddPage
                .enterModuleNumber("ModuleNumber" + generateRandomNum())
                .enterModuleName(moduleName)
                .pressButtonAdd();
        header.openModules();
        modulesPage.pressButtonSearch();
        modulesPage.searchModuleByName(moduleName);
        modulesPage.pressButtonSearch();
        waitForMessageRecordsAreFound(driver);
        modulesPage.pressButtonView();
    }

    @Test
    @Tag("smoke")
    @Tag("regression")
    public void moduleShouldBeInvalidated() {
        performInitialSteps();
        moduleViewPage.pressButtonDelete();
        waitForMessageRecordDeleted(driver);

        assertEquals("Įrašas sėkmingai ištrintas", moduleViewPage.getSuccessMessageAfterDeletion()
                , "No success message received after module deletion");
    }

    @Test
    @Tag("smoke")
    @Tag("regression")
    public void invalidatedModuleShouldBeRestored() {
        performInitialSteps();
        moduleViewPage.pressButtonDelete();
        waitUntilRestoreButtonAppears(driver);
        moduleViewPage.pressButtonRestore();
        waitForMessageRecordRestored(driver);

        assertEquals("Įrašas sėkmingai atstatytas", moduleViewPage.getSuccessMessageAfterRestore()
                , "No success message received");

    }
}

package it.academy.test.modules;

import it.academy.pom.Header;
import it.academy.pom.modules.ModuleViewPage;
import it.academy.pom.modules.ModulesPage;
import it.academy.test.BaseTest;
import org.junit.jupiter.api.Test;

import static it.academy.utils.WaitUtils.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ModuleViewPageTest extends BaseTest {

    private Header header;
    private ModulesPage modulesPage;
    private ModuleViewPage moduleViewPage;

    void performInitialSteps() {
        header = new Header(driver);
        modulesPage = new ModulesPage(driver);
        moduleViewPage = new ModuleViewPage(driver);
        header.openModules();
        modulesPage.pressButtonView();
    }

    @Test
    public void moduleShouldBeInvalidated() {
        performInitialSteps();
        moduleViewPage.pressButtonDelete();
        waitForMessageModuleDeleted(driver);

        assertEquals("Įrašas sėkmingai ištrintas", moduleViewPage.getSuccessMessageAfterDeletion()
                , "No success message received after module deletion");
    }

    @Test
    public void invalidatedModuleShouldBeRestored() {
        performInitialSteps();
        moduleViewPage.pressButtonDelete();
        waitUntilRestoreButtonAppears(driver);
        moduleViewPage.pressButtonRestore();
        waitForMessageModuleRestored(driver);

        assertEquals("Įrašas sėkmingai atstatytas", moduleViewPage.getSuccessMessageAfterReset()
                , "No success message received");

    }
}

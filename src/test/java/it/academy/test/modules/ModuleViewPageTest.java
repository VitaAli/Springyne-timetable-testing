package it.academy.test.modules;

import it.academy.pom.Header;
import it.academy.pom.modules.ModuleViewPage;
import it.academy.pom.modules.ModulesPage;
import it.academy.test.BaseTest;
import it.academy.utils.WaitUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
        WaitUtils.waitForSuccessMessage(driver);

        String expectedMessage = "Įrašas sėkmingai ištrintas";
        String actualMessage = moduleViewPage.getSuccessMessageAfterDeletion();

        Assertions.assertEquals(expectedMessage, actualMessage
                , "No success message received after module deletion");
    }

    @Test
    public void invalidatedModuleShouldBeRestored() {
        performInitialSteps();
        moduleViewPage.pressButtonDelete();
        WaitUtils.waitUntilRestoreButtonAppears(driver);
        moduleViewPage.pressButtonRestore();
        WaitUtils.waitForErrorMessage(driver);

        String expectedMessage = "Įrašas sėkmingai atstatytas";
        String actualMessage = moduleViewPage.getSuccessMessageAfterReset();

        Assertions.assertEquals(expectedMessage, actualMessage
                , "No success message received");

    }
}

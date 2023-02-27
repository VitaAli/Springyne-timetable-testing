package it.academy.test.modules;

import it.academy.pom.Header;
import it.academy.pom.modules.ModuleViewPage;
import it.academy.pom.modules.ModulesPage;
import it.academy.test.BaseTest;
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
    public void moduleShouldBeInvalidated() throws InterruptedException {
        performInitialSteps();
        moduleViewPage.pressButtonDelete();

        Thread.sleep(3000);

        String expectedMessage = "Įrašas sėkmingai ištrintas";
        String actualMessage = moduleViewPage.getSuccessMessageAfterDeletion();

        Assertions.assertEquals(expectedMessage, actualMessage
                , "No success message received");
    }

    @Test
    public void invalidatedModuleShouldBeRestored() throws InterruptedException {
        performInitialSteps();
        moduleViewPage.pressButtonDelete();
        Thread.sleep(3000);
        moduleViewPage.pressButtonRestore();
        Thread.sleep(3000);

        String expectedMessage = "Įrašas sėkmingai atstatytas";
        String actualMessage = moduleViewPage.getSuccessMessageAfterReset();

        Assertions.assertEquals(expectedMessage, actualMessage
                , "No success message received");

    }
}

package it.academy.test.modules;

import it.academy.pom.Header;
import it.academy.pom.modules.ModuleEditPage;
import it.academy.pom.modules.ModulesPage;
import it.academy.test.BaseTest;
import it.academy.utils.WaitUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ModuleEditPageTest extends BaseTest {

    private Header header;
    private ModulesPage modulesPage;
    private ModuleEditPage moduleEditPage;

    void performInitialSteps() {
        header = new Header(driver);
        modulesPage = new ModulesPage(driver);
        moduleEditPage = new ModuleEditPage(driver);
        header.openModules();
        modulesPage.pressButtonEdit();
    }

    @Test
    public void moduleNumberAndNameShouldBeEdited() {
        performInitialSteps();
        moduleEditPage.enterNumber("008");
        moduleEditPage.enterName("name");
        moduleEditPage.pressButtonEdit();

        WaitUtils.waitForMessageModuleUpdated(driver);
        Assertions.assertEquals("Įrašas sėkmingai atnaujintas"
                , moduleEditPage.getSuccessMessage()
                , "The number and name fields are mandatory. The number must be unique");
    }

    @Test
    public void moduleShouldBeInvalidated() {
        performInitialSteps();
        moduleEditPage.pressButtonDelete();

        WaitUtils.waitForMessageModuleUpdated(driver);
        Assertions.assertEquals("Įrašas sėkmingai atnaujintas"
                , moduleEditPage.getSuccessMessage()
                , "No success message received");
    }

    @Test
    public void moduleShouldBeRestored() {
        performInitialSteps();
        moduleEditPage.pressButtonDelete();
        WaitUtils.waitUntilRestoreButtonAppears(driver);
        moduleEditPage.pressButtonRestore();

        WaitUtils.waitForMessageModuleUpdated(driver);
        Assertions.assertEquals("Įrašas sėkmingai atnaujintas"
                , moduleEditPage.getSuccessMessage()
                , "No success message received");
    }

}

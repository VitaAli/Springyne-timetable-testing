package it.academy.test.modules;

import it.academy.pom.Header;
import it.academy.pom.modules.ModuleEditPage;
import it.academy.pom.modules.ModulesPage;
import it.academy.test.BaseTest;
import it.academy.utils.WaitUtils;
import org.junit.jupiter.api.Test;

import static it.academy.utils.GenerateDataUtils.generateRandomModuleName;
import static it.academy.utils.GenerateDataUtils.generateRandomModuleNumber;
import static it.academy.utils.WaitUtils.waitForMessageModuleUpdated;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
        moduleEditPage.clearAndFillNewNumber(generateRandomModuleNumber());
        moduleEditPage.clearAndFillNewName(generateRandomModuleName());
        moduleEditPage.pressButtonEdit();
        waitForMessageModuleUpdated(driver);

        assertEquals("Įrašas sėkmingai atnaujintas", moduleEditPage.getSuccessMessage()
                , "The number and name fields are mandatory. The number must be unique");
    }

    @Test
    public void moduleShouldBeRestoredAfterDeletion() {
        performInitialSteps();
        moduleEditPage.pressButtonDelete();
        WaitUtils.waitUntilRestoreButtonAppears(driver);
        moduleEditPage.pressButtonRestore();
        waitForMessageModuleUpdated(driver);

        assertEquals("Įrašas sėkmingai atnaujintas", moduleEditPage.getSuccessMessage()
                , "No success message received");
    }

}

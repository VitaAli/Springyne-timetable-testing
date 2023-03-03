package it.academy.test.modules;

import it.academy.pom.Header;
import it.academy.pom.modules.ModuleEditPage;
import it.academy.pom.modules.ModulesPage;
import it.academy.test.BaseTest;
import it.academy.utils.WaitUtils;
import org.junit.jupiter.api.Test;

import static it.academy.utils.GenerateDataUtils.generateRandomName;
import static it.academy.utils.GenerateDataUtils.generateRandomNumber;
import static it.academy.utils.WaitUtils.waitForMessageModuleUpdated;
import static it.academy.utils.WaitUtils.waitUntilRestoreButtonAppears;
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
        moduleEditPage.enterNumber(generateRandomNumber());
        moduleEditPage.enterName(generateRandomName());
        moduleEditPage.pressButtonEdit();
        waitForMessageModuleUpdated(driver);

        assertEquals("Įrašas sėkmingai atnaujintas", moduleEditPage.getSuccessMessage()
                , "The number and name fields are mandatory. The number must be unique");
    }

    @Test
    public void moduleShouldBeRestoredAfterDeletion() {
        performInitialSteps();
        moduleEditPage.pressButtonDelete();
        waitUntilRestoreButtonAppears(driver);
        moduleEditPage.pressButtonRestore();
        waitForMessageModuleUpdated(driver);

        assertEquals("Įrašas sėkmingai atnaujintas", moduleEditPage.getSuccessMessage()
                , "No success message received");
    }

}

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
        moduleEditPage.enterNumber("010");
        moduleEditPage.enterName("name");
        moduleEditPage.pressButtonEdit();
        WaitUtils.waitMessageRecordSuccessfullyCreated(driver, 10);

        String expectedMessage = "Įrašas sėkmingai atnaujintas";
        String actualMessage = moduleEditPage.getSuccessMessage();

        Assertions.assertEquals(expectedMessage, actualMessage
                , "The number and name fields are mandatory. The number must be unique");
    }

    @Test
    public void moduleShouldBeInvalidated() {
        performInitialSteps();
        moduleEditPage.pressButtonDelete();
        WaitUtils.waitMessageRecordSuccessfullyCreated(driver, 10);

        String expectedMessage = "Įrašas sėkmingai atnaujintas";
        String actualMessage = moduleEditPage.getSuccessMessage();

        Assertions.assertEquals(expectedMessage, actualMessage
                , "No success message received");
    }

    @Test
    public void moduleShouldBeRestored() {
        performInitialSteps();
        moduleEditPage.pressButtonDelete();
        WaitUtils.waitUntilRestoreButtonAppears(driver, 10);
        moduleEditPage.pressButtonRestore();

        String expectedMessage = "Įrašas sėkmingai atnaujintas";
        String actualMessage = moduleEditPage.getSuccessMessage();

        Assertions.assertEquals(expectedMessage, actualMessage
                , "No success message received");
    }

}

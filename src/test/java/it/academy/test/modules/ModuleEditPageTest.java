package it.academy.test.modules;

import it.academy.pom.Header;
import it.academy.pom.modules.ModuleAddPage;
import it.academy.pom.modules.ModuleEditPage;
import it.academy.pom.modules.ModulesPage;
import it.academy.test.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ModuleEditPageTest extends BaseTest {

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
        modulesPage.pressButtonEdit();
    }

    @Test
    public void moduleNumberAndNameShouldBeEdited() throws InterruptedException {
        performInitialSteps();
        moduleEditPage.enterNumber("008");
        moduleEditPage.enterName("name");
        moduleEditPage.pressButtonEdit();
//        thread.sleep is used for some time until we fix the explicit wait:
        Thread.sleep(3000);
        String expectedMessage = "Įrašas sėkmingai atnaujintas";
        String actualMessage = moduleEditPage.getSuccessMessage();

        Assertions.assertEquals(expectedMessage, actualMessage
                , "The number and name fields are mandatory. The number must be unique");
    }

    @Test
    public void moduleShouldBeInvalidated() throws InterruptedException {
        performInitialSteps();
        moduleEditPage.pressButtonDelete();
        String expectedMessage = "Įrašas sėkmingai atnaujintas";
        String actualMessage = moduleEditPage.getSuccessMessage();
//        thread.sleep is used for some time until we fix the explicit wait:
        Thread.sleep(3000);
        Assertions.assertEquals(expectedMessage, actualMessage
                , "No success message received");
    }

    @Test
    public void moduleShouldBeRestored() throws InterruptedException {
        performInitialSteps();
        moduleEditPage.pressButtonDelete();
//        thread.sleep is used for some time until we fix the explicit wait:
        Thread.sleep(3000);
        moduleEditPage.pressButtonRestore();

        String expectedMessage = "Įrašas sėkmingai atnaujintas";
        String actualMessage = moduleEditPage.getSuccessMessage();

        Assertions.assertEquals(expectedMessage, actualMessage
                , "No success message received");
    }




}

package it.academy.test.modules;

import it.academy.pom.Header;
import it.academy.pom.modules.ModuleAddPage;
import it.academy.pom.modules.ModulesPage;
import it.academy.test.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
    public void moduleShouldBeCreatedWithUniqueNumberAndAnyName() throws InterruptedException {

        performInitialSteps();
        moduleAddPage.enterNumber("008");
        moduleAddPage.enterName("name");
        moduleAddPage.pressButtonAdd();

        Thread.sleep(3000);

        String expectedMessage = "Įrašas sėkmingai sukurtas";
        String actualMessage = moduleAddPage.getSuccessMessage();

        Assertions.assertEquals(expectedMessage, actualMessage
                , "The number and name fields are mandatory. The number must be unique");
    }

    @Test
    public void moduleShouldNotBeCreatedWithUniqueNumberAndNoName() {
        performInitialSteps();
        moduleAddPage.enterNumber("007");
        moduleAddPage.enterName("");
        moduleAddPage.pressButtonAdd();

        Assertions.assertTrue(moduleAddPage.getNameInvalidValue()
                , "The module name is mandatory for adding a new module");
    }

    @Test
    public void moduleShouldNotBeCreatedWithNoNumberAndAnyName() {
        performInitialSteps();
        moduleAddPage.enterNumber("");
        moduleAddPage.enterName("name");
        moduleAddPage.pressButtonAdd();

        Assertions.assertTrue(moduleAddPage.getNumberInvalidValue()
                , "The module number is mandatory for adding a new module");
    }

    @Test
    public void moduleShouldNotBeCreatedWithNonUniqueNumberAndAnyName() throws InterruptedException {
        performInitialSteps();
        moduleAddPage.enterNumber("001");
        moduleAddPage.enterName("name");
        moduleAddPage.pressButtonAdd();

        Thread.sleep(3000);

        String expectedMessage = "Įrašo nepavyko sukurti";
        String actualMessage = moduleAddPage.getErrorMessage();

        Assertions.assertEquals(expectedMessage, actualMessage, "The module number must be unique");
    }
}

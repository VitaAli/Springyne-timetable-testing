package it.academy.test.modules;

import it.academy.pom.Header;
import it.academy.pom.modules.ModuleAdd;
import it.academy.pom.modules.ModulesPage;
import it.academy.test.BaseTest;
import it.academy.utils.WaitUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ModuleAddTest extends BaseTest {

    private Header header;
    private ModulesPage modulesPage;
    private ModuleAdd moduleAdd;

    @Test
    public void moduleCanBeCreatedWithUniqueNumberAndAnyName() throws InterruptedException {
        header = new Header(driver);
        modulesPage = new ModulesPage(driver);
        moduleAdd = new ModuleAdd(driver);

        header.openModules();
        modulesPage.pressButtonAdd();
        moduleAdd.enterNumber("1");
        moduleAdd.enterName("name");
        moduleAdd.pressButtonAdd();
//        is used for some time until we fix the explicit wait:
        Thread.sleep(3000);
        String expectedMessage = "Įrašas sėkmingai sukurtas";
        String actualMessage = moduleAdd.getSuccessMessage();

        Assertions.assertEquals(expectedMessage, actualMessage
                , "The number and name fields are mandatory. The number must be unique");

    }
}

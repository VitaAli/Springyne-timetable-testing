package it.academy.test.modules;

import it.academy.pom.Header;
import it.academy.pom.modules.ModuleAdd;
import it.academy.pom.modules.ModulesPage;
import it.academy.test.BaseTest;
import org.junit.jupiter.api.Test;

import static it.academy.test.BaseTest.driver;

public class ModuleAddTest extends BaseTest {

    private Header header;
    private ModulesPage modulesPage;
    private ModuleAdd moduleAdd;

    @Test
    public void moduleCanBeAdded() {
        header = new Header(driver);
        modulesPage = new ModulesPage(driver);
        moduleAdd = new ModuleAdd(driver);

        header.openModules();
        modulesPage.pressButtonAdd();

    }
}

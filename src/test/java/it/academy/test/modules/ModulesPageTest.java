package it.academy.test.modules;

import it.academy.pom.Header;
import it.academy.pom.modules.ModulesPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static it.academy.test.BaseTest.driver;

public class ModulesPageTest {

    private Header header;
    private ModulesPage modulesPage;

    @Test
    public void modulesCanBeFilteredByModuleName() {

        header = new Header(driver);
        modulesPage = new ModulesPage(driver);

        header.openModules();
        modulesPage.searchModuleByName("Informacinių sistemų projektavimas");
        modulesPage.pressButtonEnter();

        Assertions.assertTrue(modulesPage.getModulesList().contains("Informacinių sistemų projektavimas"));

    }
}

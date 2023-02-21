package it.academy.test.modules;

import it.academy.pom.Header;
import it.academy.pom.modules.ModulesPage;

import static it.academy.test.BaseTest.driver;

public class ModulesPageTest {

    private Header header;
    private ModulesPage moduleListPage;

    public void modulesCanBeFilteredByModuleName() {

        header = new Header(driver);
        moduleListPage = new ModulesPage(driver);

        header.openModules();
        moduleListPage.searchModuleByName("Test name1");
        moduleListPage.pressButtonEnter();


    }
}

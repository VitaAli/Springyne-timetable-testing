package it.academy.test.module;

import it.academy.pom.Header;
import it.academy.pom.module.ModuleListPage;

import static it.academy.test.BaseTest.driver;

public class ModuleListPageTest {

    private Header header;
    private ModuleListPage moduleListPage;

    public void modulesCanBeFilteredByModuleName() {

        header = new Header(driver);
        moduleListPage = new ModuleListPage(driver);

        header.selectModuleListFromNavbar();
        moduleListPage.searchModuleByName("Test name1");
        moduleListPage.pressButtonEnter();


    }
}

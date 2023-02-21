package it.academy.test;

import it.academy.pom.Header;
import it.academy.pom.ModuleListPage;
import org.junit.jupiter.api.Assertions;

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

        //Inga, žemiau pakartotas kodas ištestuoti merge į main šaką:
        moduleListPage.pressButtonEnter();

    }
}

package it.academy.test.modules;

import it.academy.pom.Header;
import it.academy.pom.modules.ModulesPage;
import it.academy.test.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;

public class ModulesPageTest extends BaseTest {

    private Header header;
    private ModulesPage modulesPage;

    @Test
    public void modulesCanBeFilteredByModuleName() {

        header = new Header(driver);
        modulesPage = new ModulesPage(driver);

        header.openModules();
        modulesPage.searchModuleByName("Informacinių sistemų projektavimas");
        modulesPage.pressButtonSearch();

        Assertions.assertTrue(modulesPage.getModuleNames().contains("Informacinių sistemų projektavimas")
                , "The searched module was not found in the list of modules");

    }

    @Test
    public void modulesCanBeFilteredByPartialModuleName() {

        header = new Header(driver);
        modulesPage = new ModulesPage(driver);

        header.openModules();
        modulesPage.searchModuleByName("Informacinių");
        modulesPage.pressButtonSearch();

        Assertions.assertTrue(modulesPage.getFirstWordsOfModuleNames().contains("Informacinių")
                , "The searched module was not found in the list of modules");
    }

    @Test
    public void modulesCannotBeFilteredByRandomWord() {

        header = new Header(driver);
        modulesPage = new ModulesPage(driver);

        header.openModules();
        modulesPage.searchModuleByName("random");
        modulesPage.pressButtonSearch();

        Assertions.assertEquals("Įrašų nerasta", modulesPage.getTextOfMessageNoRecords()
                , "Either the message is not displayed or no results were found");
    }

    @Test
    public void moduleListCanBeDisplayedBy10EntriesPerPage() {

        header = new Header(driver);
        modulesPage = new ModulesPage(driver);

        header.openModules();
        modulesPage.selectPageSize10();

        Assertions.assertEquals(10, modulesPage.getModulesListSize()
                , "There are more or less results than selected to display on the page, or no results found");
    }


}

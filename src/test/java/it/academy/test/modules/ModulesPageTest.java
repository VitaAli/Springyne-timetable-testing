package it.academy.test.modules;

import it.academy.pom.Header;
import it.academy.pom.modules.ModulesPage;
import it.academy.test.BaseTest;
import it.academy.utils.WaitUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class ModulesPageTest extends BaseTest {

    private Header header;
    private ModulesPage modulesPage;

    @ParameterizedTest
    @CsvFileSource(resources = "/TestData1.txt")
    public void modulesCanBeFilteredByName(String valueFromFile) {

        header = new Header(driver);
        modulesPage = new ModulesPage(driver);

        header.openModules();
        modulesPage.searchModuleByName(valueFromFile);
        modulesPage.pressButtonSearch();

        Assertions.assertTrue(modulesPage.getModuleNames().contains(valueFromFile)
                , "The list should be filtered by the value");
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/TestData2.txt")
    public void modulesCanBeFilteredByPartialName(String valueFromFile) {

        header = new Header(driver);
        modulesPage = new ModulesPage(driver);

        header.openModules();
        modulesPage.searchModuleByName(valueFromFile);
        modulesPage.pressButtonSearch();

        Assertions.assertTrue(modulesPage.getFirstWordsOfModuleNames().contains(valueFromFile)
                , "The list should be filtered by the value");
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/TestData3.txt")
    public void modulesCannotBeFound(String valueFromFile) {

        WaitUtils.waitCertainTime(driver);

        header = new Header(driver);
        modulesPage = new ModulesPage(driver);

        header.openModules();
        modulesPage.searchModuleByName(valueFromFile);
        modulesPage.pressButtonSearch();

        Assertions.assertEquals("Įrašų nerasta", modulesPage.getTextOfMessageNoRecords()
                , "Modules cannot be filtered by random words or symbols");
    }

//    @Test
//    public void moduleListCanBeDisplayedBy10EntriesPerPage() throws InterruptedException {
//
//        header = new Header(driver);
//        modulesPage = new ModulesPage(driver);
//
//        header.openModules();
//        modulesPage.selectPageSize10();
//
//        Assertions.assertEquals(10, modulesPage.getModulesListSize()
//                , "There are more or less results than selected to display on the page, or no results found");
//    }

}

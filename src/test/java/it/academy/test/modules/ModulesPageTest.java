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
    @CsvFileSource(resources = "/TestData.txt")
    public void modulesAreFilteredBy(String valueFromFile) {

        header = new Header(driver);
        modulesPage = new ModulesPage(driver);

        header.openModules();
        modulesPage.searchModuleByName(valueFromFile);
        modulesPage.pressButtonSearch();


        Assertions.assertTrue(modulesPage.getModuleNames().contains(valueFromFile)
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

    @ParameterizedTest
    @CsvFileSource(resources = "/TestData.txt")
    public void modulesCannotBeFilteredByRandomAndSymbols(String valueFromFile) {

        WaitUtils.waitCertainTime(driver);

        header = new Header(driver);
        modulesPage = new ModulesPage(driver);

        header.openModules();
        modulesPage.searchModuleByName(valueFromFile);
        modulesPage.pressButtonSearch();
        Assertions.assertEquals("Įrašų nerasta", modulesPage.getTextOfMessageNoRecords()
                , "Modules cannot be filtered by random words/symbols");
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

    //kokiais atvejais gauname tą patį rezultatą
    //Įrašų nerasta jei norim patikrinti, ar tikrai įrašų nerasta, jei įvedame params:
    // neegzistuojantį pavadinimą, simbolių seką, skaičių seką
    //gauname listą ir jame contains params(partial name, number related to name, symbol related to name)


}

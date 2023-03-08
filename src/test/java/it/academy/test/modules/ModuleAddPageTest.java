package it.academy.test.modules;

import it.academy.pom.Header;
import it.academy.pom.modules.ModuleAddPage;
import it.academy.pom.modules.ModulesPage;
import it.academy.test.BaseTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static it.academy.utils.GenerateDataUtils.generateRandomNumber;
import static it.academy.utils.WaitUtils.waitForMessageRecordIsCreated;
import static it.academy.utils.WaitUtils.waitForMessageRecordIsNotCreated;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

    @ParameterizedTest
    @CsvFileSource(resources = "/ModuleAddTestData.txt")
    public void moduleShouldBeCreatedWithUniqueNumberAndAnyName(String valueFromFile) {
        performInitialSteps();
        moduleAddPage.enterNumber(generateRandomNumber());
        moduleAddPage.enterName(valueFromFile);
        moduleAddPage.pressButtonAdd();

        waitForMessageRecordIsCreated(driver);
        assertEquals("Įrašas sėkmingai sukurtas", moduleAddPage.getSuccessMessage()
                , "The number and name fields are mandatory. The number must be unique");
    }

    @Test
    public void moduleShouldNotBeCreatedWithUniqueNumberAndNoName() {
        performInitialSteps();
        moduleAddPage.enterNumber(generateRandomNumber());
        moduleAddPage.enterName("");
        moduleAddPage.pressButtonAdd();

        assertTrue(moduleAddPage.getNameInvalidValue()
                , "User must see validation error message when he wants to create a module with no name");
    }

    @Test
    public void moduleShouldNotBeCreatedWithNoNumberAndAnyName() {
        performInitialSteps();
        moduleAddPage.enterNumber("");
        moduleAddPage.enterName("name");
        moduleAddPage.pressButtonAdd();

        assertTrue(moduleAddPage.getNumberInvalidValue()
                , "User must see validation error message when he wants to create a module with no number");
    }

    @Test
    public void moduleShouldNotBeCreatedWithNonUniqueNumberAndAnyName() {
        performInitialSteps();
        moduleAddPage.enterNumber("001");
        moduleAddPage.enterName("name");
        moduleAddPage.pressButtonAdd();

        waitForMessageRecordIsNotCreated(driver);
        assertEquals("Įrašo nepavyko sukurti", moduleAddPage.getErrorMessage()
                , "The module number must be unique");
    }
}

package it.academy.test.modules;

import it.academy.pom.Header;
import it.academy.pom.modules.ModuleEditPage;
import it.academy.pom.modules.ModulesPage;
import it.academy.test.BaseTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static it.academy.utils.GenerateDataUtils.generateRandomName;
import static it.academy.utils.GenerateDataUtils.generateRandomNumber;
import static it.academy.utils.WaitUtils.waitForMessageRecordUpdated;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ModuleEditPageTest extends BaseTest {

    private Header header;
    private ModulesPage modulesPage;
    private ModuleEditPage moduleEditPage;

    void performInitialSteps() {
        header = new Header(driver);
        modulesPage = new ModulesPage(driver);
        moduleEditPage = new ModuleEditPage(driver);
        header.openModules();
        modulesPage.pressButtonEdit();
    }

    @Test
    @Tag("smoke")
    public void moduleNumberAndNameShouldBeEdited() {
        performInitialSteps();
        moduleEditPage.enterNumber(generateRandomNumber());
        moduleEditPage.enterName(generateRandomName());
        moduleEditPage.pressButtonEdit();
        waitForMessageRecordUpdated(driver);

        assertEquals("Įrašas sėkmingai atnaujintas", moduleEditPage.getSuccessMessage()
                , "The number and name fields are mandatory. The number must be unique");
    }

    @Test
    @Tag("smoke")
    public void moduleShouldBeInvalidated() {
        performInitialSteps();
        moduleEditPage.pressButtonDelete();
        waitForMessageRecordUpdated(driver);

        assertEquals("Įrašas sėkmingai atnaujintas", moduleEditPage.getSuccessMessage()
                , "No success message received");
    }

}

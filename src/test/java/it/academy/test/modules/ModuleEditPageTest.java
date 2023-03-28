package it.academy.test.modules;

import it.academy.pom.Header;
import it.academy.pom.modules.ModuleAddPage;
import it.academy.pom.modules.ModuleEditPage;
import it.academy.pom.modules.ModulesPage;
import it.academy.test.BaseTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static it.academy.utils.GenerateDataUtils.*;
import static it.academy.utils.WaitUtils.waitForMessageRecordUpdated;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ModuleEditPageTest extends BaseTest {

    private Header header;
    private ModulesPage modulesPage;
    private ModuleAddPage moduleAddPage;
    private ModuleEditPage moduleEditPage;

    void performInitialSteps() {
        header = new Header(driver);
        modulesPage = new ModulesPage(driver);
        moduleAddPage = new ModuleAddPage(driver);
        moduleEditPage = new ModuleEditPage(driver);
        header
                .openModules();
        modulesPage
                .pressButtonAdd();
        String moduleName = "ModuleName" + generateRandomNum();
        moduleAddPage
                .enterModuleNumber("ModuleNumber" + generateRandomNum())
                .enterModuleName(moduleName)
                .pressButtonAdd();
        header
                .openModules();
        modulesPage
                .pressButtonSearch()
                .searchModuleByName(moduleName)
                .pressButtonSearch()
                .pressButtonEdit();
    }

    @Test
    @Tag("smoke")
    @Tag("regression")
    public void moduleNumberAndNameShouldBeEdited() {
        performInitialSteps();
        moduleEditPage
                .editModuleNumber("ModuleNumber" + generateRandomNum())
                .editModuleName("ModuleName" + generateRandomNum())
                .pressButtonEditModule();
        waitForMessageRecordUpdated(driver);

        assertEquals("Įrašas sėkmingai atnaujintas", moduleEditPage.getSuccessMessage()
                , "The number and name fields are mandatory. The number must be unique");
    }

    @Test
    @Tag("smoke")
    @Tag("regression")
    public void moduleShouldBeInvalidated() {
        performInitialSteps();
        moduleEditPage
                .pressButtonDelete();
        waitForMessageRecordUpdated(driver);

        assertEquals("Įrašas sėkmingai atnaujintas", moduleEditPage.getSuccessMessage()
                , "No success message received");
    }

}

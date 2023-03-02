package it.academy.pom.modules;


import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({ModulesPage.class, ModuleAddPage.class, ModuleEditPage.class, ModuleViewPage.class})
public class ModuleSuitTest {
}

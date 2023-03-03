package it.academy.test.modules;


import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({ModulesPageTest.class, ModuleAddPageTest.class, ModuleEditPageTest.class, ModuleViewPageTest.class})
public class ModulesSuitTest {

}

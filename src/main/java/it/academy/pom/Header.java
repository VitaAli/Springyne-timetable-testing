package it.academy.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Header {

    @FindBy(xpath = "//a[normalize-space()='Moduliai']")
    private WebElement moduleListFromNavbar;

    public Header(WebDriver driver) {
        super();
    }

    public void selectModuleListFromNavbar() {
        moduleListFromNavbar.click();
    }
}

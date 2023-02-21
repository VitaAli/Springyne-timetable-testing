package it.academy.pom.modules;

import it.academy.pom.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RoomsPage extends AbstractPage {

    @FindBy (css = "a[href='#/rooms/create']")
    private WebElement buttonAddRoom;

    public RoomsPage(WebDriver driver) {
        super(driver);
    }
}

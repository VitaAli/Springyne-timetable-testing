package it.academy.pom.modules;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RoomsPage {

    @FindBy (css = "a[href='#/rooms/create']")
    private WebElement buttonAddRoom;

    public RoomsPage(WebDriver driver) {
        super();
    }
}

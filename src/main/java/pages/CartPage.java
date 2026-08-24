package pages;

import driver.DriverFactory;
import org.openqa.selenium.By;

public class CartPage {

    private final By backpack = By.id("item_4_title_link");

    public boolean isBackpackDisplayed() {
        return DriverFactory.getDriver().findElement(backpack).isDisplayed();
    }
}

package pages;

import driver.DriverFactory;
import org.openqa.selenium.By;

public class ProductsPage {

    private final By backpack = By.id("add-to-cart-sauce-labs-backpack");
    private final By cart = By.className("shopping_cart_link");

    public ProductsPage addBackpackToCart() {
        DriverFactory.getDriver().findElement(backpack).click();
        return this;
    }

    public CartPage openCart() {
        DriverFactory.getDriver().findElement(cart).click();
        return new CartPage();
    }
}

package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.LoginPage;
import pages.ProductsPage;

public class ShoppingCartTest extends BaseTest {
    @Test
    public void verifyBackpackCanBeAddedToCart() {
        ProductsPage productsPage = new LoginPage().login();
        CartPage cartPage = productsPage.addBackpackToCart().openCart();
        Assert.assertTrue(cartPage.isBackpackDisplayed(), "Backpack should be displayed in the cart");
    }
}

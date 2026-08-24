package pages;

import config.ConfigReader;
import driver.DriverFactory;
import org.openqa.selenium.By;

public class LoginPage {
    private final By username = By.id("user-name");
    private final By password = By.id("password");
    private final By loginButton = By.id("login-button");

    public ProductsPage login() {
        DriverFactory.getDriver().findElement(username).sendKeys(ConfigReader.get("username"));
        DriverFactory.getDriver().findElement(password).sendKeys(ConfigReader.get("password"));
        DriverFactory.getDriver().findElement(loginButton).click();
        return new ProductsPage();
    }
}

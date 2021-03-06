package tests;

import models.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.*;


import java.util.concurrent.TimeUnit;

public class BaseTest {
    WebDriver driver;
    LoginPage loginPage;
    ProductsPage productsPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;
    LoginPageFactory loginPageFactory;
    User user = new User ("standard_user", "secret_sauce");

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/linux/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        loginPage = new LoginPage(driver) {
            @Override
            public void login(ChromeOptions chromeOptions) {

            }
        };
        productsPage = new ProductsPage(driver) {
            @Override
            public void login(ChromeOptions chromeOptions) {

            }
        };
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver) {
            @Override
            public void login(ChromeOptions chromeOptions) {

            }
        };
        loginPageFactory = new LoginPageFactory(driver) {
            @Override
            public void login(ChromeOptions chromeOptions) {

            }
        };

    }

    @AfterMethod(alwaysRun=true)
    public void closeBrowser() {
       // driver.quit();
    }

}

package tests;


import org.testng.annotations.Test;

public class SauceDemoTest extends BaseTest{


    @Test
    public void loginTest() {
        loginPage.openPage();
        loginPage.login("standard_user","secret_sauce");
        productsPage.openPage();
        productsPage.addToCart("Sauce Labs Fleece Jacket");
        cartPage.openPage();
        cartPage.validateNumberOfProducts(1);
        cartPage.validateProductDetails("Sauce Labs Fleece Jacket", 1, 49.99);
        checkoutPage.openPage();
        checkoutPage.checkout( "Stanislau", "Puninski", "12345");

    }
}

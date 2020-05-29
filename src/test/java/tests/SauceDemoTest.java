package tests;
import org.testng.annotations.Test;
import utils.CapabilitiesGenerator;

public class SauceDemoTest extends BaseTest{


    @Test
    public void loginTest() {

        loginPage.openPage();

        loginPage.login(CapabilitiesGenerator.getChromeOptions());
        productsPage.openPage();
        productsPage.addToCart("Sauce Labs Fleece Jacket");
        cartPage.openPage();
        cartPage.validateNumberOfProducts(1);
        cartPage.validateProductDetails("Sauce Labs Fleece Jacket", 1, 49.99);
        checkoutPage.openPage();
        checkoutPage.checkout( "Stanislau", "Puninski", "12345");

    }

    @Test
    public void loginTest2(){
      String uniqueId =  loginPageFactory
        .openPage()
        .login(user)
        .addToCart("Sauce Labs Fleece Jacket")
        .addToCart("Sauce Labs Bolt T-Shirt")
        .clickCart()
        .validateNumberOfProducts(2);


        ;
    }

}



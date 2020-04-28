package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage {
    private static final By FIRST_NAME_INPUT = By.id("first-name");
    private static final By LAST_NAME_INPUT = By.id("last-name");
    private static final By ZIP_CODE_INPUT = By.id("postal-code");
    private static final By CONTINUE_BUTTON = By.cssSelector(".btn_primary");
    private static final By FINISH_BUTTON = By.cssSelector(".btn_action");

    private static final String CHECKOUT_URL = "https://www.saucedemo.com/checkout-step-one.html";

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }
    public void openPage() {
        driver.get(CHECKOUT_URL);

    }
    public void checkout(String FirstName, String LastName, String PostalCode){
        driver.findElement(FIRST_NAME_INPUT).sendKeys(FirstName);
        driver.findElement(LAST_NAME_INPUT).sendKeys(LastName);
        driver.findElement(ZIP_CODE_INPUT).sendKeys(PostalCode);
        driver.findElement(CONTINUE_BUTTON).click();
        driver.findElement(FINISH_BUTTON).click();
    }
}

package pages;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public abstract class LoginPageFactory extends BasePage{
    private static final By USERNAME_INPUT = By.id("user-name");
    private static final By PASSWORD_INPUT = By.id("password");
    private static final By LOGIN_BUTTON = By.cssSelector(".btn_action");
    private static final String LOGIN_URL = "https://www.saucedemo.com/index.html";

    @FindBy(id = "user-name")
    WebElement userNameInput;
    @FindBy(id = "password")
    WebElement passwordInput;
    @FindBy(css = ".btn_action")
    WebElement loginButton;

    public LoginPageFactory(WebDriver driver){
        super(driver);
    }

    @Override
    public LoginPageFactory openPage() {
        driver.get(LOGIN_URL);
        PageFactory.initElements(driver,this);
        isPageOpened();
        return this;
    }

    @Override
    public LoginPageFactory isPageOpened() {
        wait.until(ExpectedConditions.visibilityOf(loginButton));
        return this;
    }

    public ProductsPage login(User user){
     userNameInput.sendKeys(user.getUserName());
        passwordInput.sendKeys(user.getPassword());
       loginButton.click();
       return new ProductsPage(driver) {
           @Override
           public void login(ChromeOptions chromeOptions) {

           }
       };
    }
}

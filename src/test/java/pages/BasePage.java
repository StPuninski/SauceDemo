package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class BasePage {
    WebDriver driver;
    WebDriverWait wait;



    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver,10);

    }

    public void waitForNumberOfElements(By locator, int numberOfElements) {
        try {
        wait.until(ExpectedConditions.numberOfElementsToBe(locator,numberOfElements));
        } catch (TimeoutException ex){
            ex.printStackTrace();
            Assert.fail("Колличество элементов не соответствует ожидаемому числу" + numberOfElements);
        }
    }


}


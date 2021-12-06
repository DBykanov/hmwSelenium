package hmwSelenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    protected WebDriver driver;
    protected Actions action;


    public BasePage(WebDriver driver) {
        this.driver = driver;

    }

    protected void waitElementClickableMethod(WebElement element, WebDriverWait wait) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void moveToElementMethod(WebElement element) {
        action.moveToElement(element).build().perform();
    }

    protected void waitForLoad(WebElement element, WebDriverWait wait){
            wait.until(ExpectedConditions.visibilityOf(element));

    }

}
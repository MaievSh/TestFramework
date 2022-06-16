package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {
    protected final WebDriver webDriver;

    protected String switchToNewTab;
    protected JavascriptExecutor js;


    public BasePage(WebDriver driver) {
        this.webDriver = driver;
        PageFactory.initElements(driver, this);
    }

    public BasePage(String winHandleBefore, WebDriver driver) {
        this(driver);
        this.switchToNewTab = winHandleBefore;
        winHandleBefore = webDriver.getWindowHandle();
    }

    public void waitElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void scrollTO(WebElement element) {
        js = (JavascriptExecutor) webDriver;
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    public void highlightElement(WebElement element) {
        js = (JavascriptExecutor) webDriver;
        js.executeScript("arguments[0]. setAttribute('style', 'border:2px solid red; background:yellow')", element);
    }


    public void doubleClick(WebElement element) {
        Actions action = new Actions(webDriver);
        action.moveToElement(element).doubleClick().build().perform();
    }

    public void pause(WebElement element) {
        Actions action = new Actions(webDriver);
        action.moveToElement(element).pause(java.time.Duration.ofSeconds(10)).build().perform();
    }

}
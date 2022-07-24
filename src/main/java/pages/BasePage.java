package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.pastBinPages.AfterCreationPastePage;
import pages.pastBinPages.CreationNewPastePage;

import java.time.Duration;
import java.util.List;

import static driver.DriverSingleton.webDriver;

public abstract class BasePage {

    protected Logger logger = LogManager.getRootLogger();

    protected WebDriver webDriver;

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

    public WebElement findElement(By by){
        return webDriver.findElement(by);
    }

    public List<WebElement> findElements(By by){
        return webDriver.findElements(by);
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

    public void click(WebElement element) {
        js = (JavascriptExecutor) webDriver;
        js.executeScript("arguments[0].click();", element);
    }

}
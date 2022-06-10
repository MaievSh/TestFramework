package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {

    protected final WebDriver webDriver;
    protected String winHandleBefore;
    //String originalWindow = webDriver.getWindowHandle();

    public BasePage(WebDriver driver) {
        this.webDriver = driver;
        PageFactory.initElements(driver, this);
    }

    public BasePage(WebDriver driver, String winHandleBefore) {
        this.webDriver = driver;
        this.winHandleBefore = winHandleBefore;
        winHandleBefore = webDriver.getWindowHandle();
        PageFactory.initElements(driver, this);
    }

    public void waiter(WebElement element) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void scrollBy(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

}

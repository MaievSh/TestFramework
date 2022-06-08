package yopmailPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EmailCheckPage {

    private final WebDriver webDriver;

    public EmailCheckPage(WebDriver driver) {
        this.webDriver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//td[starts-with(@style,'margin-left: 11px !important') and text()='USD 21,894.89']")
    private WebElement check;

    private void waiter(WebElement element) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement checkBill() {
        waiter(check);
        return check;
    }
}

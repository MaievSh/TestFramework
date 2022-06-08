package yopmailPages;

import dev.failsafe.internal.util.Assert;
import gogleCloudPages.GoogleCloudPricingCalculatorPage;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

import java.security.Key;
import java.time.Duration;

public class YopMailMainPage {

    private final WebDriver webDriver;

    public YopMailMainPage(WebDriver driver) {
        this.webDriver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[starts-with(@title,'Генератор Одноразовых')]")
    private WebElement emailGenerator;
    @FindBy(xpath = "//span[@class='notmobile'][contains(text(),'Скопировать в буфер обмена')]")
    private WebElement copyEmail;
    @FindBy(xpath = "//span[text()='Проверить почту']")
    private WebElement checkEmailBtn;


    private void waiter(WebElement element) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }


    public YopMailMainPage chooseEmailGenerator() {
        waiter(emailGenerator);
        emailGenerator.click();
        return new YopMailMainPage(webDriver);
    }

    public YopMailMainPage copyEmail() {
        copyEmail.click();
        return new YopMailMainPage(webDriver);
    }

    public EmailCheckPage emailCheck() {
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        checkEmailBtn.click();
        return new EmailCheckPage(webDriver);
    }


}

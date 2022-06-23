package pages.yopmailPages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.BasePage;
import pages.gogleCloudPages.GoogleCloudPricingCalculatorPage;

import java.time.Duration;

public class YopMailMainPage extends BasePage {
    public YopMailMainPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[starts-with(@title,'Генератор Одноразовых')]")
    private WebElement emailGenerator;
    @FindBy(xpath = "//span[@class='notmobile'][contains(text(),'Скопировать в буфер обмена')]")
    private WebElement copyEmail;
    @FindBy(xpath = "//span[text()='Проверить почту']")
    private WebElement checkEmailBtn;

    public YopMailMainPage chooseEmailGenerator() {
        waitElement(emailGenerator);
        emailGenerator.click();
        logger.info("Email generator button is clicked");
        return new YopMailMainPage(webDriver);
    }

    public YopMailMainPage copyEmail() {
        copyEmail.click();
        logger.info("Copy email button is clicked");
        return new YopMailMainPage(webDriver);
    }

    public EmailCheckPage emailCheck() {
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        checkEmailBtn.click();
        logger.info("Check email button is clicked");
        return new EmailCheckPage(webDriver);
    }


}

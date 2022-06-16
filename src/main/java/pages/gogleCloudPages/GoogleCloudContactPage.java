package pages.gogleCloudPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import java.time.Duration;

public class GoogleCloudContactPage extends BasePage {

    @FindBy(xpath = "//a[@track-name='Chat online with us']")
    private WebElement chatWithUsBtn;
    @FindBy(xpath = "//div[@id='cloud-chatbot-header']")
    private WebElement chatBot;

    public GoogleCloudContactPage(WebDriver driver) {
        super(driver);
    }

    public GoogleCloudContactPage chooseChatWitsUsBtn() {
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        waitElement(chatWithUsBtn);
        highlightElement(chatWithUsBtn);
        doubleClick(chatWithUsBtn);
        return new GoogleCloudContactPage(webDriver);
    }

    public WebElement chatBotIsOpen() {
        waitElement(chatBot);
        highlightElement(chatBot);
        return chatBot;
    }
}

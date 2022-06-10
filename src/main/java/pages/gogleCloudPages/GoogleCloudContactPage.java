package pages.gogleCloudPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class GoogleCloudContactPage extends BasePage {

    public GoogleCloudContactPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@track-name='Chat online with us']")
    private WebElement chatWithUsBtn;
    @FindBy(xpath = "//div[@class='message-list']")
    private WebElement chatBot;

    public GoogleCloudContactPage chooseChatWitsUsBtn() {
        waiter(chatWithUsBtn);
        chatWithUsBtn.click();
        return new GoogleCloudContactPage(webDriver);
    }

    public WebElement chatBotIsOpen() {
        waiter(chatBot);
        return chatBot;
    }
}

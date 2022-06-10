package pages.gogleCloudPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class GoogleCloudWebassessorPage extends BasePage {

    public GoogleCloudWebassessorPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[contains(text(),'Ready to start?')]")
    private WebElement readyToStartTitle;

    public WebElement logInContainerIsShowUp() {
        waiter(readyToStartTitle);
        return readyToStartTitle;
    }
}

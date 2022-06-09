package pages.pastBinPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;

import java.time.Duration;

public class AfterCreationPastePage extends BasePage {

    public AfterCreationPastePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='de1']")
    private WebElement afterPostingPaste;
    @FindBy(xpath = "//div[@class='info-top']/child::h1[text()='how to gain dominance among developers']")
    private WebElement pagePasteTitle;
    @FindBy(xpath = "//div[@class='top-buttons']/child::div/child::a[@class='btn -small h_800' and text()='Bash']")
    private WebElement syntaxBash;
    @FindBy(xpath = "//ol[@class='bash']")
    private WebElement createdPaste;


    public WebElement getAfterPostingPaste() {
        waiter(afterPostingPaste);
        return afterPostingPaste;
    }

    public WebElement checkPasteTitle() {
        waiter(pagePasteTitle);
        return pagePasteTitle;
    }

    public WebElement syntaxBashCheck() {
        waiter(syntaxBash);
        return syntaxBash;
    }

    public WebElement createdPasteCheck() {
        waiter(createdPaste);
        return createdPaste;
    }
}

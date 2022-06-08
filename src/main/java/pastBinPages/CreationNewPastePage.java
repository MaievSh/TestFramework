package pastBinPages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreationNewPastePage {
    private final WebDriver webDriver;

    public CreationNewPastePage(WebDriver driver) {
        this.webDriver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//textarea[@id='postform-text']")
    private WebElement textArea;
    @FindBy(xpath = "//span[@role='textbox' and @title='Never']")
    private WebElement pasteExpirationDropDownMenu;
    @FindBy(xpath = "//li[@class='select2-results__option' and text()='10 Minutes']")
    private WebElement timeOfExpiration;
    @FindBy(xpath = "//input[@id='postform-name']")
    private WebElement postFormText;
    @FindBy(xpath = "//button[text()='Create New Paste']")
    private WebElement newPasteButton;
    @FindBy(xpath = "//div[@class='content__title -paste']")
    private WebElement checkScroll;
    @FindBy(xpath = "//label[@for='paste-raw-on']")
    private WebElement syntaxHighlight;
    @FindBy(xpath = "//span[@id='select2-postform-format-container' and @title='None']")
    private WebElement syntaxHighlightInOptionalSettings;
    @FindBy(xpath = "//li[@class='select2-results__option']/descendant::li[@class='select2-results__option' and text()='Bash'][1]")
    private WebElement bashSyntax;

    public void writeTextOfNewPaste(String textOfPaste) {
        textArea.sendKeys(textOfPaste);
    }

    public void scrollBy() {
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("arguments[0].scrollIntoView();", checkScroll);
    }

    public void choosePasteExpiration() {
        pasteExpirationDropDownMenu.click();
        timeOfExpiration.click();
    }

    public void writePostFormText(String postTxt) {
        postFormText.click();
        postFormText.sendKeys(postTxt);
    }

    public AfterCreationPastePage createNewPaste() {
        newPasteButton.click();
        return new AfterCreationPastePage(webDriver);
    }

    public void highlightTextInPaste() {
        syntaxHighlight.click();
    }

    public void chooseBashSyntaxInOptionalSettings() {
        syntaxHighlightInOptionalSettings.click();
        bashSyntax.click();
    }

}
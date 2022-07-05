package pages.pastBinPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class CreationNewPastePage extends BasePage {

    public CreationNewPastePage(WebDriver driver) {
        super(driver);
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

    public void choosePasteExpiration() {
        scrollTO(checkScroll);
        pasteExpirationDropDownMenu.click();
        timeOfExpiration.click();
    }

    public void writePostFormText(String postTxt) {
        postFormText.click();
        postFormText.sendKeys(postTxt);
    }

    public AfterCreationPastePage createNewPaste() {
        scrollTO(checkScroll);
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
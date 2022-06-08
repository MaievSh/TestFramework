package pastBinTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pastBinPages.AfterCreationPastePage;
import pastBinPages.CreationNewPastePage;

public class CreateNewPasteTest {

    private WebDriver webDriver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetUp() {
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
    }

    @Test
    public void creationNewPasteWithParamTest() {
        CreationNewPastePage creationNewPastePage = new CreationNewPastePage(webDriver);
        AfterCreationPastePage afterCreationPastePage = new AfterCreationPastePage(webDriver);
        webDriver.get("https://pastebin.com/");
        creationNewPastePage.writeTextOfNewPaste("Hello from WebDriver");
        creationNewPastePage.scrollBy();
        creationNewPastePage.choosePasteExpiration();
        creationNewPastePage.writePostFormText("Test");
        creationNewPastePage.createNewPaste();
        Assert.assertTrue(afterCreationPastePage.getAfterPostingPaste().isDisplayed());
    }

    @Test
    public void creationNewPasteWithBashSyntaxTest() {
        CreationNewPastePage creationNewPastePage = new CreationNewPastePage(webDriver);
        AfterCreationPastePage afterCreationPastePage = new AfterCreationPastePage(webDriver);
        webDriver.get("https://pastebin.com/");
        creationNewPastePage.writeTextOfNewPaste("git config --global user.name" + " " + "'New Sheriff in Town'" + "\n" +
                "git reset $(git commit-tree HEAD^{tree} -m 'Legacy code')" + "\n" +
                "git push origin master --force");
        creationNewPastePage.highlightTextInPaste();
        creationNewPastePage.scrollBy();
        creationNewPastePage.chooseBashSyntaxInOptionalSettings();
        creationNewPastePage.writePostFormText("how to gain dominance among developers");
        creationNewPastePage.createNewPaste();
        Assert.assertTrue(afterCreationPastePage.checkPasteTitle().isDisplayed() && afterCreationPastePage.syntaxBashCheck().isDisplayed());
    }

    @AfterMethod(alwaysRun = true)
    public void browserQuite() {
        webDriver.quit();
        webDriver = null;
    }

}

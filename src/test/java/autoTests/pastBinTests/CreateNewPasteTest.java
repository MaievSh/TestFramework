package autoTests.pastBinTests;

import autoTests.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.pastBinPages.AfterCreationPastePage;
import pages.pastBinPages.CreationNewPastePage;

public class CreateNewPasteTest extends BaseTest {

    @Test()
    public void creationNewPasteWithParamTest() {
        webDriver.get("https://pastebin.com/");
        CreationNewPastePage creationNewPastePage = new CreationNewPastePage(webDriver);
        AfterCreationPastePage afterCreationPastePage = new AfterCreationPastePage(webDriver);
        creationNewPastePage.writeTextOfNewPaste("Hello from WebDriver");
        creationNewPastePage.choosePasteExpiration();
        creationNewPastePage.writePostFormText("Test");
        creationNewPastePage.createNewPaste();
        Assert.assertTrue(afterCreationPastePage.getAfterPostingPaste().isDisplayed());
    }

    @Test()
    public void creationNewPasteWithBashSyntaxTest() {
        CreationNewPastePage creationNewPastePage = new CreationNewPastePage(webDriver);
        AfterCreationPastePage afterCreationPastePage = new AfterCreationPastePage(webDriver);
        webDriver.get("https://pastebin.com/");
        creationNewPastePage.writeTextOfNewPaste("git config --global user.name" + " " + "'New Sheriff in Town'" + "\n" +
                "git reset $(git commit-tree HEAD^{tree} -m 'Legacy code')" + "\n" +
                "git push origin master --force");
        creationNewPastePage.highlightTextInPaste();
        creationNewPastePage.chooseBashSyntaxInOptionalSettings();
        creationNewPastePage.writePostFormText("how to gain dominance among developers");
        creationNewPastePage.createNewPaste();
        Assert.assertTrue(afterCreationPastePage.checkPasteTitle().isDisplayed() && afterCreationPastePage.syntaxBashCheck().isDisplayed());
    }


}
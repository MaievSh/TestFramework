package autoTests.pastBinTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.pastBinPages.AfterCreationPastePage;
import pages.pastBinPages.CreationNewPastePage;

public class CreateNewPasteTest extends PastBinBaseTest {

    @Test(groups = "Regression", enabled = false)
    public void creationNewPasteWithParamTest() {
        CreationNewPastePage creationNewPastePage = new CreationNewPastePage(webDriver);
        getPasteBinSiteMainPage();
        AfterCreationPastePage afterCreationPastePage = new AfterCreationPastePage(webDriver);
        creationNewPastePage.writeTextOfNewPaste("Hello from WebDriver");
        creationNewPastePage.choosePasteExpiration();
        creationNewPastePage.writePostFormText("Test");
        creationNewPastePage.createNewPaste();
        Assert.assertTrue(afterCreationPastePage.getAfterPostingPaste().isDisplayed());
    }

    @Test(groups = "Regression", enabled = false)
    public void creationNewPasteWithBashSyntaxTest() {
        CreationNewPastePage creationNewPastePage = new CreationNewPastePage(webDriver);
        getPasteBinSiteMainPage();
        AfterCreationPastePage afterCreationPastePage = new AfterCreationPastePage(webDriver);
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
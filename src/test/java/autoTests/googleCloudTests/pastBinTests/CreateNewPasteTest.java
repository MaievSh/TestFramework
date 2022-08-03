package autoTests.googleCloudTests.pastBinTests;

import driver.ChromeDriverCreator;
import driver.WebDriverCreator;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.pastBinPages.AfterCreationPastePage;
import pages.pastBinPages.CreationNewPastePage;
import static driver.DriverSingleton.webDriver;
public class CreateNewPasteTest extends PastBinBaseTest {

    @Test(groups = "Regression")
    public void creationNewPasteWithParamTest() {
        WebDriverCreator creator = new ChromeDriverCreator();
        webDriver = creator.createWebDriver();
        webDriver.get("https://pastebin.com/");
        CreationNewPastePage creationNewPastePage = new CreationNewPastePage(webDriver);
        AfterCreationPastePage afterCreationPastePage = new AfterCreationPastePage(webDriver);
        creationNewPastePage.writeTextOfNewPaste("Hello from WebDriver");
        creationNewPastePage.choosePasteExpiration();
        creationNewPastePage.chooseTimeOfExpiration("10 Minutes");
        creationNewPastePage.writePostFormText("Test");
        creationNewPastePage.createNewPaste();
        Assert.assertTrue(afterCreationPastePage.getAfterPostingPaste().isDisplayed());
    }

    @Test(groups = "Regression")
    public void creationNewPasteWithBashSyntaxTest() {
        WebDriverCreator creator = new ChromeDriverCreator();
        webDriver = creator.createWebDriver();
        webDriver.get("https://pastebin.com/");
        CreationNewPastePage creationNewPastePage = new CreationNewPastePage(webDriver);
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
package autoTests.googleCloudTests;

import autoTests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.gogleCloudPages.GoogleCloudContactPage;
import pages.gogleCloudPages.GoogleCloudMainPage;

public class ChatBotTest extends GoogleCloudBaseTest {

    @Test(groups = "googleCloudTests")
    public void checkAppearingChatBot() {
        GoogleCloudMainPage googleCloudMainPage = new GoogleCloudMainPage(webDriver);
        getGoogleCloudSiteMainPage();
        GoogleCloudContactPage googleCloudContactPage = googleCloudMainPage
                .talkToUsBtnClick()
                .chooseChatWitsUsBtn();
        Assert.assertTrue(googleCloudContactPage.chatBotIsOpen().isDisplayed(),"ChetBot is not displayed! ");
    }
}

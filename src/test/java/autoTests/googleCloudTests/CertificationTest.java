package autoTests.googleCloudTests;

import autoTests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.gogleCloudPages.GoogleCloudMainPage;
import pages.gogleCloudPages.GoogleCloudWebassessorPage;

public class CertificationTest extends GoogleCloudBaseTest {

    @Test(groups = "googleCloudTests")
    public void checkingAbilityToRegistrOnCertificationTest() {
        GoogleCloudMainPage googleCloudMainPage = new GoogleCloudMainPage(webDriver);
        getGoogleCloudSiteMainPage();
        GoogleCloudWebassessorPage googleCloudWebassessorPageg =  googleCloudMainPage.gettingStartTabClick()
                .chooseTraining()
                .learningPathBtnClick()
                .appDevChoose()
                .chooseDevPath()
                .getCertification()
                .clickRegisterCertification()
                .switchToNewTab();
        Assert.assertTrue(googleCloudWebassessorPageg.logInContainerIsShowUp().isDisplayed(),"Login is nor showing up!");


    }
}

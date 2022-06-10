package autoTests.googleCloudTests;

import autoTests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.gogleCloudPages.GoogleCloudMainPage;
import pages.gogleCloudPages.GoogleCloudWebassessorPage;

public class CertificationTest extends BaseTest {

    @Test()
    public void checkingAbilityToRegistrOnCertificationTest() {
        GoogleCloudMainPage googleCloudMainPage = new GoogleCloudMainPage(webDriver);
        GoogleCloudWebassessorPage googleCloudWebassessorPageg = new GoogleCloudWebassessorPage(webDriver);
        webDriver.get("https://cloud.google.com/");
        googleCloudMainPage.gettingStartTabClick()
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

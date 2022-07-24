package autoTests.googleCloudTests;

import autoTests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.gogleCloudPages.GoogleCloudMainPage;
import pages.gogleCloudPages.GoogleCloudWebassessorPage;
import static driver.DriverSingleton.webDriver;

public class CertificationTest extends GoogleCloudBaseTest {

    @Test(groups = "Smoke", enabled = false)
    public void checkingAbilityToRegistrOnCertificationTest() throws InterruptedException {
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

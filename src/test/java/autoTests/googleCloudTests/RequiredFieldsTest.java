package autoTests.googleCloudTests;

import autoTests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.gogleCloudPages.GoogleCloudContactSalesPage;
import pages.gogleCloudPages.GoogleCloudMainPage;

public class RequiredFieldsTest extends GoogleCloudBaseTest {

    @Test(groups = "Regression")
    public void checkHighlightedRequiredFieldsTest() {
        GoogleCloudMainPage googleCloudMainPage = new GoogleCloudMainPage(webDriver);
        getGoogleCloudSiteMainPage();
        GoogleCloudContactSalesPage googleCloudContactSalesPage =
        googleCloudMainPage.solutionsBtnClick()
                .industrySolutionsChoose()
                .gamingBtnClick()
                .clickTakeNextStepTab()
                .clickContactSalesBtn()
                .clickSubmitButton();
        Assert.assertTrue(googleCloudContactSalesPage.errorTextAppears().isDisplayed(),"Errors in fields is not displayed!");
    }
}

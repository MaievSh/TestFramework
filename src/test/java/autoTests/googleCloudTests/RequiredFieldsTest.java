package autoTests.googleCloudTests;

import autoTests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.gogleCloudPages.GoogleCloudContactSalesPage;
import pages.gogleCloudPages.GoogleCloudMainPage;

public class RequiredFieldsTest extends BaseTest {

    @Test
    public void checkHighlightedRequiredFieldsTest() {
        GoogleCloudMainPage googleCloudMainPage = new GoogleCloudMainPage(webDriver);
        GoogleCloudContactSalesPage googleCloudContactSalesPage = new GoogleCloudContactSalesPage(webDriver);
        webDriver.get("https://cloud.google.com/");
        googleCloudMainPage.solutionsBtnClick()
                .industrySolutionsChoose()
                .gamingBtnClick()
                .clickTakeNextStepTab()
                .clickContactSalesBtn()
                .clickSubmitButton();
        Assert.assertTrue(googleCloudContactSalesPage.errorTextAppears().isDisplayed(),"Errors in fields is not displayed!");
    }
}

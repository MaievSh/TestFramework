package autoTests.googleCloudTests;

import driver.EdgeDriverCreator;
import driver.WebDriverCreator;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.gogleCloudPages.GoogleCloudContactSalesPage;
import pages.gogleCloudPages.GoogleCloudMainPage;

public class RequiredFieldsTest extends GoogleCloudBaseTest {

    @Test(groups = "Regression")
    public void checkHighlightedRequiredFieldsTest() {
        WebDriverCreator creator = new EdgeDriverCreator(); // can be chrome
        webDriver = creator.createWebDriver();
        webDriver.get("https://cloud.google.com/");
        GoogleCloudMainPage googleCloudMainPage = new GoogleCloudMainPage(webDriver);
        GoogleCloudContactSalesPage googleCloudContactSalesPage =
                googleCloudMainPage.solutionsBtnClick()
                        .industrySolutionsChoose()
                        .gamingBtnClick()
                        .clickTakeNextStepTab()
                        .clickContactSalesBtn()
                        .clickSubmitButton();
        Assert.assertTrue(googleCloudContactSalesPage.errorTextAppears().isDisplayed(), "Errors in fields is not displayed!");
    }
}

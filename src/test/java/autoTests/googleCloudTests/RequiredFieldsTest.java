package autoTests.googleCloudTests;

import driver.ChromeDriverCreator;
import driver.EdgeDriverCreator;
import driver.WebDriverCreator;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.gogleCloudPages.GoogleCloudContactSalesPage;
import pages.gogleCloudPages.GoogleCloudMainPage;
import utils.AllureListener;

import static driver.DriverSingleton.webDriver;
@Listeners({AllureListener.class})
public class RequiredFieldsTest extends GoogleCloudBaseTest {

    @Test(groups = "Regression")
    @Step
    public void checkHighlightedRequiredFieldsTest() {
        WebDriverCreator creator = new ChromeDriverCreator(); // can be chrome
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

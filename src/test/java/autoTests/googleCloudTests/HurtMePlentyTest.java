package autoTests.googleCloudTests;

import autoTests.BaseTest;
import pages.gogleCloudPages.GoogleCloudPricingCalculatorPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.gogleCloudPages.GoogleCloudMainPage;
import pages.pastBinPages.AfterCreationPastePage;
import pages.pastBinPages.CreationNewPastePage;

public class HurtMePlentyTest extends BaseTest {


    @Test()
    public void checkPrisingCalculatorTest() {
        webDriver.get("https://cloud.google.com/");
        GoogleCloudMainPage googleCloudMainPage = new GoogleCloudMainPage(webDriver);
        GoogleCloudPricingCalculatorPage googleCloudPricingCalculatorPage = new GoogleCloudPricingCalculatorPage(webDriver);
        googleCloudMainPage.inputInSearchField("Google Cloud Platform Pricing Calculator")
                .pricingCalculatorSearch()
                .getFrameInsideFrame()
                .chooseOperatingSystem()
                .chooseMachineType()
                .enterInfoInNumberOfInstField("4")
                .selectDownAddGpusCheckbox()
                .chooseGpuType()
                .chooseNumberOfGpu()
                .chooseSSD()
                .chooseDataCenterLocation("Fran")
                .chooseCommitedUsage()
                .addToEstimate();
        Assert.assertTrue(googleCloudPricingCalculatorPage.estimateFieldInstanceTypeCheck().isDisplayed(), "Instance type is not equals instance type in bill");
        Assert.assertTrue(googleCloudPricingCalculatorPage.estimateFieldRegionCheck().isDisplayed(), "Region is not equals region in bill");
        Assert.assertTrue(googleCloudPricingCalculatorPage.estimateFieldSSDCheck().isDisplayed(), "SSD type is not equals SSD type in bill");
        Assert.assertTrue(googleCloudPricingCalculatorPage.estimateFieldCommitedTermCheck().isDisplayed(), "Commitment term is not equals commitment term in bill");
        Assert.assertTrue(googleCloudPricingCalculatorPage.checkCurrentTotalCostAndManualTotalCost().isDisplayed(), "Total cost is not equal total cost when choose parameters in manual way");
    }

}

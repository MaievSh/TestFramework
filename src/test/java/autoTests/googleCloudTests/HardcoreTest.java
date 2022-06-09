package autoTests.googleCloudTests;

import autoTests.BaseTest;
import pages.gogleCloudPages.GoogleCloudMainPage;
import pages.gogleCloudPages.GoogleCloudPricingCalculatorPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.yopmailPages.EmailCheckPage;

public class HardcoreTest extends BaseTest {

    @Test()
    public void checkPrisingCalculatorTest() {
        GoogleCloudMainPage googleCloudMainPage = new GoogleCloudMainPage(webDriver);
        GoogleCloudPricingCalculatorPage googleCloudPricingCalculatorPage = new GoogleCloudPricingCalculatorPage(webDriver);
        EmailCheckPage emailCheckPage = new EmailCheckPage(webDriver);
        webDriver.get("https://cloud.google.com/");
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
                .addToEstimate()
                .openNewTab()
                .chooseEmailGenerator()
                .copyEmail();
        googleCloudPricingCalculatorPage.closeNewTab()
                .getFrameInsideFrame()
                .sendEstimateOnEmail()
                .openNewTabAgain()
                .emailCheck()
                .checkBill();
        Assert.assertTrue(emailCheckPage.checkBill().getText().contains("USD 21,894.89"), "Total Estimated Monthly Cost not equals cost in calculator!");

    }


}

package googleCloudTests;

import gogleCloudPages.GoogleCloudMainPage;
import gogleCloudPages.GoogleCloudPricingCalculatorPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import yopmailPages.EmailCheckPage;
import yopmailPages.YopMailMainPage;

public class HardcoreTest {

    private WebDriver webDriver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetUp() {
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
    }

    @Test()
    public void checkPrisingCalculatorTest() throws InterruptedException {
        GoogleCloudMainPage googleCloudMainPage = new GoogleCloudMainPage(webDriver);
        YopMailMainPage yopMailMainPage = new YopMailMainPage(webDriver);
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
        Assert.assertTrue(emailCheckPage.checkBill().getText().contains("USD 21,894.89"),"Total Estimated Monthly Cost not equals cost in calculator!");

    }

    @AfterMethod(alwaysRun = true)
    public void browserQuite() {
        webDriver.quit();
        webDriver = null;
    }

}

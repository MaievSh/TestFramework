package autoTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.gogleCloudPages.GoogleCloudMainPage;
import pages.gogleCloudPages.GoogleCloudPricingCalculatorPage;
import pages.pastBinPages.AfterCreationPastePage;
import pages.pastBinPages.CreationNewPastePage;
import pages.yopmailPages.EmailCheckPage;

public abstract class BaseTest {

    public WebDriver webDriver;


    @BeforeMethod(alwaysRun = true)
    public void browserSetUp() {
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
    }

    @AfterMethod(alwaysRun = true)
    public void browserQuite() {
        webDriver.quit();
        webDriver = null;
    }

}
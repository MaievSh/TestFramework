package autoTests.googleCloudTests.pastBinTests;

import autoTests.BaseTest;
import pages.CustomActionDriver;
import pages.pastBinPages.AfterCreationPastePage;
import pages.pastBinPages.CreationNewPastePage;

import static driver.DriverSingleton.webDriver;

public abstract class PastBinBaseTest extends BaseTest {
    public void getPasteBinSiteMainPage() {
        webDriver = new CustomActionDriver(webDriver);
        webDriver.get("https://pastebin.com/");
    }
}

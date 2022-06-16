package autoTests.googleCloudTests;

import autoTests.BaseTest;
import pages.gogleCloudPages.GoogleCloudMainPage;

public abstract class GoogleCloudBaseTest extends BaseTest {

    public void getGoogleCloudSiteMainPage() {
        this.webDriver.get("https://cloud.google.com/");
    }
}
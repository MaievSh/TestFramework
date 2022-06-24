package autoTests.googleCloudTests;

import autoTests.BaseTest;
import pages.gogleCloudPages.GoogleCloudMainPage;
import service.TestDataReader;

public abstract class GoogleCloudBaseTest extends BaseTest {

    public static final String URL = "test.url";

    public void getGoogleCloudSiteMainPage() {
        this.webDriver.get(TestDataReader.getTestData(URL));
    }
}
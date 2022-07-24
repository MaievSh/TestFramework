package autoTests.googleCloudTests;

import autoTests.BaseTest;
import pages.gogleCloudPages.GoogleCloudMainPage;
import service.TestDataReader;
import static driver.DriverSingleton.webDriver;

public abstract class GoogleCloudBaseTest extends BaseTest {

    public static final String URL = "test.url";

    public void getGoogleCloudSiteMainPage() {
      webDriver.get(TestDataReader.getTestData(URL));
    }
}
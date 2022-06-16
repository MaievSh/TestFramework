package autoTests.pastBinTests;

import autoTests.BaseTest;

public abstract class PastBinBaseTest extends BaseTest {

    public void getPasteBinSiteMainPage() {
        this.webDriver.get("https://pastebin.com/");
    }
}

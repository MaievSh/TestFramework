package autoTests;

import driver.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import utils.ScreenOnTestFailure;

import java.net.MalformedURLException;

@Listeners({ScreenOnTestFailure.class})
public abstract class BaseTest {

    public WebDriver webDriver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetUp() throws MalformedURLException {
        webDriver = DriverSingleton.getDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void browserQuite() {
        DriverSingleton.closeDriver();
    }
}
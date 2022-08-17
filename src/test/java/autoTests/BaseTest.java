package autoTests;

import driver.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import utils.AllureListener;
import utils.ScreenOnTestFailure;

import java.net.MalformedURLException;
import static driver.DriverSingleton.webDriver;

@Listeners({AllureListener.class})
public abstract class BaseTest {

    @BeforeMethod(alwaysRun = true)
    public void browserSetUp() throws MalformedURLException {
        webDriver = DriverSingleton.getDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void browserQuite() {
        DriverSingleton.closeDriver();
    }
}
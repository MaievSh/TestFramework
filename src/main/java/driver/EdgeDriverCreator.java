package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import pages.CustomActionDriver;

import static driver.DriverSingleton.webDriver;

public class EdgeDriverCreator implements WebDriverCreator {

    protected static EdgeOptions edgeOptions = new EdgeOptions();
    @Override
    public WebDriver createWebDriver() {
        WebDriver customDriver = new CustomActionDriver(webDriver);
        WebDriverManager.edgedriver().setup();
        webDriver = new EdgeDriver();
        //  webDriver = new RemoteWebDriver(new URL("http://192.168.100.5:4455/wd/hub"), chromeOptions);
        webDriver.manage().window().maximize();
        return webDriver;
    }
}

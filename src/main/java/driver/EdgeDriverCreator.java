package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import static driver.DriverSingleton.webDriver;

public class EdgeDriverCreator implements WebDriverCreator {

    @Override
    public WebDriver createWebDriver() {
        WebDriverManager.edgedriver().setup();
        webDriver = new EdgeDriver();
        webDriver.manage().window().maximize();
        return webDriver;
    }
}

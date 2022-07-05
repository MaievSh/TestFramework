package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static driver.DriverSingleton.webDriver;

public class ChromeDriverCreator implements WebDriverCreator {

    @Override
    public WebDriver createWebDriver() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        return webDriver;
    }
}

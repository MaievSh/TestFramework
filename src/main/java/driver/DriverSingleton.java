package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.net.MalformedURLException;


public class DriverSingleton {

    public static WebDriver webDriver;

    protected static ChromeOptions chromeOptions = new ChromeOptions();
    protected static EdgeOptions edgeOptions = new EdgeOptions();

    private DriverSingleton() {
    }

    public static WebDriver getDriver() throws MalformedURLException {
        if (webDriver == null) {
            if ("edge".equals(System.getProperty("browser"))) {
                WebDriverManager.edgedriver().setup();
                webDriver = new EdgeDriver();
                //webDriver = new RemoteWebDriver(new URL("http://192.168.100.5:4455/wd/hub"), edgeOptions);
                webDriver.manage().window().maximize();
            } else {
                if ("chrome".equals(System.getProperty("browser")))
                    WebDriverManager.chromedriver().setup();
                webDriver = new ChromeDriver();
                //  webDriver = new RemoteWebDriver(new URL("http://192.168.100.5:4455/wd/hub"), chromeOptions);
                webDriver.manage().window().maximize();
            }
        }
        return webDriver;
    }

    public static void closeDriver() {
        webDriver.quit();
        webDriver = null;
    }
}

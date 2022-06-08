package gogleCloudPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchResultGoogleCloudPage {

    private final WebDriver webDriver;

    public SearchResultGoogleCloudPage(WebDriver driver) {
        this.webDriver = driver;
        PageFactory.initElements(driver, this);
    }

    private void waiter(WebElement element) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    @FindBy(xpath = "//div[@class='gsc-thumbnail-inside']//a/child::b[text()='Google Cloud Pricing Calculator']")
    private WebElement foundedResultBtn;

    public GoogleCloudPricingCalculatorPage pricingCalculatorSearch() {
        waiter(foundedResultBtn);
        foundedResultBtn.click();
        return new GoogleCloudPricingCalculatorPage(webDriver);
    }

}

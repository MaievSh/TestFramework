package pages.gogleCloudPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class SearchResultGoogleCloudPage extends BasePage {


    public SearchResultGoogleCloudPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//div[@class='gsc-thumbnail-inside']//a/child::b[text()='Google Cloud Pricing Calculator']")
    private WebElement foundedResultBtn;

    public GoogleCloudPricingCalculatorPage pricingCalculatorSearch() {
        waiter(foundedResultBtn);
        foundedResultBtn.click();
        return new GoogleCloudPricingCalculatorPage(webDriver);
    }

}

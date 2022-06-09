package pages.gogleCloudPages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class GoogleCloudMainPage extends BasePage {

    public GoogleCloudMainPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@aria-label='Search']")
    private WebElement searchBtn;


    public SearchResultGoogleCloudPage inputInSearchField(String txt) {
        searchBtn.click();
        searchBtn.sendKeys(txt);
        searchBtn.sendKeys(Keys.ENTER);
        return new SearchResultGoogleCloudPage(webDriver);
    }

}

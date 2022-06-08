package gogleCloudPages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleCloudMainPage {
    private final WebDriver webDriver;

    public GoogleCloudMainPage(WebDriver driver) {
        this.webDriver = driver;
        PageFactory.initElements(driver, this);
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

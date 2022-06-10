package pages.gogleCloudPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class GoogleCloudContactSalesPage extends BasePage {

    public GoogleCloudContactSalesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[@name='SubmitButton']")
    private WebElement submitBtn;
    @FindBy(xpath = "//span[@slot='error-text-required']")
    private WebElement errorText;

    public void clickSubmitButton() {
        waiter(submitBtn);
        submitBtn.click();
    }

    public WebElement errorTextAppears() {
        return errorText;
    }


}

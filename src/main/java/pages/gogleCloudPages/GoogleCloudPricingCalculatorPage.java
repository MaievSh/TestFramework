package pages.gogleCloudPages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import pages.yopmailPages.YopMailMainPage;


public class GoogleCloudPricingCalculatorPage extends BasePage {

    public GoogleCloudPricingCalculatorPage(WebDriver webDriver) {
        super(webDriver);
    }


    @FindBy(xpath = "//input[@ng-model='listingCtrl.soleTenant.nodesCount']")
    private WebElement numbOfInstancesField;
    @FindBy(xpath = "//*[@id='cloud-site']/devsite-iframe/iframe")
    private WebElement checkingFrame;
    @FindBy(xpath = "//*[@id='myFrame']")
    private WebElement insideFrameFrame;
    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.os']")
    private WebElement operatingSystemField;
    @FindBy(xpath = "//div[@class='md-text'][contains(text(),'Ubuntu Pro')]")
    private WebElement chooseUbuntuPro;
    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.instance']")
    private WebElement machineTypeField;
    @FindBy(xpath = "//md-option[@value='CP-COMPUTEENGINE-VMIMAGE-E2-STANDARD-8']")
    private WebElement chooseStandardMachineType;
    @FindBy(xpath = "//md-checkbox[@ng-model='listingCtrl.soleTenant.addGPUs'][starts-with(@ng-disabled,'!(listingCtrl.soleTenant.nodeType')]")
    private WebElement addGpusCheckbox;
    @FindBy(xpath = "//h2[@class='md-title' and text()='Sole-tenant nodes']")
    private WebElement titleSoleTenantNodes;
    @FindBy(xpath = "//md-select[@placeholder='GPU type']")
    private WebElement gpuTypeField;
    @FindBy(xpath = "//md-option[@value='NVIDIA_TESLA_P4']")
    private WebElement nvidiaGpuType;
    @FindBy(xpath = "//md-select[@placeholder='Number of GPUs']")
    private WebElement numberOfGpuField;
    @FindBy(xpath = "//md-option[@ng-value='item.value' and @value='4']")
    private WebElement chooseNumberOfGpu;
    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.soleTenant.ssd']")
    private WebElement localSSDField;
    @FindBy(xpath = "//div[@class='md-text'][contains(text(),'24x375 GB')]")
    private WebElement chooseLocalSSD;
    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.soleTenant.location']")
    private WebElement dataCenterLocationField;
    @FindBy(xpath = "//label[@ng-click='delegateClick()']/following-sibling::input[@ng-model='listingCtrl.inputRegionText.soleTenant']")
    private WebElement searchRegionField;
    @FindBy(xpath = "//md-option[@value='europe-west3' and @id='select_option_285']/child::div[@class='md-text ng-binding'][contains(text(),'Frankfurt')]")
    private WebElement chooseFrankfurt;
    @FindBy(xpath = "//md-select-value[@id='select_value_label_130']")
    private WebElement commitedUsageField;
    @FindBy(xpath = "//md-option[@id='select_option_150']/div[@class='md-text']")
    private WebElement chooseCommitedUsage;
    @FindBy(xpath = "//button[@aria-label='Add to Estimate'][starts-with(@ng-click,'listingCtrl.soleTenant.submitted = true')]")
    private WebElement addToEstimateBtn;
    @FindBy(xpath = "//div[starts-with(@class,'md-list-item-text')][contains(text(),'Instance type: n1-node-96-624')]")
    private WebElement estimateListInstanceTypeField;
    @FindBy(xpath = "//md-list-item[@role='listitem']/child::div[@class='md-list-item-text ng-binding'][contains(text(),'Region: Frankfurt')]")
    private WebElement estimateListRegionField;
    @FindBy(xpath = "//div[starts-with(@class,'md-list-item-text')][contains(text(),' Local SSD: 24x375 GiB')]")
    private WebElement estimateListLocalSSDField;
    @FindBy(xpath = "//md-list-item[@role='listitem']/child::div[@class='md-list-item-text ng-binding'][contains(text(),'Commitment term: 1 Year')]")
    private WebElement estimateListCommitedTermField;
    @FindBy(xpath = "//h2[@class='md-title']/b[@class='ng-binding'][contains(text(),'USD 21,894.89')]")
    private WebElement totalCostManualTest;
    @FindBy(xpath = "//*[@id='email_quote']")
    private WebElement emailBtn;
    @FindBy(xpath = "//input[@name='description' and @type='email']")
    private WebElement enterEmail;
    @FindBy(xpath = "//button[@aria-label='Send Email']")
    private WebElement sendEmailInWindow;


    public YopMailMainPage openNewTab() {
        webDriver.switchTo().newWindow(WindowType.TAB).get("https://yopmail.com/ru/");
        return new YopMailMainPage(webDriver);
    }

    public GoogleCloudPricingCalculatorPage getFrameInsideFrame() {
        waiter(checkingFrame);
        webDriver.switchTo().frame(checkingFrame);
        webDriver.switchTo().frame(insideFrameFrame);
        return new GoogleCloudPricingCalculatorPage(webDriver);
    }

    public GoogleCloudPricingCalculatorPage enterInfoInNumberOfInstField(String number) {
        numbOfInstancesField.click();
        numbOfInstancesField.sendKeys(number);
        return new GoogleCloudPricingCalculatorPage(webDriver);
    }

    public GoogleCloudPricingCalculatorPage chooseOperatingSystem() {
        operatingSystemField.click();
        waiter(chooseUbuntuPro);
        chooseUbuntuPro.click();
        return new GoogleCloudPricingCalculatorPage(webDriver);
    }

    public GoogleCloudPricingCalculatorPage chooseMachineType() {
        machineTypeField.click();
        waiter(chooseStandardMachineType);
        chooseStandardMachineType.click();
        return new GoogleCloudPricingCalculatorPage(webDriver);
    }

    public GoogleCloudPricingCalculatorPage selectDownAddGpusCheckbox() {
        waiter(addGpusCheckbox);
        addGpusCheckbox.click();
        return new GoogleCloudPricingCalculatorPage(webDriver);
    }

    public GoogleCloudPricingCalculatorPage chooseGpuType() {
        scrollBy(titleSoleTenantNodes);
        gpuTypeField.click();
        waiter(nvidiaGpuType);
        nvidiaGpuType.click();
        return new GoogleCloudPricingCalculatorPage(webDriver);
    }

    public GoogleCloudPricingCalculatorPage chooseNumberOfGpu() {
        scrollBy(titleSoleTenantNodes);
        numberOfGpuField.click();
        waiter(chooseNumberOfGpu);
        chooseNumberOfGpu.click();
        return new GoogleCloudPricingCalculatorPage(webDriver);
    }

    public GoogleCloudPricingCalculatorPage chooseSSD() {
        localSSDField.click();
        waiter(chooseLocalSSD);
        chooseLocalSSD.click();
        return new GoogleCloudPricingCalculatorPage(webDriver);
    }

    public GoogleCloudPricingCalculatorPage chooseDataCenterLocation(String region) {
        dataCenterLocationField.click();
        waiter(searchRegionField);
        searchRegionField.click();
        searchRegionField.sendKeys(region);
        chooseFrankfurt.click();
        return new GoogleCloudPricingCalculatorPage(webDriver);
    }

    public GoogleCloudPricingCalculatorPage chooseCommitedUsage() {
        waiter(dataCenterLocationField);
        commitedUsageField.click();
        waiter(chooseCommitedUsage);
        chooseCommitedUsage.click();
        return new GoogleCloudPricingCalculatorPage(webDriver);
    }

    public GoogleCloudPricingCalculatorPage addToEstimate() {
        waiter(addToEstimateBtn);
        addToEstimateBtn.click();
        return new GoogleCloudPricingCalculatorPage(webDriver);
    }

    public GoogleCloudPricingCalculatorPage sendEstimateOnEmail() {
        waiter(emailBtn);
        emailBtn.click();
        enterEmail.click();
        enterEmail.sendKeys(Keys.CONTROL, "v");
        sendEmailInWindow.click();
        return new GoogleCloudPricingCalculatorPage(webDriver);
    }

    public GoogleCloudPricingCalculatorPage closeNewTab() {
        for (String winHandle : webDriver.getWindowHandles()) {
            webDriver.switchTo().window(winHandle);
            break;
        }
        return new GoogleCloudPricingCalculatorPage(webDriver);
    }


    public YopMailMainPage openNewTabAgain() {
        for (String winHandle : webDriver.getWindowHandles()) {
            webDriver.switchTo().window(winHandle);
        }
        return new YopMailMainPage(webDriver);
    }

    public WebElement estimateFieldInstanceTypeCheck() {
        return estimateListInstanceTypeField;
    }

    public WebElement estimateFieldRegionCheck() {
        return estimateListRegionField;
    }

    public WebElement estimateFieldSSDCheck() {
        return estimateListLocalSSDField;
    }

    public WebElement estimateFieldCommitedTermCheck() {
        return estimateListCommitedTermField;
    }

    public WebElement checkCurrentTotalCostAndManualTotalCost() {
        return totalCostManualTest;
    }


}
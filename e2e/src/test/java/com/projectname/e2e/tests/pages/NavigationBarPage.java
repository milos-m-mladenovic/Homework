package com.projectname.e2e.tests.pages;

import com.projectname.e2e.tests.pages.common.PageBase;
import com.projectname.e2e.tests.selectors.CustomBy;
import com.projectname.e2e.tests.utils.CheckIfElement;
import com.projectname.e2e.tests.webdriver.CustomWebDriver;
import org.openqa.selenium.WebElement;

public class NavigationBarPage extends PageBase {
    public NavigationBarPage(CustomWebDriver driver, String url, String email, String password) {
        super(driver, url, email, password);
    }

    @Override
    public PageBase show() {
        return null;
    }

    @Override
    public boolean isDisplayed() {
        return CheckIfElement.isDisplayed(CustomBy.id("PHPTRAVELS"), driver);
    }

    private WebElement getDemoBtn() {
        try {
            return driver.findElement(CustomBy.xpath("/html/body/header/div/nav/a[1]"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Could not find Demo button on Navigation bar page.", e);
        }
    }

    public DemoPage openDemoPage() {
        getDemoBtn().click();
        return new DemoPage(driver, url, email, password);
    }

    private WebElement getFeaturesBtn() {
        try {
            return driver.findElement(CustomBy.xpath("/html/body/header/div/nav/div[1]/span"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Could not find Features button on Navigation bar page.", e);
        }
    }

    private WebElement getFlightsBtn() {
        getFeaturesBtn().click();
        try {
            return driver.findElement(CustomBy.xpath("/html/body/header/div/nav/div[1]/div/a[3]"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Could not find Flights button on Navigation bar page.", e);
        }
    }

    public FlightsPage openFlightsPage() {
        getFlightsBtn().click();
        return new FlightsPage(driver, url, email, password);
    }

    private WebElement getPricingBtn() {
        try {
            return driver.findElement(CustomBy.xpath("/html/body/header/div/nav/a[2]"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Could not find Pricing button on Navigation bar page.", e);
        }
    }

    public PricingPage openPricingPage() {
        getPricingBtn().click();
        return new PricingPage(driver, url, email, password);
    }

    private WebElement getMainFeaturesBtn() {
        getFeaturesBtn().click();
        try {
            return driver.findElement(CustomBy.xpath("/html/body/header/div/nav/div[1]/div/a[1]"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Could not find Main Features button on Navigation bar page.", e);
        }
    }

    public MainFeaturesPage openMainFeaturesPage() {
        getMainFeaturesBtn().click();
        return new MainFeaturesPage(driver, url, email, password);
    }

    private WebElement getHotelsBtn() {
        getFeaturesBtn().click();
        try {
            return driver.findElement(CustomBy.xpath("/html/body/header/div/nav/div[1]/div/a[2]"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Could not find Hotels button on Navigation bar page.", e);
        }
    }

    public HotelsPage openHotelsPage() {
        getHotelsBtn().click();
        return new HotelsPage(driver, url, email, password);
    }

    private WebElement getProductBtn() {
        try {
            return driver.findElement(CustomBy.xpath("/html/body/header/div/nav/div[2]/span"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Could not find Product button on Navigation bar page.", e);
        }
    }

    private WebElement getIntegrationBtn() {
        getProductBtn().click();
        try {
            return driver.findElement(CustomBy.xpath("/html/body/header/div/nav/div[2]/div/a[1]"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Could not find Integration button on Navigation bar page.", e);
        }
    }

    public IntegrationPage openIntegrationPage() {
        getIntegrationBtn().click();
        return new IntegrationPage(driver, url, email, password);
    }

    private WebElement getProductServicesBtn() {
        getProductBtn().click();
        try {
            return driver.findElement(CustomBy.xpath("/html/body/header/div/nav/div[2]/div/a[2]"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Could not find Product Services button on Navigation bar page.", e);
        }
    }

    public ProductServicesPage openProductServicesPage() {
        getProductServicesBtn().click();
        return new ProductServicesPage(driver, url, email, password);
    }

    private WebElement getDocsBtn() {
        try {
            return driver.findElement(CustomBy.xpath("/html/body/header/div/nav/a[3]"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Could not find Docs button on Navigation bar page.", e);
        }
    }

    public DocsPage openDocsPage() {
        getDocsBtn().click();
        return new DocsPage(driver, url, email, password);
    }

}

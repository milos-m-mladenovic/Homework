package com.projectname.e2e.tests.suites;

import com.projectname.e2e.tests.pages.*;
import com.projectname.e2e.tests.suites.common.TestBase;
import com.projectname.e2e.tests.webdriver.CustomWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class NavigationBarTests extends TestBase {

    @Test
    public void verifyDemoButtonIsWorking() {
        NavigationBarPage navigationBarPage = new NavigationBarPage(getDriver(), "", "", "");

        DemoPage demoPage = navigationBarPage.openDemoPage();

        Assert.assertTrue(demoPage.isDisplayed());
    }

    @Test
    public void verifyPricingButtonIsWorking() {
        NavigationBarPage navigationBarPage = new NavigationBarPage(getDriver(), "", "", "");

        PricingPage pricingPage = navigationBarPage.openPricingPage();

        Assert.assertTrue(pricingPage.isDisplayed());
    }

    @Test
    public void verifyMainFeaturesButtonIsWorking() {
        NavigationBarPage navigationBarPage = new NavigationBarPage(getDriver(), "", "", "");

        MainFeaturesPage mainFeaturesPage = navigationBarPage.openMainFeaturesPage();

        Assert.assertTrue(mainFeaturesPage.isDisplayed());
    }

    @Test
    public void verifyHotelsButtonIsWorking() {
        NavigationBarPage navigationBarPage = new NavigationBarPage(getDriver(), "", "", "");

        HotelsPage hotelsPage = navigationBarPage.openHotelsPage();

        Assert.assertTrue(hotelsPage.isDisplayed());
    }

    @Test
    public void verifyFlightsButtonIsWorking() {
        NavigationBarPage navigationBarPage = new NavigationBarPage(getDriver(), "", "", "");

        FlightsPage flightsPage = navigationBarPage.openFlightsPage();

        Assert.assertTrue(flightsPage.isDisplayed());
    }

    @Test
    public void verifyIntegrationButtonIsWorking() {
        NavigationBarPage navigationBarPage = new NavigationBarPage(getDriver(), "", "", "");

        IntegrationPage integrationPage = navigationBarPage.openIntegrationPage();

        Assert.assertTrue(integrationPage.isDisplayed());
    }

    @Test
    public void verifyProductServicesButtonIsWorking() {
        NavigationBarPage navigationBarPage = new NavigationBarPage(getDriver(), "", "", "");

        ProductServicesPage productServicesPage = navigationBarPage.openProductServicesPage();

        Assert.assertTrue(productServicesPage.isDisplayed());
    }

    @Test
    public void verifyDocsButtonIsWorking() {
        NavigationBarPage navigationBarPage = new NavigationBarPage(getDriver(), "", "", "");

        CustomWebDriver cwd = new CustomWebDriver(getDriver());

        DocsPage docsPage = navigationBarPage.openDocsPage();

        ArrayList<String> tabs = new ArrayList<String> (cwd.getWindowHandles());
        cwd.switchTo().window(tabs.get(1));

        Assert.assertTrue(docsPage.isDisplayed());
    }

}

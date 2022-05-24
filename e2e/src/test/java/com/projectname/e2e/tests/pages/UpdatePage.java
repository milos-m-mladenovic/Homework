package com.projectname.e2e.tests.pages;

import com.projectname.e2e.tests.data.model.UpdateUserRequest;
import com.projectname.e2e.tests.pages.common.PageBase;
import com.projectname.e2e.tests.selectors.CustomBy;
import com.projectname.e2e.tests.utils.CheckIfElement;
import com.projectname.e2e.tests.webdriver.CustomWebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

public class UpdatePage extends PageBase {
    public UpdatePage(CustomWebDriver driver, String url, String email, String password) {
        super(driver, url, email, password);
    }

    @Override
    public PageBase show() {
        if(!isDisplayed()) {
            NavigationBarPage navigationBarPage = new NavigationBarPage(driver, url, email, password);
            navigationBarPage.openUpdatePage();
        }
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        return this;
    }

    @Override
    public boolean isDisplayed() {
        return CheckIfElement.isDisplayed(CustomBy.xpath("/html/body/section/div/div[1]/div[2]/form/div[4]/input[1]"), driver);
    }

    private WebElement getInputFirstNameField() {
        try {
            return driver.findElement(CustomBy.id("inputFirstName"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Could not find input first name field on Update page", e);
        }
    }

    private WebElement getLastNameField() {
        try {
            return driver.findElement(CustomBy.id("inputLastName"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Could not find last name field on Update page", e);
        }
    }

    private WebElement getEmailField() {
        try {
            return driver.findElement(CustomBy.id("inputEmail"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Could not find email field on Update page", e);
        }
    }

    private WebElement getPaymentMethod() {
        try {
            return driver.findElement(CustomBy.id("inputPaymentMethod"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Could not find Payment Method field on Update page", e);
        }
    }

    private WebElement getDefaultBillingContact() {
        try {
            return driver.findElement(CustomBy.id("inputBillingContact"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Could not find Default Billing Contact field on Update page", e);
        }
    }

    private WebElement getMobileField() {
        try {
            return driver.findElement(CustomBy.id("customfield2"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Could not find not a robot checkbox on Update page", e);
        }
    }

    private WebElement getStreetAddressField() {
        try {
            return driver.findElement(CustomBy.id("inputAddress1"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Could not find street address field on Update page", e);
        }
    }

    private WebElement getStreetAddress2Field() {
        try {
            return driver.findElement(CustomBy.id("inputAddress2"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Could not find street address 2 field on Update page", e);
        }
    }

    private WebElement getCityField() {
        try {
            return driver.findElement(CustomBy.id("inputCity"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Could not find street address 2 field on Update page", e);
        }
    }

    private WebElement getStateField() {
        try {
            return driver.findElement(CustomBy.id("stateinput"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Could not find street address 2 field on Update page", e);
        }
    }

    private WebElement getPostcodeField() {
        try {
            return driver.findElement(CustomBy.id("inputPostcode"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Could not find street address 2 field on Update page", e);
        }
    }

    private WebElement getInputPhoneField() {
        try {
            return driver.findElement(CustomBy.id("inputPhone"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Could not find street address field on Update page", e);
        }
    }

    private WebElement getSaveChangesButton() {
        try {
            return driver.findElement(CustomBy.xpath("/html/body/section/div/div[1]/div[2]/form/div[4]/input[1]"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Could not find not Save Changes button on Update page", e);
        }
    }

    public UserPage updateUserDetails(UpdateUserRequest userRequest) {

        getInputFirstNameField().click();
        getInputFirstNameField().clear();
        getInputFirstNameField().sendKeys(userRequest.getFirstName());

        getLastNameField().click();
        getLastNameField().clear();
        getLastNameField().sendKeys(userRequest.getLastName());

        getSaveChangesButton().click();

        return new UserPage(driver, url, email, password);

    }

    public UserPage loginWithExistingUser() {

        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        WebElement emailInput = driver.findElement(CustomBy.id("inputEmail"));
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys("uas22211@zcrcd.com");

        WebElement passwordInput = driver.findElement(CustomBy.id("inputPassword"));
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys("123456aA");

        WebElement login = driver.findElement(CustomBy.id("login"));
        login.click();

        return new UserPage(driver, url, email, password);
    }

}

package com.projectname.e2e.tests.suites;

import com.projectname.e2e.tests.asserts.PhpTravelAssert;
import com.projectname.e2e.tests.data.model.UpdateUserRequest;
import com.projectname.e2e.tests.data.model.UserPageDetails;
import com.projectname.e2e.tests.data.provider.PhpTravels.PhpTravelsProvider;
import com.projectname.e2e.tests.pages.NavigationBarPage;
import com.projectname.e2e.tests.pages.UpdatePage;
import com.projectname.e2e.tests.pages.UserPage;
import com.projectname.e2e.tests.selectors.CustomBy;
import com.projectname.e2e.tests.suites.common.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class UpdateTests extends TestBase {

    @Test
    public void verifyUserIsUpdated() {
        NavigationBarPage navigationBarPage = new NavigationBarPage(getDriver(), "", "", "");
        navigationBarPage.show();

        UpdatePage updatePage = new UpdatePage(getDriver(), "", "", "");
        updatePage.show();

        updatePage.loginWithExistingUser();

        UserPage userpage = new UserPage(getDriver(), "", "", "");
        userpage.show();

        UserPageDetails firstAndLastNameBeforeUpdate = userpage.getFirstAndLastNameOfUser();
        System.out.println(firstAndLastNameBeforeUpdate);

        WebElement updateButton = getDriver().findElement(CustomBy.xpath("/html/body/section/div/div[1]/div[1]/div[1]/div/div[3]/a"));
        updateButton.click();

        UpdateUserRequest userRequest = PhpTravelsProvider.prepareUpdateUserRequest();
        updatePage.updateUserDetails(userRequest);

        PhpTravelAssert phpTravelAssert = new PhpTravelAssert();
        phpTravelAssert.assertUserDetailsAreUpdated(firstAndLastNameBeforeUpdate, userRequest);
    }
}

package com.projectname.api.tests.functional.suites;

import com.projectname.api.client.calls.*;
import com.projectname.api.client.data.model.crocodile.*;
import com.projectname.api.client.data.model.crocodile.CrocodileResponse;
import com.projectname.api.client.data.model.crocodile.LoginRequest;
import com.projectname.api.tests.constants.DataProviderNames;
import com.projectname.api.tests.constants.ErrorMessages;
import com.projectname.api.tests.data.provider.*;
import com.projectname.api.tests.environment.ConfigSetup;
import com.projectname.api.tests.functional.asserts.*;
import com.projectname.api.tests.init.TestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CrocodileSecurityTests extends TestBase {
    String accessTokenMainUser;
    String accessTokenSecondUser;

    @BeforeClass
    public void prepareDataForTest() {
        accessTokenMainUser = CrocodilesAPI.loginUser(new LoginRequest(ConfigSetup.getMainUser(), ConfigSetup.getPass())).getAccess();
        accessTokenSecondUser = CrocodilesAPI.loginUser(new LoginRequest(ConfigSetup.getSecondUser(), ConfigSetup.getPass())).getAccess();
    }

    @Test
    public void verifyCannotGetCrocodileFromAnotherUser() {
        CrocodileResponse crocodileResponse = CrocodilesAPI.createCrocodile(accessTokenMainUser, CrocodileProvider.prepareCrocodileRequest());

        CrocodileErrorResponse actualError = CrocodilesAPI.getSingleCrocWithError(accessTokenSecondUser, crocodileResponse.getId());

        CommonErrorAssert commonErrorAssert = new CommonErrorAssert();
        commonErrorAssert.assertCrocodileErrorResponse(actualError, new CrocodileErrorResponse(ErrorMessages.NOT_FOUND));
    }

    @Test(dataProvider = DataProviderNames.VERIFY_CANNOT_CREATE_USER_WITHOUT_REQUIRED_FIELD, dataProviderClass = CrocodileProvider.class)
    public void verifyCannotCreateCrocodileWithoutRequiredFields(String suffix, CrocodileRequest crocodileRequest, RequiredFieldErrorResponse expectedError) {
        RequiredFieldErrorResponse actualError = CrocodilesAPI.createCrocodileWithRequiredFieldError(accessTokenMainUser, crocodileRequest);

        CommonErrorAssert commonErrorAssert = new CommonErrorAssert();
        commonErrorAssert.assertRequiredFieldErrors(actualError, expectedError);
    }
}

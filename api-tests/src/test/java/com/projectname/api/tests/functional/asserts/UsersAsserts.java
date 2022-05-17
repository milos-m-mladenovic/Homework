package com.projectname.api.tests.functional.asserts;

import com.projectname.api.client.data.model.users.UsersResponse;
import org.testng.asserts.SoftAssert;

public class UsersAsserts {

    SoftAssert softAssert = new SoftAssert();

    public void assertUsers(UsersResponse[] getUsers) {
        for(int i = 0; i < getUsers.length; i++) {
            softAssert.assertFalse(getUsers[i].getUserName().isEmpty(), "Username is empty.");
            softAssert.assertFalse(getUsers[i].getPassword().isEmpty(), "Password is empty.");
        }
        softAssert.assertAll();
    }

    public void assertUser(UsersResponse userResponse) {
        softAssert.assertFalse(userResponse.getUserName().isEmpty(), "Username is empty.");
        softAssert.assertFalse(userResponse.getPassword().isEmpty(), "Password is empty.");
        softAssert.assertAll();
    }

    public void assertEditUser(UsersResponse oldValues, UsersResponse newValues) {
        softAssert.assertFalse(oldValues.getUserName().equals(newValues.getUserName()), "Username is the same.");
        softAssert.assertFalse(oldValues.getPassword().equals(newValues.getPassword()), "Password is the same.");
        softAssert.assertAll();
    }

    public void assertDeleteUser(UsersResponse deletedUser) {
        softAssert.assertNull(deletedUser);
        softAssert.assertAll();
    }

}

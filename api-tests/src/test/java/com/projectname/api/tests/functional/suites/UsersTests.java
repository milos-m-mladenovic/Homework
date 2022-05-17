package com.projectname.api.tests.functional.suites;

import com.projectname.api.client.calls.UsersApi;
import com.projectname.api.client.data.model.users.UsersRequest;
import com.projectname.api.client.data.model.users.UsersResponse;
import com.projectname.api.client.utils.ValueChoosers;
import com.projectname.api.tests.data.provider.Provider;
import com.projectname.api.tests.functional.asserts.UsersAsserts;
import com.projectname.api.tests.init.TestBase;
import org.testng.annotations.Test;

public class UsersTests extends TestBase {

    UsersResponse[] getUsers;
    UsersAsserts assertUsers = new UsersAsserts();

    @Test
    public void getUsers() {
        getUsers = UsersApi.getUsers();
        assertUsers.assertUsers(getUsers);

    }

    @Test
    public void getUser() {
        getUsers = UsersApi.getUsers();
        UsersResponse getUser = UsersApi.getUser(getUsers[0].getId());
        assertUsers.assertUser(getUser);
    }

    @Test
    public void createUser() {
        UsersResponse newUser = UsersApi.postUser(Provider.prepareUserRequest());
        assertUsers.assertUser(newUser);
    }

    @Test
    public void editUser() {
        getUsers = UsersApi.getUsers();
        UsersResponse existingUser = UsersApi.getUser(getUsers[0].getId());
        UsersRequest editUser = new UsersRequest(existingUser.getId(), ValueChoosers.setRandomUsername(), ValueChoosers.setRandomPassword());
        UsersResponse editedUser = UsersApi.putUser(existingUser.getId(), editUser);
        assertUsers.assertEditUser(existingUser, editedUser);
    }

    @Test
    public void deleteUser() {
        getUsers = UsersApi.getUsers();
        UsersResponse deleteUser = UsersApi.deleteUser(getUsers[0].getId());
        assertUsers.assertDeleteUser(deleteUser);
    }

}

package com.projectname.api.client.calls;

import com.projectname.api.client.constants.UsersApiEndpoints;
import com.projectname.api.client.data.model.users.UsersRequest;
import com.projectname.api.client.data.model.users.UsersResponse;
import com.projectname.api.client.utils.GsonFunctions;
import com.projectname.api.client.utils.RestAssuredFunctions;

public class UsersApi {

    public static UsersResponse[] getUsers() {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.get(UsersApiEndpoints.USERS), UsersResponse[].class);
    }

    public static UsersResponse getUser(int id) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.get(UsersApiEndpoints.USER(id)), UsersResponse.class);
    }

    public static UsersResponse postUser(UsersRequest createUser) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.post(UsersApiEndpoints.USERS, createUser), UsersResponse.class);
    }

    public static UsersResponse putUser(int id, UsersRequest editUser) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.put(UsersApiEndpoints.USER(id), editUser), UsersResponse.class);
    }

    public static UsersResponse deleteUser(int id) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.delete(UsersApiEndpoints.USER(id)), UsersResponse.class);
    }

}

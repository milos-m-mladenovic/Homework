package com.projectname.api.client.constants;

public class UsersApiEndpoints {

    //public static final String USERS = "https://fakerestapi.azurewebsites.net/api/v1/Users";

    public static final String USERS = "Users";

    public static String USER(int id) { return USERS + "/" + id + "/"; }

}

package com.projectname.api.client.constants;

public class AuthorsApiEndpoints {

    //public static final String AUTHORS = "https://fakerestapi.azurewebsites.net/api/v1/Authors";

    public static final String AUTHORS = "Authors";

    public static String AUTHOR(int id) { return AUTHORS + "/" + id + "/"; }

    public static String  AUTHORBYBOOK(int id) { return AUTHORS + "/authors/books/" + id; }

}

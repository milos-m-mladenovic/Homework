package com.projectname.api.client.constants;

public class BooksApiEndpoints {

    //public static final String BOOKS = "https://fakerestapi.azurewebsites.net/api/v1/Books";

    public static final String BOOKS = "Books";

    public static String BOOK(int id) { return BOOKS + "/" + id + "/"; }

}

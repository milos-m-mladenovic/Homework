package com.projectname.api.client.calls;

import com.projectname.api.client.constants.AuthorsApiEndpoints;

import com.projectname.api.client.data.model.authors.AuthorsRequest;
import com.projectname.api.client.data.model.authors.AuthorsResponse;
import com.projectname.api.client.utils.GsonFunctions;
import com.projectname.api.client.utils.RestAssuredFunctions;

public class AuthorsApi {

    public static AuthorsResponse[] getAuthors() {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.get(AuthorsApiEndpoints.AUTHORS), AuthorsResponse[].class);
    }

    public static AuthorsResponse getAuthor(int id) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.get(AuthorsApiEndpoints.AUTHOR(id)), AuthorsResponse.class);
    }

    public static AuthorsResponse[] getBooksByAuthor(int id) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.get(AuthorsApiEndpoints.AUTHORBYBOOK(id)), AuthorsResponse[].class);
    }

    public static AuthorsResponse postAuthor(AuthorsRequest authorsRequest) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.post(AuthorsApiEndpoints.AUTHORS, authorsRequest), AuthorsResponse.class);
    }

    public static AuthorsResponse putAuthor(AuthorsRequest authorsRequest, int id) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.put(AuthorsApiEndpoints.AUTHOR(id), authorsRequest), AuthorsResponse.class);
    }

    public static AuthorsResponse deleteAuthor(int id) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.delete(AuthorsApiEndpoints.AUTHOR(id)), AuthorsResponse.class);
    }

}

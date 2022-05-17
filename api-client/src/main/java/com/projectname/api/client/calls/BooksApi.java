package com.projectname.api.client.calls;

import com.projectname.api.client.constants.BooksApiEndpoints;
import com.projectname.api.client.data.model.books.BooksRequest;
import com.projectname.api.client.data.model.books.BooksResponse;
import com.projectname.api.client.utils.GsonFunctions;
import com.projectname.api.client.utils.RestAssuredFunctions;

public class BooksApi {

    public static BooksResponse[] getBooks() {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.get(BooksApiEndpoints.BOOKS), BooksResponse[].class);
    }

    public static BooksResponse getBook(int id) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.get(BooksApiEndpoints.BOOK(id)), BooksResponse.class);
    }

    public static BooksResponse postBook(BooksRequest createBook) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.post(BooksApiEndpoints.BOOKS, createBook), BooksResponse.class);
    }

    public static BooksResponse putBook(int id, BooksRequest editBook) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.put(BooksApiEndpoints.BOOK(id), editBook), BooksResponse.class);
    }

    public static BooksResponse deleteBook(int id) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.delete(BooksApiEndpoints.BOOK(id)), BooksResponse.class);
    }

}

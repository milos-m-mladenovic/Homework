package com.projectname.api.tests.data.provider;

import com.projectname.api.client.data.model.activities.ActivitiesRequest;
import com.projectname.api.client.data.model.authors.AuthorsRequest;
import com.projectname.api.client.data.model.books.BooksRequest;
import com.projectname.api.client.data.model.coverphotos.CoverphotosRequest;
import com.projectname.api.client.data.model.users.UsersRequest;

public class Provider {

    public static ActivitiesRequest prepareActivityRequest() {
        ActivitiesRequest newActivityRequest = new ActivitiesRequest();
        newActivityRequest.setId(100);
        newActivityRequest.setCompleted(true);
        newActivityRequest.setDueDate("2022-04-06T05:37:01.389Z");
        newActivityRequest.setTitle("Test");
        return newActivityRequest;
    }

    public static AuthorsRequest prepareAuthorRequest() {
        AuthorsRequest newAuthorRequest = new AuthorsRequest();
        newAuthorRequest.setId(100);
        newAuthorRequest.setIdBook(100);
        newAuthorRequest.setFirstName("Ftest");
        newAuthorRequest.setLastName("Ltest");
        return newAuthorRequest;
    }

    public static BooksRequest prepareBookRequest() {
        BooksRequest newBookRequest = new BooksRequest();
        newBookRequest.setId(100);
        newBookRequest.setDescription("Test description");
        newBookRequest.setTitle("Test title");
        newBookRequest.setExcerpt("Test excerpt");
        newBookRequest.setPageCount(123);
        newBookRequest.setPublishDate("1900-04-10T12:32:04.324768+00:00");
        return newBookRequest;
    }

    public static CoverphotosRequest prepareCoverphotoRequest() {
        CoverphotosRequest newCoverPhoto = new CoverphotosRequest();
        newCoverPhoto.setId(100);
        newCoverPhoto.setIdBook(100);
        newCoverPhoto.setUrl("www.test.com");
        return newCoverPhoto;
    }

    public static UsersRequest prepareUserRequest() {
        UsersRequest newUser = new UsersRequest();
        newUser.setId(100);
        newUser.setUserName("TestUsername");
        newUser.setPassword("TestPassword");
        return newUser;
    }

}

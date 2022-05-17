package com.projectname.api.client.constants;

public class CoverPhotosApiEndpoints {

    //public static final String COVERPHOTOS = "https://fakerestapi.azurewebsites.net/api/v1/CoverPhotos";

    public static final String COVERPHOTOS = "CoverPhotos";

    public static String COVERPHOTO(int id) { return COVERPHOTOS + "/" + id + "/"; }

    public static String  COVERPHOTOSBYBOOK(int id) { return COVERPHOTOS + "/books/covers/" + id; }
}

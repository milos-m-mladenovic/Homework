package com.projectname.api.client.calls;

import com.projectname.api.client.constants.CoverPhotosApiEndpoints;
import com.projectname.api.client.data.model.coverphotos.CoverphotosRequest;
import com.projectname.api.client.data.model.coverphotos.CoverphotosResponse;
import com.projectname.api.client.utils.GsonFunctions;
import com.projectname.api.client.utils.RestAssuredFunctions;

public class CoverPhotosApi {

    public static CoverphotosResponse[] getCoverphotos() {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.get(CoverPhotosApiEndpoints.COVERPHOTOS), CoverphotosResponse[].class);
    }

    public static CoverphotosResponse getCoverphoto(int id) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.get(CoverPhotosApiEndpoints.COVERPHOTO(id)), CoverphotosResponse.class);
    }

    public static CoverphotosResponse[] getCoverphotosByBook(int id) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.get(CoverPhotosApiEndpoints.COVERPHOTOSBYBOOK(id)), CoverphotosResponse[].class);
    }

    public static CoverphotosResponse postCoverphoto(CoverphotosRequest coverphotosRequest) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.post(CoverPhotosApiEndpoints.COVERPHOTOS, coverphotosRequest), CoverphotosResponse.class);
    }

    public static CoverphotosResponse putCoverphoto(CoverphotosRequest coverphotosRequest, int id) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.put(CoverPhotosApiEndpoints.COVERPHOTO(id), coverphotosRequest), CoverphotosResponse.class);
    }

    public static CoverphotosResponse deletCoverphoto(int id) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.delete(CoverPhotosApiEndpoints.COVERPHOTO(id)), CoverphotosResponse.class);
    }

}

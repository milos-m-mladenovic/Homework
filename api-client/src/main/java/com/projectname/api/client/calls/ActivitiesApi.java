package com.projectname.api.client.calls;

import com.projectname.api.client.constants.ActivitiesApiEndpoints;
import com.projectname.api.client.constants.ApiEndpoints;
import com.projectname.api.client.data.model.activities.ActivitiesRequest;
import com.projectname.api.client.data.model.activities.ActivitiesResponse;
import com.projectname.api.client.data.model.activities.UpdateActivityRequest;
import com.projectname.api.client.data.model.activities.UpdateActivityResponse;
import com.projectname.api.client.utils.GsonFunctions;
import com.projectname.api.client.utils.RestAssuredFunctions;


public class ActivitiesApi {

    public static ActivitiesResponse[] getActivities() {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.get(ActivitiesApiEndpoints.ACTIVITIES), ActivitiesResponse[].class);
    }

    public static ActivitiesResponse getActivity(int id) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.get(ActivitiesApiEndpoints.ACTIVITY(id)), ActivitiesResponse.class);
    }

    public static ActivitiesResponse postActivity(ActivitiesRequest createActivity) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.post(ActivitiesApiEndpoints.ACTIVITIES, createActivity), ActivitiesResponse.class);
    }

    public static ActivitiesResponse putActivity(int id, ActivitiesRequest editActivity) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.put(ActivitiesApiEndpoints.ACTIVITY(id), editActivity), ActivitiesResponse.class);
    }

    public static UpdateActivityResponse updateActivity(UpdateActivityRequest activityRequest, int activityId) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.put(activityRequest, ActivitiesApiEndpoints.ACTIVITY(activityId)), UpdateActivityResponse.class);
    }

    public static ActivitiesResponse deleteActivity(int id) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.delete(ActivitiesApiEndpoints.ACTIVITY(id)), ActivitiesResponse.class);
    }

}

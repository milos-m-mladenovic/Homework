package com.projectname.api.client.constants;

public class ActivitiesApiEndpoints {

    //public static final String ACTIVITIES = "https://fakerestapi.azurewebsites.net/api/v1/Activities";

    public static final String ACTIVITIES = "Activities";

    public static String ACTIVITY(int id) { return ACTIVITIES + "/" + id + "/"; }

}

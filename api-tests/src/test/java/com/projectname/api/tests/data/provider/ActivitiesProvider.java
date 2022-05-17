package com.projectname.api.tests.data.provider;

import com.projectname.api.client.data.model.activities.ActivitiesRequest;
import com.projectname.api.client.data.model.activities.UpdateActivityRequest;
import com.projectname.api.client.data.model.template.create.CreateUserRequest;
import com.projectname.api.client.data.model.template.update.UpdateUserRequest;
import com.projectname.api.client.utils.RandomStringGenerator;
import com.projectname.api.tests.constants.DataProviderNames;
import org.testng.annotations.DataProvider;



public class ActivitiesProvider {

    @DataProvider(name = DataProviderNames.VERIFY_CREATE_ACTIVITY)
    public static Object[][] verifyCreateActivity() {
        return new Object[][]{
                {"id1000", new ActivitiesRequest(1000, "Some Title", "2021-04-06T05:37:01.389Z", true)},
                {"id1001", new ActivitiesRequest(1001, "Title Title", "2020-04-06T05:37:01.389Z", false)},
        };
    }
    @DataProvider(name = DataProviderNames.VERIFY_UPDATE_ACTIVITY)
    public static Object[][] verifyUpdateActivity() {
        return new Object[][]{
                {"forId1000", prepareActivityRequest(), getRandomId()},
                {"forId1001", new UpdateActivityRequest(1001, "Title Title", "2020-04-06T05:37:01.389Z", false), 1001}
        };
    }

    public static UpdateActivityRequest prepareActivityRequest() {
        UpdateActivityRequest activityRequest = new UpdateActivityRequest();
        activityRequest.setId(1000);
        activityRequest.setTitle("Updated");
        activityRequest.setDueDate("2021-04-06T05:36:01.389Z");
        activityRequest.setCompleted(false);
        return activityRequest;
    }

    public static int getRandomId() {
        return 1000;
    }
}

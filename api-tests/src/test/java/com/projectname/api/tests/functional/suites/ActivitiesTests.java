package com.projectname.api.tests.functional.suites;

import com.projectname.api.client.calls.ActivitiesApi;
import com.projectname.api.client.data.model.activities.ActivitiesRequest;
import com.projectname.api.client.data.model.activities.ActivitiesResponse;
import com.projectname.api.client.data.model.activities.UpdateActivityRequest;
import com.projectname.api.client.data.model.activities.UpdateActivityResponse;
import com.projectname.api.client.utils.RandomStringGenerator;
import com.projectname.api.client.utils.ValueChoosers;
import com.projectname.api.tests.constants.DataProviderNames;
import com.projectname.api.tests.data.provider.ActivitiesProvider;
import com.projectname.api.tests.data.provider.Provider;
import com.projectname.api.tests.functional.asserts.ActivitiesAsserts;
import com.projectname.api.tests.init.TestBase;
import org.testng.annotations.Test;

public class ActivitiesTests extends TestBase {

    ActivitiesResponse[] getActivities;
    ActivitiesAsserts activitiesAsserts = new ActivitiesAsserts();

    @Test
    public void testTest() {
        System.out.println(RandomStringGenerator.createRandomStringAlphanumericWithLen(8));
    }

    @Test
    public void getActivities() {
        getActivities = ActivitiesApi.getActivities();
        activitiesAsserts.assertActivities(getActivities);

    }

    @Test
    public void getActivity() {
        getActivities = ActivitiesApi.getActivities();
        ActivitiesResponse getActivity = ActivitiesApi.getActivity(getActivities[0].getId());
        activitiesAsserts.assertActivity(getActivity);
    }

    @Test
    public void createActivity() {
        ActivitiesResponse newActivity = ActivitiesApi.postActivity(Provider.prepareActivityRequest());
        activitiesAsserts.assertNewActivity(newActivity);
    }

    @Test
    public void editActivity() {
        getActivities = ActivitiesApi.getActivities();
        ActivitiesResponse existingActivity = ActivitiesApi.getActivity(getActivities[0].getId());
        ActivitiesRequest editActivity = new ActivitiesRequest(existingActivity.getId(), ValueChoosers.setRandomTitleName(), ValueChoosers.setDueDate(), ValueChoosers.setRandomCompletedState());
        ActivitiesResponse editedActivity = ActivitiesApi.putActivity(existingActivity.getId(), editActivity);
        activitiesAsserts.assertEditActivity(existingActivity, editedActivity);
    }

    @Test
    public void verifyUpdateActivity() {
        ActivitiesResponse activityResponse = ActivitiesApi.postActivity(new ActivitiesRequest(100, "TestActivity", "2022-04-23T05:57:15.057Z", true));
        UpdateActivityRequest activityRequest = new UpdateActivityRequest(100, "MilosTest", "2022-05-23T05:57:15.057Z", false);
        UpdateActivityResponse actualUpdateActivityResponse = ActivitiesApi.updateActivity(activityRequest, activityResponse.getId());
        UpdateActivityResponse expectedActivityResponse = UpdateActivityResponse.parseExpectedActivityResponse(activityRequest);
        activitiesAsserts.assertUpdateActivity(expectedActivityResponse, actualUpdateActivityResponse);
    }

    @Test(dataProvider = DataProviderNames.VERIFY_UPDATE_ACTIVITY, dataProviderClass = ActivitiesProvider.class)
    public void verifyUpdateActivityWithProvider(String suffix, UpdateActivityRequest activityRequest, int activityId) {
        UpdateActivityResponse actualResponse = ActivitiesApi.updateActivity(activityRequest, activityId);

        UpdateActivityResponse expectedResponse = UpdateActivityResponse.parseExpectedActivityResponse(activityRequest);

        activitiesAsserts.assertUpdateActivity(expectedResponse, actualResponse);
    }

    @Test
    public void deleteActivity() {
        getActivities = ActivitiesApi.getActivities();
        ActivitiesResponse deleteActivity = ActivitiesApi.deleteActivity(getActivities[0].getId());
        activitiesAsserts.assertDeleteActivity(deleteActivity);
    }

}

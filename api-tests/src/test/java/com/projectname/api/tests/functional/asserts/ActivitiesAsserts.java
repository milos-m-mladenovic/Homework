package com.projectname.api.tests.functional.asserts;

import com.projectname.api.client.data.model.activities.ActivitiesResponse;
import com.projectname.api.client.data.model.activities.UpdateActivityResponse;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class ActivitiesAsserts {

    SoftAssert softAssert = new SoftAssert();

    public void assertActivities(ActivitiesResponse[] getActivities) {
        for(int i = 0; i < getActivities.length; i++) {
            softAssert.assertFalse(getActivities[i].getDueDate().isEmpty(), "Due date is empty.");
            softAssert.assertFalse(getActivities[i].getTitle().isEmpty(), "Title is empty.");
        }
        softAssert.assertAll();
    }

    public void assertActivity(ActivitiesResponse activitiesResponse) {
        softAssert.assertFalse(activitiesResponse.getTitle().isEmpty(), "Title is empty.");
        softAssert.assertFalse(activitiesResponse.getDueDate().isEmpty(), "Due date is empty.");
        softAssert.assertAll();
    }

    public void assertNewActivity(ActivitiesResponse activitiesResponse) {
        if (activitiesResponse == null) {
            Assert.fail("Activity was not created.");
        }
        softAssert.assertFalse(activitiesResponse.getTitle().isEmpty(), "Title is empty.");
        softAssert.assertFalse(activitiesResponse.getDueDate().isEmpty(), "Due date is empty.");
        softAssert.assertAll();
    }

    public void assertEditActivity(ActivitiesResponse oldValues, ActivitiesResponse newValues) {
        softAssert.assertFalse(oldValues.getTitle().equals(newValues.getTitle()), "Title is the same.");
        softAssert.assertFalse(oldValues.getDueDate().equals(newValues.getDueDate()), "Title is the same.");
        softAssert.assertAll();
    }

    public void assertUpdateActivity(UpdateActivityResponse actualResponse, UpdateActivityResponse expectedResponse) {
        if (actualResponse == null) {
            Assert.fail("Activity is not updated.");
        }

        softAssert.assertEquals(actualResponse.getTitle(), expectedResponse.getTitle(), "Title is not updated.");
        softAssert.assertEquals(actualResponse.getDueDate(), expectedResponse.getDueDate(), "Due date is not updated.");
        softAssert.assertEquals(actualResponse.getCompleted(), expectedResponse.getCompleted(), "Completion status not updated.");
        softAssert.assertAll();
    }

    public void assertDeleteActivity(ActivitiesResponse deletedActivity) {
        softAssert.assertNull(deletedActivity);
        softAssert.assertAll();
    }

}
